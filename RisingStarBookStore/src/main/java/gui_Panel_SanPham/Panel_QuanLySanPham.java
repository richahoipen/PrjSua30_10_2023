package gui_Panel_SanPham;

import gui_Dialog.Message;
import gui_Frame_Running.Frame_Chinh;
import image.ImageToBytesExample;

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
import javax.swing.JTable;
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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class Panel_QuanLySanPham extends JPanel implements ActionListener,MouseListener
{
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JPanel pn_Master,pn_Header,pn_QL_SP,pn_Table_DSSP;
	private Custom_JLabel picture_Logo;
	private Custom_Button btn_Close,btn_Home,btn_Logout;
	private JLabel lbl_Title_QL_SP,lbl_Title_DSSP;
	private JLabel lbl_MaSP,lbl_TenSP,lbl_LoaiSP,lbl_NgonNgu,lbl_NhaCungCap,lbl_NhaXuatBan,lbl_NamXuatBan,lbl_TacGia,lbl_SoLuongCon,lbl_SoLuongBan,lbl_GiaNhap,lbl_GiaBan;
	private Custom_ComboBox cbo_TenSP,cbo_LoaiSP,cbo_NgonNgu,cbo_NhaCungCap;
	private JTextField txt_TenSP,txt_NhaXuatBan,txt_TacGia,txt_GiaNhap,txt_GiaBan;
	private JLabel lbl_txt_MaSP,lbl_txt_SoLuongBan;
	private JSpinner spn_NamXuatBan,spn_SoLuongCon;
	private Custom_JLabel lbl_hinhAnhSP;
	private Custom_Button btn_Them,btn_XoaTrang,btn_CapNhat,btn_ChonAnh;
	private JScrollPane scr_DSSP;
	private CustomTable tbl_DSSP;
	private DefaultTableModel dtm_SP;
	private NhaCungCap_BUS sqlNhaCungCap_BUS=new NhaCungCap_BUS();
	private SanPham_BUS sqlSanPham_BUS=new SanPham_BUS();
	private boolean daChon=false;
	private byte[] duLieuAnh;
    // End of variables declaration//GEN-END:variables
    public Panel_QuanLySanPham() {
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
		
		lbl_txt_MaSP = new JLabel();
		lbl_txt_MaSP.setForeground(Color.black);
		lbl_txt_MaSP.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_txt_MaSP.setOpaque(true);
		lbl_txt_MaSP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
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
		
		txt_NhaXuatBan = new JTextField();
		txt_NhaXuatBan.setForeground(Color.black);
		txt_NhaXuatBan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		spn_NamXuatBan = new JSpinner();
		spn_NamXuatBan.setForeground(Color.black);
		spn_NamXuatBan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		txt_TacGia = new JTextField();
		txt_TacGia.setForeground(Color.black);
		txt_TacGia.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		spn_SoLuongCon = new JSpinner();
		spn_SoLuongCon.setForeground(Color.black);
		spn_SoLuongCon.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lbl_txt_SoLuongBan = new JLabel();
		lbl_txt_SoLuongBan.setForeground(Color.black);
		lbl_txt_SoLuongBan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbl_txt_SoLuongBan.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_txt_SoLuongBan.setOpaque(true);
		
		txt_GiaNhap = new JTextField();
		txt_GiaNhap.setForeground(Color.black);
		txt_GiaNhap.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		txt_GiaBan = new JTextField();
		txt_GiaBan.setForeground(Color.black);
		txt_GiaBan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
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
		int[] columnWidths = {100, 175, 130, 85, 100, 220, 60, 130, 60,60,70,70};
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
		
		btn_ChonAnh = new Custom_Button();
		btn_ChonAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_ChonAnh.setBuffered_Icon("src/main/images/view_image/Add image.png");
		btn_ChonAnh.resizeIcon(14, 14);
		btn_ChonAnh.setText("Chọn ảnh");
		btn_ChonAnh.setFont(new Font("Inner", Font.BOLD, 12));
		btn_ChonAnh.setOver(true);
		btn_ChonAnh.setColor_Foreground(Color.black);
		btn_ChonAnh.setColor_Hightlight(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_ChonAnh.setColor_Background(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_ChonAnh.setColor_Over(Custom_ColorPicker.lightgrey_D9D9D9);
		btn_ChonAnh.setColor_Click(Color.black);
		btn_ChonAnh.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		
		btn_Them = new Custom_Button();
		btn_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Them.setText("Thêm");
		btn_Them.setFont(new Font("Inner", Font.BOLD, 12));
		btn_Them.setBuffered_Icon("src/main/images/view_image/Add product.png");
		btn_Them.resizeIcon(14, 14);
		btn_Them.setOver(true);
		btn_Them.setColor_Foreground(Color.black);
		btn_Them.setColor_Hightlight(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_Them.setColor_Background(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_Them.setColor_Over(Custom_ColorPicker.lightgrey_D9D9D9);
		btn_Them.setColor_Click(Color.black);
		btn_Them.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		
		btn_CapNhat = new Custom_Button();
		btn_CapNhat.setText("Cập nhật");
		btn_CapNhat.setFont(new Font("Inner", Font.BOLD, 12));
		btn_CapNhat.setBuffered_Icon("src/main/images/view_image/Update.png");
		btn_CapNhat.resizeIcon(14, 14);
		btn_CapNhat.setOver(true);
		btn_CapNhat.setColor_Foreground(Color.black);
		btn_CapNhat.setColor_Hightlight(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_CapNhat.setColor_Background(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_CapNhat.setColor_Over(Custom_ColorPicker.lightgrey_D9D9D9);
		btn_CapNhat.setColor_Click(Color.black);
		btn_CapNhat.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		
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
        	gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_QL_SP.createSequentialGroup()
        			.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGap(5)
        					.addComponent(lbl_NgonNgu, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGap(7)
        					.addComponent(lbl_MaSP, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGap(6)
        					.addComponent(lbl_TenSP, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGap(6)
        					.addComponent(lbl_LoaiSP)))
        			.addGap(6)
        			.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addComponent(lbl_txt_MaSP, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED))
        						.addComponent(cbo_TenSP, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        						.addComponent(cbo_LoaiSP, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        					.addGap(4))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addComponent(cbo_NgonNgu, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lbl_NhaXuatBan, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_TacGia)
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_NhaCungCap))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_NamXuatBan)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btn_CapNhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btn_Them, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btn_ChonAnh, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addComponent(txt_NhaXuatBan, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        						.addComponent(txt_TacGia, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        						.addComponent(spn_NamXuatBan, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        						.addComponent(cbo_NhaCungCap, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        							.addGroup(gl_pn_QL_SP.createSequentialGroup()
        								.addGap(11)
        								.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING, false)
        									.addGroup(gl_pn_QL_SP.createSequentialGroup()
        										.addComponent(lbl_GiaBan, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
        										.addGap(6))
        									.addGroup(gl_pn_QL_SP.createSequentialGroup()
        										.addPreferredGap(ComponentPlacement.RELATED)
        										.addComponent(lbl_SoLuongBan, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
        								.addGap(4))
        							.addGroup(gl_pn_QL_SP.createSequentialGroup()
        								.addPreferredGap(ComponentPlacement.UNRELATED)
        								.addComponent(lbl_SoLuongCon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addPreferredGap(ComponentPlacement.RELATED)))
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(lbl_GiaNhap, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)))
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addComponent(spn_SoLuongCon, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(txt_GiaBan, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(txt_GiaNhap, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lbl_txt_SoLuongBan, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lbl_hinhAnhSP, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
        			.addGap(0))
        );
        gl_pn_QL_SP.setVerticalGroup(
        	gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_QL_SP.createSequentialGroup()
        			.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbl_hinhAnhSP, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addGap(4)
        							.addComponent(lbl_txt_MaSP, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        							.addGap(3)
        							.addComponent(cbo_TenSP, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        							.addGap(8)
        							.addComponent(cbo_LoaiSP, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addGap(6)
        							.addComponent(lbl_MaSP)
        							.addGap(7)
        							.addComponent(lbl_TenSP)
        							.addGap(12)
        							.addComponent(lbl_LoaiSP))
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.BASELINE)
        								.addComponent(lbl_NhaXuatBan, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addComponent(txt_NhaXuatBan, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lbl_SoLuongCon, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        							.addGap(6)
        							.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        								.addComponent(lbl_NhaCungCap, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addComponent(cbo_NhaCungCap, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        							.addGap(8)
        							.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        								.addComponent(spn_NamXuatBan, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lbl_NamXuatBan, Alignment.TRAILING)))
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addGap(30)
        							.addComponent(lbl_SoLuongBan, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
        					.addGap(6)
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(lbl_GiaBan)
        						.addComponent(txt_TacGia, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_TacGia)
        						.addComponent(lbl_NgonNgu)
        						.addComponent(cbo_NgonNgu, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
        					.addGap(0, 0, Short.MAX_VALUE))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addComponent(spn_SoLuongCon, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
        					.addGap(7)
        					.addComponent(lbl_txt_SoLuongBan)
        					.addGap(8)
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.BASELINE)
        						.addComponent(txt_GiaNhap, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_GiaNhap, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(txt_GiaBan, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btn_ChonAnh, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn_CapNhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn_Them, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        gl_pn_QL_SP.linkSize(SwingConstants.VERTICAL, new Component[] {btn_ChonAnh, btn_Them, btn_CapNhat, btn_XoaTrang});
        gl_pn_QL_SP.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_MaSP, lbl_TenSP, lbl_LoaiSP, lbl_NgonNgu});
        gl_pn_QL_SP.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_NhaCungCap, lbl_NhaXuatBan, lbl_NamXuatBan, lbl_TacGia, lbl_SoLuongCon, lbl_SoLuongBan, lbl_GiaNhap, lbl_GiaBan});
        gl_pn_QL_SP.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_txt_MaSP, cbo_TenSP, cbo_LoaiSP, cbo_NgonNgu, cbo_NhaCungCap, txt_NhaXuatBan, spn_NamXuatBan, txt_TacGia, spn_SoLuongCon, lbl_txt_SoLuongBan, txt_GiaNhap, txt_GiaBan});
        gl_pn_QL_SP.linkSize(SwingConstants.HORIZONTAL, new Component[] {btn_ChonAnh, btn_Them, btn_CapNhat, btn_XoaTrang});
        gl_pn_QL_SP.linkSize(SwingConstants.HORIZONTAL, new Component[] {lbl_MaSP, lbl_TenSP, lbl_LoaiSP, lbl_NgonNgu, lbl_NhaCungCap, lbl_NamXuatBan, lbl_TacGia, lbl_SoLuongCon, lbl_SoLuongBan, lbl_GiaNhap, lbl_GiaBan});
        pn_QL_SP.setLayout(gl_pn_QL_SP);
        addAction();
    }// </editor-fold>//GEN-END:initComponents
    private void addAction()
    {
    	btn_Them.addActionListener(this);
    	btn_XoaTrang.addActionListener(this);
    	btn_CapNhat.addActionListener(this);
    	btn_ChonAnh.addActionListener(this);
    	tbl_DSSP.addMouseListener(this);
    	addCombobox();
    	resetTable();
    	
    }
    private void addCombobox()
    {
    	//TenSP
    	cbo_TenSP.addItem("Chọn");
    	cbo_TenSP.addItem("Doraemon tập 1");
    	cbo_TenSP.getMyVector().add("Doraemon tập 1");
    	cbo_TenSP.addItem("Doraemon tập 2");
    	cbo_TenSP.getMyVector().add("Doraemon tập 2");
    	cbo_TenSP.addItem("Mắt biếc");
    	cbo_TenSP.getMyVector().add("Mắt biếc");
    	cbo_TenSP.addItem("Harry Potter");
    	cbo_TenSP.getMyVector().add("Harry Potter");
    	cbo_TenSP.addItem("Doraemon tập 5");
    	cbo_TenSP.getMyVector().add("Doraemon tập 5");
    	cbo_TenSP.addItem("Cô tiên xanh");
    	cbo_TenSP.getMyVector().add("Cô tiên xanh");
    	cbo_TenSP.addItem("Doraemon tập 50");
    	cbo_TenSP.getMyVector().add("Doraemon tập 50");
    	cbo_TenSP.addItem("Ba chàng lính ngự lâm");
    	cbo_TenSP.getMyVector().add("Ba chàng lính ngự lâm");
    	//loaiSP
    	cbo_LoaiSP.addItem("Chọn");
    	cbo_LoaiSP.addItem("Sách thiếu nhi");
    	cbo_LoaiSP.getMyVector().add("Sách thiếu nhi");
    	cbo_LoaiSP.addItem("Tiểu thuyết");
    	cbo_LoaiSP.getMyVector().add("Tiểu thuyết");
    	cbo_LoaiSP.addItem("Truyện tranh");
    	cbo_LoaiSP.getMyVector().add("Truyện tranh");
    	//nha cung cap
    	cbo_NhaCungCap.addItem("Chọn");
    	sqlNhaCungCap_BUS.dayComboBoxMaNCC(cbo_NhaCungCap);
    	//ngon ngu
    	cbo_NgonNgu.addItem("Chọn");
    	cbo_NgonNgu.addItem("Tiếng việt");
    	cbo_NgonNgu.getMyVector().add("Tiếng việt");
    	cbo_NgonNgu.addItem("Tiếng anh");
    	cbo_NgonNgu.getMyVector().add("Tiếng anh");
    	cbo_NgonNgu.addItem("Tiếng pháp");
    	cbo_NgonNgu.getMyVector().add("Tiếng pháp");
    	cbo_NgonNgu.addItem("Tiếng trung");
    	cbo_NgonNgu.getMyVector().add("Tiếng trung");
    	cbo_NgonNgu.addItem("Tiếng hàn");
    	cbo_NgonNgu.getMyVector().add("Tiếng hàn");
    	cbo_NgonNgu.addItem("Tiếng nhật");
    	cbo_NgonNgu.getMyVector().add("Tiếng nhật");
    	cbo_NgonNgu.addItem("Tiếng đức");
    	cbo_NgonNgu.getMyVector().add("Tiếng đức");
    	
    }
    private void resetTable()
    {
    	dtm_SP.setRowCount(0);
    	sqlSanPham_BUS.xuatDanhSachSanPham(dtm_SP);
    }
    private void xoaTrang()
    {
    	lbl_txt_MaSP.setText("");
    	cbo_TenSP.setSelectedItem("Chọn");
    	cbo_LoaiSP.setSelectedItem("Chọn");
    	cbo_NgonNgu.setSelectedItem("Chọn");
    	cbo_NhaCungCap.setSelectedItem("Chọn");
    	txt_NhaXuatBan.setText("");
    	txt_GiaBan.setText("");
    	txt_GiaNhap.setText("");
    	txt_TacGia.setText("");
    	lbl_txt_SoLuongBan.setText("");
    	txt_TacGia.setText("");
    	LocalDate ngayHienTai=LocalDate.now();
    	spn_NamXuatBan.setValue(ngayHienTai.getYear());
    	spn_SoLuongCon.setValue(0);
    	lbl_hinhAnhSP.setIcon(null);
    	setDaChon(false);
    	resetTable();
    	
    }
    private boolean checkComboboxNULL()
    {
    	String tenSP=(String) cbo_TenSP.getSelectedItem();
    	String loaiSP=(String) cbo_LoaiSP.getSelectedItem();
    	String ngonNgu=(String) cbo_NgonNgu.getSelectedItem();
    	String nhaCungCap=(String) cbo_NhaCungCap.getSelectedItem();
    	if(tenSP!=null && loaiSP!=null && ngonNgu!=null && nhaCungCap!=null)
    	{
    		return true;
    	}
    	else
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
            UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
            JOptionPane.showMessageDialog(null, "Dữ liệu ở thanh xổ không được rỗng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
    	}
    }
    private boolean checkJSpinner()
    {
    	Object namXuatBan=spn_NamXuatBan.getValue();
    	Object soLuong=spn_SoLuongCon.getValue();
    	if(namXuatBan instanceof String || soLuong instanceof String)
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
            UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
            JOptionPane.showMessageDialog(null, "Năm xuất bản hoặc số lượng không được là chuỗi.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
    		return false; 		
    	}
    	else
    	{
    		return true;
    	}
    }
    private boolean kiemTraRangBuoc()
    {
    	//SanPham(String maSP, String tenSP, String loaiSP, String tacGia, String nhaXuatBan, int namXuatBan,
		//int soLuong, String ngonNgu, double giaNhap, double giaBan,byte[] hinhAnh) 
    	String tenSP=(String) cbo_TenSP.getSelectedItem();
    	String loaiSP=(String) cbo_LoaiSP.getSelectedItem();
    	String tacGia=txt_TacGia.getText();
    	String nhaXuatBan=txt_NhaXuatBan.getText();
    	int namXuatBan=(int) spn_NamXuatBan.getValue();
    	int soLuong=(int)spn_SoLuongCon.getValue();
    	String ngonNgu=(String) cbo_NgonNgu.getSelectedItem();
    	String giaNhap=txt_GiaNhap.getText();
    	
    	String giaBan=txt_GiaNhap.getText();
    	
    	
    	String nhaCungCap=(String) cbo_NhaCungCap.getSelectedItem();
    	LocalDate ngayHienTai=LocalDate.now();
    	String chon="Chọn";
    	if(tenSP.equalsIgnoreCase(chon) || loaiSP.equalsIgnoreCase(chon) || tacGia.trim().equals("") ||
    			nhaXuatBan.trim().equals("")|| namXuatBan==0|| soLuong==0||
    				ngonNgu.equalsIgnoreCase(chon)|| giaNhap.trim().equals("")||nhaCungCap.equalsIgnoreCase(chon)||
    				giaBan.trim().equals(""))
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
            UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
            JOptionPane.showMessageDialog(null, "Vui lòng nhập hết dữ liệu.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
    	}
    	
    	if(!checkComboboxNULL())
    		return false;
    	if(!checkJSpinner())
    		return false;
    	if(!tacGia.matches("^[\\p{Lu}][\\p{Ll}]+(\\s[\\p{Lu}][\\p{Ll}]+)*$"))
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Tên tác giả không hợp lệ.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_TacGia.requestFocus();
	        return false;
    	}
    	if(namXuatBan<=1800)
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Năm xuất bản trước 1800.", "Warning", JOptionPane.WARNING_MESSAGE);
	        return false;
    	}
    	if(namXuatBan>ngayHienTai.getYear())
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Năm xuất bản sau năm hiện tại.", "Warning", JOptionPane.WARNING_MESSAGE);
	        return false;
    	}
    	
    	if(soLuong<=0)
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0.", "Warning", JOptionPane.WARNING_MESSAGE);
	        return false;
    	}
    	if(!giaNhap.matches("^\\d+(\\.\\d+)?$"))
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Giá nhập phải là số.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_GiaNhap.requestFocus();
	        return false;
    	}
    	double giaNhap_Double=Double.parseDouble(giaNhap);
    	
    	if(giaNhap_Double<=0)
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Giá nhập phải lớn hơn 0.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_GiaNhap.requestFocus();
	        return false;
    	}
    	double giaBan_Double=Double.parseDouble(giaBan);
    	if(!giaBan.matches("^\\d+(\\.\\d+)?$"))
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Giá bán phải là số.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_GiaNhap.requestFocus();
	        return false;
    	}
    	if(giaBan_Double<=0)
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Giá bán phải lớn hơn 0.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_GiaNhap.requestFocus();
	        return false;
    	}
    	if(isDaChon()==false)
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Vui lòng thêm ảnh.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_GiaNhap.requestFocus();
	        return false;
    	}
    			
    	
    	return true;
    }
    private byte[] getBytes(BufferedImage image) throws IOException 
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        return baos.toByteArray();
    }
    private void chonAnh()
    {
    	JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(Panel_QuanLySanPham.this);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                // Load the selected image
                BufferedImage originalImage  = ImageIO.read(selectedFile);
                // Set the desired width and height
                // Set the desired width and height
                ImageIcon imageIcon = new ImageIcon(originalImage);
                int desiredWidth = lbl_hinhAnhSP.getWidth();
        	    int desiredHeight = lbl_hinhAnhSP.getHeight();
        	    // Resize the image while maintaining the aspect ratio
        	    Image resizedImage = imageIcon.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        	    // Create a new ImageIcon from the resized image
        	    ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        	    // Set the resized image to the JLabel
        	    lbl_hinhAnhSP.setIcon(resizedImageIcon);            
                setDaChon(true);
                // Convert the loaded image to bytes
                byte[] imageData = getBytes(originalImage);
                // Do something with the imageData byte array
                setDuLieuAnh(imageData);
            } catch (IOException ex) {
                ex.printStackTrace();
                UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
    	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
    	        JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
    	        txt_GiaNhap.requestFocus();
            }
        }
    }
    private void themSP()
    {
    	//SanPham(String maSP, String tenSP, String loaiSP, String tacGia, String nhaXuatBan, int namXuatBan,
    			//int soLuong, String ngonNgu, double giaNhap, double giaBan,byte[] hinhAnh) 
		String tenSP=(String) cbo_TenSP.getSelectedItem();
		String loaiSP=(String) cbo_LoaiSP.getSelectedItem();
		String tacGia=txt_TacGia.getText();
		String nhaXuatBan=txt_NhaXuatBan.getText();
		int namXuatBan=(Integer)spn_NamXuatBan.getValue();
		int soLuong=(Integer)spn_SoLuongCon.getValue();
		String ngonNgu=(String) cbo_NgonNgu.getSelectedItem();
		String giaNhap=txt_GiaNhap.getText();   
		double giaNhap_Double=Double.parseDouble(giaNhap);
		String giaBan=txt_GiaBan.getText();
		double giaBan_Double=Double.parseDouble(giaBan);
		String nhaCungCap=(String) cbo_NhaCungCap.getSelectedItem();	
		SanPham s=new SanPham();
		s.setTenSP(tenSP);
		s.setLoaiSP(loaiSP);
		s.setTacGia(tacGia);
		s.setNhaXuatBan(nhaXuatBan);
		s.setNamXuatBan(namXuatBan);
		s.setSoLuong(soLuong);
		s.setNgonNgu(ngonNgu);
		s.setGiaNhap(giaNhap_Double);
		s.setGiaBan(giaBan_Double);
		s.setMaNhaCungCap(nhaCungCap);
		s.setHinhAnh(getDuLieuAnh());
		sqlSanPham_BUS.themSanPham(s, dtm_SP);
		resetTable();
    }
    private void capNhatSP()
    {
    	String maSP=lbl_txt_MaSP.getText();
    	String tenSP=(String) cbo_TenSP.getSelectedItem();
		String loaiSP=(String) cbo_LoaiSP.getSelectedItem();
		String tacGia=txt_TacGia.getText();
		String nhaXuatBan=txt_NhaXuatBan.getText();
		int namXuatBan=(Integer)spn_NamXuatBan.getValue();
		int soLuong=(Integer)spn_SoLuongCon.getValue();
		String ngonNgu=(String) cbo_NgonNgu.getSelectedItem();
		String giaNhap=txt_GiaNhap.getText();   
		double giaNhap_Double=Double.parseDouble(giaNhap);
		String giaBan=txt_GiaBan.getText();
		double giaBan_Double=Double.parseDouble(giaBan);
		String nhaCungCap=(String) cbo_NhaCungCap.getSelectedItem();
		SanPham s=new SanPham(maSP, tenSP, loaiSP, tacGia, nhaXuatBan, namXuatBan, soLuong, soLuong, ngonNgu, giaNhap_Double, giaBan_Double, duLieuAnh);
		s.setMaNhaCungCap(nhaCungCap);
		sqlSanPham_BUS.capNhatSanPham(s, dtm_SP);
		resetTable();
    }
    public ImageIcon createImageIconFromBytes(byte[] imageData) {
        if (imageData != null) {
            try {
                ByteArrayInputStream stream = new ByteArrayInputStream(imageData);
                BufferedImage image = ImageIO.read(stream);
                return new ImageIcon(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=tbl_DSSP.getSelectedRow();
		//dtm_SP = new DefaultTableModel(new String[] 
		//{"Mã sản phẩm","Tên sản phẩm","Loại","Ngôn ngữ","Nhà cung cấp","NXB","Năm XB","Tác giả","SL còn","SL bán","Giá Nhập","Giá Bán"},0);
		lbl_txt_MaSP.setText(tbl_DSSP.getValueAt(row, 0).toString());
		cbo_TenSP.setSelectedItem(tbl_DSSP.getValueAt(row, 1).toString());
		cbo_LoaiSP.setSelectedItem(tbl_DSSP.getValueAt(row, 2).toString());
		cbo_NgonNgu.setSelectedItem(tbl_DSSP.getValueAt(row, 3).toString());
		cbo_NhaCungCap.setSelectedItem(tbl_DSSP.getValueAt(row, 4).toString());
		txt_NhaXuatBan.setText(tbl_DSSP.getValueAt(row, 5).toString());
		spn_NamXuatBan.setValue(Integer.parseInt(tbl_DSSP.getValueAt(row, 6).toString()));
		txt_TacGia.setText(tbl_DSSP.getValueAt(row, 7).toString());
		spn_SoLuongCon.setValue(Integer.parseInt(tbl_DSSP.getValueAt(row, 8).toString()));
		lbl_txt_SoLuongBan.setText(tbl_DSSP.getValueAt(row, 9).toString());
		txt_GiaNhap.setText(tbl_DSSP.getValueAt(row, 10).toString());
		txt_GiaBan.setText(tbl_DSSP.getValueAt(row, 11).toString());
		ImageIcon originalImage = createImageIconFromBytes(sqlSanPham_BUS.getBytesAnh(tbl_DSSP.getValueAt(row, 0).toString()));
		int desiredWidth = lbl_hinhAnhSP.getWidth();
	    int desiredHeight = lbl_hinhAnhSP.getHeight();

	    // Resize the image while maintaining the aspect ratio
	    Image resizedImage = originalImage.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);

	    // Create a new ImageIcon from the resized image
	    ImageIcon resizedImageIcon = new ImageIcon(resizedImage);

	    // Set the resized image to the JLabel
	    lbl_hinhAnhSP.setIcon(resizedImageIcon);
        setDaChon(true);
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
		Object o=e.getSource();
		if(o.equals(btn_XoaTrang))
		{
			xoaTrang();
		}
		if(o.equals(btn_Them))
		{
			if(kiemTraRangBuoc())
			{
				themSP();
			}
		}
		if(o.equals(btn_ChonAnh))
		{
			chonAnh();
		}
		if(o.equals(btn_CapNhat))
		{
			if(kiemTraRangBuoc())
			{
				capNhatSP();
			}
		}
		
	}



	public boolean isDaChon() {
		return daChon;
	}



	public void setDaChon(boolean daChon) {
		this.daChon = daChon;
	}



	public byte[] getDuLieuAnh() {
		return duLieuAnh;
	}



	public void setDuLieuAnh(byte[] duLieuAnh) {
		this.duLieuAnh = duLieuAnh;
	}
}
