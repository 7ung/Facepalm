/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.fbservices;

import facepalm.model.Album;
import facepalm.model.Photo;
import facepalm.model.User;
import facepalm.model.User.PictureWrap;
import facepalm.model.User.UserPhoto;
import java.util.List;
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
  
    @GET("{album_id}/")
    Call<Album> retrieveAlbum(@Path("album_id") String albumId, @Query("fields") String fields, @Query("access_token") String token);
  
    @GET("{photo_id}/")
    Call<Photo> retrievePhoto(@Path("photo_id") String albumId, @Query("fields") String fields, @Query("access_token") String token);
    
    @GET("me/photos/")
    Call<UserPhoto> retrieveUserPhotos(@Query("fields") String fields, @Query("access_token") String token);
    
    @GET("me/picture?redirect=false")
    Call<PictureWrap> retrivePicture(@Query("width") int width, @Query("height") int height, @Query("access_token") String token);

    @GET("{user_id}/picture?redirect=false")
    Call<PictureWrap> retrivePeoplePicture(@Path("user_id") String userId, @Query("width") int width, @Query("height") int height, @Query("access_token") String token);
    
}
