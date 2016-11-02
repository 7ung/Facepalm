/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.fbservices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author Stevie
 */
public class ServiceUtils {
    public static final String HOME = "https://graph.facebook.com/";
    public static final String VERSION = "v2.8/";
    
    private static Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(HOME + VERSION)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    
    public static <T> T createService(Class<T> apiClass){
        return retrofit.create(apiClass);
    }
}
