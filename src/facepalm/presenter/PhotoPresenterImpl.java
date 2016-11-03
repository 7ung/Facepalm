/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.presenter;

import facepalm.IPhotoView;
import facepalm.fbservices.FBManager;
import facepalm.fbservices.Router;
import facepalm.fbservices.ServiceUtils;
import facepalm.model.Album;
import facepalm.model.Photo;
import facepalm.model.User.UserPhoto;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * @author Stevie
 */
public class PhotoPresenterImpl implements IPhotoPresenter{

    private static Router sRouter = ServiceUtils.createService(Router.class);
    
    private IPhotoView iView;

    private Callback<Photo> mPhotoCallback = new Callback<Photo>() {

        @Override
        public void onResponse(Call<Photo> call, Response<Photo> rspns) {
            Photo photo = rspns.body();
            iView.updateView(photo);
        }

        @Override
        public void onFailure(Call<Photo> call, Throwable thrwbl) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    
    private Callback<UserPhoto> mUserPhotosCallback = new Callback<UserPhoto>() {

        @Override
        public void onResponse(Call<UserPhoto> call, Response<UserPhoto> rspns) {
            UserPhoto photo = rspns.body();
            iView.updateListView(photo);
        }

        @Override
        public void onFailure(Call<UserPhoto> call, Throwable thrwbl) {
            System.out.print(thrwbl.getMessage());
        }
    };
    public PhotoPresenterImpl(IPhotoView view){
        iView = view;
    }
    
    @Override
    public void loadPhotoInfo(String id) {
        Call<Photo> call = sRouter.retrievePhoto(id, 
                Photo.buildFieldsParams(), 
                FBManager.getInstance().getAccessToken());
        call.enqueue(mPhotoCallback);         
    }
    
    @Override
    public void loadUserPhotos(){
        Call<UserPhoto> call = sRouter.retrieveUserPhotos(
            Photo.buildFieldsParams(), 
            FBManager.getInstance().getAccessToken());
        call.enqueue(mUserPhotosCallback);
    }
}
