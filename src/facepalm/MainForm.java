/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facepalm.fbservices.FBManager;
import facepalm.fbservices.LoginDialog;
import facepalm.fbservices.Router;
import facepalm.fbservices.ServiceUtils;
import facepalm.model.Privacy;
import facepalm.model.Feed;
import facepalm.model.User;
import facepalm.presenter.FeedPresenter;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Vinh
 */
public class MainForm extends javax.swing.JFrame implements IFeedView {

    private FeedPresenter _feedPresenter;
    
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        
        _feedPresenter = new FeedPresenter(this);
        
        FBManager.getInstance().loadData();

        // update UI
        updateUI();
    }
    
    private void loadImage(String imagePath)
    {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try
                {
                    URL url = new URL(imagePath);
                   
                    BufferedImage image = ImageIO.read(url);
                    System.out.println("Load image into frame...");
                    
                    Image img = image.getScaledInstance(avatarLabel.getWidth(), avatarLabel.getHeight(), Image.SCALE_SMOOTH);
                    
                    avatarLabel.setIcon(new ImageIcon(img));
                    
                    System.out.println("done.");
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
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

        tabbedPanel = new javax.swing.JTabbedPane();
        basicInfoTab = new javax.swing.JPanel();
        loginBtn = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        avatarLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputText = new javax.swing.JTextArea();
        sendBtn = new javax.swing.JButton();
        privacyComboBox = new javax.swing.JComboBox();
        linkInputText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        photosTab = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 150));

        tabbedPanel.setFocusable(false);

        basicInfoTab.setFocusable(false);

        loginBtn.setFocusable(false);
        loginBtn.setLabel("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        nameLabel.setText("Hello");

        avatarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        avatarLabel.setToolTipText("");
        avatarLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        inputText.setColumns(20);
        inputText.setRows(3);
        jScrollPane1.setViewportView(inputText);

        sendBtn.setText("�ang");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        privacyComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C�ng khai", "Ch? m�nh t�i", "B?n b�" }));

        jLabel1.setText("Link");

        javax.swing.GroupLayout basicInfoTabLayout = new javax.swing.GroupLayout(basicInfoTab);
        basicInfoTab.setLayout(basicInfoTabLayout);
        basicInfoTabLayout.setHorizontalGroup(
            basicInfoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicInfoTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basicInfoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(loginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(avatarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(basicInfoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(basicInfoTabLayout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basicInfoTabLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(linkInputText, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(privacyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendBtn)))
                .addContainerGap())
        );
        basicInfoTabLayout.setVerticalGroup(
            basicInfoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicInfoTabLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(basicInfoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(basicInfoTabLayout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(avatarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(basicInfoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginBtn)
                    .addComponent(privacyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendBtn)
                    .addComponent(linkInputText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        tabbedPanel.addTab("Tr?ng th�i", basicInfoTab);

        javax.swing.GroupLayout photosTabLayout = new javax.swing.GroupLayout(photosTab);
        photosTab.setLayout(photosTabLayout);
        photosTabLayout.setHorizontalGroup(
            photosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );
        photosTabLayout.setVerticalGroup(
            photosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );

        tabbedPanel.addTab("tab2", photosTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPanel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPanel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
        if(FBManager.getInstance().isLoggedIn())
        {
            FBManager.getInstance().logOut();
            updateUI();
            return;
        
        }
        // login
        String oauth = FBManager.getInstance().getOauthUrl();

        LoginDialog login = new LoginDialog("Login", oauth, "connect/login_success.html");
        login.setVisible(true);

        login.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                // save current access token
                FBManager.getInstance().setAccessToken(login._token, login._expiresDate);
                
                FBManager.getInstance().updateCurrentUserData();
                
                // update UI
                updateUI();
            }
        });
    }//GEN-LAST:event_loginBtnActionPerformed

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        // TODO add your handling code here:
        
        Feed feed = new Feed();
        feed.setData(inputText.getText(), linkInputText.getText(), "", "", "", "", "", "", "");
        
        _feedPresenter.sendStatus(feed, privacyComboBox.getSelectedIndex());
    }//GEN-LAST:event_sendBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
    
    @Override
    public void updateUI()
    {
        if(FBManager.getInstance().isLoggedIn())
        {
           // get user data
           User user = FBManager.getInstance().getCurrentUser();

           nameLabel.setText("Xin ch�o " + user.getName() + ", b?n dang nghi g�? :)");
           
           loadImage(user.getPicture().getUrl());
           
           loginBtn.setText("�ang xu?t");
           sendBtn.setEnabled(true);
           inputText.setEnabled(true);
           linkInputText.setEnabled(true);
           privacyComboBox.setEnabled(true);
        }
        else
        {
           nameLabel.setText("B?m n�t d? dang nh?p.");
           avatarLabel.setIcon(null);
           
           loginBtn.setText("�ang nh?p");
           sendBtn.setEnabled(false);
           inputText.setEnabled(false);
           linkInputText.setEnabled(false);
           privacyComboBox.setEnabled(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatarLabel;
    private javax.swing.JPanel basicInfoTab;
    private javax.swing.JTextArea inputText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField linkInputText;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel photosTab;
    private javax.swing.JComboBox privacyComboBox;
    private javax.swing.JButton sendBtn;
    private javax.swing.JTabbedPane tabbedPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateUserFeed() {
        inputText.setText("");
        linkInputText.setText("");
    }
}
