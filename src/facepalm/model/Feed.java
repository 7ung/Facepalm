/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Stevie
 */
public class Feed {
    @SerializedName("id")    
    private String _id;
    
    @SerializedName("message")
    private String _message;
    
    @SerializedName("created_time")
    private String _created_time;
}
