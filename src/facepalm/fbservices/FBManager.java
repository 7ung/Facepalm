/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.fbservices;

import facepalm.model.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Vinh
 */
public class FBManager {

    private FBManager() {
    }
    
    private static FBManager _instance = null;

    private String _currentAccessToken;
    private Date _expiresDate;
    private User _currentUser;

    private String _appId;
    private String _redirectUri = "https://www.facebook.com/connect/login_success.html";
    private String _responseType = "token";
    
    /**
     * Use for ...
     */
    private static final String SCOPE_USER_ABOUT_ME = "user_about_me";
    
    /**
     * Use for ...
     */
    private static final String SCOPE_EMAIL = "email";
    
    /**
     * Use for ...
     */
    private static final String SCOPE_USER_POSTS = "user_posts";

    private static ArrayList<String> _scope = new ArrayList<>();
    static {
        _scope.add(SCOPE_USER_ABOUT_ME);
        _scope.add(SCOPE_EMAIL);
        _scope.add(SCOPE_USER_POSTS);
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

    public void setAccessToken(String token) {
        _currentAccessToken = token;
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

    public void createLoginInfo(String appId, String redirect, String responseType, String scope) {
        _appId = appId;
        _redirectUri = redirect;
        _responseType = responseType;
//        _scope = scope;
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
}
