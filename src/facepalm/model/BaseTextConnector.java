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
    private String _created_time;
    
    @SerializedName("privacy")
    private Privacy _privacy;
    
    public void setMessage(String message, Privacy privacy)
    {
        _message = message;
        _privacy = privacy;
    }
    
    public String getMessage()
    {
        return _message;
    }
    
    public String getId()
    {
        return _id;
    }

    /**
     * @return the _created_time
     */
    public String getCreatedTime() {
        return _created_time;
    }

    /**
     * @return the _privacy
     */
    public Privacy getPrivacy() {
        return _privacy;
    }
    
}
