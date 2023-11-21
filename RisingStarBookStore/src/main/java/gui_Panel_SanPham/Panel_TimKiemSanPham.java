package gui_Panel_SanPham;

import gui_Dialog.Message;
import gui_Frame_Running.Frame_Chinh;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;

import customEntities.Custom_Button;
import customEntities.Custom_ColorPicker;
import customEntities.Custom_ComboBox;
import customEntities.Custom_ImageIcon;
import customEntities.Custom_JLabel;
import dataBase_BUS.NhaCungCap_BUS;
import dataBase_BUS.SanPham_BUS;
import entities.SanPham;
import customEntities.CustomTable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JButton;

public class Panel_TimKiemSanPham extends JPanel implements ActionListener, MouseListener
{
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JPanel pn_Master,pn_Header,pn_QL_SP,pn_Table_DSSP;
	private Custom_JLabel picture_Logo;
	private Custom_Button btn_Close,btn_Home,btn_Logout;
	private JLabel lbl_Title_QL_SP,lbl_Title_DSSP;
	private JLabel lbl_MaSP,lbl_TenSP,lbl_LoaiSP,lbl_NgonNgu,lbl_NhaCungCap,lbl_NhaXuatBan,lbl_NamXuatBan,lbl_TacGia,lbl_SoLuongCon,lbl_SoLuongBan,lbl_GiaNhap,lbl_GiaBan;
	private Custom_ComboBox cbo_MaSP,cbo_TenSP,cbo_LoaiSP,cbo_NgonNgu,cbo_NhaCungCap,cbo_NhaXuatBan,cbo_NamXuatBan,cbo_TacGia,cbo_SoLuongCon,cbo_SoLuongBan,cbo_GiaNhap,cbo_GiaBan;
	private Custom_JLabel lbl_hinhAnhSP;
	private Custom_Button btn_XoaTrang,btn_TimKiem;
	private JScrollPane scr_DSSP;
	private CustomTable tbl_DSSP;
	private DefaultTableModel dtm_SP;
	private SanPham_BUS sqlSanPham_BUS=new SanPham_BUS();
	private NhaCungCap_BUS sqlNhaCungCap_BUS=new NhaCungCap_BUS();
    // End of variables declaration//GEN-END:variables
    public Panel_TimKiemSanPham() {
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
    	lbl_Title_QL_SP = new JLabel("Quản lý sản phẩm");
    	lbl_Title_QL_SP.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_QL_SP.setForeground(new Color(0, 0, 255));
		lbl_Title_QL_SP.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Title_QL_SP.setBounds(30,100,2500,50);
		
    	pn_QL_SP = new JPanel();
		pn_QL_SP.setIgnoreRepaint(true);
		pn_QL_SP.setBackground(Color.white);
		pn_QL_SP.setBorder(new LineBorder(Custom_ColorPicker.lightgrey_D9D9D9, 3));
		
		lbl_MaSP = new JLabel("Mã sản phẩm:");
		lbl_MaSP.setForeground(Color.black);
		lbl_MaSP.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_TenSP = new JLabel("Tên sản phẩm:");
		lbl_TenSP.setForeground(Color.black);
		lbl_TenSP.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_LoaiSP = new JLabel("Loại sản phẩm:");
		lbl_LoaiSP.setForeground(Color.black);
		lbl_LoaiSP.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_NgonNgu = new JLabel("Ngôn ngữ:");
		lbl_NgonNgu.setForeground(Color.black);
		lbl_NgonNgu.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_NhaCungCap = new JLabel("Nhà cung cấp:");
		lbl_NhaCungCap.setForeground(Color.black);
		lbl_NhaCungCap.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_NhaXuatBan = new JLabel("Nhà xuất bản:");
		lbl_NhaXuatBan.setForeground(Color.black);
		lbl_NhaXuatBan.setFont(new Font("Inter", Font.PLAIN, 14));

		lbl_NamXuatBan = new JLabel("Năm xuất bản:");
		lbl_NamXuatBan.setForeground(Color.black);
		lbl_NamXuatBan.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_TacGia = new JLabel("Tác giả:");
		lbl_TacGia.setForeground(Color.black);
		lbl_TacGia.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_SoLuongCon = new JLabel("Số lượng còn:");
		lbl_SoLuongCon.setForeground(Color.black);
		lbl_SoLuongCon.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_SoLuongBan = new JLabel("Số lượng bán:");
		lbl_SoLuongBan.setForeground(Color.black);
		lbl_SoLuongBan.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_GiaNhap = new JLabel("Giá nhập:");
		lbl_GiaNhap.setForeground(Color.black);
		lbl_GiaNhap.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_GiaBan = new JLabel("Giá bán:");
		lbl_GiaBan.setForeground(Color.black);
		lbl_GiaBan.setFont(new Font("Inter", Font.PLAIN, 14));
		
		cbo_MaSP = new Custom_ComboBox();
		cbo_MaSP.setForeground(Color.black);
		cbo_MaSP.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_MaSP.setOpaque(true);
		cbo_MaSP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_TenSP = new Custom_ComboBox();
		cbo_TenSP.setForeground(Color.black);
		cbo_TenSP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_TenSP.setColor_Foreground(Color.black);
		cbo_TenSP.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_TenSP.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_TenSP.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_TenSP.redraw_Custom_Combobox();
		
		cbo_LoaiSP = new Custom_ComboBox();
		cbo_LoaiSP.setForeground(Color.black);
		cbo_LoaiSP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_LoaiSP.setColor_Foreground(Color.black);
		cbo_LoaiSP.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_LoaiSP.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_LoaiSP.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_LoaiSP.redraw_Custom_Combobox();
		
		cbo_NgonNgu = new Custom_ComboBox();
		cbo_NgonNgu.setForeground(Color.black);
		cbo_NgonNgu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_NgonNgu.setColor_Foreground(Color.black);
		cbo_NgonNgu.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_NgonNgu.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_NgonNgu.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_NgonNgu.redraw_Custom_Combobox();
		
		cbo_NhaCungCap = new Custom_ComboBox();
		cbo_NhaCungCap.setForeground(Color.black);
		cbo_NhaCungCap.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_NhaCungCap.setColor_Foreground(Color.black);
		cbo_NhaCungCap.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_NhaCungCap.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_NhaCungCap.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_NhaCungCap.redraw_Custom_Combobox();
		cbo_NhaCungCap.setRadius(0);
		
		cbo_NhaXuatBan = new Custom_ComboBox();
		cbo_NhaXuatBan.setForeground(Color.black);
		cbo_NhaXuatBan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_NamXuatBan = new Custom_ComboBox();
		cbo_NamXuatBan.setForeground(Color.black);
		cbo_NamXuatBan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_TacGia = new Custom_ComboBox();
		cbo_TacGia.setForeground(Color.black);
		cbo_TacGia.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_SoLuongCon = new Custom_ComboBox();
		cbo_SoLuongCon.setForeground(Color.black);
		cbo_SoLuongCon.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_SoLuongBan = new Custom_ComboBox();
		cbo_SoLuongBan.setForeground(Color.black);
		cbo_SoLuongBan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_SoLuongBan.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		
		cbo_GiaNhap = new Custom_ComboBox();
		cbo_GiaNhap.setForeground(Color.black);
		cbo_GiaNhap.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_GiaBan = new Custom_ComboBox();
		cbo_GiaBan.setForeground(Color.black);
		cbo_GiaBan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lbl_hinhAnhSP = new Custom_JLabel();
		lbl_hinhAnhSP.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_hinhAnhSP.setOpaque(true);
		lbl_hinhAnhSP.setVisible(true);
		
		lbl_Title_DSSP = new JLabel("Danh sách sản phẩm");
		lbl_Title_DSSP.setForeground(Color.BLUE);
		lbl_Title_DSSP.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		dtm_SP = new DefaultTableModel(new String[] {"Mã sản phẩm","Tên sản phẩm","Loại","Ngôn ngữ","Nhà cung cấp","NXB","Năm XB","Tác giả","SL còn","SL bán","Giá Nhập","Giá Bán"},0);	

		tbl_DSSP = new CustomTable();
		tbl_DSSP.setModel(dtm_SP);
		JScrollPane scr_DSSP = new JScrollPane(tbl_DSSP);
		TableColumnModel columnModel = tbl_DSSP.getColumnModel();

        // Thiết lập chiều rộng cột cụ thể (ví dụ: cột 1 có chiều rộng 150px)
		int[] columnWidths = {100, 175, 130, 85, 150, 150, 60, 130, 60,60,70,70};
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
		
		btn_TimKiem = new Custom_Button();
		btn_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_TimKiem.setBuffered_Icon("src/main/images/view_image/Search.png");
		btn_TimKiem.resizeIcon(14, 14);
		btn_TimKiem.setText("Tìm kiếm");
		btn_TimKiem.setFont(new Font("Inner", Font.BOLD, 12));
		btn_TimKiem.setOver(true);
		btn_TimKiem.setColor_Foreground(Color.black);
		btn_TimKiem.setColor_Hightlight(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_TimKiem.setColor_Background(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_TimKiem.setColor_Over(Custom_ColorPicker.lightgrey_D9D9D9);
		btn_TimKiem.setColor_Click(Color.black);
		btn_TimKiem.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		
		btn_XoaTrang = new Custom_Button();
		btn_XoaTrang.setText("Xóa trắng");
		btn_XoaTrang.setFont(new Font("Inner", Font.BOLD, 12));
		btn_XoaTrang.setBuffered_Icon("src/main/images/view_image/Refresh.png");
		btn_XoaTrang.resizeIcon(14, 14);
		btn_XoaTrang.setOver(true);
		btn_XoaTrang.setColor_Foreground(Color.black);
		btn_XoaTrang.setColor_Hightlight(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_XoaTrang.setColor_Background(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_XoaTrang.setColor_Over(Custom_ColorPicker.lightgrey_D9D9D9);
		btn_XoaTrang.setColor_Click(Color.black);
		btn_XoaTrang.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		
		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.CENTER)
				.addGroup(layout.createSequentialGroup()
					.addGap(1)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_Title_QL_SP))
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_Title_DSSP))
						.addComponent(scr_DSSP, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pn_QL_SP, GroupLayout.PREFERRED_SIZE, 790, Short.MAX_VALUE)))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(lbl_Title_QL_SP)
					.addGap(1)
					.addComponent(pn_QL_SP, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_Title_DSSP)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSSP, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
		);
        this.setLayout(layout);
        
        GroupLayout gl_pn_QL_SP = new GroupLayout(pn_QL_SP);
        gl_pn_QL_SP.setHorizontalGroup(
        	gl_pn_QL_SP.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_pn_QL_SP.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addComponent(lbl_LoaiSP)
        						.addComponent(lbl_TenSP, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_NgonNgu, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_MaSP, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addComponent(cbo_MaSP, GroupLayout.PREFERRED_SIZE, 108, Short.MAX_VALUE)
        						.addComponent(cbo_TenSP, GroupLayout.PREFERRED_SIZE, 108, Short.MAX_VALUE)
        						.addComponent(cbo_LoaiSP, GroupLayout.PREFERRED_SIZE, 108, Short.MAX_VALUE)
        						.addComponent(cbo_NgonNgu, GroupLayout.PREFERRED_SIZE, 108, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addComponent(lbl_TacGia)
        						.addComponent(lbl_NhaCungCap)
        						.addComponent(lbl_NamXuatBan)
        						.addComponent(lbl_NhaXuatBan, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addComponent(cbo_NamXuatBan, GroupLayout.PREFERRED_SIZE, 108, Short.MAX_VALUE)
        						.addComponent(cbo_NhaCungCap, GroupLayout.PREFERRED_SIZE, 108, Short.MAX_VALUE)
        						.addComponent(cbo_NhaXuatBan, GroupLayout.PREFERRED_SIZE, 108, Short.MAX_VALUE)
        						.addComponent(cbo_TacGia, GroupLayout.PREFERRED_SIZE, 108, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lbl_SoLuongCon, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_SoLuongBan, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_GiaNhap, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_GiaBan, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
        					.addGap(5)
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addComponent(cbo_GiaNhap, GroupLayout.PREFERRED_SIZE, 108, Short.MAX_VALUE)
        						.addComponent(cbo_GiaBan, GroupLayout.PREFERRED_SIZE, 108, Short.MAX_VALUE)
        						.addComponent(cbo_SoLuongBan, GroupLayout.PREFERRED_SIZE, 108, Short.MAX_VALUE)
        						.addComponent(cbo_SoLuongCon, GroupLayout.PREFERRED_SIZE, 108, Short.MAX_VALUE))))
        			.addGap(10)
        			.addComponent(lbl_hinhAnhSP, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
        );
        gl_pn_QL_SP.setVerticalGroup(
        	gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_QL_SP.createSequentialGroup()
        			.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGap(1)
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addComponent(lbl_NhaXuatBan, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_SoLuongCon, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        								.addComponent(lbl_TenSP)
        								.addComponent(cbo_TenSP, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lbl_NhaCungCap, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addComponent(cbo_NhaCungCap, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addComponent(cbo_SoLuongBan, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addGap(6)
        							.addComponent(lbl_SoLuongBan, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        								.addComponent(lbl_LoaiSP)
        								.addComponent(lbl_NamXuatBan)
        								.addComponent(cbo_NamXuatBan, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addComponent(cbo_GiaNhap, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addComponent(cbo_LoaiSP, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addGap(6)
        							.addComponent(lbl_GiaNhap, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
        					.addGap(9)
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        								.addComponent(lbl_NgonNgu)
        								.addComponent(lbl_TacGia)
        								.addComponent(cbo_TacGia, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        								.addComponent(cbo_GiaBan, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        								.addGroup(gl_pn_QL_SP.createSequentialGroup()
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(lbl_GiaBan)))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.BASELINE)
        								.addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        						.addComponent(cbo_NgonNgu, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addComponent(lbl_hinhAnhSP, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        					.addGap(30))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGap(2)
        					.addComponent(cbo_NhaXuatBan, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGap(2)
        					.addComponent(cbo_MaSP, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGap(1)
        					.addComponent(cbo_SoLuongCon, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGap(1)
        					.addComponent(lbl_MaSP)))
        			.addGap(8))
        );
        gl_pn_QL_SP.linkSize(SwingConstants.VERTICAL, new Component[] {cbo_MaSP, cbo_TenSP, cbo_LoaiSP, cbo_NgonNgu, cbo_NhaCungCap, cbo_NhaXuatBan, cbo_NamXuatBan, cbo_TacGia, cbo_SoLuongCon, cbo_SoLuongBan, cbo_GiaNhap, cbo_GiaBan});
        gl_pn_QL_SP.linkSize(SwingConstants.VERTICAL, new Component[] {btn_TimKiem, btn_XoaTrang});
        gl_pn_QL_SP.linkSize(SwingConstants.HORIZONTAL, new Component[] {lbl_NhaCungCap, lbl_NhaXuatBan, lbl_NamXuatBan, lbl_TacGia, lbl_SoLuongCon, lbl_SoLuongBan, lbl_GiaNhap, lbl_GiaBan});
        gl_pn_QL_SP.linkSize(SwingConstants.HORIZONTAL, new Component[] {btn_TimKiem, btn_XoaTrang});
        gl_pn_QL_SP.linkSize(SwingConstants.HORIZONTAL, new Component[] {lbl_MaSP, lbl_TenSP, lbl_LoaiSP, lbl_NgonNgu});
        pn_QL_SP.setLayout(gl_pn_QL_SP);
        addAction();
    }// </editor-fold>//GEN-END:initComponents
    private void addAction()
    {
    	cbo_GiaBan.addActionListener(this);
    	cbo_GiaNhap.addActionListener(this);
    	cbo_LoaiSP.addActionListener(this);
    	cbo_MaSP.addActionListener(this);
    	cbo_NamXuatBan.addActionListener(this);
    	cbo_NgonNgu.addActionListener(this);
    	cbo_NhaCungCap.addActionListener(this);
    	cbo_SoLuongBan.addActionListener(this);
    	cbo_SoLuongCon.addActionListener(this);
    	cbo_TacGia.addActionListener(this);
    	cbo_TenSP.addActionListener(this);
    	tbl_DSSP.addMouseListener(this);
    	btn_XoaTrang.addActionListener(this);
    	btn_TimKiem.addActionListener(this);
    	addCombobox();
    	resetTable();
    }
    private void addCombobox()
    {
    	cbo_MaSP.addItem("Chọn");
    	sqlSanPham_BUS.dayCombobox_maSP(cbo_MaSP);
    	cbo_TenSP.addItem("Chọn");
    	sqlSanPham_BUS.dayCombobox_tenSP(cbo_TenSP);
    	cbo_LoaiSP.addItem("Chọn");
    	sqlSanPham_BUS.dayCombobox_loaiSP(cbo_LoaiSP);
    	cbo_TacGia.addItem("Chọn");
    	sqlSanPham_BUS.dayCombobox_tacGia(cbo_TacGia);
    	cbo_NhaXuatBan.addItem("Chọn");
    	sqlSanPham_BUS.dayCombobox_nhaXuatBan(cbo_NhaXuatBan);
    	cbo_NamXuatBan.addItem("Chọn");
    	sqlSanPham_BUS.dayCombobox_namXuatBan(cbo_NamXuatBan);
    	cbo_NhaCungCap.addItem("Chọn");
    	sqlNhaCungCap_BUS.dayComboBoxTenNCC(cbo_NhaCungCap);
    	cbo_NgonNgu.addItem("Chọn");
    	sqlSanPham_BUS.dayCombobox_ngonNgu(cbo_NgonNgu);
    	cbo_GiaNhap.addItem("Chọn");
    	sqlSanPham_BUS.dayCombobox_giaBan(cbo_GiaNhap);
    	cbo_GiaBan.addItem("Chọn");
    	sqlSanPham_BUS.dayCombobox_giaBan(cbo_GiaBan);
    	cbo_SoLuongCon.addItem("Chọn");
    	sqlSanPham_BUS.dayCombobox_soLuong(cbo_SoLuongCon);
    	cbo_SoLuongBan.addItem("Chọn");
    	sqlSanPham_BUS.dayCombobox_soLuongBan(cbo_SoLuongBan);
    }
    private void resetTable()
    {
    	dtm_SP.setRowCount(0);
    	sqlSanPham_BUS.xuatDanhSachSanPham(dtm_SP);
    }
    private boolean checkComboboxNULL()
    {
    	String maSP=(String) cbo_MaSP.getSelectedItem();
    	String tenSP=(String) cbo_TenSP.getSelectedItem();
    	String loaiSP=(String) cbo_LoaiSP.getSelectedItem();
    	String ngonNgu=(String) cbo_NgonNgu.getSelectedItem();
    	String nhaCungCap=(String) cbo_NhaCungCap.getSelectedItem();
    	String nhaXuatBan=(String) cbo_NhaXuatBan.getSelectedItem();
    	String namXuatBan=(String) cbo_NamXuatBan.getSelectedItem();
    	String tacGia=(String) cbo_TacGia.getSelectedItem();
    	String soLuong=(String) cbo_SoLuongCon.getSelectedItem();
    	String soLuongBan=(String) cbo_SoLuongBan.getSelectedItem();
    	String giaNhap=(String) cbo_GiaNhap.getSelectedItem();
    	String giaBan=(String) cbo_GiaBan.getSelectedItem();
    	if(maSP!=null && tenSP!=null && loaiSP!=null && ngonNgu!=null && nhaCungCap!=null && nhaXuatBan!=null &&
    			namXuatBan!=null && tacGia!=null && soLuong!=null && soLuongBan!=null && giaNhap!=null && giaBan!=null)
    	{
    		return true;
    	}
    	else
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
            UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
            JOptionPane.showMessageDialog(null, "Dữ liệu tìm kiếm không được rỗng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
    	}			
    }
    private void xoaTrang()
    {
    	String chon="Chọn";
    	cbo_MaSP.setSelectedItem(chon);
		cbo_TenSP.setSelectedItem(chon);
		cbo_LoaiSP.setSelectedItem(chon);
		cbo_NgonNgu.setSelectedItem(chon);
		cbo_NhaCungCap.setSelectedItem(chon);
		cbo_NhaXuatBan.setSelectedItem(chon);
		
		cbo_NamXuatBan.setSelectedItem(chon);
		cbo_TacGia.setSelectedItem(chon);
		cbo_SoLuongCon.setSelectedItem(chon);
		cbo_SoLuongBan.setSelectedItem(chon);
		cbo_GiaNhap.setSelectedItem(chon);
		cbo_GiaBan.setSelectedItem(chon);			
		lbl_hinhAnhSP.setIcon(null);
		resetTable();
    }
    private void timKiem()
    {
    	
    	String maSP=(String) cbo_MaSP.getSelectedItem();
    	String tenSP=(String) cbo_TenSP.getSelectedItem();
    	String loaiSP=(String) cbo_LoaiSP.getSelectedItem();
    	String ngonNgu=(String) cbo_NgonNgu.getSelectedItem();
    	String nhaCungCap=(String) cbo_NhaCungCap.getSelectedItem();
    	String nhaXuatBan=(String) cbo_NhaXuatBan.getSelectedItem();
    	String namXuatBan=(String) cbo_NamXuatBan.getSelectedItem();
    	String tacGia=(String) cbo_TacGia.getSelectedItem();
    	String soLuong=(String) cbo_SoLuongCon.getSelectedItem();
    	String soLuongBan=(String) cbo_SoLuongBan.getSelectedItem();
    	String giaNhap=(String) cbo_GiaNhap.getSelectedItem();
    	String giaBan=(String) cbo_GiaBan.getSelectedItem();
    	String chon="Chọn";
    	if(maSP.equalsIgnoreCase(chon)&& tenSP.equalsIgnoreCase(chon)&&loaiSP.equalsIgnoreCase(chon)&&ngonNgu.equalsIgnoreCase(chon)&&
    			nhaCungCap.equalsIgnoreCase(chon)&&nhaXuatBan.equalsIgnoreCase(chon)&&namXuatBan.equalsIgnoreCase(chon)&&
    			tacGia.equalsIgnoreCase(chon)&&soLuong.equalsIgnoreCase(chon)&&
    			soLuongBan.equalsIgnoreCase(chon)&&giaNhap.equalsIgnoreCase(chon)&&giaBan.equalsIgnoreCase(chon))
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
			JOptionPane.showMessageDialog(null, "Vui lòng chọn thông tin để tìm kiếm.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else
    	{
    		if(namXuatBan.equalsIgnoreCase(chon))
    		{
    			namXuatBan="2023";
    		}
    		if(soLuong.equalsIgnoreCase(chon))
    		{
    			soLuong="0";
    		}
    		if(soLuongBan.equalsIgnoreCase(chon))
    		{
    			soLuongBan="0";
    		}
    		if(giaNhap.equalsIgnoreCase(chon))
    		{
    			giaNhap="0.0";
    		}
    		if(giaBan.equalsIgnoreCase(chon))
    		{
    			giaBan="0.0";
    		}
    		try {
               //Chuyển đổi kiểu dữ liệu
    			int namXuatBan_Int=Integer.parseInt(namXuatBan);
    			int soLuong_Int=Integer.parseInt(soLuong);
    			int soLuongBan_Int=Integer.parseInt(soLuongBan);
    			double giaNhap_Double=Double.parseDouble(giaNhap);
    			double giaBan_Double=Double.parseDouble(giaNhap);
    			SanPham s=new SanPham(maSP, tenSP, loaiSP, tacGia, nhaXuatBan, namXuatBan_Int, soLuong_Int, soLuongBan_Int, ngonNgu, giaNhap_Double, giaBan_Double, sqlNhaCungCap_BUS.getMaNhaCungCap(nhaCungCap));
    			dtm_SP.setRowCount(0);
    			sqlSanPham_BUS.timKiem_SanPham(s, dtm_SP);
    			
    			
            } catch (NumberFormatException e) {
                // Xử lý exception nếu không thể chuyển đổi
            	UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
    	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
    			JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
    	}
    	
    	
    }
    private ImageIcon createImageIconFromBytes(byte[] imageData) {
        if (imageData != null) {
            try {
                ByteArrayInputStream stream = new ByteArrayInputStream(imageData);
                BufferedImage image = ImageIO.read(stream);
                return new ImageIcon(image);
            } catch (IOException e) {
                e.printStackTrace();
                UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
    			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
    			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int row=tbl_DSSP.getSelectedRow();
		//dtm_SP = new DefaultTableModel(new String[] 
		//{"Mã sản phẩm","Tên sản phẩm","Loại","Ngôn ngữ","Nhà cung cấp","NXB","Năm XB","Tác giả","SL còn","SL bán","Giá Nhập","Giá Bán"},0);
		cbo_MaSP.setSelectedItem(tbl_DSSP.getValueAt(row, 0).toString());
		cbo_TenSP.setSelectedItem(tbl_DSSP.getValueAt(row, 1).toString());
		cbo_LoaiSP.setSelectedItem(tbl_DSSP.getValueAt(row, 2).toString());
		cbo_NgonNgu.setSelectedItem(tbl_DSSP.getValueAt(row, 3).toString());
		cbo_NhaCungCap.setSelectedItem(tbl_DSSP.getValueAt(row, 4).toString());
		cbo_NhaXuatBan.setSelectedItem(tbl_DSSP.getValueAt(row, 5).toString());
		cbo_NamXuatBan.setSelectedItem(Integer.parseInt(tbl_DSSP.getValueAt(row, 6).toString()));
		cbo_TacGia.setSelectedItem(tbl_DSSP.getValueAt(row, 7).toString());
		cbo_SoLuongCon.setSelectedItem(Integer.parseInt(tbl_DSSP.getValueAt(row, 8).toString()));
		cbo_SoLuongBan.setSelectedItem(tbl_DSSP.getValueAt(row, 9).toString());
		cbo_GiaNhap.setSelectedItem(tbl_DSSP.getValueAt(row, 10).toString());
		cbo_GiaBan.setSelectedItem(tbl_DSSP.getValueAt(row, 11).toString());
		ImageIcon originalImage = createImageIconFromBytes(sqlSanPham_BUS.getBytesAnh(tbl_DSSP.getValueAt(row, 0).toString()));
		int desiredWidth = lbl_hinhAnhSP.getWidth();
		int desiredHeight = lbl_hinhAnhSP.getHeight();
		
		// Resize the image while maintaining the aspect ratio
		Image resizedImage = originalImage.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
		
		// Create a new ImageIcon from the resized image
		ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
		
		// Set the resized image to the JLabel
		lbl_hinhAnhSP.setIcon(resizedImageIcon);	
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btn_XoaTrang))
		{
			xoaTrang();
		}
		if(o.equals(btn_TimKiem))
		{
			if(checkComboboxNULL())
				timKiem();
		}
	}
}
