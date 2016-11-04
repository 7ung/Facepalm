/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm;

import facepalm.model.Feed;
import java.util.ArrayList;

/**
 *
 * @author Vinh
 */
public interface IFeedView {
    void updateUI();
    void updateUserFeed();
    void updateFeed(ArrayList<Feed> feeds);
}
