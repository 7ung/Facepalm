/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.fbservices;

import facepalm.fbservices.FBManager.AccessToken;
import facepalm.model.User;
import facepalm.model.User.PictureData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 *
 * @author Stevie
 */
public interface Router {
    
    @GET("me/")
    Call<User> retrieveInfo(@Query("fields") String fields, @Query("access_token") String token);
  
    @GET("me/picture?redirect=false")
    Call<PictureData> getUserPicture(@Query("width") int width, @Query("height") int height, @Query("access_token") String token);
    
    @GET("{path}")
    <T> T getData(@Path("path") String path, @Query("access_token") String token);
    
    @GET("oauth/access_token?grant_type=fb_exchange_token")
    Call<AccessToken> getLongTermToken(
            @Query("client_id") String appId, 
            @Query("client_secret") String appSecret,
            @Query("fb_exchange_token") String token);
}
