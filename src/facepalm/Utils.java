package facepalm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facepalm.model.SavedData;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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

    public static void loadImage(JLabel label, String path){
                        
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
            try {
                    URL url = new URL(path);
                    BufferedImage image = ImageIO.read(url);
                    Image img = image.getScaledInstance(
                            label.getPreferredSize().width,
                            label.getPreferredSize().height,
                            Image.SCALE_SMOOTH);
                    label.setIcon(new ImageIcon(image));
                } catch (Exception exp) {
                    exp.printStackTrace();
                }                        
            }
        });
    }
}
