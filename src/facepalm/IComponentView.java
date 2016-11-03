/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm;

/**
 *
 * @author Stevie
 */
public interface IComponentView <T>{
    void startLoading(String componentId);
    void updateView(T album);
}
