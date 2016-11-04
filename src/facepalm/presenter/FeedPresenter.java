/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.presenter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facepalm.IFeedView;
import facepalm.fbservices.FBManager;
import facepalm.fbservices.Router;
import facepalm.fbservices.ServiceUtils;
import facepalm.model.Feed;
import facepalm.model.Parameters;
import facepalm.model.Privacy;
import facepalm.model.User.UserFeed;
import java.io.IOException;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * @author Vinh
 */
public class FeedPresenter {
    
    private IFeedView _view;
    
    private Router _router = ServiceUtils.createService(Router.class);
    
    private ArrayList<Feed> _feeds = new ArrayList<Feed>();
    
    public FeedPresenter(IFeedView view)
    {
        _view = view;
    }
    
    public void sendStatus(Feed status, int privacyIndex)
    {
        Privacy.eType type = Privacy.eType.SELF;
        
        switch (privacyIndex) {
            case 0:
                type = Privacy.eType.EVERYONE;
                break;
            case 1:
                type = Privacy.eType.SELF;
                break;
            case 2:
                type = Privacy.eType.ALL_FRIENDS;
                break;
            default:
                break;
        }
        
        Privacy privacy = new Privacy(type.toString());
        // build privacy data
        Gson gson = new GsonBuilder().create();
        String pr = gson.toJson(privacy);
        
        Parameters params = new Parameters();
        params.add("message", status.getMessage());
        params.add("link", status.getLink());
        params.add("picture", status.getPicture());
        params.add("name", status.getName());
        params.add("caption", status.getCaption());
        params.add("description", status.getDescription());
        params.add("place", status.getPlace());
        params.add("tags", status.getTags());
        params.add("object_attachment", status.getObjectAttachment());
        params.add("privacy", pr);
        
        try {
            // post status
            Call<Feed> call = _router.postStatus(params, FBManager.getInstance().getAccessToken());
            Feed result = call.execute().body();
            
            // get post data
            //Call<Feed> feedCall = _router.getPost(result.getId(), FBManager.getInstance().getAccessToken());
            //Feed f = feedCall.execute().body();
            //_feeds.add(f);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        _view.updateUserFeed();
    }
    
    public void loadUserFeed(){
        Call<UserFeed> call  = _router.retriveUserFeed(
                Feed.buildFieldsParams(),
                FBManager.getInstance().getAccessToken());
        call.enqueue(new Callback<UserFeed>() {

            @Override
            public void onResponse(Call<UserFeed> call, Response<UserFeed> rspns) {
                UserFeed feeds = rspns.body();
                _view.updateFeed(feeds._feeds);
            }

            @Override
            public void onFailure(Call<UserFeed> call, Throwable thrwbl) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
    }
}
