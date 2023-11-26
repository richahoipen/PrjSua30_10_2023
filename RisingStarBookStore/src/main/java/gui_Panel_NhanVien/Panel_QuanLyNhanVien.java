package gui_Panel_NhanVien;

import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.toedter.calendar.JDateChooser;

import customEntities.Custom_Button;
import customEntities.Custom_ColorPicker;
import customEntities.Custom_ComboBox;
import customEntities.Custom_Function;
import customEntities.Custom_ImageIcon;
import customEntities.Custom_JLabel;
import dataBase_BUS.NhanVien_BUS;
import entities.NhaCungCap;
import entities.NhanVien;
import entities.TaiKhoan;
import customEntities.CustomTable;
import gui_Dialog.Message;
import gui_Frame_Running.Frame_Chinh;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Date;


import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class Panel_QuanLyNhanVien extends JPanel implements ActionListener, MouseListener
{
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JPanel pn_QL_NV,pn_Table_DSNV;
	private Custom_JLabel picture_Logo;
	private JLabel lbl_Title_QL_NV,lbl_Title_DSNV;
	private JLabel lbl_MaNV,lbl_HoTen,lbl_MatKhau,lbl_ChucVu,lbl_GioiTinh,lbl_NgaySinh,lbl_DiaChi,lbl_CaLam,lbl_CCCD,lbl_SoDienThoai;
	private Custom_ComboBox cbo_ChucVu,cbo_GioiTinh,cbo_CaLam;
	private JTextField txt_HoTen,txt_MatKhau,txt_DiaChi,txt_CCCD,txt_SoDienThoai;
	private JLabel lbl_txt_MaNV;
	private JDateChooser dcr_NgaySinh;
	private JFormattedTextField ftf_NgaySinh;
	private BufferedImage bfi_ChonNgay;
	private Custom_Button btn_Them,btn_XoaTrang,btn_CapNhat;
	private JScrollPane scr_DSNV;
	private CustomTable tbl_DSNV;
	private DefaultTableModel dtm_NV;
	private NhanVien_BUS sqlNhanVien_BUS=new NhanVien_BUS();
    // End of variables declaration//GEN-END:variables
    public Panel_QuanLyNhanVien() {
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
    	lbl_Title_QL_NV = new JLabel("Quản lý nhân viên");
    	lbl_Title_QL_NV.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_QL_NV.setForeground(new Color(0, 0, 255));
		lbl_Title_QL_NV.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Title_QL_NV.setBounds(30,100,2500,50);
		
    	pn_QL_NV = new JPanel();
		pn_QL_NV.setIgnoreRepaint(true);
		pn_QL_NV.setBackground(Color.white);
		pn_QL_NV.setBorder(new LineBorder(Custom_ColorPicker.lightgrey_D9D9D9, 3));
		
		lbl_MaNV = new JLabel("Mã nhân viên:");
		lbl_MaNV.setForeground(Color.black);
		lbl_MaNV.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_HoTen = new JLabel("Họ tên:");
		lbl_HoTen.setForeground(Color.black);
		lbl_HoTen.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_MatKhau = new JLabel("Mật khẩu:");
		lbl_MatKhau.setForeground(Color.black);
		lbl_MatKhau.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_ChucVu = new JLabel("Chức vụ:");
		lbl_ChucVu.setForeground(Color.black);
		lbl_ChucVu.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_GioiTinh = new JLabel("Giới tính:");
		lbl_GioiTinh.setForeground(Color.black);
		lbl_GioiTinh.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_NgaySinh = new JLabel("Ngày sinh:");
		lbl_NgaySinh.setForeground(Color.black);
		lbl_NgaySinh.setFont(new Font("Inter", Font.PLAIN, 14));

		lbl_DiaChi = new JLabel("Địa chỉ:");
		lbl_DiaChi.setForeground(Color.black);
		lbl_DiaChi.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_CaLam = new JLabel("Ca làm:");
		lbl_CaLam.setForeground(Color.black);
		lbl_CaLam.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_CCCD = new JLabel("CCCD:");
		lbl_CCCD.setForeground(Color.black);
		lbl_CCCD.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_SoDienThoai = new JLabel("Số điện thoại:");
		lbl_SoDienThoai.setForeground(Color.black);
		lbl_SoDienThoai.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_txt_MaNV = new JLabel();
		lbl_txt_MaNV.setForeground(Color.black);
		lbl_txt_MaNV.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_txt_MaNV.setOpaque(true);
		lbl_txt_MaNV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		txt_HoTen = new JTextField();
		txt_HoTen.setForeground(Color.black);
		txt_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		txt_MatKhau = new JTextField();
		txt_MatKhau.setForeground(Color.black);
		txt_MatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_ChucVu = new Custom_ComboBox();
		cbo_ChucVu.setForeground(Color.black);
		cbo_ChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_ChucVu.setColor_Foreground(Color.black);
		cbo_ChucVu.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_ChucVu.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_ChucVu.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_ChucVu.redraw_Custom_Combobox();
		
		cbo_GioiTinh = new Custom_ComboBox();
		cbo_GioiTinh.setForeground(Color.black);
		cbo_GioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_GioiTinh.setColor_Foreground(Color.black);
		cbo_GioiTinh.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_GioiTinh.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_GioiTinh.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_GioiTinh.redraw_Custom_Combobox();
		cbo_GioiTinh.setRadius(0);
		
		dcr_NgaySinh = new JDateChooser ();
		try {
			bfi_ChonNgay = ImageIO.read(new File("src\\main\\images\\view_image\\Calendar.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bfi_ChonNgay = Custom_Function.resize(bfi_ChonNgay, 20, 20);
		dcr_NgaySinh.setIcon (new ImageIcon(bfi_ChonNgay));
		dcr_NgaySinh.getCalendarButton().setBackground (Custom_ColorPicker.lavender_ED91FF);
		dcr_NgaySinh.setLocation(1150,50); 
		dcr_NgaySinh.setSize(350, 50);
		ftf_NgaySinh = (JFormattedTextField) dcr_NgaySinh.getComponent(1);
		ftf_NgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ftf_NgaySinh.setPreferredSize(new Dimension(300,50));
		ftf_NgaySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		dcr_NgaySinh.getComponent(0).setPreferredSize(new Dimension(50,50));
		dcr_NgaySinh.getJCalendar().setPreferredSize (new Dimension (dcr_NgaySinh.getWidth()*3/2, dcr_NgaySinh.getWidth()*2/3));
		dcr_NgaySinh.setDateFormatString("dd-MM-yyyy");
		dcr_NgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		cbo_CaLam = new Custom_ComboBox();
		cbo_CaLam.setForeground(Color.black);
		cbo_CaLam.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		txt_CCCD = new JTextField();
		txt_CCCD.setForeground(Color.black);
		txt_CCCD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		txt_SoDienThoai = new JTextField();
		txt_SoDienThoai.setForeground(Color.black);
		txt_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		txt_DiaChi = new JTextField();
		txt_DiaChi.setForeground(Color.black);
		txt_DiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lbl_Title_DSNV = new JLabel("Danh sách nhân viên");
		lbl_Title_DSNV.setForeground(Color.BLUE);
		lbl_Title_DSNV.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		dtm_NV = new DefaultTableModel(new String[] {"Mã nhân viên","Tên nhân viên","Số điện thoại","Giới tính","Địa chỉ","Ngày sinh","Chức vụ","Căn cước công dân","Ca làm"},0);
		/*
		for (int i = 0; i < 1000; i++) {
			dtm_NV.addRow(new String[] {"SP0001","199 Đề Và Bài Văn Hay 9","Sách kham khảo","Tiếng Việt","Dn Tư Nhân Thương Mại Toàn Phúc","NXB Đại Học Quốc Gia Hà Nội","2018","	Phạm Ngọc Thắm","455","65","44.000đ","50.000đ"});
		}*/
		//NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String email, String caLam)
				
		tbl_DSNV = new CustomTable();
		tbl_DSNV.setModel(dtm_NV);
		JScrollPane scr_DSNV = new JScrollPane(tbl_DSNV);
		TableColumnModel columnModel = tbl_DSNV.getColumnModel();

        // Thiết lập chiều rộng cột cụ thể (ví dụ: cột 1 có chiều rộng 150px)
		int[] columnWidths = {20,100,20,20,350,30,30,50,10};
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
		
		
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
							.addComponent(lbl_Title_QL_NV))
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_Title_DSNV))
						.addComponent(scr_DSNV, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pn_QL_NV, GroupLayout.PREFERRED_SIZE, 790, Short.MAX_VALUE)))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(lbl_Title_QL_NV)
					.addGap(1)
					.addComponent(pn_QL_NV, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_Title_DSNV)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSNV, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
		);
        this.setLayout(layout);
        
        GroupLayout gl_pn_QL_NV = new GroupLayout(pn_QL_NV);
        gl_pn_QL_NV.setHorizontalGroup(
        	gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_QL_NV.createSequentialGroup()
        			.addGap(59)
        			.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lbl_ChucVu, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
        				.addComponent(lbl_HoTen, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
        				.addComponent(lbl_MaNV, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
        				.addComponent(lbl_MatKhau, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(6)
        			.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_QL_NV.createSequentialGroup()
        					.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_pn_QL_NV.createSequentialGroup()
        							.addComponent(lbl_txt_MaNV, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED))
        						.addComponent(txt_HoTen, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        						.addComponent(txt_MatKhau, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
        					.addGap(4))
        				.addGroup(gl_pn_QL_NV.createSequentialGroup()
        					.addComponent(cbo_ChucVu, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lbl_NgaySinh, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_CaLam)
        				.addGroup(gl_pn_QL_NV.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_GioiTinh))
        				.addGroup(gl_pn_QL_NV.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_DiaChi)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_QL_NV.createSequentialGroup()
        					.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        						.addComponent(dcr_NgaySinh, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        						.addComponent(cbo_CaLam, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        						.addComponent(cbo_GioiTinh, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
        					.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.TRAILING)
        						.addGroup(gl_pn_QL_NV.createSequentialGroup()
        							.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING, false)
        								.addGroup(gl_pn_QL_NV.createSequentialGroup()
        									.addGap(11)
        									.addComponent(lbl_SoDienThoai, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
        								.addGroup(gl_pn_QL_NV.createSequentialGroup()
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(lbl_CCCD, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
        							.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
        							.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        								.addComponent(txt_CCCD, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
        								.addGroup(gl_pn_QL_NV.createSequentialGroup()
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(txt_SoDienThoai, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))))
        						.addGroup(gl_pn_QL_NV.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btn_CapNhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btn_Them, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))))
        				.addComponent(txt_DiaChi, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
        			.addGap(62))
        );
        gl_pn_QL_NV.setVerticalGroup(
        	gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_QL_NV.createSequentialGroup()
        			.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_QL_NV.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        						.addComponent(dcr_NgaySinh, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_txt_MaNV, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_NgaySinh, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_MaNV)
        						.addComponent(lbl_CCCD, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txt_CCCD, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE))
        					.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_pn_QL_NV.createSequentialGroup()
        							.addGap(7)
        							.addComponent(txt_HoTen, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        							.addGap(8)
        							.addComponent(txt_MatKhau, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_pn_QL_NV.createSequentialGroup()
        							.addGap(9)
        							.addComponent(lbl_HoTen)
        							.addGap(12)
        							.addComponent(lbl_MatKhau))
        						.addGroup(gl_pn_QL_NV.createSequentialGroup()
        							.addGap(6)
        							.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        								.addComponent(lbl_GioiTinh, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addComponent(cbo_GioiTinh, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        							.addGap(8)
        							.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.BASELINE)
        								.addComponent(lbl_DiaChi)
        								.addComponent(txt_DiaChi, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
        						.addGroup(gl_pn_QL_NV.createSequentialGroup()
        							.addGap(7)
        							.addComponent(txt_SoDienThoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        					.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_pn_QL_NV.createSequentialGroup()
        							.addGap(6)
        							.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.TRAILING, false)
        								.addComponent(cbo_CaLam, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lbl_CaLam)
        								.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.BASELINE)
        									.addComponent(cbo_ChucVu, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        									.addComponent(lbl_ChucVu))))
        						.addGroup(gl_pn_QL_NV.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.BASELINE)
        								.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(btn_CapNhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(btn_Them, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))))
        				.addGroup(gl_pn_QL_NV.createSequentialGroup()
        					.addGap(41)
        					.addComponent(lbl_SoDienThoai, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(27, Short.MAX_VALUE))
        );
        gl_pn_QL_NV.linkSize(SwingConstants.VERTICAL, new Component[] {btn_Them, btn_CapNhat, btn_XoaTrang});
        gl_pn_QL_NV.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_GioiTinh, lbl_NgaySinh, lbl_DiaChi, lbl_CaLam, lbl_CCCD, lbl_SoDienThoai});
        gl_pn_QL_NV.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_txt_MaNV, txt_HoTen, txt_MatKhau, cbo_ChucVu, cbo_GioiTinh, dcr_NgaySinh, cbo_CaLam, txt_CCCD, txt_SoDienThoai, txt_DiaChi});
        gl_pn_QL_NV.linkSize(SwingConstants.HORIZONTAL, new Component[] {btn_Them, btn_CapNhat, btn_XoaTrang});
        gl_pn_QL_NV.linkSize(SwingConstants.HORIZONTAL, new Component[] {lbl_GioiTinh, lbl_DiaChi, lbl_CaLam, lbl_CCCD, lbl_SoDienThoai});
        pn_QL_NV.setLayout(gl_pn_QL_NV);
        addAction();
    }// </editor-fold>//GEN-END:initComponents
    private void addAction()
    {
    	/*
    	 * sqlNhaCungCap_BUS.xuatDanhSachNhaCungCap(dtm_NCC);
		btn_Them.addActionListener(this);
		btn_CapNhat.addActionListener(this);
		btn_XoaTrang.addActionListener(this);	
		tbl_DSNCC.addMouseListener(this);
    	 */
    	sqlNhanVien_BUS.xuatDanhSachNhanVien(dtm_NV);
    	btn_Them.addActionListener(this);
		btn_CapNhat.addActionListener(this);
		btn_XoaTrang.addActionListener(this);	
		tbl_DSNV.addMouseListener(this);
		//Add dữ liệu cho combobox
		cbo_CaLam.addItem("");
		cbo_CaLam.addItem("Sáng");
		cbo_CaLam.addItem("Chiều");
		cbo_CaLam.addItem("Tối");
		cbo_CaLam.getMyVector().add("Sáng");
		cbo_CaLam.getMyVector().add("Chiều");
		cbo_CaLam.getMyVector().add("Tối");
		//
		cbo_GioiTinh.addItem("");
		cbo_GioiTinh.addItem("Nam");
		cbo_GioiTinh.addItem("Nữ");
		cbo_GioiTinh.getMyVector().add("Nam");
		cbo_GioiTinh.getMyVector().add("Nữ");
		//
		cbo_ChucVu.addItem("");
		cbo_ChucVu.addItem("Nhân viên");
		cbo_ChucVu.addItem("Nhân viên quản lí");
		cbo_ChucVu.getMyVector().add("Nhân viên");
		cbo_ChucVu.getMyVector().add("Nhân viên quản lí");
    }
    private void xoaTrang()
    {
    	cbo_CaLam.setSelectedItem("");
    	cbo_GioiTinh.setSelectedItem("");
    	cbo_ChucVu.setSelectedItem("");
    	//set Text
    	lbl_txt_MaNV.setText("");
    	txt_HoTen.setText("");
    	txt_MatKhau.setText("");
    	txt_CCCD.setText("");
    	txt_DiaChi.setText("");
    	txt_SoDienThoai.setText("");
    	ftf_NgaySinh.setText("");
    	
    	resetTable();
    }
    private void resetTable()
    {
    	dtm_NV.setRowCount(0);
    	sqlNhanVien_BUS.xuatDanhSachNhanVien(dtm_NV);
    }
    private boolean checkComboboxNULL()
    {
    	String gioiTinh=(String) cbo_GioiTinh.getSelectedItem();
    	String chucVu=(String) cbo_ChucVu.getSelectedItem();
    	String caLam=(String) cbo_CaLam.getSelectedItem();
    	if(gioiTinh!=null||chucVu!=null||caLam!=null)
    		return true;
    	else
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
            UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
            JOptionPane.showMessageDialog(null, "Dữ liệu giới tính không được rỗng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
    	}
    }
	private boolean kiemTraRangBuoc()
    {
    	String tenNV=txt_HoTen.getText();
    	String sdt=txt_SoDienThoai.getText();
    	String gioiTinh=(String) cbo_GioiTinh.getSelectedItem();
    	String diaChi=txt_DiaChi.getText();
    	Date ngaySinh=dcr_NgaySinh.getDate();
    	java.sql.Date sqlDateNgaySinh = new java.sql.Date(ngaySinh.getTime());
    	//set và get
    	NhanVien n=new NhanVien();
    	n.setNgaySinh(sqlDateNgaySinh);
    	//
    	String chucVu=(String) cbo_ChucVu.getSelectedItem();
    	String cMND=txt_CCCD.getText();
    	String caLam=(String) cbo_CaLam.getSelectedItem();
    	String ngaySinhString=ftf_NgaySinh.getText();
    	String chon="";
    	
    	if(tenNV.trim().equals("") || sdt.trim().equals("") || gioiTinh.equalsIgnoreCase(chon) ||
        			diaChi.trim().equals("")||ngaySinhString.trim().equals("")  || chucVu.equalsIgnoreCase(chon) ||
        				cMND.trim().equals("") || caLam.equalsIgnoreCase(chon))
        {
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
			JOptionPane.showMessageDialog(null, "Vui lòng nhập hết dữ liệu.", "Warning", JOptionPane.WARNING_MESSAGE);
			txt_HoTen.requestFocus();
			return false;
        }
    	if(checkComboboxNULL()==false)
    		return false;
    	if(!tenNV.matches("^[\\p{Lu}][\\p{Ll}]+(\\s[\\p{Lu}][\\p{Ll}]+)*$"))
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Họ và tên không hợp lệ.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_HoTen.requestFocus();
	        return false;
    	}
    	if(!sdt.matches("^0[0-9]{9}$"))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_SoDienThoai.requestFocus();
	        return false;
		}
		if(!diaChi.matches("^[a-zA-Z0-9,./\\p{L} ]*$"))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Địa chỉ không hợp lệ.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_DiaChi.requestFocus();
	        return false;
		}
    	if(!cMND.matches("\\d{12}"))
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Căn cước công dân không hợp lệ, phải là 12 số.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_CCCD.requestFocus();
	        return false;
    	}
    	LocalDate ngaySinh_LocalDate=n.getNgaySinhLocalDate();
    	if(!ngaySinh_LocalDate.isBefore(LocalDate.now()))
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ.", "Warning", JOptionPane.WARNING_MESSAGE);
	        ftf_NgaySinh.requestFocus();
	        return false;
    	}
    	int tuoi=LocalDate.now().getYear()-ngaySinh_LocalDate.getYear();
    	if(tuoi<16)
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Chưa đủ tuổi để đi làm nhân viên.", "Warning", JOptionPane.WARNING_MESSAGE);
	        ftf_NgaySinh.requestFocus();
	        return false;
    	}
    	if(tuoi>70)
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Đã quá tuổi để đi làm nhân viên.", "Warning", JOptionPane.WARNING_MESSAGE);
	        ftf_NgaySinh.requestFocus();
	        return false;
    	}
    	return true;
    }
    private void themNhanVien()
    {
    	//NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String email, String caLam)
    			
    	String tenNV=txt_HoTen.getText();
    	String sdt=txt_SoDienThoai.getText();
    	String gioiTinh=(String) cbo_GioiTinh.getSelectedItem();
    	String diaChi=txt_DiaChi.getText();
    	Date ngaySinh=dcr_NgaySinh.getDate();
    	java.sql.Date sqlDateNgaySinh = new java.sql.Date(ngaySinh.getTime());
    	String chucVu=(String) cbo_ChucVu.getSelectedItem();
    	String cMND=txt_CCCD.getText();
    	String caLam=(String) cbo_CaLam.getSelectedItem();
    	String matKhau=txt_MatKhau.getText();
    	try
    	{
    		NhanVien n=new NhanVien();
    		TaiKhoan t=new TaiKhoan();
        	n.setTenNV(tenNV);
        	n.setSdt(sdt);
        	n.setGioiTinh(gioiTinh);
        	n.setDiaChi(diaChi);
        	n.setNgaySinh(sqlDateNgaySinh);
        	n.setChucVu(chucVu);
        	n.setcMND(cMND);
        	n.setCaLam(caLam);
        	t.setMatKhau(matKhau);
        	sqlNhanVien_BUS.themNhanVien(n,t);
        	xoaTrang();
    	}catch(Exception e)
		{
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}	
    }
    private void capNhatNhanVien()
    {
    	int row = tbl_DSNV.getSelectedRow();
    	if(row!=-1)
		{
    		try
    		{
    			String tenNV=txt_HoTen.getText();
        		String maNV=lbl_txt_MaNV.getText();
            	String sdt=txt_SoDienThoai.getText();
            	String gioiTinh=(String) cbo_GioiTinh.getSelectedItem();
            	String diaChi=txt_DiaChi.getText();
            	Date ngaySinh=dcr_NgaySinh.getDate();
            	java.sql.Date sqlDateNgaySinh = new java.sql.Date(ngaySinh.getTime());
            	String chucVu=(String) cbo_ChucVu.getSelectedItem();
            	String cMND=txt_CCCD.getText();
            	String caLam=(String) cbo_CaLam.getSelectedItem();
            	String matKhau=txt_MatKhau.getText();
            	NhanVien n=new NhanVien(maNV, tenNV, sdt, gioiTinh, diaChi, sqlDateNgaySinh, chucVu, cMND, caLam);
            	TaiKhoan t=new TaiKhoan(matKhau);
            	if(sqlNhanVien_BUS.capNhatNhanVien(n,t))
            		System.out.println("Thành công cập nhật");
            	
    			//cập nhật xong thì bỏ chọn
    			tbl_DSNV.clearSelection();
    			resetTable();
    		}catch(Exception e)
    		{
    			e.printStackTrace();
    			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
    	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
    	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    		}
		}
		else
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn dữ liệu để cập nhật.", "Thông báo.", JOptionPane.INFORMATION_MESSAGE);
		}
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		/*
		 * int row=tbl_DSNCC.getSelectedRow();
		lbl_txt_MaNCC.setText(tbl_DSNCC.getValueAt(row, 0).toString());
		txt_HoTen.setText(tbl_DSNCC.getValueAt(row, 1).toString());
		txt_SoDienThoai.setText(tbl_DSNCC.getValueAt(row, 2).toString());
		txt_Email.setText(tbl_DSNCC.getValueAt(row, 3).toString());
		txt_DiaChi.setText(tbl_DSNCC.getValueAt(row, 4).toString());
		{"Mã nhân viên","Tên nhân viên","Số điện thoại","Giới tính","Địa chỉ","Ngày sinh","Chức vụ","Căn cước công dân","Ca làm"}
		 */
		int row=tbl_DSNV.getSelectedRow();
		lbl_txt_MaNV.setText(tbl_DSNV.getValueAt(row, 0).toString());
		txt_HoTen.setText(tbl_DSNV.getValueAt(row, 1).toString());
		txt_SoDienThoai.setText(tbl_DSNV.getValueAt(row, 2).toString());
		cbo_GioiTinh.setSelectedItem(tbl_DSNV.getValueAt(row, 3).toString());
		txt_DiaChi.setText(tbl_DSNV.getValueAt(row, 4).toString());
		ftf_NgaySinh.setText(tbl_DSNV.getValueAt(row, 5).toString());
		cbo_ChucVu.setSelectedItem(tbl_DSNV.getValueAt(row, 6).toString());
		txt_CCCD.setText(tbl_DSNV.getValueAt(row, 7).toString());
		cbo_CaLam.setSelectedItem(tbl_DSNV.getValueAt(row, 8).toString());
		txt_MatKhau.setText(sqlNhanVien_BUS.getMatKhau(tbl_DSNV.getValueAt(row, 0).toString()));
		dcr_NgaySinh.setDate(sqlNhanVien_BUS.getNgaySinh(tbl_DSNV.getValueAt(row, 0).toString()));
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
		Date ngaySinh=dcr_NgaySinh.getDate();
		if(o.equals(btn_Them))
		{
			if(ngaySinh!=null)
	    	{
				if(kiemTraRangBuoc())
				{
					themNhanVien();
				}
	    	}
			else
			{
				UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
				UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
				JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ hoặc rỗng.", "Warning", JOptionPane.WARNING_MESSAGE);
				ftf_NgaySinh.requestFocus();
			}	
				
		}
		if(o.equals(btn_CapNhat))
		{
			if(ngaySinh!=null)
	    	{
				if(kiemTraRangBuoc())
				{
					capNhatNhanVien();
				}
	    	}
			else
			{
				UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
				UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
				JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ hoặc rỗng.", "Warning", JOptionPane.WARNING_MESSAGE);
				ftf_NgaySinh.requestFocus();
			}	
		}
	}
}
