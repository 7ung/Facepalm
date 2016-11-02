/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.fbservices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonWriter;
import facepalm.fbservices.FBManager.AccessToken;
import facepalm.fbservices.FBManager.SavedData;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author Stevie
 */
public class ServiceUtils {
    public static final String HOME = "https://graph.facebook.com/";
    public static final String VERSION = "v2.8/";
    public static final String CONFIG_PATH = "config.json";
    
    private static Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(HOME + VERSION)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    
    public static <T> T createService(Class<T> apiClass){
        return retrofit.create(apiClass);
    }
    
    public static void saveData(SavedData data)
    {
        try
        {
            Writer writer = new FileWriter(CONFIG_PATH);
            
            Gson gson = new GsonBuilder().create();
            gson.toJson(data, writer);
            
            writer.close();
        }
        catch (IOException | JsonIOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public static SavedData loadData()
    {
        try
        {
            Reader reader = new FileReader(CONFIG_PATH);
            
            Gson gson = new GsonBuilder().create();
            SavedData data = gson.fromJson(reader, SavedData.class);
            
            reader.close();
            
            return data;
        }
        catch (IOException | JsonIOException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return null;
    }
}
