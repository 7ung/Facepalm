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
public class AccessToken {

    @SerializedName("access_token")
    private String _accessToken;

    @SerializedName("expires_in")
    private int _expiresSecond;

    @SerializedName("machine_id")
    private String _machineId;

    public String getToken() {
        return _accessToken;
    }

    public int getExpires() {
        return _expiresSecond;
    }
}
