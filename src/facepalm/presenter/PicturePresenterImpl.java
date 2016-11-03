/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.presenter;

import com.sun.javafx.scene.web.Debugger;
import facepalm.IAlbumView;
import facepalm.IPictureView;
import facepalm.fbservices.FBManager;
import facepalm.fbservices.Router;
import facepalm.fbservices.ServiceUtils;
import facepalm.model.Album;
import facepalm.model.User.PictureWrap;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * @author Stevie
 */
public class PicturePresenterImpl implements IPicturePresenter{
    private static Router sRouter = ServiceUtils.createService(Router.class);

    private IPictureView iView;
    private Callback<PictureWrap> mPictureCallback = new Callback<PictureWrap>() {

        @Override
        public void onResponse(Call<PictureWrap> call, Response<PictureWrap> rspns) {
            PictureWrap album = rspns.body();
            iView.updateView(album);
        }

        @Override
        public void onFailure(Call<PictureWrap> call, Throwable thrwbl) {
            System.out.println(thrwbl.getMessage());

        }
    };
    public PicturePresenterImpl(IPictureView view){
        iView = view;
    }
    
    @Override
    public void loadUserPicture(int width, int height) {
        Call<PictureWrap> call = sRouter.retrivePicture(width, height, FBManager.getInstance().getAccessToken());
        call.enqueue(mPictureCallback);
    }

    @Override
    public void loadPeoplePicture(String userid, int width, int height) {
        Call<PictureWrap> call = sRouter.retrivePeoplePicture(
                userid, 
                width, height, 
                FBManager.getInstance().getAccessToken());
        call.enqueue(mPictureCallback);
    }

    
}
