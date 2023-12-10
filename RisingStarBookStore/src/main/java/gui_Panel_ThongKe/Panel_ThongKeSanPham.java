package gui_Panel_ThongKe;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import customEntities.CustomTable;
import customEntities.Custom_Button;
import customEntities.Custom_ColorPicker;
import customEntities.Custom_ComboBox;
import customEntities.Custom_Function;
import customEntities.XuatFile;
import gui_Panel.barchart.BarChart;
import gui_Panel.barchart.ModelChart;
import gui_Panel.lineChart.LineChart;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.raven.model.SettingModel;
import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Panel_ThongKeSanPham extends JPanel implements ActionListener{
	private JPanel panel = new JPanel();
    private JPanel pn_TieuDe = new JPanel();
    private JLabel lbl_Title_BaoCaoDoanhThu = new JLabel();
    private JPanel pn_Control = new JPanel();
    private JLabel lbl_LoaiThoiGian = new JLabel("Loại thời gian");
    private Custom_ComboBox cbo_LoaiThoiGian = new Custom_ComboBox();
    private JLabel lbl_ThoiGianBatDau = new JLabel("Thời gian bắt đầu");
    private JLabel lbl_ThoiGianKetThuc = new JLabel("Thời gian kết thúc");
    private JPanel pn_Control_Main = new JPanel();
    private Custom_Button btn_TimKiem = new Custom_Button();
    private Custom_Button btn_XuatExcel = new Custom_Button();
    private Custom_Button btn_XuatPDF = new Custom_Button();
    private JPanel pn_Control_Show = new JPanel();
    private Custom_Button btn_BieuDo = new Custom_Button();
    private Custom_Button btn_HienThi = new Custom_Button();
    private JPanel pn_Info = new JPanel();
    private JLabel lbl_DoanhThu = new JLabel("Doanh Thu");
    private JTextField txt_read_DoanhThu = new JTextField();
    private JLabel lbl_Chi = new JLabel("Chi");
    private JTextField txt_read_Chi = new JTextField();
    private JLabel lbl_LoiNhuan = new JLabel("Lợi nhuận");
    private JTextField txt_read_LoiNhuan = new JTextField();
    private JPanel pn_Show = new JPanel();
    private LineChart lineChart = new LineChart();
    private BarChart barChart = new BarChart();
    private DefaultTableModel dtm_ChiTiet;
    private CustomTable tbl_ChiTiet;
    private JScrollPane scr_ChiTiet;
    private SettingModel settingModel;
    private JLabel lbl_Control_Main = new JLabel("Thao tác:");
    private JLabel lbl_Control_Show = new JLabel("Nội dung");
	private JDateChooser dcr_NgayBatDau;
	private JFormattedTextField ftf_NgayBatDau;
	private BufferedImage bfi_ChonNgay;
	private JDateChooser dcr_NgayKetThuc;
	private JFormattedTextField ftf_NgayKetThuc;
	private final JTextField txt_Read_TonKho = new JTextField();
	private final JTextField txt_Read_BanDuoc = new JTextField();
	private final JLabel lbl_Read_TonKho = new JLabel("Lượng sản phẩm tồn kho");
	private final JLabel lbl_Read_BanDuoc = new JLabel("Lượng sản phảm bán được");
	private final Custom_ComboBox cbo_Loc = new Custom_ComboBox();
	private final JLabel lbl_Loc = new JLabel("Lọc theo");
	private final JLabel lbl_ShowName = new JLabel("");
	private final JTextField txt_Read_SLLoaiSP = new JTextField();
	private final JLabel lbl_Read_SLLoaiSP = new JLabel("Lượng loại sản phẩm được bán");
	private final JLabel lbl_Read_SLLoaiSPTong = new JLabel("Lượng các loại sản phẩm tổng");
	private final JTextField txt_Read_SLLoaiSPTong = new JTextField();
	private final JLabel lbl_Read_Loc = new JLabel("Lọc theo");
	private final JTextField txt_Read_Loc = new JTextField();
	
    /**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * @return the btn_XuatPDF
	 */
	public Custom_Button getBtn_XuatPDF() {
		return btn_XuatPDF;
	}

	/**
	 * @return the cbo_Loc
	 */
	public Custom_ComboBox getCbo_Loc() {
		return cbo_Loc;
	}

	/**
	 * @return the lbl_Loc
	 */
	public JLabel getLbl_Loc() {
		return lbl_Loc;
	}

	/**
	 * @return the lbl_ShowName
	 */
	public JLabel getLbl_ShowName() {
		return lbl_ShowName;
	}

	/**
	 * @return the lbl_Read_Loc
	 */
	public JLabel getLbl_Read_Loc() {
		return lbl_Read_Loc;
	}

	/**
	 * @return the txt_Read_Loc
	 */
	public JTextField getTxt_Read_Loc() {
		return txt_Read_Loc;
	}

	/**
	 * @return the txt_Read_NVLoc
	 */
	public JTextField getTxt_Read_NVLoc() {
		return txt_Read_SLLoaiSP;
	}

	/**
	 * @return the lbl_Read_NVLoc
	 */
	public JLabel getLbl_Read_NVLoc() {
		return lbl_Read_SLLoaiSP;
	}

	/**
	 * @return the lbl_Read_NVTong
	 */
	public JLabel getLbl_Read_NVTong() {
		return lbl_Read_SLLoaiSPTong;
	}

	/**
	 * @return the txt_Read_NVTong
	 */
	public JTextField getTxt_Read_NVTong() {
		return txt_Read_SLLoaiSPTong;
	}

	/**
	 * @param btn_XuatPDF the btn_XuatPDF to set
	 */
	public void setBtn_XuatPDF(Custom_Button btn_XuatPDF) {
		this.btn_XuatPDF = btn_XuatPDF;
	}

	/**
	 * @return the pn_TieuDe
	 */
	public JPanel getPn_TieuDe() {
		return pn_TieuDe;
	}

	/**
	 * @return the lbl_Title_BaoCaoDoanhThu
	 */
	public JLabel getLbl_Title_BaoCaoDoanhThu() {
		return lbl_Title_BaoCaoDoanhThu;
	}

	/**
	 * @return the pn_Control
	 */
	public JPanel getPn_Control() {
		return pn_Control;
	}

	/**
	 * @return the lbl_LoaiThoiGian
	 */
	public JLabel getLbl_LoaiThoiGian() {
		return lbl_LoaiThoiGian;
	}

	/**
	 * @return the cbo_LoaiThoiGian
	 */
	public Custom_ComboBox getCbo_LoaiThoiGian() {
		return cbo_LoaiThoiGian;
	}

	/**
	 * @return the lbl_ThoiGianBatDau
	 */
	public JLabel getLbl_ThoiGianBatDau() {
		return lbl_ThoiGianBatDau;
	}

	/**
	 * @return the lbl_ThoiGianKetThuc
	 */
	public JLabel getLbl_ThoiGianKetThuc() {
		return lbl_ThoiGianKetThuc;
	}

	/**
	 * @return the pn_Control_Main
	 */
	public JPanel getPn_Control_Main() {
		return pn_Control_Main;
	}

	/**
	 * @return the btn_TimKiem
	 */
	public Custom_Button getBtn_TimKiem() {
		return btn_TimKiem;
	}

	/**
	 * @return the btn_XuatExcel
	 */
	public Custom_Button getBtn_XuatExcel() {
		return btn_XuatExcel;
	}

	/**
	 * @return the btn_XuatPDF
	 */
	public Custom_Button getbtn_XuatPDF() {
		return btn_XuatPDF;
	}

	/**
	 * @return the pn_Control_Show
	 */
	public JPanel getPn_Control_Show() {
		return pn_Control_Show;
	}

	/**
	 * @return the btn_BieuDo
	 */
	public Custom_Button getBtn_BieuDo() {
		return btn_BieuDo;
	}

	/**
	 * @return the btn_HienThi
	 */
	public Custom_Button getBtn_HienThi() {
		return btn_HienThi;
	}

	/**
	 * @return the pn_Info
	 */
	public JPanel getPn_Info() {
		return pn_Info;
	}

	/**
	 * @return the lbl_DoanhThu
	 */
	public JLabel getLbl_DoanhThu() {
		return lbl_DoanhThu;
	}

	/**
	 * @return the txt_read_DoanhThu
	 */
	public JTextField getTxt_read_DoanhThu() {
		return txt_read_DoanhThu;
	}

	/**
	 * @return the lbl_Chi
	 */
	public JLabel getLbl_Chi() {
		return lbl_Chi;
	}

	/**
	 * @return the txt_read_Chi
	 */
	public JTextField getTxt_read_Chi() {
		return txt_read_Chi;
	}

	/**
	 * @return the lbl_LoiNhuan
	 */
	public JLabel getLbl_LoiNhuan() {
		return lbl_LoiNhuan;
	}

	/**
	 * @return the txt_read_LoiNhuan
	 */
	public JTextField getTxt_read_LoiNhuan() {
		return txt_read_LoiNhuan;
	}

	/**
	 * @return the lbl_SLHoaDon
	 */

	/**
	 * @return the txt_read_SoLuongHoaDon
	 */

	/**
	 * @return the pn_Show
	 */
	public JPanel getPn_Show() {
		return pn_Show;
	}

	/**
	 * @return the lineChart
	 */
	public LineChart getLineChart() {
		return lineChart;
	}

	/**
	 * @return the barChart
	 */
	public BarChart getBarChart() {
		return barChart;
	}

	/**
	 * @return the dtm_ChiTiet
	 */
	public DefaultTableModel getDtm_ChiTiet() {
		return dtm_ChiTiet;
	}

	/**
	 * @return the tbl_ChiTiet
	 */
	public CustomTable getTbl_ChiTiet() {
		return tbl_ChiTiet;
	}

	/**
	 * @return the scr_ChiTiet
	 */
	public JScrollPane getScr_ChiTiet() {
		return scr_ChiTiet;
	}

	/**
	 * @return the settingModel
	 */
	public SettingModel getSettingModel() {
		return settingModel;
	}

	/**
	 * @return the lbl_Control_Main
	 */
	public JLabel getLbl_Control_Main() {
		return lbl_Control_Main;
	}

	/**
	 * @return the lbl_Control_Show
	 */
	public JLabel getLbl_Control_Show() {
		return lbl_Control_Show;
	}

	/**
	 * @return the dcr_NgayBatDau
	 */
	public JDateChooser getDcr_NgayBatDau() {
		return dcr_NgayBatDau;
	}

	/**
	 * @return the ftf_NgayBatDau
	 */
	public JFormattedTextField getFtf_NgayBatDau() {
		return ftf_NgayBatDau;
	}

	/**
	 * @return the bfi_ChonNgay
	 */
	public BufferedImage getBfi_ChonNgay() {
		return bfi_ChonNgay;
	}

	/**
	 * @return the dcr_NgayKetThuc
	 */
	public JDateChooser getDcr_NgayKetThuc() {
		return dcr_NgayKetThuc;
	}

	/**
	 * @return the ftf_NgayKetThuc
	 */
	public JFormattedTextField getFtf_NgayKetThuc() {
		return ftf_NgayKetThuc;
	}

	/**
	 * @return the txt_read_SoLuongKhach
	 */
	public JTextField getTxt_read_SoLuongKhach() {
		return txt_Read_TonKho;
	}

	/**
	 * @return the txt_read_SoLuongSanPhamBanDuoc
	 */
	public JTextField getTxt_read_SoLuongSanPhamBanDuoc() {
		return txt_Read_BanDuoc;
	}

	/**
	 * @return the lbl_SLKhach
	 */
	public JLabel getLbl_SLKhach() {
		return lbl_Read_TonKho;
	}

	/**
	 * @return the lbl_SLSPB
	 */
	public JLabel getLbl_SLSPB() {
		return lbl_Read_BanDuoc;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * @param pn_TieuDe the pn_TieuDe to set
	 */
	public void setPn_TieuDe(JPanel pn_TieuDe) {
		this.pn_TieuDe = pn_TieuDe;
	}

	/**
	 * @param lbl_Title_BaoCaoDoanhThu the lbl_Title_BaoCaoDoanhThu to set
	 */
	public void setLbl_Title_BaoCaoDoanhThu(JLabel lbl_Title_BaoCaoDoanhThu) {
		this.lbl_Title_BaoCaoDoanhThu = lbl_Title_BaoCaoDoanhThu;
	}

	/**
	 * @param pn_Control the pn_Control to set
	 */
	public void setPn_Control(JPanel pn_Control) {
		this.pn_Control = pn_Control;
	}

	/**
	 * @param lbl_LoaiThoiGian the lbl_LoaiThoiGian to set
	 */
	public void setLbl_LoaiThoiGian(JLabel lbl_LoaiThoiGian) {
		this.lbl_LoaiThoiGian = lbl_LoaiThoiGian;
	}

	/**
	 * @return the txt_Read_TonKho
	 */
	public JTextField getTxt_Read_TonKho() {
		return txt_Read_TonKho;
	}

	/**
	 * @return the txt_Read_BanDuoc
	 */
	public JTextField getTxt_Read_BanDuoc() {
		return txt_Read_BanDuoc;
	}

	/**
	 * @return the lbl_Read_TonKho
	 */
	public JLabel getLbl_Read_TonKho() {
		return lbl_Read_TonKho;
	}

	/**
	 * @return the lbl_Read_BanDuoc
	 */
	public JLabel getLbl_Read_BanDuoc() {
		return lbl_Read_BanDuoc;
	}

	/**
	 * @return the txt_Read_SLLoaiSP
	 */
	public JTextField getTxt_Read_SLLoaiSP() {
		return txt_Read_SLLoaiSP;
	}

	/**
	 * @return the lbl_Read_SLLoaiSP
	 */
	public JLabel getLbl_Read_SLLoaiSP() {
		return lbl_Read_SLLoaiSP;
	}

	/**
	 * @return the lbl_Read_SLLoaiSPTong
	 */
	public JLabel getLbl_Read_SLLoaiSPTong() {
		return lbl_Read_SLLoaiSPTong;
	}

	/**
	 * @return the txt_Read_SLLoaiSPTong
	 */
	public JTextField getTxt_Read_SLLoaiSPTong() {
		return txt_Read_SLLoaiSPTong;
	}

	/**
	 * @param cbo_LoaiThoiGian the cbo_LoaiThoiGian to set
	 */
	public void setCbo_LoaiThoiGian(Custom_ComboBox cbo_LoaiThoiGian) {
		this.cbo_LoaiThoiGian = cbo_LoaiThoiGian;
	}

	/**
	 * @param lbl_ThoiGianBatDau the lbl_ThoiGianBatDau to set
	 */
	public void setLbl_ThoiGianBatDau(JLabel lbl_ThoiGianBatDau) {
		this.lbl_ThoiGianBatDau = lbl_ThoiGianBatDau;
	}

	/**
	 * @param lbl_ThoiGianKetThuc the lbl_ThoiGianKetThuc to set
	 */
	public void setLbl_ThoiGianKetThuc(JLabel lbl_ThoiGianKetThuc) {
		this.lbl_ThoiGianKetThuc = lbl_ThoiGianKetThuc;
	}

	/**
	 * @param pn_Control_Main the pn_Control_Main to set
	 */
	public void setPn_Control_Main(JPanel pn_Control_Main) {
		this.pn_Control_Main = pn_Control_Main;
	}

	/**
	 * @param btn_TimKiem the btn_TimKiem to set
	 */
	public void setBtn_TimKiem(Custom_Button btn_TimKiem) {
		this.btn_TimKiem = btn_TimKiem;
	}

	/**
	 * @param btn_XuatExcel the btn_XuatExcel to set
	 */
	public void setBtn_XuatExcel(Custom_Button btn_XuatExcel) {
		this.btn_XuatExcel = btn_XuatExcel;
	}

	/**
	 * @param btn_XuatPDF the btn_XuatPDF to set
	 */
	public void setbtn_XuatPDF(Custom_Button btn_XuatPDF) {
		this.btn_XuatPDF = btn_XuatPDF;
	}

	/**
	 * @param pn_Control_Show the pn_Control_Show to set
	 */
	public void setPn_Control_Show(JPanel pn_Control_Show) {
		this.pn_Control_Show = pn_Control_Show;
	}

	/**
	 * @param btn_BieuDo the btn_BieuDo to set
	 */
	public void setBtn_BieuDo(Custom_Button btn_BieuDo) {
		this.btn_BieuDo = btn_BieuDo;
	}

	/**
	 * @param btn_HienThi the btn_HienThi to set
	 */
	public void setBtn_HienThi(Custom_Button btn_HienThi) {
		this.btn_HienThi = btn_HienThi;
	}

	/**
	 * @param pn_Info the pn_Info to set
	 */
	public void setPn_Info(JPanel pn_Info) {
		this.pn_Info = pn_Info;
	}

	/**
	 * @param lbl_DoanhThu the lbl_DoanhThu to set
	 */
	public void setLbl_DoanhThu(JLabel lbl_DoanhThu) {
		this.lbl_DoanhThu = lbl_DoanhThu;
	}

	/**
	 * @param txt_read_DoanhThu the txt_read_DoanhThu to set
	 */
	public void setTxt_read_DoanhThu(JTextField txt_read_DoanhThu) {
		this.txt_read_DoanhThu = txt_read_DoanhThu;
	}

	/**
	 * @param lbl_Chi the lbl_Chi to set
	 */
	public void setLbl_Chi(JLabel lbl_Chi) {
		this.lbl_Chi = lbl_Chi;
	}

	/**
	 * @param txt_read_Chi the txt_read_Chi to set
	 */
	public void setTxt_read_Chi(JTextField txt_read_Chi) {
		this.txt_read_Chi = txt_read_Chi;
	}

	/**
	 * @param lbl_LoiNhuan the lbl_LoiNhuan to set
	 */
	public void setLbl_LoiNhuan(JLabel lbl_LoiNhuan) {
		this.lbl_LoiNhuan = lbl_LoiNhuan;
	}

	/**
	 * @param txt_read_LoiNhuan the txt_read_LoiNhuan to set
	 */
	public void setTxt_read_LoiNhuan(JTextField txt_read_LoiNhuan) {
		this.txt_read_LoiNhuan = txt_read_LoiNhuan;
	}

	/**
	 * @param lbl_SLHoaDon the lbl_SLHoaDon to set
	 */

	/**
	 * @param txt_read_SoLuongHoaDon the txt_read_SoLuongHoaDon to set
	 */

	/**
	 * @param pn_Show the pn_Show to set
	 */
	public void setPn_Show(JPanel pn_Show) {
		this.pn_Show = pn_Show;
	}

	/**
	 * @param lineChart the lineChart to set
	 */
	public void setLineChart(LineChart lineChart) {
		this.lineChart = lineChart;
	}

	/**
	 * @param barChart the barChart to set
	 */
	public void setBarChart(BarChart barChart) {
		this.barChart = barChart;
	}

	/**
	 * @param dtm_ChiTiet the dtm_ChiTiet to set
	 */
	public void setDtm_ChiTiet(DefaultTableModel dtm_ChiTiet) {
		this.dtm_ChiTiet = dtm_ChiTiet;
	}

	/**
	 * @param tbl_ChiTiet the tbl_ChiTiet to set
	 */
	public void setTbl_ChiTiet(CustomTable tbl_ChiTiet) {
		this.tbl_ChiTiet = tbl_ChiTiet;
	}

	/**
	 * @param scr_ChiTiet the scr_ChiTiet to set
	 */
	public void setScr_ChiTiet(JScrollPane scr_ChiTiet) {
		this.scr_ChiTiet = scr_ChiTiet;
	}

	/**
	 * @param settingModel the settingModel to set
	 */
	public void setSettingModel(SettingModel settingModel) {
		this.settingModel = settingModel;
	}

	/**
	 * @param lbl_Control_Main the lbl_Control_Main to set
	 */
	public void setLbl_Control_Main(JLabel lbl_Control_Main) {
		this.lbl_Control_Main = lbl_Control_Main;
	}

	/**
	 * @param lbl_Control_Show the lbl_Control_Show to set
	 */
	public void setLbl_Control_Show(JLabel lbl_Control_Show) {
		this.lbl_Control_Show = lbl_Control_Show;
	}

	/**
	 * @param dcr_NgayBatDau the dcr_NgayBatDau to set
	 */
	public void setDcr_NgayBatDau(JDateChooser dcr_NgayBatDau) {
		this.dcr_NgayBatDau = dcr_NgayBatDau;
	}

	/**
	 * @param ftf_NgayBatDau the ftf_NgayBatDau to set
	 */
	public void setFtf_NgayBatDau(JFormattedTextField ftf_NgayBatDau) {
		this.ftf_NgayBatDau = ftf_NgayBatDau;
	}

	/**
	 * @param bfi_ChonNgay the bfi_ChonNgay to set
	 */
	public void setBfi_ChonNgay(BufferedImage bfi_ChonNgay) {
		this.bfi_ChonNgay = bfi_ChonNgay;
	}

	/**
	 * @param dcr_NgayKetThuc the dcr_NgayKetThuc to set
	 */
	public void setDcr_NgayKetThuc(JDateChooser dcr_NgayKetThuc) {
		this.dcr_NgayKetThuc = dcr_NgayKetThuc;
	}

	/**
	 * @param ftf_NgayKetThuc the ftf_NgayKetThuc to set
	 */
	public void setFtf_NgayKetThuc(JFormattedTextField ftf_NgayKetThuc) {
		this.ftf_NgayKetThuc = ftf_NgayKetThuc;
	}

	/**
	 * Create the panel.
	 */
	public Panel_ThongKeSanPham() {
		lbl_Title_BaoCaoDoanhThu.setFont(new Font("Times New Roman", Font.BOLD, 30));
        setLayout(new BorderLayout(0, 0));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
        pn_TieuDe.setBackground(new Color(240, 240, 240));
        panel.add(pn_TieuDe, BorderLayout.NORTH);
        pn_TieuDe.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pn_TieuDe.add(lbl_Title_BaoCaoDoanhThu);
        panel.add(pn_Control, BorderLayout.CENTER);
		try {
			bfi_ChonNgay = ImageIO.read(new File("src\\main\\images\\view_image\\Calendar.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bfi_ChonNgay = Custom_Function.resize(bfi_ChonNgay, 20, 20);
		
		pn_Control.setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[][][grow][][grow]"));
		pn_Control.add(lbl_LoaiThoiGian, "cell 0 0,alignx left");
		pn_Control.add(cbo_LoaiThoiGian, "cell 1 0,growx, width 50%");
		lbl_Loc.setHorizontalAlignment(SwingConstants.LEFT);
		
		pn_Control.add(lbl_Loc, "cell 2 0,alignx left");
		
		pn_Control.add(cbo_Loc, "cell 3 0,growx");
		pn_Control.add(lbl_ThoiGianBatDau, "cell 0 1,alignx left");
		dcr_NgayBatDau = new JDateChooser ();
		
		dcr_NgayBatDau.setIcon (new ImageIcon(bfi_ChonNgay));
		ftf_NgayBatDau = (JFormattedTextField) dcr_NgayBatDau.getComponent(1);
		ftf_NgayBatDau.setHorizontalAlignment(SwingConstants.RIGHT);
		dcr_NgayBatDau.getJCalendar().setPreferredSize (new Dimension ((int) 400,(int) 200));
		dcr_NgayBatDau.setDateFormatString("dd-MM-yyyy");
		pn_Control.add(dcr_NgayBatDau, "cell 1 1,growx,width 50%");
		pn_Control.add(lbl_ThoiGianKetThuc, "cell 2 1,alignx left");
		dcr_NgayKetThuc = new JDateChooser ();
		
		dcr_NgayKetThuc.setIcon (new ImageIcon(bfi_ChonNgay));
		ftf_NgayKetThuc = (JFormattedTextField) dcr_NgayKetThuc.getComponent(1);
		ftf_NgayKetThuc.setHorizontalAlignment(SwingConstants.RIGHT);
		dcr_NgayKetThuc.getJCalendar().setPreferredSize (new Dimension ((int) 400,(int) 200));
		dcr_NgayKetThuc.setDateFormatString("dd-MM-yyyy");
		
		pn_Control.add(dcr_NgayKetThuc, "cell 3 1,growx,width 50%");
		pn_Control.add(pn_Control_Main, "flowx,cell 0 2 2 1,growx");

        
        pn_Control_Main.add(lbl_Control_Main);
        btn_TimKiem.setText("Tìm kiếm");
        pn_Control_Main.add(btn_TimKiem);
        btn_XuatExcel.setText("Xuất Excel");
        pn_Control_Main.add(btn_XuatExcel);
        btn_XuatPDF.setText("In báo cáo");
        pn_Control_Main.add(btn_XuatPDF);
        lbl_ShowName.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        pn_Control.add(lbl_ShowName, "cell 0 3 6 1,alignx center");
        pn_Control.add(pn_Control_Show, "cell 2 2 2 1,growx");
        
        pn_Control_Show.add(lbl_Control_Show);
        btn_BieuDo.setText("Biểu đồ");
        pn_Control_Show.add(btn_BieuDo);
        btn_HienThi.setText("Hiển thị chi tiết");
        pn_Control_Show.add(btn_HienThi);
        add(pn_Info, BorderLayout.SOUTH);
        pn_Info.setLayout(new MigLayout("", "[][grow][52px][grow][][grow][][grow]", "[][][14px]"));
        
        pn_Info.add(lbl_Read_SLLoaiSP, "cell 0 0 2 1,alignx trailing");
        txt_Read_SLLoaiSP.setText("0");
        txt_Read_SLLoaiSP.setColumns(10);
        
        pn_Info.add(txt_Read_SLLoaiSP, "cell 2 0 2 1,growx");
        
        pn_Info.add(lbl_Read_SLLoaiSPTong, "cell 4 0 2 1,alignx trailing");
        txt_Read_SLLoaiSPTong.setText("0");
        txt_Read_SLLoaiSPTong.setColumns(10);
        
        pn_Info.add(txt_Read_SLLoaiSPTong, "cell 6 0 2 1,growx");
        
        pn_Info.add(lbl_Read_TonKho, "cell 0 1 2 1,alignx trailing");
        txt_Read_TonKho.setText("0");
        txt_Read_TonKho.setColumns(10);
        
        pn_Info.add(txt_Read_TonKho, "flowx,cell 2 1 2 1,growx");
        
        pn_Info.add(lbl_Read_BanDuoc, "cell 4 1 2 1,alignx trailing");
        txt_Read_BanDuoc.setText("0");
        txt_Read_BanDuoc.setColumns(10);
        
        pn_Info.add(txt_Read_BanDuoc, "cell 6 1 2 1,growx");
        
        pn_Info.add(lbl_Read_Loc, "cell 0 2,alignx trailing");
        txt_Read_Loc.setText("");
        txt_Read_Loc.setColumns(10);
        
        pn_Info.add(txt_Read_Loc, "cell 1 2,growx");
        pn_Info.add(lbl_DoanhThu, "cell 2 2,alignx trailing");
        txt_read_DoanhThu.setColumns(10);
        pn_Info.add(txt_read_DoanhThu, "cell 3 2,growx");
        pn_Info.add(lbl_Chi, "cell 4 2,alignx trailing");
        txt_read_Chi.setColumns(10);
        pn_Info.add(txt_read_Chi, "cell 5 2,growx");
        pn_Info.add(lbl_LoiNhuan, "cell 6 2,alignx trailing");
        txt_read_LoiNhuan.setColumns(10);
        pn_Info.add(txt_read_LoiNhuan, "cell 7 2,growx");
        
        add(pn_Show, BorderLayout.CENTER);
        dtm_ChiTiet = new DefaultTableModel(new String[]{"Mã sản phẩm","Tên sản phẩm","Lượng hóa đơn","Lượng khách","Lượng sản phẩm bán được","Thu","Chi","Lợi nhuận"},0);
        setEditableToFalseTextfield();
        addAction();
        loadInfoText();
        setting();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Panel_ThongKeSanPham panel_ThongKeDoanhThu = new Panel_ThongKeSanPham();
		frame.getContentPane().add(panel_ThongKeDoanhThu);
        // Thiết lập các thuộc tính cho JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 700);
        frame.setVisible(true);
    }
	private void addAction() {
		btn_BieuDo.addActionListener(this);
		btn_HienThi.addActionListener(this);
		btn_XuatPDF.addActionListener(this);
		btn_TimKiem.addActionListener(this);
		btn_XuatExcel.addActionListener(this);
	}
	private void setEditableToFalseTextfield() {
		for (Component component : pn_Info.getComponents()) {
	        if (component instanceof JTextField) {
	        	((JTextField)component).setEditable(false);
	        	((JTextField)component).setCaretColor(component.getBackground());
	        }
	    }
	}
	private void loadInfoText() {
		tinhBang();
	    double revenue = 0, expenditure = 0;
	    int rowCount = dtm_ChiTiet.getRowCount();
	    int inventoryQuantity = 0, ProductsSoldQuantity = 0;
	    String loc = "";
	    if (cbo_Loc.getSelectedItem()==null){
	    	String ngonNgu = settingModel.getNgonNgu(); 
	    	if(ngonNgu.equals("Vietnamese"))
	    		loc = "Tất cả sản phẩm";
	    	if(ngonNgu.equals("English"))
	    		loc = "All products";	    
	    } 
	    else loc = cbo_Loc.getSelectedItem().toString();
	    for (int i = 0; i < rowCount; i++) {
	    	
    		inventoryQuantity += Integer.parseInt(dtm_ChiTiet.getValueAt(i, 2).toString());
    		ProductsSoldQuantity += Integer.parseInt(dtm_ChiTiet.getValueAt(i, 3).toString());
    		revenue += Integer.parseInt(dtm_ChiTiet.getValueAt(i, 4).toString());
    		expenditure += Double.parseDouble(dtm_ChiTiet.getValueAt(i, 5).toString());
    	}
	    if(loc.equals("Tất cả sản phẩm")||loc.equals("All products")) {
    		txt_Read_SLLoaiSP.setText(rowCount+"");
    	} else {
    		txt_Read_SLLoaiSP.setText("1");
    	}
	    txt_read_DoanhThu.setText(revenue + "");
	    txt_read_Chi.setText(expenditure + "");
	    txt_read_LoiNhuan.setText(revenue - expenditure + "");
	    txt_Read_TonKho.setText(inventoryQuantity+""); //
	    txt_Read_BanDuoc.setText(ProductsSoldQuantity + "");
	    //Nhật lo số lượng tổng nhé, dsnvToanbo.getlength
	    txt_Read_SLLoaiSPTong.setText("");
	    txt_Read_Loc.setText(loc);
	}

	private void tinhBang() {
        tbl_ChiTiet = new CustomTable();
        tbl_ChiTiet.setModel(dtm_ChiTiet);
        dtm_ChiTiet.setRowCount(0);
        scr_ChiTiet = new JScrollPane(tbl_ChiTiet);
        setDefaultValue();
        long daycount = 1,weekcount = 1,monthcount=1,quartercount=1,yearcount =1;
		LocalDate ngayBatDau = dcr_NgayBatDau.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // Lấy ngày từ JDateChooser, chuyển đổi sang LocalDate
		LocalDate ngayKetThuc = dcr_NgayKetThuc.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // Lấy ngày từ JDateChooser, chuyển đổi sang LocalDate
		daycount = ChronoUnit.DAYS.between(ngayBatDau, ngayKetThuc)+1;
		weekcount = ChronoUnit.WEEKS.between(ngayBatDau, ngayKetThuc)+1;
		monthcount = ChronoUnit.MONTHS.between(ngayBatDau, ngayKetThuc)+1;
		quartercount =(long) ChronoUnit.MONTHS.between(ngayBatDau, ngayKetThuc)/4+1;
		yearcount = ChronoUnit.YEARS.between(ngayBatDau, ngayKetThuc)+1;
		String loaiThoiGian = (String) cbo_LoaiThoiGian.getSelectedItem();
		String loc = (cbo_Loc.getSelectedItem()!=null) ? cbo_Loc.getSelectedItem().toString() : "Tất cả sản phẩm";
		String ngonNgu = settingModel.getNgonNgu();
		Random rand = new Random();
		if(loc.equals("Tất cả sản phẩm")||loc.equals("All products")) {
			
	        for (int i = 0; i < 20; i++) {
	            String maNhanVien = "NV" + (i+1);
	            String tenNhanVien = "Product"+ (i+1);
	            int luongHoaDon = rand.nextInt(50);
	            int luongKhach = rand.nextInt(100);
	            int luongSanPhamBanDuoc = rand.nextInt(200);
	            int thu = rand.nextInt(7000);
	            int chi = rand.nextInt(5000);
	            int loiNhuan = thu - chi;
	            dtm_ChiTiet.addRow(new Object[]{maNhanVien, tenNhanVien, luongHoaDon, luongKhach, luongSanPhamBanDuoc, thu, chi, loiNhuan});
	        }
		}
		else {
			tbl_ChiTiet.removeColumn(tbl_ChiTiet.getColumnModel().getColumn(1));
			if(loaiThoiGian.equals("By day")||loaiThoiGian.equals("Theo ngày")) {
        	if(loaiThoiGian.equals("By day")) {
        		tbl_ChiTiet.getColumnModel().getColumn(0).setHeaderValue("Date");
        	}
        	if(loaiThoiGian.equals("Theo ngày")) {
        		tbl_ChiTiet.getColumnModel().getColumn(0).setHeaderValue("Ngày");
        	}
        	for (int i = 0; i < daycount; i++) {
    		String ngay = LocalDate.now().minusDays(i).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String luongHoaDon = i+"";
            String luongKhach = i+"";
            String luongSanPhamBan = i+"";
            int thu = i * 100;
            int chi = (i+1) * 100 - (100 - i);
            int loiNhuan = thu - chi;
            Object[] row = { ngay,luongHoaDon, luongKhach, luongKhach, luongSanPhamBan, thu,chi,loiNhuan};
        	dtm_ChiTiet.addRow(row);
        	}
            
        }
        if (loaiThoiGian.equals("By week") || loaiThoiGian.equals("Theo tuần")) {
        	String weekString = null,yearString = null;
            if(loaiThoiGian.equals("By week")) {
            	weekString = "Week ";
            	yearString = " year ";
                tbl_ChiTiet.getColumnModel().getColumn(0).setHeaderValue("Week");
            }
            if(loaiThoiGian.equals("Theo tuần")) {
            	weekString = "Tuần ";
            	yearString = " năm ";
                tbl_ChiTiet.getColumnModel().getColumn(0).setHeaderValue("Tuần");
            }
            for (int i = 0; i < weekcount; i++) {
                LocalDate date = ngayBatDau.plusWeeks(i);
                int weekOfYear = date.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
                int year = date.getYear();
                String week = weekString + weekOfYear + yearString + year;
                String luongHoaDon = i+"";
                String luongKhach = i+"";
                String luongSanPhamBan = i+"";
                int thu = i * 100;
                int chi = (i+1) * 100 - (100 - i);
                int loiNhuan = (thu - chi);
                Object[] row = { week, luongHoaDon, luongKhach, luongKhach, luongSanPhamBan, thu, chi, loiNhuan };
                dtm_ChiTiet.addRow(row);
            }
        }
        if (loaiThoiGian.equals("By month") || loaiThoiGian.equals("Theo tháng")) {
            String monthString = null, yearString = null;
            if(loaiThoiGian.equals("By month")) {
                monthString = "Month ";
                yearString = " year ";
                tbl_ChiTiet.getColumnModel().getColumn(0).setHeaderValue("Month");
            }
            if(loaiThoiGian.equals("Theo tháng")) {
                monthString = "Tháng ";
                yearString = " năm ";
                tbl_ChiTiet.getColumnModel().getColumn(0).setHeaderValue("Tháng");
            }
            for (int i = 0; i < monthcount; i++) {
                LocalDate date = ngayBatDau.plusMonths(i);
                int monthOfYear = date.getMonthValue();
                int year = date.getYear();
                String month = monthString + monthOfYear + yearString + year;
                String luongHoaDon = i+"";
                String luongKhach = i+"";
                String luongSanPhamBan = i+"";
                int thu = i * 100;
                int chi = (i+1) * 100 - (100 - i);
                int loiNhuan = thu - chi;
                Object[] row = { month, luongHoaDon, luongKhach, luongKhach, luongSanPhamBan, thu, chi, loiNhuan };
                dtm_ChiTiet.addRow(row);
            }
        }

        if (loaiThoiGian.equals("By quarter") || loaiThoiGian.equals("Theo quý")) {
            String quarterString = null, yearString = null;
            if(loaiThoiGian.equals("By quarter")) {
                quarterString = "Quarter ";
                yearString = " year ";
                tbl_ChiTiet.getColumnModel().getColumn(0).setHeaderValue("Quarter");
            }
            if(loaiThoiGian.equals("Theo quý")) {
                quarterString = "Quý ";
                yearString = " năm ";
                tbl_ChiTiet.getColumnModel().getColumn(0).setHeaderValue("Quý");
            }
            for (int i = 0; i < quartercount; i++) {
                LocalDate date = ngayBatDau.plusMonths(i*3);
                int quarterOfYear = (date.getMonthValue()-1)/3 + 1;
                int year = date.getYear();
                String quarter = quarterString + quarterOfYear + yearString + year;
                String luongHoaDon = i+"";
                String luongKhach = i+"";
                String luongSanPhamBan = i+"";
                int thu = i * 100;
                int chi = (i+1) * 100 - (100 - i);
                int loiNhuan = thu - chi;
                Object[] row = { quarter, luongHoaDon, luongKhach, luongKhach, luongSanPhamBan, thu, chi, loiNhuan };
                dtm_ChiTiet.addRow(row);
            }
        }

        if (loaiThoiGian.equals("By year") || loaiThoiGian.equals("Theo năm")) {
            String yearString = null;
            if(loaiThoiGian.equals("By year")) {
                yearString = "Year ";
                tbl_ChiTiet.getColumnModel().getColumn(0).setHeaderValue("Year");
            }
            if(loaiThoiGian.equals("Theo năm")) {
                yearString = "Năm ";
                tbl_ChiTiet.getColumnModel().getColumn(0).setHeaderValue("Năm");
            }
            for (int i = 0; i < yearcount; i++) {
                LocalDate date = ngayBatDau.plusYears(i);
                int year = date.getYear();
                String yearValue = yearString + year;
                String luongHoaDon = i+"";
                String luongKhach = i+"";
                String luongSanPhamBan = i+"";
                int thu = i * 100;
                int chi = (i+1) * 100 - (100 - i);
                int loiNhuan = thu - chi;
                Object[] row = { yearValue, luongHoaDon, luongKhach, luongKhach, luongSanPhamBan, thu, chi, loiNhuan };
                dtm_ChiTiet.addRow(row);
            }
        }
        }
	}
	
	private void hienChiTiet() {
		String ngonNgu = settingModel.getNgonNgu();
        if(ngonNgu.equals("English"))
        	lbl_ShowName.setText("Detailed table of revenue statistics from product");
        if(ngonNgu.equals("Vietnamese"))
        	lbl_ShowName.setText("Bảng chi tiết thống kê doanh thu từ sản phẩm");
		JPanel pn_Temp = new JPanel(new BorderLayout());
        tbl_ChiTiet = new CustomTable();
        tinhBang();
        tbl_ChiTiet.setModel(dtm_ChiTiet);
        scr_ChiTiet = new JScrollPane(tbl_ChiTiet);
        
        
        pn_Temp.add(scr_ChiTiet, BorderLayout.CENTER);
        // Xóa component cũ khỏi container
        this.remove(pn_Show);

        // Cập nhật tham chiếu và thêm component mới vào container
        pn_Show = pn_Temp;
        this.add(pn_Show, BorderLayout.CENTER);

        // Yêu cầu Swing cập nhật giao diện người dùng
        this.revalidate();
        this.repaint();
	}
	public JPanel tinhBieuDo() {
		long daycount = 1,weekcount = 1,monthcount=1,quartercount=1,yearcount =1;
		long maxcount = 2;
		setDefaultValue();
		LocalDate ngayBatDau = dcr_NgayBatDau.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // Lấy ngày từ JDateChooser, chuyển đổi sang LocalDate
		LocalDate ngayKetThuc = dcr_NgayKetThuc.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // Lấy ngày từ JDateChooser, chuyển đổi sang LocalDate
		daycount = ChronoUnit.DAYS.between(ngayBatDau, ngayKetThuc)+1;
		weekcount = (daycount + 6) / 7; // Chia số ngày cho 7 và làm tròn lên		
		monthcount = (daycount + 29) / 30; // Chia số ngày cho 30 và làm tròn lên
		quartercount = (daycount + 89) / 90; // Chia số ngày cho 90 và làm tròn lên
		yearcount = (daycount + 364) / 365; // Chia số ngày cho 365 và làm tròn lên
		// Tính số ngày giữa hai ngày
		barChart = new BarChart();
		barChart.addLegend(lbl_DoanhThu.getText(), Custom_ColorPicker.lime_BFFF00);
		barChart.addLegend(lbl_Chi.getText(), Custom_ColorPicker.lightred_FF6666);
		barChart.addLegend(lbl_LoiNhuan.getText(), Custom_ColorPicker.blue_4B70F5);
		lineChart = new LineChart();
		lineChart.addLegend(lbl_DoanhThu.getText(), Custom_ColorPicker.lime_BFFF00,Custom_ColorPicker.lime_BFFF00);
        lineChart.addLegend(lbl_Chi.getText(), Custom_ColorPicker.lightred_FF6666,Custom_ColorPicker.lightred_FF6666);
        lineChart.addLegend(lbl_LoiNhuan.getText(), Custom_ColorPicker.blue_4B70F5,Custom_ColorPicker.blue_4B70F5);
		String loaiThoiGian = (String) cbo_LoaiThoiGian.getSelectedItem();
		Random rand = new Random();
		String loc = cbo_Loc.getSelectedItem().toString();
		String ngonNgu = settingModel.getNgonNgu();
		if(loc.equals("Tất cả sản phẩm")||loc.equals("All products")) {
	        if(ngonNgu.equals("English"))
	        	lbl_ShowName.setText("Chart of revenue statistics by top 10 products");
	        if(ngonNgu.equals("Vietnamese"))
	        	lbl_ShowName.setText("Biểu đồ thống kê doanh thu theo top 10 sản phẩm");
	        //Nhật ở đây NumberOfProduct là số lượng sản phẩm thực hiện giao dịch, tui để 10 để test, ông thanh thành list.length
	        int NumberOfProduct = 2;
	        
	        int result = (10 <= NumberOfProduct) ? 10 : NumberOfProduct;
	        for (int i = 0; i < result; i++) {
	            barChart.addData(new ModelChart("SP1 - Thái Gõ", new double[]{i+200, i+200, 20*(i+1)}));
	        }
			barChart.start();
			return barChart;
		}
		else {
			if(ngonNgu.equals("English"))
	        	lbl_ShowName.setText("Statistics chart of revenue by products");
	        if(ngonNgu.equals("Vietnamese"))
	        	lbl_ShowName.setText("Biểu đồ thống kê doanh thu theo sản phẩm");
			if(loaiThoiGian.equals("By day")||loaiThoiGian.equals("Theo ngày")) {
			if(daycount<=maxcount) {
				for (int i = 0; i < daycount; i++) {
		            barChart.addData(new ModelChart(ngayBatDau.plusDays(i).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), new double[]{i+200, i+200, 20*(i+1)}));
		        }
				barChart.start();
				return barChart;
			}
			else {
		        for (int i = 0; i < daycount; i++) {
		        	int a = rand.nextInt(1001); // Gán giá trị ngẫu nhiên từ 0 đến 1000 cho biến a
		        	int b = rand.nextInt(1001); // Gán giá trị ngẫu nhiên từ 0 đến 1000 cho biến b
		            int c = a-b; // lợi nhuận = doanh thu - chi
		            lineChart.addData(new gui_Panel.lineChart.ModelChart(String.format(ngayBatDau.plusDays(i).format(DateTimeFormatter.ofPattern("dd-MM")), i+1), new double[]{a,b,c}));
		        }
		        lineChart.start();
		        return lineChart;
			}
		}
		if (loaiThoiGian.equals("By week")||loaiThoiGian.equals("Theo tuần")) {
			
		    if(weekcount<=maxcount) {
		        for (int i = 0; i < weekcount; i++) {
		        	LocalDate date = ngayBatDau.plusWeeks(i);
		        	int weekOfYear = date.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
		            int year = date.getYear();
		            barChart.addData(new ModelChart("Tuần " + weekOfYear + "/" + year, new double[]{i+200, i+200, 20*(i+1)}));
		        }
		        barChart.start();
		        return barChart;
		    }
		    else {
		        for (int i = 0; i < weekcount; i++) {
		            int a = rand.nextInt(1001); // Gán giá trị ngẫu nhiên từ 0 đến 1000 cho biến a
		            int b = rand.nextInt(1001); // Gán giá trị ngẫu nhiên từ 0 đến 1000 cho biến b
		            int c = a-b; // lợi nhuận = doanh thu - chi
		            LocalDate date = ngayBatDau.plusWeeks(i);
		            int weekOfYear = date.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
		            int year = date.getYear();
		            lineChart.addData(new gui_Panel.lineChart.ModelChart((weekOfYear) + "/" + year, new double[]{a,b,c}));
		        }
		        lineChart.start();
		        return lineChart;
		    }
		} 
		if (loaiThoiGian.equals("By month") || loaiThoiGian.equals("Theo tháng")) {
		    if (monthcount <= maxcount) {
		        for (int i = 0; i < monthcount; i++) {
		        	LocalDate date = ngayBatDau.plusMonths(i);
		            int monthOfYear = date.getMonthValue();
		            int year = date.getYear();
		            barChart.addData(new ModelChart("Tháng " + monthOfYear + "/" + year, new double[]{i+200, i+200, 20*(i+1)}));		        }
		        barChart.start();
		        return barChart;
		    } else {
		        for (int i = 0; i < monthcount; i++) {
		            int a = rand.nextInt(1001);
		            int b = rand.nextInt(1001);
		            int c = a-b; // lợi nhuận = doanh thu - chi
		            LocalDate date = ngayBatDau.plusMonths(i);
		            int monthOfYear = date.getMonthValue();
		            int year = date.getYear();
		            lineChart.addData(new gui_Panel.lineChart.ModelChart(monthOfYear + "/" + year, new double[]{a, b, c}));
		        }
		        lineChart.start();
		        return lineChart;
		    }
		}
		if (loaiThoiGian.equals("By quarter") || loaiThoiGian.equals("Theo quý")) {
		    if (quartercount <= maxcount) {
		        for (int i = 0; i < quartercount; i++) {
		            LocalDate date = ngayBatDau.plusMonths(i*3);
		            int quarterOfYear = (date.getMonthValue()-1)/3 + 1;
		            int year = date.getYear();
		            barChart.addData(new ModelChart("Quý " + quarterOfYear + "/" + year, new double[]{i+200, i+200, 20*(i+1)}));
		        }
		        barChart.start();
		        return barChart;
		    } else {
		        for (int i = 0; i < quartercount; i++) {
		            int a = rand.nextInt(1001);
		            int b = rand.nextInt(1001);
		            int c = a-b; // lợi nhuận = doanh thu - chi
		            LocalDate date = ngayBatDau.plusMonths(i*3);
		            int quarterOfYear = (date.getMonthValue()-1)/3 + 1;
		            int year = date.getYear();
		            lineChart.addData(new gui_Panel.lineChart.ModelChart(quarterOfYear + "/" + year, new double[]{a, b, c}));
		        }
		        lineChart.start();
		        return lineChart;
		    }
		} else if (loaiThoiGian.equals("By year") || loaiThoiGian.equals("Theo năm")) {
		    if (yearcount <= maxcount) {
		        for (int i = 0; i < yearcount; i++) {
		            LocalDate date = ngayBatDau.plusYears(i);
		            int year = date.getYear();
		            barChart.addData(new ModelChart("Năm " + year, new double[]{i+200, i+200, 20*(i+1)}));
		        }
		        barChart.start();
		        return barChart;
		    } else {
		        for (int i = 0; i < yearcount; i++) {
		            int a = rand.nextInt(1001);
		            int b = rand.nextInt(1001);
		            int c = a-b; // lợi nhuận = doanh thu - chi
		            LocalDate date = ngayBatDau.plusYears(i);
		            int year = date.getYear();
		            lineChart.addData(new gui_Panel.lineChart.ModelChart(year+"", new double[]{a, b, c}));
		        }
		        lineChart.start();
		        return lineChart;
		    }
		}
		}

		return null;
	}
	private void hienBieuDo() {
        
        // Xóa component cũ khỏi container
        this.remove(pn_Show);

        // Cập nhật tham chiếu và thêm component mới vào container
        pn_Show = tinhBieuDo();
        this.add(pn_Show, BorderLayout.CENTER);

        // Yêu cầu Swing cập nhật giao diện người dùng
        this.revalidate();
        this.repaint();
	}
	private void setDefaultValue() {
	    Calendar cal = Calendar.getInstance();
	    settingModel = new SettingModel();
		try {
			settingModel.readFrom();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ngonNgu = settingModel.getNgonNgu();
		if(cbo_Loc.getSelectedItem() == null) {
			if(ngonNgu.equals("Vietnamese"))
	    		cbo_Loc.setSelectedItem("Tất cả sản phẩm");
	    	if(ngonNgu.equals("English"))
	    		cbo_Loc.setSelectedItem("All products");   	
		}
	    if(cbo_LoaiThoiGian.getSelectedItem() == null) {
	    	if(ngonNgu.equals("Vietnamese"))
	    		cbo_LoaiThoiGian.setSelectedItem("Theo ngày");
	    	if(ngonNgu.equals("English"))
	    		cbo_LoaiThoiGian.setSelectedItem("By day");
	    }
	    String loaiThoiGian = (String) cbo_LoaiThoiGian.getSelectedItem();
	    switch (loaiThoiGian) {
	    	case "By day":
	    		loaiThoiGian = "Theo ngày";
	    		break;
	    	case "By week":
	    		loaiThoiGian = "Theo tuần";
	    		break;
	    	case "By month":
	    		loaiThoiGian = "Theo tháng";
	    		break;
	    	case "By quarter":
	    		loaiThoiGian = "Theo quý";
	    		break;
	    	case "By year":
	    		loaiThoiGian = "Theo năm";
	    		break;
	    }
	    if (dcr_NgayKetThuc.getDate() == null) dcr_NgayKetThuc.setDate(cal.getTime());
	    if (dcr_NgayBatDau.getDate() == null) {
	        switch (loaiThoiGian) {
	            case "Theo ngày":
	                // Ngày hôm nay
	                dcr_NgayBatDau.setDate(cal.getTime());
	                break;
	            case "Theo tuần":
	                // Đầu tuần (Thứ Hai)
	                cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	                dcr_NgayBatDau.setDate(cal.getTime());
	                break;
	            case "Theo tháng":
	                // Đầu tháng
	                cal.set(Calendar.DAY_OF_MONTH, 1);
	                dcr_NgayBatDau.setDate(cal.getTime());
	                break;
	            case "Theo quý":
	                // Đầu quý
	                int month = cal.get(Calendar.MONTH);
	                int quarter = month / 3;
	                cal.set(Calendar.MONTH, quarter * 3);
	                cal.set(Calendar.DAY_OF_MONTH, 1);
	                dcr_NgayBatDau.setDate(cal.getTime());
	                break;
	            case "Theo năm":
	                // Đầu năm
	                cal.set(Calendar.DAY_OF_YEAR, 1);
	                dcr_NgayBatDau.setDate(cal.getTime());
	                break;
	        }
	    }
	}

	private boolean kiemTraHopLe() {
		setDefaultValue();
		Date ngayHienTai = new Date();
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
        String canhBao = null, loaiCanhBao = null, ngonNgu = settingModel.getNgonNgu();
        if (dcr_NgayBatDau.getDate() == null || dcr_NgayKetThuc.getDate() == null) {
            if (ngonNgu.equals("Vietnamese")) {
                canhBao = "Ngày bắt đầu hoặc ngày kết thúc không được để trống.";
                loaiCanhBao = "Lỗi";
            } else if (ngonNgu.equals("English")) {
                canhBao = "Start date or end date should not be empty.";
                loaiCanhBao = "Error";
            }
        } else if (dcr_NgayBatDau.getDate().after(dcr_NgayKetThuc.getDate())) {
            if (ngonNgu.equals("Vietnamese")) {
                canhBao = "Ngày bắt đầu không thể sau ngày kết thúc.";
                loaiCanhBao = "Lỗi";
            } else if (ngonNgu.equals("English")) {
                canhBao = "Start date cannot be after end date.";
                loaiCanhBao = "Error";
            }
        } else if (dcr_NgayBatDau.getDate().after(ngayHienTai)) {
            if (ngonNgu.equals("Vietnamese")) {
                canhBao = "Ngày bắt đầu không thể sau ngày hiện tại.";
                loaiCanhBao = "Lỗi";
            } else if (ngonNgu.equals("English")) {
                canhBao = "Start date cannot be after current date.";
                loaiCanhBao = "Error";
            }
        } 
        if(loaiCanhBao == null) {
        	return true;
        }
        JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.ERROR_MESSAGE);
        return false;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btn_BieuDo)) {
			hienBieuDo();
			loadInfoText();
		}
		if (o.equals(btn_HienThi)) {
			hienChiTiet();
			loadInfoText();
		}
		if (o.equals(btn_TimKiem)) {
			kiemTraHopLe();
			loadInfoText();
		}
		if (o.equals(btn_XuatExcel)) {
			XuatFile.saveToExcel(dtm_ChiTiet,"Thống kê hóa đơn");
		}
		if (o.equals(btn_XuatPDF)&&kiemTraHopLe()) {
			Frame_ThongKeSanPham frameXuatPDF = new Frame_ThongKeSanPham(this);
			frameXuatPDF.setVisible(true);
		}
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
		settingButton();
		settingCombobox();
	}
	private void settingLanguage() {
	    if(settingModel.getNgonNgu().equals("Vietnamese")) {
	    	lbl_Title_BaoCaoDoanhThu.setText("Thống kê doanh thu theo sản phẩm");
	        lbl_LoaiThoiGian.setText("Loại thời gian");
	        lbl_Loc.setText("Lọc theo");
	        lbl_ThoiGianBatDau.setText("Thời gian bắt đầu");
	        lbl_ThoiGianKetThuc.setText("Thời gian kết thúc");
	        btn_TimKiem.setText("Tìm kiếm");
	        btn_XuatExcel.setText("Xuất Excel");
	        btn_XuatPDF.setText("Xuất PDF");
	        btn_BieuDo.setText("Biểu đồ");
	        btn_HienThi.setText("Hiển thị chi tiết");
	        
	        
	        lbl_Read_SLLoaiSP.setText("Lượng loại sản phẩm được bán");
	        lbl_Read_SLLoaiSPTong.setText("Lượng các loại sản phẩm tổng");
	        lbl_Read_TonKho.setText("Lượng sản phẩm tồn kho");
	        lbl_Read_BanDuoc.setText("Lượng sản phẩm bán được");
	        
	        lbl_Read_Loc.setText("Lọc theo");
	        lbl_DoanhThu.setText("Doanh thu");
	        lbl_Chi.setText("Chi");
	        lbl_LoiNhuan.setText("Lợi nhuận");
	        
	        lbl_Control_Main.setText("Thao tác: ");
	        lbl_Control_Show.setText("Nội dung: ");
	        dtm_ChiTiet =  new DefaultTableModel(new String[]{"Mã sản phẩm","Tên sản phẩm","Lượng sản phẩm tồn kho","Lượng sản phẩm bán được","Thu","Chi","Lợi nhuận"},0);
	        cbo_LoaiThoiGian.addItem("Theo ngày");
	        cbo_LoaiThoiGian.addItem("Theo tuần");
	        cbo_LoaiThoiGian.addItem("Theo tháng");
	        cbo_LoaiThoiGian.addItem("Theo quý");
	        cbo_LoaiThoiGian.addItem("Theo năm");
	        cbo_Loc.addItem("Tất cả sản phẩm");
	        lbl_ShowName.setText("Chọn nội dung hiển thị");
	    }
	    if(settingModel.getNgonNgu().equals("English")) {
	    	lbl_Title_BaoCaoDoanhThu.setText("Revenue statistics by product");
	    	lbl_LoaiThoiGian.setText("Type of time");
	    	lbl_Loc.setText("Filter by");
	    	lbl_ThoiGianBatDau.setText("Start time");
	    	lbl_ThoiGianKetThuc.setText("End time");
	    	btn_TimKiem.setText("Search");
	    	btn_XuatExcel.setText("Export Excel");
	    	btn_XuatPDF.setText("Export PDF");
	    	btn_BieuDo.setText("Chart");
	    	btn_HienThi.setText("Show details");

	    	lbl_Read_SLLoaiSP.setText("Amount of product types sold");
	    	lbl_Read_SLLoaiSPTong.setText("Total amount of product types");
	    	lbl_Read_TonKho.setText("Inventory quantity");
	    	lbl_Read_BanDuoc.setText("Amount of product sold");

	    	lbl_Read_Loc.setText("Filter by");
	    	lbl_DoanhThu.setText("Revenue");
	    	lbl_Chi.setText("Expenditure");
	    	lbl_LoiNhuan.setText("Profit");

	    	lbl_Control_Main.setText("Operation: ");
	    	lbl_Control_Show.setText("Content: ");
	    	dtm_ChiTiet =  new DefaultTableModel(new String[]{"Product Number","Product name","Inventory quantity","Amount of product sold","Revenue","Expenditure","Profit"},0);
	    	cbo_LoaiThoiGian.addItem("By day");
	    	cbo_LoaiThoiGian.addItem("By week");
	    	cbo_LoaiThoiGian.addItem("By month");
	    	cbo_LoaiThoiGian.addItem("By quarter");
	    	cbo_LoaiThoiGian.addItem("By year");
	    	cbo_Loc.addItem("All products");
	    	lbl_ShowName.setText("Select content to show");
	    }
	    
	    //Nhật xóa các dòng dưới này
	    cbo_Loc.addItem("SP1");
	    cbo_Loc.addItem("SP2");
	    cbo_Loc.addItem("SP3");
	}
	private void settingButton() {
		// TODO Auto-generated method stub
		for (Component component : pn_Control_Show.getComponents()) {
		    if (component instanceof Custom_Button) {
		        Custom_Button button = (Custom_Button) component;

		        FontMetrics fm = button.getFontMetrics(button.getFont());
		        int textWidth = fm.stringWidth(button.getText());
		        int textHeight = fm.getHeight();
		        int paddingWidth = (int)(textWidth * 0.3); // 30% of text width
		        int paddingHeight = (int)(textHeight * 0.3); // 30% of text height
		        Dimension currentPreferredSize = button.getPreferredSize();
		        Dimension newPreferredSize = new Dimension(
		            currentPreferredSize.width + 2 * paddingWidth,
		            currentPreferredSize.height + 2 * paddingHeight
		        );
		        button.setPreferredSize(newPreferredSize);
		    }
		}
		for (Component component : pn_Control_Main.getComponents()) {
		    if (component instanceof Custom_Button) {
		        Custom_Button button = (Custom_Button) component;

		        FontMetrics fm = button.getFontMetrics(button.getFont());
		        int textWidth = fm.stringWidth(button.getText());
		        int textHeight = fm.getHeight();
		        int paddingWidth = (int)(textWidth * 0.3); // 30% of text width
		        int paddingHeight = (int)(textHeight * 0.3); // 30% of text height
		        Dimension currentPreferredSize = button.getPreferredSize();
		        Dimension newPreferredSize = new Dimension(
		            currentPreferredSize.width + 2 * paddingWidth,
		            currentPreferredSize.height + 2 * paddingHeight
		        );
		        button.setPreferredSize(newPreferredSize);
		    }
		}
	}
	private void settingCombobox() {
		// TODO Auto-generated method stub
	}
}
