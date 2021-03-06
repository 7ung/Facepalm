/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.fbservices;

import facepalm.Utils;
import facepalm.model.*;
import facepalm.model.User.PictureData;
import java.io.IOException;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * @author Vinh
 */
public class FBManager {

    private Router _router;
    
    private FBManager() {
        _router = ServiceUtils.createService(Router.class);
    }
    
    private static FBManager _instance = null;

    private String _currentAccessToken;
    private Date _expiresDate;
    private User _currentUser;

    private String _appId;
    private String _redirectUri = "https://www.facebook.com/connect/login_success.html";
    private String _responseType = "token";
    private String _appSecret = "c21caf80b9052640680b79ebf966a417";
    
    /**
     * Nhận thông tin cơ bản
     */
    private static final String SCOPE_USER_ABOUT_ME = "user_about_me";
    
    /**
     * Nhận email
     */
    private static final String SCOPE_EMAIL = "email";
    
    /**
     * Use for ...
     */
    private static final String SCOPE_USER_POSTS = "user_posts";
    private static final String SCOPE_USER_PUBLISH = "publish_actions";
    
    /**
     * Nhận ngày sinh
     */
    private static final String SCOPE_USER_BIRTHDAY = "user_birthday";

    /**
     * Nhận quote
     * Nhận danh sách page like
     */
    private static final String SCOPE_USER_LIKE = "user_likes";
    
    /**
     * Nhận thông tin ảnh
     */
    private static final String SCOPE_USER_PHOTOS = "user_photos";
    
    /**
     * Nhận thông tin friends
     */
    private static final String SCOPE_USER_FRIENDS = "user_friends";
    
    private static ArrayList<String> _scope = new ArrayList<>();
    static {
        _scope.add(SCOPE_USER_ABOUT_ME);
        _scope.add(SCOPE_EMAIL);
        _scope.add(SCOPE_USER_POSTS);
        _scope.add(SCOPE_USER_BIRTHDAY);
        _scope.add(SCOPE_USER_LIKE);
        _scope.add(SCOPE_USER_PHOTOS);
        _scope.add(SCOPE_USER_FRIENDS);
        _scope.add(SCOPE_USER_PUBLISH);
    }
    
    private String buildScope(){
        StringBuilder builder = new StringBuilder();
        for (int  i = 0; i < _scope.size(); ++i){
            if (i != 0)
                builder.append(",");
            builder.append(_scope.get(i));
        }
        return builder.toString();
    }
    
    public static FBManager getInstance() {
        if (_instance == null) {
            _instance = new FBManager();
        }

        return _instance;
    }

    public void setAccessToken(String token, Date expires) {
        _currentAccessToken = token;
        _expiresDate = expires;
        
        saveData();
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        
        if(_expiresDate.before(cal.getTime()))
        {
            convertToLongTerm(_currentAccessToken);
        }
    }

    public String getAccessToken() {
        return _currentAccessToken;
    }
    
    public void setExpiresDate(Date date) {
        _expiresDate = date;
    }

    public Date getExpiresDate() {
        return _expiresDate;
    }

    public void setCurrentUser(User user) {
        _currentUser = user;
    }

    public User getCurrentUser() {
        return _currentUser;
    }

    public void setAppId(String id) {
        _appId = id;
    }

    public void addScope(String scope){
        _scope.add(scope);
    }

    public String getOauthUrl() {
        String oauth = "https://www.facebook.com/v2.8/dialog/oauth"
                + "?client_id=" + _appId
                + "&redirect_uri=" + _redirectUri
                + "&response_type=" + _responseType
                + "&scope=" + buildScope();

        return oauth;
    }
    
    public void convertToLongTerm(String accessToken)
    {
        //String oauth = "https://graph.facebook.com/oauth/access_token?"
        //                      + "grant_type=fb_exchange_token"
        //                      + "&client_id=" + _appId
        //                      + "&client_secret=" + _appSecret
        //                      + "&fb_exchange_token=" + _currentAccessToken;
        
        Call<AccessToken> callToken = _router.getLongTermToken(_appId, _appSecret, accessToken);
        callToken.enqueue(new Callback<AccessToken>() {

            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> rspns) {
                AccessToken token = rspns.body();
                _currentAccessToken = token.getToken();
                
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, token.getExpires());
                _expiresDate = cal.getTime();
                
                // save
                saveData();
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable thrwbl) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
    private void saveData()
    {
        SavedData data = new SavedData();
        data.setTokenData(_currentAccessToken, _expiresDate.getTime());
        data.setAppId(_appId);
        
        Utils.saveData(data);
    }
    
    public void loadData()
    {
        SavedData data = Utils.loadData();
        
        _currentAccessToken = data.getToken();
        _expiresDate = new Date(data.getExpiresInMSecond());
        _appId = data.getAppId();
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        if(_expiresDate.before(cal.getTime()) || _currentAccessToken == null)
        {
            _currentUser = null;
            _currentAccessToken = null;
            
            return;
        }
        
        // update current user data
        updateCurrentUserData();
    }
    
    public boolean isLoggedIn()
    {
        if(_currentUser != null)
            return true;
        else
            return false;
    }
    
    public void logOut()
    {
        _currentAccessToken = null;
        _expiresDate = Calendar.getInstance().getTime();
        _currentUser = null;
        
        this.saveData();
    }
    
    public void updateCurrentUserData()
    {
        // get info current user
        Call<User> call = _router.retrieveInfo(User.buildFieldsParams(), FBManager.getInstance().getAccessToken());
        try
        {
            User user = call.execute().body();
            FBManager.getInstance().setCurrentUser(user);
            
            // lấy hình avatar mới
            Call<PictureData> picCall = _router.getUserPicture(200, 200, FBManager.getInstance().getAccessToken());
            PictureData picData = picCall.execute().body();
            FBManager.getInstance().getCurrentUser().setPictureData(picData);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
