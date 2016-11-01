/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.model;

import com.google.gson.annotations.SerializedName;

/**
 * Thông tin các album ảnh của User
 * @author Stevie
 */
public class Album extends BaseConnector{
        
    
    @SerializedName("description")
    private String _description;   

    @SerializedName("updated_time")
    private String _updated_time;    
    
    @SerializedName("count")    
    private int _count;     //Tổng số ảnh + video
    
    @SerializedName("photo_count")    
    private int _photo_count; 
        
    @SerializedName("video_count")    
    private int _video_count; 
    
    @SerializedName("link")
    private String _link;        
}
