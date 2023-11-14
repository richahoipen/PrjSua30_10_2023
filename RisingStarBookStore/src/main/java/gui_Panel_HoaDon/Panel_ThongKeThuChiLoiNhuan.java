package gui_Panel_HoaDon;

import com.oracle.javafx.scenebuilder.kit.util.control.paintpicker.colorpicker.ColorPicker;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.toedter.calendar.JDateChooser;

import customEntities.CustomFunction;
import customEntities.CustomIcon;
import customEntities.Custom_Button;
import customEntities.Custom_ColorPicker;
import customEntities.Custom_ComboBox;
import customEntities.CustomTable;
import gui_Dialog.Message;
import gui_Frame_Running.Frame_Chinh;
import gui_Panel.barchart.*;
import gui_Panel.lineChart.LineChart;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import javax.swing.JEditorPane;

public class Panel_ThongKeThuChiLoiNhuan extends JPanel {
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JLabel lbl_Title_BarbarChart;
	private JLabel lbl_Title_LinebarChart;
	private JLabel lblNewLabel;
	private BarChart barChart;
	private LineChart lineChart;
	private Custom_Button btnXuatBaoCao;
	private JScrollPane scr_DSHD;
	private CustomTable tbl_DSHD;
	private DefaultTableModel dtm_HD;
    // End of variables declaration//GEN-END:variables
    public Panel_ThongKeThuChiLoiNhuan() {
        initComponents();
        setOpaque(false);
    }



    private void showMessage(String message) {
        Message obj = new Message(Frame_Chinh.getFrames()[0], true);
        obj.showMessage(message);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	lbl_Title_BarbarChart = new JLabel("Biểu đồ cột");
    	lbl_Title_BarbarChart.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_BarbarChart.setForeground(new Color(0, 0, 255));
		lbl_Title_BarbarChart.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Title_BarbarChart.setBounds(30,100,2500,50);
		lbl_Title_BarbarChart.setForeground(Custom_ColorPicker.darkblue_4F709C);
		
		String[] string_NgayTrongThang = new String[31];
		for (int i = 0; i < 31; i++) {
			string_NgayTrongThang[i] = String.format("%02d",i+1);
		}
		
		String[] string_ThangTrongNam = new String[12];
		for (int i = 0; i < 12; i++) {
			string_ThangTrongNam[i] = String.format("%02d",i+1);
		}
		
		String[] string_Nam = new String[1500];
		LocalDate ngayHienTai = LocalDate.now(); 
		int namHienTai = ngayHienTai.getYear();
		for (int i = 0; i < 1500; i++) {
			string_Nam[i] = String.format("%04d",namHienTai-i);
		}
		
		lbl_Title_LinebarChart = new JLabel("Biểu đồ đường");
		lbl_Title_LinebarChart.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_LinebarChart.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_LinebarChart.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblNewLabel = new JLabel("Chọn thời gian:");
		
		Custom_ComboBox custom_ComboBox = new Custom_ComboBox();
		
		barChart = new BarChart();
		barChart.addLegend("Thu", Custom_ColorPicker.lime_BFFF00);
        barChart.addLegend("Chi", Custom_ColorPicker.lightred_FF6666);
        barChart.addLegend("Lợi nhuận", Custom_ColorPicker.blue_4B70F5);
        for (int i = 0; i < 12; i++) {
        	barChart.addData(new ModelChart(String.format("Th%d", i+1), new double[]{500, 200, 80}));
		}
		barChart.start();
		
		lineChart = new LineChart();
		lineChart.addLegend("Thu", Custom_ColorPicker.lime_BFFF00,Custom_ColorPicker.lime_BFFF00);
        lineChart.addLegend("Chi", Custom_ColorPicker.lightred_FF6666,Custom_ColorPicker.lightred_FF6666);
        lineChart.addLegend("Lợi nhuận", Custom_ColorPicker.blue_4B70F5,Custom_ColorPicker.blue_4B70F5);
        for (int i = 0; i < 6; i++) {
        	lineChart.addData(new gui_Panel.lineChart.ModelChart(String.format("Th%d", i+1), new double[]{i*200, i-200, 80*i}));
        	lineChart.addData(new gui_Panel.lineChart.ModelChart(String.format("Th%d", i+1), new double[]{i*200-100, i+200, i+80}));
		}
        lineChart.start();
		
		btnXuatBaoCao = new Custom_Button();
		btnXuatBaoCao.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXuatBaoCao.setText("Xuất báo cáo");
		
		JLabel lbl_Title_DSHD = new JLabel("Danh sách hóa đơn");
		lbl_Title_DSHD.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_DSHD.setForeground(SystemColor.activeCaption);
		lbl_Title_DSHD.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		dtm_HD = new DefaultTableModel(new String[] {"Mã hóa đơn","Tên nhân viên","Tên khách hàng","Tổng tiền","Chi","Lợi nhuận"},0);
		for (int i = 0; i < 1000; i++) {
			dtm_HD.addRow(new String[] {"HD0001","199 Đề Và Bài Văn Hay 9","Sách kham khảo","15000đ","12000đ","3000đ"});
		}
		tbl_DSHD = new CustomTable();
		tbl_DSHD.setModel(dtm_HD);
		scr_DSHD = new JScrollPane(tbl_DSHD);
		
		Custom_Button btnXuatDuLieu = new Custom_Button();
		btnXuatDuLieu.setText("Xuất dữ liệu");
		btnXuatDuLieu.setFont(new Font("SansSerif", Font.BOLD, 14));
		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(scr_DSHD, GroupLayout.DEFAULT_SIZE, 1087, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_Title_BarbarChart)
								.addComponent(barChart, GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
									.addComponent(lbl_Title_LinebarChart, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
									.addGap(185))
								.addGroup(layout.createSequentialGroup()
									.addComponent(lineChart, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
									.addGap(8))))
						.addGroup(layout.createSequentialGroup()
							.addComponent(lbl_Title_DSHD, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 853, Short.MAX_VALUE)
							.addComponent(btnXuatDuLieu, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addComponent(btnXuatBaoCao, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(custom_ComboBox, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(6)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(custom_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(btnXuatBaoCao, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_Title_BarbarChart)
						.addComponent(lbl_Title_LinebarChart, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(lineChart, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
						.addComponent(barChart, 0, 0, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lbl_Title_DSHD, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXuatDuLieu, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSHD, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
					.addContainerGap())
		);
		layout.linkSize(SwingConstants.VERTICAL, new Component[] {lblNewLabel, custom_ComboBox, btnXuatBaoCao, btnXuatDuLieu});
        this.setLayout(layout);
        
        
    }// </editor-fold>//GEN-END:initComponents
}
