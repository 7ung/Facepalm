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
public class SavedData {

    @SerializedName("access_token")
    private String _token = "";

    @SerializedName("expires_in_milisecond")
    private long _expiresMSecond;

    @SerializedName("app_id")
    private String _appId = "";

    public void setTokenData(String token, long expiresMSec) {
        _token = token;
        _expiresMSecond = expiresMSec;
    }

    public String getToken() {
        return _token;
    }

    public long getExpiresInMSecond() {
        return _expiresMSecond;
    }

    public String getAppId() {
        return _appId;
    }

    public void setAppId(String appId) {
        _appId = appId;
    }
}
