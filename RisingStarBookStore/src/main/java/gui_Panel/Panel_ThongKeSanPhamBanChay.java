package gui_Panel;

import com.oracle.javafx.scenebuilder.kit.util.control.paintpicker.colorpicker.ColorPicker;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.toedter.calendar.JDateChooser;

import customEntities.Custom_Button;
import customEntities.Custom_ColorPicker;
import customEntities.Custom_ComboBox;
import customEntities.CustomFunction;
import customEntities.CustomIcon;
import customEntities.Custom_Table;
import gui_Dialog.Message;
import gui_Frame_Running.Frame_Chinh;
import gui_Panel.lineChart.LineChart;
import gui_Panel.piechart.ModelPieChart;
import gui_Panel.piechart.PieChart;

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

public class Panel_ThongKeSanPhamBanChay extends JPanel {
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JLabel lbl_Title_pieChart;
	private JLabel lbl_Title_LinepieChart;
	private JLabel lblNewLabel;
	private PieChart pieChart;
	private LineChart lineChart;
	private Custom_Button btnXuatBaoCao;
	private JScrollPane scr_DSSP;
	private Custom_Table tbl_DSSP;
	private DefaultTableModel dtm_SP;
    // End of variables declaration//GEN-END:variables
    public Panel_ThongKeSanPhamBanChay() {
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
    	lbl_Title_pieChart = new JLabel("Biểu đồ tròn sản phẩm tồn kho hiện tại");
    	lbl_Title_pieChart.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_pieChart.setForeground(new Color(0, 0, 255));
		lbl_Title_pieChart.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Title_pieChart.setBounds(30,100,2500,50);
		lbl_Title_pieChart.setForeground(Custom_ColorPicker.darkblue_4F709C);
		
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
		
		lbl_Title_LinepieChart = new JLabel("Biểu đồ đường danh mục sản phẩm bán chạy");
		lbl_Title_LinepieChart.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_LinepieChart.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_LinepieChart.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblNewLabel = new JLabel("Chọn thời gian:");
		
		Custom_ComboBox custom_ComboBox = new Custom_ComboBox();
		
		pieChart = new PieChart();
		pieChart.setBackground(new Color(255, 255, 255));
		for (int i = 0; i < 10; i++) {
			pieChart.addData(new ModelPieChart(String.format("Sản phẩm %d", i),1, new Color(i*22, 100-i*10, i*10)));
		}
		
		lineChart = new LineChart();
		lineChart.addLegend("Bút viết", Custom_ColorPicker.lime_BFFF00,Custom_ColorPicker.lime_BFFF00);
        lineChart.addLegend("Sách giáo khoa", Custom_ColorPicker.lightred_FF6666,Custom_ColorPicker.lightred_FF6666);
        lineChart.addLegend("Đồ văn phòng", Custom_ColorPicker.blue_4B70F5,Custom_ColorPicker.blue_4B70F5);
        lineChart.addData(new gui_Panel.lineChart.ModelChart("Bút viết", new double[]{500, 200, 80}));
        lineChart.addData(new gui_Panel.lineChart.ModelChart("Sách giáo khoa", new double[]{600, 750, 90}));
        lineChart.addData(new gui_Panel.lineChart.ModelChart("Đồ văn phòng", new double[]{200, 350, 460}));
        lineChart.start();
		
		btnXuatBaoCao = new Custom_Button();
		btnXuatBaoCao.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXuatBaoCao.setText("Xuất báo cáo");
		
		JLabel lbl_Title_DSSP = new JLabel("Danh sách sản phẩm bán chạy");
		lbl_Title_DSSP.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_DSSP.setForeground(SystemColor.activeCaption);
		lbl_Title_DSSP.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		dtm_SP = new DefaultTableModel(new String[] {"Mã sản phẩm","Tên sản phẩm","Danh mục","Đơn giá","Số lượng tồn kho","Số lượng bán"},0);
		for (int i = 0; i < 1000; i++) {
			dtm_SP.addRow(new String[] {"SP0001","199 Đề Và Bài Văn Hay 9","Sách kham khảo","15000đ","23","32"});
		}
		tbl_DSSP = new Custom_Table();
		tbl_DSSP.setModel(dtm_SP);
		scr_DSSP = new JScrollPane(tbl_DSSP);
		
		Custom_Button btnXuatDuLieu = new Custom_Button();
		btnXuatDuLieu.setText("Xuất dữ liệu");
		btnXuatDuLieu.setFont(new Font("SansSerif", Font.BOLD, 14));
		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(scr_DSSP, GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
							.addComponent(lbl_Title_DSSP)
							.addPreferredGap(ComponentPlacement.RELATED, 463, Short.MAX_VALUE)
							.addComponent(btnXuatDuLieu, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(pieChart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lbl_Title_pieChart))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_Title_LinepieChart, GroupLayout.PREFERRED_SIZE, 516, Short.MAX_VALUE)
								.addComponent(lineChart, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)))
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
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(custom_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(btnXuatBaoCao, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_Title_pieChart)
						.addComponent(lbl_Title_LinepieChart, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(pieChart, 0, 0, Short.MAX_VALUE)
						.addComponent(lineChart, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnXuatDuLieu, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_Title_DSSP, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSSP, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
					.addContainerGap())
		);
		layout.linkSize(SwingConstants.VERTICAL, new Component[] {lblNewLabel, custom_ComboBox, btnXuatBaoCao, btnXuatDuLieu});
        this.setLayout(layout);
        
        
    }// </editor-fold>//GEN-END:initComponents
}
