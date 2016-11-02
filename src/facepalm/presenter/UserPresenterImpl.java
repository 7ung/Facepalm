/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.presenter;

import facepalm.IUserView;
import facepalm.Utils;
import facepalm.fbservices.FBManager;
import facepalm.fbservices.Router;
import facepalm.fbservices.ServiceUtils;
import facepalm.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * @author Stevie
 */
public class UserPresenterImpl implements IUserPresenter{
    private static Router sRouter = ServiceUtils.createService(Router.class);

    private IUserView iView;
    private User mUser;
    
    public UserPresenterImpl(IUserView view){
        iView = view;
    }
    
    @Override
    public void loadUserInfo(){
                
        Call<User> call = sRouter.retrieveInfo(User.buildFieldsParams(), FBManager.getInstance().getAccessToken());
        call.enqueue(mUserCallback);
        
    }
    
    private Callback mUserCallback = new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                mUser = response.body();
                iView.updateUserInfo(mUser);
            }

            @Override
            public void onFailure(Call<User> call, Throwable thrwbl) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

    /**
     * @return the mUser
     */
    public User getmUser() {
        return mUser;
    }

}
