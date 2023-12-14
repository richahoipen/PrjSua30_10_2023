package gui_Frame_Running;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;


import javax.imageio.ImageIO;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import com.jidesoft.swing.AutoCompletion;
import com.jidesoft.swing.AutoCompletionComboBox;
import com.raven.event.EventMenuSelected;
import com.raven.event.EventShowPopupMenu;
import com.raven.model.ModelMenu;
import com.raven.model.SettingModel;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;

import customEntities.CustomIcon;
import customEntities.Custom_ColorPicker;
import dataBase_BUS.NhanVien_BUS;
import gui_Dialog.Message;
import gui_Panel_Setting.*;
import gui_Panel_ThongKe.Panel_ThongKeDoanhThuTheoHoaDon;
import gui_Panel_ThongKe.Panel_ThongKeDoanhThuTheoNhanVien;
import gui_Panel_ThongKe.Panel_ThongKeSanPham;
import gui_Panel_DonDat.Panel_TimKiemDonDat;
import gui_Panel_HoaDon.Panel_ThongKeThuChiLoiNhuan;
import gui_Panel_HoaDon.Panel_TimKiemHoaDon;
import gui_Panel_KhachHang.Panel_QuanLyKhachHang;
import gui_Panel_KhachHang.Panel_TimKiemKhachHang;
import gui_Panel_NhaCungCap.Panel_QuanLyNhaCungCap;
import gui_Panel_NhaCungCap.Panel_TimKiemNhaCungCap;
import gui_Panel_NhanVien.Panel_DatHang;
import gui_Panel_NhanVien.Panel_LapHoaDon;
import gui_Panel_NhanVien.Panel_QuanLyNhanVien;
import gui_Panel_NhanVien.Panel_TimKiemNhanVien;
import gui_Panel_Others.EmployeeCard;
import gui_Panel_Others.MainForm;
import gui_Panel_Others.Menu;
import gui_Panel_SanPham.Panel_QuanLySanPham;
import gui_Panel_SanPham.Panel_ThongKeSanPhamBanChay;
import gui_Panel_SanPham.Panel_TimKiemSanPham;
//sửa lại import 
import gui_Panel_TrangChu.Panel_TrangChu;
import net.miginfocom.swing.MigLayout;
import swing.MenuItem;
import swing.PanelTransparent;
import swing.PopupMenu;

