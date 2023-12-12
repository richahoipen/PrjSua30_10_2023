use RisingStar
--Lấy hóa đơn
select * from [dbo].[HoaDon]
--
SELECT *
FROM [dbo].[HoaDon]
ORDER BY CAST(SUBSTRING(maHD, 3, LEN(maHD)) AS INT) ASC;


--
select * from [dbo].[CTHoaDon]

select*from [dbo].[SanPham]

--Cập nhật soLuongban
UPDATE [dbo].[SanPham]
SET soLuongBan = ISNULL(soLuongBan, 0)

select*from [dbo].[SanPham]

--thêm hóa đơn
DECLARE @NextIndex INT;
SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maHD,3, LEN(maHD)) AS INT)), 0) + 1 FROM HoaDon;
DECLARE @NewMaHD VARCHAR(20);
SET  @NewMaHD = 'HD' + CAST(@NextIndex AS VARCHAR);
insert into [dbo].[HoaDon]([maHD],[ngayLap],[gioLap],[tienKhachDua],[tongTien],[maNV],[maKH])
values (@NewMaHD,?,?,?,?,?,?,?)
--thêm ct hoa don
DECLARE @NewSTT INT;
SET @NewSTT = ISNULL((SELECT MAX(sTT) FROM [dbo].[CTDonDatHang]), 0) + 1;
insert into [dbo].[CTHoaDon]([sTT],[maSP],[donGia],[soLuong],[thanhTien],[maHD])
values (@NewSTT,?,?,?,?,?)
--
DECLARE @NewSTT INT;
SELECT @NewSTT = COUNT(*) + 1
FROM [dbo].[CTHoaDon];
INSERT INTO [dbo].[CTHoaDon] ([sTT], [maSP], [donGia], [soLuong], [thanhTien], [maHD])
VALUES (@NewSTT, N'SP2', 34, 3, 34 * 3, N'HD11');



select * from [DonDatHang]

SELECT  TOP 1 maNV
FROM [dbo].[NhanVien]
ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;

SELECT maNV
FROM [dbo].[NhanVien] 
WHERE maNV = (
    SELECT TOP 1 maNV
    FROM [dbo].[NhanVien]
    ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) DESC
);

SELECT maHD
FROM [dbo].[HoaDon] 
WHERE maHD = (
    SELECT TOP 1 maHD
    FROM [dbo].[HoaDon]
    ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maHD)) AS INT) DESC
);
--Xóa
delete from [dbo].[HoaDon]
delete from [dbo].[CTHoaDon]
--Cập nhật mã hóa đơn cho ct
update [dbo].[CTHoaDon]
set maHD=? where maHD is null
--Cập Nhật số lương sản phẩm
select * from [dbo].[SanPham]
update [dbo].[SanPham]
set soLuong=soLuong-?,
soLuongBan=soLuongBan+?
where maSP=?

update [dbo].[DonDatHang]
set daLapHoaDon=?
where maDDH=?
--Nhóm maDDH xuất tổng
SELECT SUM(thanhTien) AS tongTien
FROM CTDonDatHang
GROUP BY maDDH;
--Lay Hoa Don
select * from [dbo].[HoaDon]
where maHD=N'HD11';

select * from [dbo].[DonDatHang]

select * from [CTHoaDon]
where maHD=N'HD10'
ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;

SELECT CTHoaDon.*, SanPham.tenSP
FROM CTHoaDon
JOIN SanPham ON CTHoaDon.maSP = SanPham.maSP
WHERE CTHoaDon.maHD = N'HD10'
ORDER BY CAST(SUBSTRING(CTHoaDon.maSP, 3, LEN(CTHoaDon.maSP)) AS INT) ASC;


SELECT maHD
FROM [dbo].[HoaDon]
ORDER BY CAST(SUBSTRING(maHD, 3, LEN(maHD)) AS INT) DESC;

SELECT TOP 1 maHD
FROM [dbo].[HoaDon]
ORDER BY CAST(SUBSTRING(maHD, 3, LEN(maHD)) AS INT) DESC;

select tenSP from [dbo].[SanPham]
where maSP=N'SP1';
--lấy danh sách hóa đơn
SELECT HoaDon.maHD, HoaDon.ngayLap, HoaDon.tongTien,
       KhachHang.tenKH, KhachHang.sdt,
       NhanVien.tenNV
FROM HoaDon
JOIN NhanVien ON HoaDon.maNV = NhanVien.maNV
JOIN KhachHang ON HoaDon.maKH = KhachHang.maKH
ORDER BY CAST(SUBSTRING(maHD, 3, LEN(maHD)) AS INT) ASC;

SELECT HoaDon.ngayLap
FROM HoaDon
JOIN NhanVien ON HoaDon.maNV = NhanVien.maNV
JOIN KhachHang ON HoaDon.maKH = KhachHang.maKH
where maHD=N'HD1';
SELECT * FROM [dbo].[TaiKhoan]