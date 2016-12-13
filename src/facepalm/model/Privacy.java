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
    public Privacy(eType value) {
        _eValue = value;
    }
    //@SerializedName("value")
    private String _value;
    
    @SerializedName("value")
    private eType _eValue;
    
    @SerializedName("allow")
    private String _allow;

    @SerializedName("deny")
    private String _deny;
    
    @SerializedName("description")
    private String _description;

    /**
     * @return the _value
     */
    public String getValue() {
        //return _value;
        return _eValue.toString();
    }

    /**
     * @return the _allow
     */
    public String getAllow() {
        return _allow;
    }

    /**
     * @return the _deny
     */
    public String getDeny() {
        return _deny;
    }

    /**
     * @return the _description
     */
    public String getDescription() {
        return _description;
    }

    /**
     * @return the _eValue
     */
    public eType geteValue() {
        return _eValue;
    }
    
    public enum eType {
        @SerializedName("SELF")
        SELF,
        @SerializedName("EVERYONE")
        EVERYONE,
        @SerializedName("ALL_FRIENDS")
        ALL_FRIENDS,
        @SerializedName("FRIENDS_OF_FRIENDS")
        FRIENDS_OF_FRIENDS,
        @SerializedName("CUSTOM")
        CUSTOM
    }
}
