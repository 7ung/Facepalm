/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.fbservices;

import facepalm.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *
 * @author Stevie
 */
public interface Router {
    
    @GET("me/")
    Call<User> retrieveInfo(@Query("fields") String fields, @Query("access_token") String token);
  
}
