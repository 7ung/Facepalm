/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 *
 * @author Stevie
 */
public class Photo extends BaseConnector{
    
    public static String buildFieldsParams(){
        // để sau bỏ vô cái list cho dễ
        return "id,created_time,images,picture,updated_time,comments,likes";
    } 
    @SerializedName("images")
    private ArrayList<Image> _image;
    
    @SerializedName("picture")
    private String _picture;            // thumbnail 
    
    @SerializedName("updated_time")
    private String _updated_time;
    
    @SerializedName("comments")
    private PhotoComment _comments;
    
    @SerializedName("likes")
    private PhotoLike _like;

    /**
     * @return the _image
     */
    public ArrayList<Image> getImage() {
        return _image;
    }

    /**
     * @return the _picture
     */
    public String getPicture() {
        return _picture;
    }

    /**
     * @return the _updated_time
     */
    public String getUpdated_time() {
        return _updated_time;
    }

    /**
     * @return the _comments
     */
    public PhotoComment getComments() {
        return _comments;
    }

    /**
     * @return the _like
     */
    public PhotoLike getLike() {
        return _like;
    }
    
    public class Image {
        @SerializedName("height")
        public int _height;

        @SerializedName("width")        
        public int _width;
        
        @SerializedName("source")        
        public String _source;
    }
    
    private class PhotoComment{
        @SerializedName("data")
        private ArrayList<Comment> _feeds;
        
        @SerializedName("paging")
        private Paging _paging;
    }
    
    private class PhotoLike{
        @SerializedName("data")
        private ArrayList<Like> _feeds;
        
        @SerializedName("paging")
        private Paging _paging;
    }
}
