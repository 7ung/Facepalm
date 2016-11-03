/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.presenter;

import facepalm.model.User.PictureWrap;

/**
 *
 * @author Stevie
 */
public interface IPicturePresenter {
    void loadUserPicture(int width, int height);
    void loadPeoplePicture(String userid, int width, int height);
}