public class Frame_Chinh extends JFrame implements ActionListener, WindowListener
{
	private MigLayout layout;
	private JPanel bg;
	private Menu menu;
	private EmployeeCard employeeCard;
	private MainForm main;
	private Animator animator;
	private String timeLabel, dateLabel;
	private Message m;
	private Frame_Chinh frame_Chinh = this;
	private SettingModel settingModel;
	//private NhanVien_BUS sqlNhanVien_BUS=new NhanVien_BUS();
	public SettingModel getSettingModel() {
		return settingModel;
	}
	public void setSettingModel(SettingModel settingModel) {
		this.settingModel = settingModel;
	}
	public Menu getMenu() {
		return menu;
	}
	public String getTimeLabel() {
		return timeLabel;
	}
	public void setTimeLabel(String timeLabel) {
		this.timeLabel = timeLabel;
	}
	public String getDateLabel() {
		return dateLabel;
	}
	public void setDateLabel(String dateLabel) {
		this.dateLabel = dateLabel;
	}
	public static void main(String[] args) {
		 try {
			// Khởi tạo một mảng chứa các giao diện người dùng đã được cài đặt 
			 UIManager.LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
			// Duyệt qua mảng để tìm Nimbus Look and Feel 
			 for (UIManager.LookAndFeelInfo info : installedLookAndFeels) { 
				 // Nếu tên của giao diện người dùng là Nimbus 
				 if ("Nimbus".equals(info.getName())) { 
				 // Đặt Nimbus làm giao diện người dùng cho ứng dụng 
				 UIManager.setLookAndFeel(info.getClassName()); 
				 // Thoát khỏi vòng lặp break; 
				 } 
			 }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Frame_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Frame_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Frame_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Frame_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                //SwingAcrylic.prepareSwing();
	                Frame_Chinh frame = new Frame_Chinh("NV1","Nhân viên quản lí");
	                frame.setIconImage(new CustomIcon("src/main/images/view_image/Logo.png").getImage());
	                frame.setVisible(true);
	                //SwingAcrylic.processFrame(frame);
	            }
	        });
	}
	
	private String maNV,chucVu;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public Frame_Chinh(String maNV, String chucVu) {
		setMaNV(maNV);
		setChucVu(chucVu);
		initBackground();
		initComponents(maNV);
		setting();
	}
	
	public Frame_Chinh() throws HeadlessException {
		super();
	}
	private void initComponents(String maNV) {
		//  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
		layout = new MigLayout("fill", "10[]10[100%, fill]10", "10[fill, top]10");
        bg.setLayout(layout);
        menu = new Menu(maNV);
        employeeCard = new EmployeeCard(maNV);
        main = new MainForm();
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        
		initMenu(maNV);
		initAnimator();
	}
	private void initMenu(String maNV) {
		menu = new Menu(maNV);
		bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
		menu.addEvent(new EventMenuSelected() {
			@Override
			public void menuSelected(int menuIndex, int subMenuIndex) {
				System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
				if (menuIndex == 0) {
					main.showForm(new Panel_TrangChu());
				}
				if (menuIndex == 1) {
					if (subMenuIndex == 0)
						main.showForm(new Panel_TimKiemHoaDon());
				}
				if (menuIndex == 2) {
					if (subMenuIndex == 0)
						main.showForm(new Panel_TimKiemDonDat());
				}
				if (menuIndex == 3) {
					if(subMenuIndex == 0)
						main.showForm(new Panel_QuanLyKhachHang());
					else if (subMenuIndex == 1)
						main.showForm(new Panel_TimKiemKhachHang());
				}
				if (menuIndex == 4) {
					if(subMenuIndex == 0)
						main.showForm(new Panel_LapHoaDon(maNV));
					else if(subMenuIndex == 1)
						main.showForm(new Panel_DatHang(maNV));
					else if(subMenuIndex == 2)
						main.showForm(new Panel_QuanLyNhanVien());
					else if (subMenuIndex == 3)
						main.showForm(new Panel_TimKiemNhanVien());
				}
				if (menuIndex == 5) {
					if(subMenuIndex == 0)
						main.showForm(new Panel_QuanLySanPham());
					else if (subMenuIndex == 1)
						main.showForm(new Panel_TimKiemSanPham());
				}
				if (menuIndex == 6) {
					if(subMenuIndex == 0)
						main.showForm(new Panel_QuanLyNhaCungCap());
					else if (subMenuIndex == 1)
						main.showForm(new Panel_TimKiemNhaCungCap());
				}
				if (menuIndex == 7) {
					if(subMenuIndex == 0)
						main.showForm(new Panel_ThongKeDoanhThuTheoHoaDon());
					else if (subMenuIndex == 1)
						main.showForm(new Panel_ThongKeDoanhThuTheoNhanVien());
					else if (subMenuIndex == 2)
						main.showForm(new Panel_ThongKeSanPham());
				}
				if (menuIndex == 8) {
					main.showForm(new Panel_Setting(frame_Chinh,maNV,chucVu));
				}
				if(menuIndex == 6 && chucVu.equalsIgnoreCase("Nhân viên"))
				{
					main.showForm(new Panel_Setting(frame_Chinh,maNV,chucVu));
				}
			}
		});
		menu.addEventShowPopup(new EventShowPopupMenu() {
			@Override
			public void showPopup(Component com) {
				MenuItem item = (MenuItem) com;
				PopupMenu popup = new PopupMenu(Frame_Chinh.this, item.getIndex(), item.getEventSelected(),
						item.getMenu().getSubMenu());
				int x = Frame_Chinh.this.getX() + 62;
				int y = Frame_Chinh.this.getY() + com.getY() + 95;
				popup.setLocation(x, y);
				popup.setVisible(true);
			}
		});
		
		
		
	}
	private void setting() {
		settingModel = new SettingModel();
		try {
			settingModel.readFrom();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		settingLanguage();
		settingStyle();
	}
	private void settingStyle() {
		String phongCach = settingModel.getPhongCach();
		if(phongCach.equals("Whitebright"))
		{
			bg.setBackground(new Custom_ColorPicker("F7F7F7").toColor());
			menu.setBackground(new Custom_ColorPicker("FFFFFF").toColor());
			menu.getSp().getViewport().setBackground(new Custom_ColorPicker("FFFFFF").toColor());

		}
		if(phongCach.equals("Darkmode"))
		{
			bg.setBackground(new Custom_ColorPicker("000000").toColor());
			menu.setBackground(new Custom_ColorPicker("F5F5F5").toColor());
			menu.getSp().getViewport().setBackground(new Custom_ColorPicker("F5F5F5").toColor());
			menu.setForeground(new Custom_ColorPicker("F7F7F7").toColor());
		}
	}
	
	private void settingLanguage() {
		if (chucVu.equals("Nhân viên quản lí")) {
			if(settingModel.getNgonNgu().equals("Vietnamese")) {
				setTitle("Rising Star: Phần mềm quản lý bán hàng sách tư nhân");
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Home.png",30,30), "Trang chủ"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Bill.png",30,30), "Hóa đơn",
						 "Tìm kiếm hóa đơn"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Preorder.png",30,30), "Đơn đặt",
						 "Tìm kiếm đơn đặt hàng"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Customer.png",30,30), "Khách hàng",
						"Cập nhật", "Tìm kiếm"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Employee.png",30,30), "Nhân viên",
						"Lập hóa đơn","Đặt hàng","Cập nhật", "Tìm kiếm"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Product.png",30,30), "Sản phẩm",
						"Cập nhật", "Tìm kiếm"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Supplier.png",30,30), "Nhà cung cấp",
						"Cập nhật", "Tìm kiếm"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Analytics.png",30,30), "Thống kê",
						"Thống kê doanh thu theo hóa đơn", "Thống kê doanh thu theo nhân viên","Thống kê sản phẩm"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Setting.png",30,30), "Cài đặt ứng dụng"));
			}
			if(settingModel.getNgonNgu().equals("English")) {
				setTitle("Rising Star: Bookstore Management at a Private Bookstore.");
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Home.png",30,30), "Home"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Bill.png",30,30), "Invoice",
				             "Search invoice"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Preorder.png",30,30), "Order",
				             "Search order"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Customer.png",30,30), "Customer",
				            "Update", "Search"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Employee.png",30,30), "Employee",
				            "Create invoice","Order","Update", "Search"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Product.png",30,30), "Product",
				            "Update", "Search"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Supplier.png",30,30), "Supplier",
				            "Update", "Search"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Analytics.png",30,30), "Statistics",
				            "Revenue statistics by invoice", "Revenue statistics by employee","Product statistics"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Setting.png",30,30), "Application settings"));
			}
		} else {
			if(settingModel.getNgonNgu().equals("Vietnamese")) {
				setTitle("Rising Star: Phần mềm quản lý bán hàng sách tư nhân");
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Home.png",30,30), "Trang chủ"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Bill.png",30,30), "Hóa đơn",
						 "Tìm kiếm hóa đơn"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Preorder.png",30,30), "Đơn đặt",
						 "Tìm kiếm đơn đặt hàng"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Customer.png",30,30), "Khách hàng",
						"Cập nhật", "Tìm kiếm"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Employee.png",30,30), "Nhân viên",
						"Lập hóa đơn","Đặt hàng"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Product.png",30,30), "Sản phẩm", "Tìm kiếm"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Setting.png",30,30), "Cài đặt ứng dụng"));
			}
			if(settingModel.getNgonNgu().equals("English")) {
				setTitle("Rising Star: Bookstore Management at a Private Bookstore.");
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Home.png",30,30), "Home"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Bill.png",30,30), "Invoice",
				             "Search invoice"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Preorder.png",30,30), "Order",
				             "Search order"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Customer.png",30,30), "Customer",
				            "Update", "Search"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Employee.png",30,30), "Employee",
				            "Create invoice","Order","Update", "Search"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Product.png",30,30), "Product",
				            "Update", "Search"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Supplier.png",30,30), "Supplier",
				            "Update", "Search"));
				menu.addMenu(new ModelMenu(new CustomIcon("src/main/images/view_image/Setting.png",30,30), "Application settings"));
			}
		}
	}
	private void initAnimator() {
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        menu.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });
        bg.add(main, "w 100%, h 100%");
        main.showForm(new Panel_TrangChu());
	}
	private void initBackground() {

        bg = new JPanel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(false);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        addAction();
        pack();
        setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents
	
	private void addAction()
	{
		addWindowListener(this);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	//NHỚ XỬ LÝ
	@Override
	public void windowClosing(WindowEvent e) {
		
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
        
		int response = JOptionPane.showConfirmDialog(null, "Bạn có lưu trước khi muốn thoát chương trình không ?", "Thông báo !!!!", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
        	UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Đã lưu", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
		
		//System.exit(0);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
