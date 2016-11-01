/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm;

import facepalm.fbservices.Router;
import facepalm.fbservices.Utils;
import facepalm.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * @author Stevie
 */
public class Facepalm {

    private static final String USER_ACCESS_TOKEN = "insert your token here";
    private static User mUser;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Router router = Utils.createService(Router.class);
        router.retrieveInfo(
                        User.buildFieldsParams(), 
                        USER_ACCESS_TOKEN)
                    .enqueue(
        new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                mUser = response.body();

            }

            @Override
            public void onFailure(Call<User> call, Throwable thrwbl) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }
        );

    }

}

