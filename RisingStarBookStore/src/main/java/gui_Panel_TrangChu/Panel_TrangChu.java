package gui_Panel_TrangChu;

import gui_Dialog.Message;
import gui_Frame_Running.Frame_Chinh;

import java.awt.Color;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.raven.model.SettingModel;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;

import customEntities.Custom_ImageIcon;

import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Panel_TrangChu extends javax.swing.JPanel {
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private SettingModel settingModel;
    // End of variables declaration//GEN-END:variables
    public Panel_TrangChu() {
        initComponents();
        setOpaque(false);
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel1)
        				.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 259, Short.MAX_VALUE)
        				.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 259, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 181, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(0)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(11)
        					.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 285, Short.MAX_VALUE)
        					.addContainerGap())
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 124, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 145, Short.MAX_VALUE)
        					.addGap(10))))
        );
        setLayout(groupLayout);
    }



    private void showMessage(String message) {
        Message obj = new Message(Frame_Chinh.getFrames()[0], true);
        obj.showMessage(message);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	settingModel = new SettingModel();
    	try {
			settingModel.readFrom();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3 = new JLabel();
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4 = new JLabel();
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        Timer timer =new Timer (1000,e -> {
			SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm:ss");
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
			Date now=new Date();
			String time=timeFormat.format(now);
			String date=dateFormat.format(now);
			if(settingModel.getNgonNgu().equals("Vietnamese")) {
				jLabel1.setText("Trang chủ. Ngày: "+date+", thời gian: "+time);
	    	}	
			if(settingModel.getNgonNgu().equals("English")) {
				jLabel1.setText("Home page. Date: "+date+", Time: "+time);
	    	}
			
		});
		
        
        jLabel2.setIcon(new ImageIcon("src\\main\\images\\view_image\\Book store 1.png"));
        jLabel3.setIcon(new ImageIcon("src\\main\\images\\view_image\\Book store 2.png"));
        jLabel4.setIcon(new ImageIcon("src\\main\\images\\view_image\\Book Store 3.png"));
        timer.start();
    }// </editor-fold>//GEN-END:initComponents

    
}
