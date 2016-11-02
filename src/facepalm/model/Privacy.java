/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Vinh
 */
public class Privacy {

    public Privacy(String value) {
        _value = value;
    }

    @SerializedName("value")
    private String _value;

    @SerializedName("allow")
    private String _allow;

    @SerializedName("deny")
    private String _deny;
    
    public enum eType {
        SELF,
        EVERYONE,
        ALL_FRIENDS,
        FRIENDS_OF_FRIENDS,
        CUSTOM
    }
}
