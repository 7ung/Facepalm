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
public class Paging{

    @SerializedName("cursors")            
    private Cursor cursor;

    @SerializedName("next")
    private String _next;
    
    @SerializedName("previous")
    private String _previous;
    
    private class Cursor{
        @SerializedName("before")            
        private String before;

        @SerializedName("after")            
        private String after;
    }
    
    
}
