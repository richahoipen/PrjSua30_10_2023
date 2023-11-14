package gui_DangNhap;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

import customEntities.CustomIcon;
import customEntities.Custom_Button;
import dataBase_BUS.NhanVien_BUS;
import dataBase_BUS.TaiKhoan_BUS;
import entities.TaiKhoan;
import gui_Frame_Running.Frame_Chinh;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Frame_DangNhap extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txt_MaNV;
	private JPasswordField txt_MatKhau;
	private JComboBox cbo_ChucVu;
	private Custom_Button btn_DangNhap;
	private TaiKhoan_BUS sqlTaiKhoan_BUS=new TaiKhoan_BUS();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_DangNhap frame = new Frame_DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame_DangNhap() {
		setTitle("Rising Star - Đăng nhập");
		setIconImage(new CustomIcon("src/main/images/view_image/Logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setSize(450,300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		
		JLabel lbl_Title_DangNhapNhanh = new JLabel("ĐĂNG NHẬP NHANH");
		lbl_Title_DangNhapNhanh.setForeground(Color.BLUE);
		lbl_Title_DangNhapNhanh.setFont(new Font("Times New Roman", Font.BOLD, 26));
		
		JLabel lbl_ChucVu = new JLabel("Chọn chức vụ:");
		lbl_ChucVu.setFont(new Font("Serif", Font.PLAIN, 18));
		
		JLabel lbl_MaNguoiDung = new JLabel("Mã NV:");
		lbl_MaNguoiDung.setFont(new Font("Serif", Font.PLAIN, 18));
		
		JLabel lbl_MatKhau = new JLabel("Mật khẩu:");
		lbl_MatKhau.setFont(new Font("Serif", Font.PLAIN, 18));
		
		txt_MaNV = new JTextField();
		txt_MaNV.setColumns(10);
		
		txt_MatKhau = new JPasswordField();
		
		cbo_ChucVu = new JComboBox();
		cbo_ChucVu.setModel(new DefaultComboBoxModel(new String[] {"Nhân viên", "Nhân viên quản lý"}));
		
		btn_DangNhap = new Custom_Button();
		/*
		btn_DangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_Chinh frame_Chinh = new Frame_Chinh();
				frame_Chinh.setVisible(true);
				Frame_DangNhap.this.dispose();
			}
		});*/
		btn_DangNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_DangNhap.setText("Đăng nhập");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lbl_MatKhau, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txt_MatKhau, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lbl_ChucVu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lbl_MaNguoiDung, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(cbo_ChucVu, 0, 280, Short.MAX_VALUE)
										.addComponent(txt_MaNV, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))))
							.addContainerGap())
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addComponent(lbl_Title_DangNhapNhanh)
							.addGap(80))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(148)
					.addComponent(btn_DangNhap, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(159, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lbl_Title_DangNhapNhanh, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(cbo_ChucVu, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_ChucVu, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_MaNguoiDung, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_MaNV, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txt_MatKhau)
						.addComponent(lbl_MatKhau, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
					.addGap(34)
					.addComponent(btn_DangNhap, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		addAction();
	}
	private void addAction()
	{
		btn_DangNhap.addActionListener(this);
	}
	private boolean xuLy_DangNhap()
	{
		String maNV=txt_MaNV.getText();
		char[] passwordChars =txt_MatKhau.getPassword();
		String matKhau= new String(passwordChars);
		String chucVu=(String) cbo_ChucVu.getSelectedItem();
		ArrayList<TaiKhoan> listTaiKhoan=sqlTaiKhoan_BUS.getTaiKhoan(chucVu);
		
		for(TaiKhoan t: listTaiKhoan)
		{
			if(t.getMaCuaNV().equalsIgnoreCase(maNV) && t.getMatKhau().equalsIgnoreCase(matKhau))
				return true;
				break;
		}
		return false;
	}
	public void load_Frame_Chinh(String maNV)
	{
		Frame_Chinh frame_Chinh = new Frame_Chinh(maNV);
		frame_Chinh.setVisible(true);
		Frame_DangNhap.this.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btn_DangNhap))
		{
			if(xuLy_DangNhap())
			{
				load_Frame_Chinh(txt_MaNV.getText());
			}else
			{
				UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
				UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
				JOptionPane.showMessageDialog(null, "Mã nhân viên hoặc mật khẩu không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
				
			}
		}
	}

	

	

	
}
