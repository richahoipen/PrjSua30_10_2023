USE [RisingStar]
GO
/****** Object:  Table [dbo].[CTDonDatHang]    Script Date: 11/21/2023 12:15:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTDonDatHang](
	[donGia] [float] NULL,
	[sTT] [int] NOT NULL,
	[soLuong] [int] NULL,
	[thanhTien] [float] NULL,
	[maDDH] [varchar](20) NULL,
	[maSP] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[sTT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTHoaDon]    Script Date: 11/21/2023 12:15:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTHoaDon](
	[donGia] [float] NULL,
	[soLuong] [int] NULL,
	[thanhTien] [float] NULL,
	[maHD] [nvarchar](50) NOT NULL,
	[maSP] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHD] ASC,
	[maSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonDatHang]    Script Date: 11/21/2023 12:15:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonDatHang](
	[daLapHoaDon] [bit] NULL,
	[ngayDat] [varchar](20) NULL,
	[maDDH] [varchar](20) NOT NULL,
	[maKH] [nvarchar](50) NULL,
	[maNV] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maDDH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/21/2023 12:15:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[tienKhachDua] [float] NULL,
	[tongTien] [float] NULL,
	[ngayLap] [datetime2](6) NULL,
	[maHD] [nvarchar](50) NOT NULL,
	[maKH] [nvarchar](50) NULL,
	[maNV] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/21/2023 12:15:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[gioiTinh] [bit] NULL,
	[diaChi] [nvarchar](150) NULL,
	[maKH] [nvarchar](50) NOT NULL,
	[sdt] [nvarchar](20) NULL,
	[tenKH] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 11/21/2023 12:15:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[diaChi] [nvarchar](150) NULL,
	[email] [nvarchar](120) NULL,
	[maNCC] [nvarchar](20) NOT NULL,
	[sdtNCC] [nvarchar](20) NULL,
	[tenNCC] [nvarchar](150) NULL,
PRIMARY KEY CLUSTERED 
(
	[maNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/21/2023 12:15:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[ngaySinh] [date] NOT NULL,
	[cMND] [nvarchar](30) NULL,
	[caLam] [nvarchar](20) NULL,
	[chucVu] [nvarchar](20) NULL,
	[diaChi] [nvarchar](150) NULL,
	[gioiTinh] [nvarchar](5) NULL,
	[maNV] [nvarchar](50) NOT NULL,
	[sdt] [nvarchar](20) NULL,
	[tenNV] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 11/21/2023 12:15:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[giaBan] [float] NULL,
	[giaNhap] [float] NULL,
	[namXuatBan] [int] NULL,
	[soLuong] [int] NULL,
	[soLuongBan] [int] NULL,
	[loaiSP] [nvarchar](20) NULL,
	[maNCC] [nvarchar](20) NULL,
	[maSP] [varchar](20) NOT NULL,
	[ngonNgu] [nvarchar](50) NULL,
	[nhaXuatBan] [nvarchar](50) NULL,
	[tacGia] [nvarchar](50) NULL,
	[tenSP] [nvarchar](50) NULL,
	[hinhAnh] [varbinary](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[maSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 11/21/2023 12:15:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[maNV] [nvarchar](50) NOT NULL,
	[matKhau] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[CTDonDatHang]  WITH CHECK ADD  CONSTRAINT [FKnv16wmavhjlvq1ggs4hgnmre4] FOREIGN KEY([maDDH])
REFERENCES [dbo].[DonDatHang] ([maDDH])
GO
ALTER TABLE [dbo].[CTDonDatHang] CHECK CONSTRAINT [FKnv16wmavhjlvq1ggs4hgnmre4]
GO
ALTER TABLE [dbo].[CTHoaDon]  WITH CHECK ADD  CONSTRAINT [FKkftv7a37atwlt1igqj5foytg9] FOREIGN KEY([maSP])
REFERENCES [dbo].[SanPham] ([maSP])
GO
ALTER TABLE [dbo].[CTHoaDon] CHECK CONSTRAINT [FKkftv7a37atwlt1igqj5foytg9]
GO
ALTER TABLE [dbo].[CTHoaDon]  WITH CHECK ADD  CONSTRAINT [FKrn4hgdmnmltfwkd1bxwlfu3ay] FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHD])
GO
ALTER TABLE [dbo].[CTHoaDon] CHECK CONSTRAINT [FKrn4hgdmnmltfwkd1bxwlfu3ay]
GO
ALTER TABLE [dbo].[DonDatHang]  WITH CHECK ADD  CONSTRAINT [FK93a945jjoo5x8i6qbmf4k1wbm] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[DonDatHang] CHECK CONSTRAINT [FK93a945jjoo5x8i6qbmf4k1wbm]
GO
ALTER TABLE [dbo].[DonDatHang]  WITH CHECK ADD  CONSTRAINT [FKe4xoierswsuaq1jqjl744oy13] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[DonDatHang] CHECK CONSTRAINT [FKe4xoierswsuaq1jqjl744oy13]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FKg1ebuq3tydt58wb4gutehmh9w] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FKg1ebuq3tydt58wb4gutehmh9w]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FKoyaa1162ps1nyifmfv2pv2qr] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FKoyaa1162ps1nyifmfv2pv2qr]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK88w6u2of9fyt7eqoqwso1creb] FOREIGN KEY([maNCC])
REFERENCES [dbo].[NhaCungCap] ([maNCC])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK88w6u2of9fyt7eqoqwso1creb]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FKdlo89541w3584djqsekcdm274] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FKdlo89541w3584djqsekcdm274]
GO
