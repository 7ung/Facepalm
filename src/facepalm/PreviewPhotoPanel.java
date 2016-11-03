/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm;

import facepalm.model.Photo;
import facepalm.model.User;
import facepalm.presenter.IPhotoPresenter;
import facepalm.presenter.PhotoPresenterImpl;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author Stevie
 */
public class PreviewPhotoPanel extends javax.swing.JPanel implements IPhotoView{

    private IPhotoPresenter photoPresenter;

    
    /**
     * Creates new form PreviewPhotoPanell
     */
    public PreviewPhotoPanel() {
        initComponents();
        photoPresenter = new PhotoPresenterImpl(this);

        this.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
//                PreviewPhotoPanel.this.startLoading(null);

            }
        });
        
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
//                PreviewPhotoPanel.this.startLoading(null);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 2));
        setMaximumSize(new java.awt.Dimension(260, 32767));
        setMinimumSize(new java.awt.Dimension(260, 0));
        setPreferredSize(new java.awt.Dimension(260, 0));
        setLayout(new java.awt.GridLayout(2, 2, 4, 4));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateListView(User.UserPhoto userPhotos) {
        List<Photo> photos = userPhotos._photos;
        // todo: update list ảnh
        if (photos.size() <= 6) {
//            ((GridLayout)this.getLayout()).setRows(photos.size() >> 1);
//            
//            for (int i = 0; i < photos.size(); ++i){
//                
//                JLabel label = new JLabel();
//                label.setMinimumSize(new Dimension(130, 130));
//                Utils.loadImage(label, 
//                    photos.get(i).getImage().get(photos.get(i).getImage().size() - 2)._source);
//                this.add(label);
//            }
            
        } else {
            ((GridLayout)this.getLayout()).setRows(3);
            this.setPreferredSize(new Dimension(260, 130* 3));
             
            ArrayList<Photo> temp = new ArrayList<>(6);
            int rand;
            for (int i = 0; i < 6; ++i){
                do{
                    rand = (int) (Math.random() * photos.size());
                }
                while (temp.contains(photos.get(rand)));
                
                JLabel label = new JLabel();
                label.setMinimumSize(new Dimension(130, 130));
                label.setPreferredSize(new Dimension(130, 130));
                label.setMaximumSize(new Dimension(130, 130));
                this.add(label);
                temp.add(photos.get(rand));
                Utils.loadImage(label, 
                    temp.get(i).getImage().get(temp.get(i).getImage().size() - 2)._source);
            }
            
        }
    }

    @Override
    public void startLoading(String componentId) {
        if (componentId == null) {
            photoPresenter.loadUserPhotos();
        } else {
            photoPresenter.loadPhotoInfo(componentId);
        }
    }

    @Override
    public void updateView(Photo album) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
