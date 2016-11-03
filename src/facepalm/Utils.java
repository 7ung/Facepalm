package facepalm;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stevie
 */
public class Utils {
    public static final String APP_ID = "1776796662585446";

    public static void loadImage(JLabel label, String path){
                        
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
            try {
                    URL url = new URL(path);
                    BufferedImage image = ImageIO.read(url);
                    Image img = image.getScaledInstance(
                            label.getPreferredSize().width,
                            label.getPreferredSize().height,
                            Image.SCALE_SMOOTH);
                    label.setIcon(new ImageIcon(image));
                } catch (Exception exp) {
                    exp.printStackTrace();
                }                        
            }
        });
    }
}
