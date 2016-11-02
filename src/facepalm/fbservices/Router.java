/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.fbservices;

import facepalm.model.AccessToken;
import facepalm.model.Album;
import facepalm.model.Feed;
import facepalm.model.Privacy;
import facepalm.model.User;
import facepalm.model.User.PictureData;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 *
 * @author Stevie
 */
public interface Router {
    
    @GET("me/")
    Call<User> retrieveInfo(@Query("fields") String fields, @Query("access_token") String token);
  
    @GET("{album_id}/")
    Call<Album> retrieveAlbum(@Path("album_id") String albumId, @Query("fields") String fields, @Query("access_token") String token);
  
    @GET("me/picture?redirect=false")
    Call<PictureData> getUserPicture(@Query("width") int width, @Query("height") int height, @Query("access_token") String token);
    
    @GET("oauth/access_token?grant_type=fb_exchange_token")
    Call<AccessToken> getLongTermToken(
            @Query("client_id") String appId, 
            @Query("client_secret") String appSecret,
            @Query("fb_exchange_token") String token);
    
    @POST("me/feed")
    Call<Feed> postStatus(@Query("message") String message, @Query("privacy") String privacy ,@Query("access_token") String token);
    
    @GET("{post_id}")
    Call<Feed> getPost(@Path("post_id") String postId, @Query("access_token") String token);
    
    @POST("me/feed")
    Call<Feed> postStatus(@QueryMap Map<String, String> parameters, @Query("access_token") String token);
}
