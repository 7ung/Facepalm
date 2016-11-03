/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.presenter;

import facepalm.IAlbumView;
import facepalm.IUserView;
import facepalm.fbservices.FBManager;
import facepalm.fbservices.Router;
import facepalm.fbservices.ServiceUtils;
import facepalm.model.Album;
import facepalm.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * @author Stevie
 */
public class AlbumPresenterImpl implements IAlbumPresenter {
    private static Router sRouter = ServiceUtils.createService(Router.class);

    private IAlbumView iView;
    private Callback<Album> mAlbumCallback = new Callback<Album>() {

        @Override
        public void onResponse(Call<Album> call, Response<Album> rspns) {
            Album album = rspns.body();
            iView.updateView(album);
        }

        @Override
        public void onFailure(Call<Album> call, Throwable thrwbl) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };

    public AlbumPresenterImpl(IAlbumView view){
        iView = view;
    }
    
    @Override
    public void loadAlbumInfo(String albumId) {
        Call<Album> call = sRouter.retrieveAlbum(albumId, 
                Album.buildFieldsParams(), 
                FBManager.getInstance().getAccessToken());
        call.enqueue(mAlbumCallback);        
    }
    
    
}
