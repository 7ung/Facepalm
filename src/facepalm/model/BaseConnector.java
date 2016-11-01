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
public class BaseConnector {
    @SerializedName("id")    
    protected String _id;
    
    @SerializedName("name")
    protected String _name;
    
    @SerializedName("created_time")
    protected String _created_time;

    /**
     * @return the _id
     */
    public String getId() {
        return _id;
    }

    /**
     * @return the _name
     */
    public String getName() {
        return _name;
    }

    /**
     * @return the _created_time
     */
    public String getCreated_time() {
        return _created_time;
    }
}
