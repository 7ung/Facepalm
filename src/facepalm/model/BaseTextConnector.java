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
public class BaseTextConnector {
    @SerializedName("id")    
    protected String _id;
    
    @SerializedName("message")
    protected String _message;
    
    @SerializedName("created_time")
    protected String _created_time;
}
