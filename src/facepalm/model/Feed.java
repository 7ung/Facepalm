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
public class Feed extends BaseTextConnector {

    @SerializedName("link")
    protected String _link;

    @SerializedName("name")
    protected String _name;

    @SerializedName("caption")
    protected String _caption;

    @SerializedName("description")
    protected String _description;

    @SerializedName("picture")
    protected String _picture;

    @SerializedName("place")
    protected String _place;

    @SerializedName("tags")
    protected String _tags;

    @SerializedName("object_attachment")
    private String _object_attachment;
    
    @SerializedName("comments")
    private FeedComment _comments;

    @SerializedName("status_type")
    private eStatusType _status_type;
    
    @SerializedName("type")
    private eType _type;
    
    @SerializedName("full_picture")
    private String _full_picture;
    
    /**
     * @return the _comments
     */
    public FeedComment getComments() {
        return _comments;
    }

    /**
     * @return the _object_attachment
     */
    public String getObject_attachment() {
        return _object_attachment;
    }

    /**
     * @return the _status_type
     */
    public eStatusType getStatus_type() {
        return _status_type;
    }

    /**
     * @return the _type
     */
    public eType getType() {
        return _type;
    }

    /**
     * @return the _full_picture
     */
    public String getFullPicture() {
        return _full_picture;
    }
    
    public class FeedComment{
        @SerializedName("data")
        public ArrayList<Comment> comments;
        
        @SerializedName("paging")
        public Paging _paging;
    }    
    public static String buildFieldsParams(){
        return "id,message,created_time,comments, privacy, full_picture,status_type, type";
    }
    
    public void setData(String message, String link, String name, String caption, String desc, String picture, String place,
                        String tags, String objectAtt)
    {
        _message = message;
        _link = link;
        _name = name;
        _caption = caption;
        _description = desc;
        _picture = picture;
        _place = place;
        _tags = tags;
        _object_attachment = objectAtt;
    }

    public String getLink() {
        return _link;
    }

    public String getName() {
        return _name;
    }

    public String getCaption() {
        return _caption;
    }

    public String getDescription() {
        return _description;
    }

    public String getPicture() {
        return _picture;
    }

    public String getPlace() {
        return _place;
    }

    public String getTags() {
        return _tags;
    }
    
    /**
     *  Status type là loại bài đăng của feed
     *  @see Feed
     */
    public enum eStatusType{
        @SerializedName("mobile_status_update")
        MOBILE_STATUS_UPDATE,
        @SerializedName("created_note")
        CREATED_NOTE,
        @SerializedName("added_photos")
        ADDED_PHOTOS,
        @SerializedName("added_video")
        ADDED_VIDEO,
        @SerializedName("shared_story")
        SHARED_STORY,
        @SerializedName("created_group")
        CREATED_GROUP, 
        @SerializedName("created_event")
        CREATED_EVENT, 
        @SerializedName("wall_post")
        WALL_POST, 
        @SerializedName("app_created_story")
        APP_CREATED_STORY, 
        @SerializedName("published_story")
        PUBLISHED_STORY, 
        @SerializedName("tagged_in_photo")
        TAGGED_IN_PHOTO,
        @SerializedName("approved_friend")
        APPROVED_FRIEND
    }
    
    public enum eType {
        @SerializedName("link")
        LINK, 
        @SerializedName("status")
        STATUS, 
        @SerializedName("photo")
        PHOTO, 
        @SerializedName("video")
        VIDEO, 
        @SerializedName("offer")
        OFFER
    }
}
