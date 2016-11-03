/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm;

import facepalm.model.User;

/**
 *
 * @author Stevie
 */
public interface IPictureView {

    public void updateView(User.PictureWrap album);
    
}
