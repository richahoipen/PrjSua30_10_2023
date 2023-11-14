use RisingStar
--CTDonDatHang
SELECT *
FROM [dbo].[CTDonDatHang]
ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;
SELECT *
FROM [dbo].[SanPham]
--DonDatHang
SELECT *
FROM [dbo].[DonDatHang]
--HoaDon
Select*from [dbo].[HoaDon]
--public CTDonDatHang(double donGia, int soLuong, double thanhTien) 
insert into [dbo].[CTDonDatHang] ([maSP],[donGia],[soLuong],[thanhTien])
values (?,?,?,?)

--Xóa cột 
ALTER TABLE [dbo].[SanPham]
DROP COLUMN maNhaCungCap;

DELETE FROM [dbo].[CTDonDatHang];
--Xuất
SELECT SanPham.maSP, SanPham.tenSP, CTDonDatHang.donGia, CTDonDatHang.soLuong, CTDonDatHang.thanhTien
FROM [dbo].[SanPham]
INNER JOIN [dbo].[CTDonDatHang] ON SanPham.maSP = CTDonDatHang.maSP
where maDDH is NULL;
--Tính tổng thành tiền
SELECT SUM(thanhTien) AS tongTien
FROM [dbo].[CTDonDatHang]
where maDDH is NULL;

DELETE FROM [dbo].[CTDonDatHang]
where maSP='SP2'
--DonDatHang(String maDDH, Date ngayDat)
DECLARE @NextIndex INT;
SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maDDH, 4, LEN(maDDH)) AS INT)), 0) + 1 FROM DonDatHang;
DECLARE @NewMaDDH VARCHAR(20);
SET  @NewMaDDH = 'DDH' + CAST(@NextIndex AS VARCHAR);
insert into [dbo].[DonDatHang]([maDDH],[maKH],[maNV],[ngayDat])
values (@NewMaDDH,N'KH3',N'NV1','2023-11-13')
update [dbo].[CTDonDatHang]
set maDDH=@NewMaDDH
where maDDH is null
--nạp
insert into [dbo].[DonDatHang]([maDDH],[maKH],[maNV],[ngayDat])
values 
--xóa bảng
delete from [dbo].[DonDatHang] where maDDH='DDH2'
delete from [dbo].[CTDonDatHang]
--Tra khach hang
select TOP 1 maKH from [dbo].[KhachHang]
where tenKH=N'Nguyễn Văn An'
and sdt=N'0981646635'
and diaChi=N'2 Lê Văn Thọ gò vấp'
--
DECLARE @NewSTT INT;
-- Lấy giá trị lớn nhất hiện tại của cột stt (nếu có)
SET @NewSTT = ISNULL((SELECT MAX(sTT) FROM [dbo].[CTDonDatHang]), 0) + 1;
-- Chèn một hàng mới với giá trị tăng dần cho cột stt
insert into [dbo].[CTDonDatHang] ([sTT],[maSP],[donGia],[soLuong],[thanhTien])
values (@NewSTT,?,?,?,?)
--Them Chi tiết
DECLARE @NewSTT INT;
SET @NewSTT = ISNULL((SELECT MAX(sTT) FROM [dbo].[CTDonDatHang]), 0) + 1;
insert into [dbo].[CTDonDatHang] ([sTT],[maSP],[donGia],[soLuong],[thanhTien])
values (@NewSTT,?,?,?,?)

--Hoa Don
select *from [dbo].[CTHoaDon]