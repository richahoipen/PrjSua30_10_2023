package gui_Panel_Setting;

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
import java.awt.Container;

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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class Frame_DoiMatKhau extends JFrame implements ActionListener, WindowListener
{

	private JPanel contentPane;
	private JPasswordField txt_MKMoi2, txt_MKCu, txt_MKMoi1;
	private Custom_Button btn_ChapNhan;
	private TaiKhoan_BUS sqlTaiKhoan_BUS = new TaiKhoan_BUS();
	private JRadioButton rdb_HienMatKhau;
	private JLabel lbl_Title_DoiMatKhau;
	private JLabel lbl_MKCu;
	private Container lbl_MKMoi1;
	private Container lbl_MKMoi2;
	private NhanVien_BUS sqlNhanVien_BUS = new NhanVien_BUS();
	private String maNV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String maNV = "NV1";
					Frame_DoiMatKhau frame = new Frame_DoiMatKhau(maNV);
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
	public Frame_DoiMatKhau(String maNV) {
		// set
		setMaNV(maNV);
		setTitle("Rising Star - Đổi mật khẩu");
		setIconImage(new CustomIcon("src/main/images/view_image/Logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		setSize(450, 227);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		lbl_Title_DoiMatKhau = new JLabel("ĐỔI MẬT KHẨU");
		lbl_Title_DoiMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Title_DoiMatKhau.setForeground(Color.BLUE);
		lbl_Title_DoiMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 26));

		lbl_MKCu = new JLabel("Mật khẩu cũ:");
		lbl_MKCu.setFont(new Font("Serif", Font.PLAIN, 18));

		lbl_MKMoi1 = new JLabel("Mật khẩu mới");
		lbl_MKMoi1.setFont(new Font("Serif", Font.PLAIN, 18));

		lbl_MKMoi2 = new JLabel("Nhập lại mật khẩu");
		lbl_MKMoi2.setFont(new Font("Serif", Font.PLAIN, 18));

		txt_MKMoi1 = new JPasswordField();
		txt_MKMoi1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txt_MKMoi1.setEchoChar('*');
		txt_MKMoi1.setColumns(10);

		txt_MKMoi2 = new JPasswordField();
		txt_MKMoi2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txt_MKMoi2.setEchoChar('*');

		btn_ChapNhan = new Custom_Button();
		btn_ChapNhan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_ChapNhan.setText("Chấp nhận");
		contentPane.setLayout(new MigLayout("", "[114px][289px,grow]", "[28px][33px][33px][33px][29px]"));

		txt_MKCu = new JPasswordField();
		txt_MKCu.setEchoChar('*');
		txt_MKCu.setColumns(10);
		txt_MKCu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(txt_MKCu, "cell 1 1,grow");
		contentPane.add(lbl_MKMoi2, "cell 0 3,alignx left,growy");
		contentPane.add(txt_MKMoi2, "cell 1 3,grow");
		contentPane.add(lbl_MKCu, "cell 0 1,alignx left,growy");
		contentPane.add(lbl_MKMoi1, "cell 0 2,alignx left,growy");
		contentPane.add(txt_MKMoi1, "cell 1 2,grow");
		contentPane.add(lbl_Title_DoiMatKhau, "cell 0 0 2 1,grow");

		rdb_HienMatKhau = new JRadioButton("Hiện mật khẩu");
		rdb_HienMatKhau.addActionListener(this);
		contentPane.add(rdb_HienMatKhau, "cell 0 4");
		contentPane.add(btn_ChapNhan, "cell 1 4,alignx center,growy");
		addAction();
	}

	private void addAction() {
		btn_ChapNhan.addActionListener(this);
		addWindowListener(this);
	}

	public void load_Frame_Chinh(String maNV) {
		Frame_Chinh frame = new Frame_Chinh(maNV);
		frame.setTitle("Rising Star: Quản lý mua bán sách tại hiệu sách tư nhân. ");
		frame.setIconImage(new CustomIcon("src/main/images/view_image/Logo.png").getImage());
		frame.setVisible(true);
		Frame_DoiMatKhau.this.dispose();
	}

	private boolean ktraMatKhau() {
		//Lấy mk cũ
		char[] passwordChars_Cu =txt_MKCu.getPassword();
		String matKhau_Cu= new String(passwordChars_Cu);
		//Lấy mk mới
		char[] passwordChars_1 =txt_MKMoi1.getPassword();
		String matKhau_Moi1= new String(passwordChars_1);
		//Lấy mk mới nhập lại
		char[] passwordChars_2 =txt_MKMoi2.getPassword();
		String matKhau_Moi2= new String(passwordChars_2);
		if(matKhau_Cu.trim().equals("") || matKhau_Moi1.trim().equals("") || matKhau_Moi2.trim().equals(""))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Vui lòng nhập hết mật khẩu.\nPlease fill in all text.\n", "Lỗi, Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(!matKhau_Cu.equalsIgnoreCase(sqlNhanVien_BUS.getMatKhau(maNV)))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Mật khẩu không đúng.\nWrong password.\n", "Lỗi, Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(!matKhau_Moi1.matches("\\S*"))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Mật khẩu không hợp lệ.\nInvalid password.\n", "Lỗi, Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(!matKhau_Moi2.equalsIgnoreCase(matKhau_Moi1))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Mật khẩu không khớp.\nNot same with new password.\n", "Lỗi, Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	private void doiMatKhau() {
		char[] passwordChars_1 =txt_MKMoi1.getPassword();
		String matKhau_Moi1= new String(passwordChars_1);
		sqlTaiKhoan_BUS.capNhat_MatKhau(maNV, matKhau_Moi1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (rdb_HienMatKhau.isSelected()) {
			txt_MKCu.setEchoChar((char) 0);
			txt_MKMoi1.setEchoChar((char) 0);
			txt_MKMoi2.setEchoChar((char) 0);
		} else {
			txt_MKCu.setEchoChar('*');
			txt_MKMoi1.setEchoChar('*');
			txt_MKMoi2.setEchoChar('*');
		}
		if (o.equals(btn_ChapNhan)) {
			/*
			 * if(true) // Nhật { //load_Frame_Chinh(txt_MKMoi1.getText()); }else {
			 * UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			 * UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			 * JOptionPane.showMessageDialog(null, "Mã nhân viên hoặc mật khẩu không đúng.",
			 * "Lỗi", JOptionPane.ERROR_MESSAGE);
			 * 
			 * }
			 */
			if (ktraMatKhau())
				doiMatKhau();
		}
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
