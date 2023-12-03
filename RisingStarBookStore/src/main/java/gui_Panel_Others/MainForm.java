package gui_Panel_Others;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.raven.model.SettingModel;

import customEntities.Custom_Button;
import customEntities.Custom_ColorPicker;
import customEntities.Custom_ComboBox;
import gui_Panel.barchart.BarChart;

public class MainForm extends javax.swing.JPanel {
	private SettingModel settingModel;
    public MainForm() {
        initComponents();
        setOpaque(true);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 20, 10, 20));
        setting();
    }
    public void showForm(JPanel form) {
        removeAll();
        setting();
        form.setOpaque(true);
        String phongCach = settingModel.getPhongCach();
        if(phongCach.equals("Whitebright"))
		{
        	for (Component component : form.getComponents()) {
        		if (component instanceof JPanel) {
                    ((JPanel) component).setBackground(Color.WHITE);
                    ((JPanel) component).setBorder(BorderFactory.createLineBorder(new Custom_ColorPicker("5A8FEB").toColor(), 2));
                }
                component.setForeground(new Custom_ColorPicker("5A8FEB").toColor());
            }
        	setBackground(new Custom_ColorPicker("FFFFFF").toColor());
        	form.setBackground(new Custom_ColorPicker("FFFFFF").toColor());
		}
        if(phongCach.equals("Darkmode"))
		{
        	for (Component component : form.getComponents()) {
        		if (component instanceof JPanel) {
        			JPanel panel = (JPanel) component;
                    panel.setBackground(new Custom_ColorPicker("323232").toColor());
                    panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                    for (Component componentS : panel.getComponents()) {
                    	if (componentS instanceof JLabel) {
                    		JLabel label = (JLabel) componentS;
                    		if(!label.getText().isEmpty()) {
                    			System.out.println(label.getText());
                    			label.setForeground(Color.WHITE);
                    		}
                    	}
                    	if (componentS instanceof Custom_ComboBox) {
                    		Custom_ComboBox custom_ComboBox = (Custom_ComboBox) componentS;
                    		custom_ComboBox.setColor_Foreground(Color.WHITE);
                    		custom_ComboBox.setColor_Background(new Custom_ColorPicker("323232").toColor());
                    		custom_ComboBox.setColor_Hightlight(new Custom_ColorPicker("778899").toColor());
                    		custom_ComboBox.setColor_Over(new Custom_ColorPicker("DCDCDC").toColor());
                    		custom_ComboBox.setColor_Border(new Custom_ColorPicker("000000").toColor());
                    		custom_ComboBox.redraw_Custom_Combobox();
                    	}
                    	if (componentS instanceof Custom_Button) {
                    		Custom_Button custom_Button = (Custom_Button) componentS;
                    		custom_Button.setColor_Foreground(Color.WHITE);
                    		custom_Button.setColor_Background(new Custom_ColorPicker("526D82").toColor());
                    		custom_Button.setColor_Hightlight(new Custom_ColorPicker("778899").toColor());
                    		custom_Button.setColor_Over(new Custom_ColorPicker("DCDCDC").toColor());
                    		custom_Button.setColor_Border(new Custom_ColorPicker("FFFFFF").toColor());
                    		custom_Button.setColor_Click(new Custom_ColorPicker("000000").toColor());
                    		custom_Button.setColor_Clicked_Background(Color.WHITE);
                    	}
                    }
                    
                    
        		}
        		if (component instanceof Custom_Button) {
            		Custom_Button custom_Button = (Custom_Button) component;
            		custom_Button.setColor_Foreground(Color.WHITE);
            		custom_Button.setColor_Background(new Custom_ColorPicker("526D82").toColor());
            		custom_Button.setColor_Hightlight(new Custom_ColorPicker("778899").toColor());
            		custom_Button.setColor_Over(new Custom_ColorPicker("DCDCDC").toColor());
            		custom_Button.setColor_Border(new Custom_ColorPicker("FFFFFF").toColor());
            		custom_Button.setColor_Click(new Custom_ColorPicker("000000").toColor());
            		custom_Button.setColor_Clicked_Background(Color.WHITE);
            	}
                component.setForeground(Color.WHITE);
                
            }
        	setBackground(new Custom_ColorPicker("323232").toColor());
        	form.setBackground(new Custom_ColorPicker("323232").toColor());
		}
        
        add(form);
        repaint();
        revalidate();
    }
    private void setting() {
		settingModel = new SettingModel();
		try {
			settingModel.readFrom();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
