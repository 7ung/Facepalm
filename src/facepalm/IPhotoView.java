/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm;

import facepalm.model.Album;
import facepalm.model.Photo;
import facepalm.model.User;
import java.util.List;

/**
 *
 * @author Stevie
 */
public interface IPhotoView extends IComponentView<Photo>{

    void updateListView(User.UserPhoto photos);
}
