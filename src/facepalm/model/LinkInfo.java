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
public class LinkInfo {
    @SerializedName("picture")
    private String _picture;
    
    @SerializedName("name")
    private String _name;
    
    @SerializedName("caption")
    private String _caption;
    
    @SerializedName("description")
    private String _description;
    
}
