use RisingStar
--Lấy hóa đơn
select * from [dbo].[HoaDon]
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
insert into [dbo].[CTHoaDon]([sTT],[maSP],[donGia],[soLuong],[thanhTien])
values (@NewSTT,?,?,?,?)

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