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
public class Comment extends BaseTextConnector{
    
    @SerializedName("from")
    private BaseConnector _from;

    /**
     * @return the _from
     */
    public BaseConnector getFrom() {
        return _from;
    }

    /**
     * @param _from the _from to set
     */
    public void setFrom(BaseConnector _from) {
        this._from = _from;
    }
}
