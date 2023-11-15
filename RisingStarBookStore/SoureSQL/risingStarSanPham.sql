use RisingStar 
--Nạp data
--SanPham(String maSP, String tenSP, String loaiSP, String tacGia, String nhaXuatBan, int namXuatBan,int soLuong, String ngonNgu, double giaNhap, double giaBan,byte[] hinhAnh) 
			
DECLARE @NextIndex INT;
SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT)), 0) + 1 FROM SanPham;
DECLARE @NewMaSP VARCHAR(20);
SET @NewMaSP = 'SP' + CAST(@NextIndex AS VARCHAR);
INSERT [dbo].[SanPham] ([maSP],[tenSP],[loaiSP],[tacGia],[nhaXuatBan],[namXuatBan],[soLuong],[giaNhap],[giaBan],[hinhAnh]) 
VALUES (@NewMaSP,?,?,?,?,?,?,?,?,?)

select*from [dbo].[SanPham]
ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;
--Xóa cột maNhaCungCap
ALTER TABLE [dbo].[SanPham]
DROP COLUMN maNhaCungCap;
--Cập nhật giá trị null
UPDATE [dbo].[SanPham]
SET soLuongBan = 4
WHERE soLuongBan IS NULL AND maSP='SP2';
--
update [dbo].[SanPham]
set
maNCC=N'NCC3',
ngonNgu=N'Tiếng việt',

where maSP='SP1';
--Lấy dữ liệu ảnh
select hinhAnh from [dbo].[SanPham]
where maSP='SP1'
--Lệnh cập nhật
--Đẩy combobox
select maSP from [dbo].[SanPham]
ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;
--soLuongBan
select soLuongBan from [dbo].[SanPham]
ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;

SELECT soLuongBan
FROM [dbo].[SanPham]
WHERE soLuongBan IS NOT NULL
ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;
--Tìm kiếm
--SanPham(String maSP, String tenSP, String loaiSP, String tacGia, String nhaXuatBan, int namXuatBan,int soLuong, String ngonNgu, double giaNhap, double giaBan,String maNCC) 
select * from  [dbo].[SanPham]
where maSP=? or
tenSP=? or
loaiSP= ? or 
tacGia=? or
nhaXuatBan=? or
namXuatBan=? or 
soLuong=? or 
soLuongBan=? or 
ngonNgu=? or
giaNhap=? or 
giaBan=? or 
maNCC=? 
ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;
--Tìm khách hàng qua sdt
SELECT TOP 1 sdt
FROM [dbo].[KhachHang]
WHERE sdt = '0917646656';

SELECT TOP 1 tenKH
FROM [dbo].[KhachHang]
WHERE sdt = '0917646656';

SELECT TOP 1 gioiTinh
FROM [dbo].[KhachHang]
WHERE sdt = '0917646656';

select * from [dbo].[TaiKhoan]
where 