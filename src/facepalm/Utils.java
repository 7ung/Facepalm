package facepalm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facepalm.model.SavedData;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stevie
 */
public class Utils {
    public static final String USER_ACCESS_TOKEN = 
            "EAAZAPZCLXpWGYBAAZBdjkQBWCmaBSqX260Q5HqeWwbSTGnOxvRIawDkE8o0O8n4ELWksMZBGMdZA4IKu7R6YZBmL8vB7Ux0C6sYtxZAMpn0SJ8pTx7tCdkZBFqa1MLIUyoiym8ptjlMlFluS5GIAJzMy0NUF9soGjE7uZC9r1FRy7DwZDZD";
    public static final String APP_ID = "1776796662585446";
    public static final String CONFIG_PATH = "config.json";
    
    public static void saveData(SavedData data)
    {
        try
        {
            Writer writer = new FileWriter(CONFIG_PATH);
            
            Gson gson = new GsonBuilder().create();
            gson.toJson(data, writer);
            
            writer.close();
        }
        catch(Exception ex)
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
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return null;
    }
}
