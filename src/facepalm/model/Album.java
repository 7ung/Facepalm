/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

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
    
    @SerializedName("link")
    private String _link;  
    
    @SerializedName("comments")
    private AlbumComment _comments;
    
    @SerializedName("likes")
    private AlbumLike _likes;

    @SerializedName("photos")    
    private AlbumPhoto _photos;
    
    @SerializedName("cover_photo")    
    private BaseConnector _cover_photo;
    
    /**
     * @return the _description
     */
    public String getDescription() {
        return _description;
    }

    /**
     * @return the _updated_time
     */
    public String getUpdated_time() {
        return _updated_time;
    }

    /**
     * @return the _count
     */
    public int getCount() {
        return _count;
    }

    /**
     * @return the _link
     */
    public String getLink() {
        return _link;
    }

    /**
     * @return the _comments
     */
    public AlbumComment getComments() {
        return _comments;
    }

    /**
     * @return the _likes
     */
    public AlbumLike getLikes() {
        return _likes;
    }

    /**
     * @return the _photos
     */
    public AlbumPhoto getPhotos() {
        return _photos;
    }

    /**
     * @return the _cover_photo
     */
    public BaseConnector getCoverPhoto() {
        return _cover_photo;
    }
    
    private class AlbumComment{
        @SerializedName("data")
        private ArrayList<Comment> _feeds;
        
        @SerializedName("paging")
        private Paging _paging;
    }
    
    private class AlbumLike{
        @SerializedName("data")
        private ArrayList<Like> _feeds;
        
        @SerializedName("paging")
        private Paging _paging;
    }
    
    private class AlbumPhoto{
        @SerializedName("data")
        private ArrayList<Photo> _feeds;
        
        @SerializedName("paging")
        private Paging _paging;
    }
    
    public static String buildFieldsParams(){
        // để sau bỏ vô cái list cho dễ
        return "id,name,created_time,description,updated_time,count,link,comments,likes,photos,cover_photo";
    }
}
