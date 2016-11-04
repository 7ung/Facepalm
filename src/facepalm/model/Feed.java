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
    protected String _object_attachment;
    
    @SerializedName("comments")
    private FeedComment _comments;

    /**
     * @return the _comments
     */
    public FeedComment getComments() {
        return _comments;
    }
    
    public class FeedComment{
        @SerializedName("data")
        public ArrayList<Comment> comments;
        
        @SerializedName("paging")
        public Paging _paging;
    }    
    public static String buildFieldsParams(){
        return "id,message,created_time,comments";
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

    public String getObjectAttachment() {
        return _object_attachment;
    }
}
