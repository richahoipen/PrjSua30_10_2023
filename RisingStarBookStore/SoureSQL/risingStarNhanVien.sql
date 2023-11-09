use RisingStar 
--Lấy NhanVien
select*from [dbo].[NhanVien]
ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;
--xóa cột email
ALTER TABLE NhanVien DROP COLUMN email;

--NhanVien
--public NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String email, String caLam)
--Nạp		
DECLARE @NextIndex INT;
SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT)), 0) + 1 FROM NhanVien;
DECLARE @NewMaNV VARCHAR(20);
SET @NewMaNV = 'NV' + CAST(@NextIndex AS VARCHAR);
INSERT [dbo].[NhanVien] ([maNV],[tenNV],[sdt],[gioiTinh],[diaChi],[ngaySinh],[chucVu],[cMND],[caLam]) 
VALUES (@NewMaNV,N'Nguyễn An Thành',N'0811646635',N'Nam',N'34 Nguyễn Tất Thành, Phan Thiết',N'1989-11-3',N'Nhân viên',N'061303000123',N'Chiều')
INSERT [dbo].[TaiKhoan]([maNV],[matKhau] )
VALUES (@NewMaNV,'thanh123')
--TaiKhoan
select*from [dbo].[TaiKhoan]
ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;
--
DECLARE @NextIndex INT;
SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT)), 0) + 1 FROM NhanVien;
DECLARE @NewMaNV VARCHAR(20);
SET @NewMaNV = 'NV' + CAST(@NextIndex AS VARCHAR);
INSERT [dbo].[TaiKhoan] ([maNV],[matKhau] )
VALUES (@NewMaNV,@NewMaNV);

INSERT [dbo].[TaiKhoan] ([maNV],[matKhau] )
VALUES ('NV25','NV25');
--
select*from [dbo].[TaiKhoan] where maNV='NV20'
-- NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String caLam)
			
UPDATE [dbo].[NhanVien]
set tenNV=N'Lâm An', 
sdt='0984636657',
gioiTinh=N'Nam',
diaChi=N'45/121 Kha Vạn Cân, Thủ Đức',
ngaySinh='2002-11-23',
chucVu=N'Nhân viên',
cMND='010405000786',
caLam=N'Chiều'
where maNV='NV3'
UPDATE [dbo].[TaiKhoan]
set matKhau='123'
where maNV='NV3'
--lấy ngày
select*from [dbo].[NhanVien] where maNV='NV30'
--lấy maNV
select maNV from [dbo].[NhanVien]
ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;
--cccd
select cMND from [dbo].[NhanVien]
ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;
--sdt
select sdt from [dbo].[NhanVien]
ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;
--diaChi
select diaChi from [dbo].[NhanVien]
ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;
--TIM KIẾM
select*from [dbo].[NhanVien]
where tenNV=?
ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;
--Theo ngày sinh
SELECT *
FROM [dbo].[NhanVien]
WHERE year(ngaySinh)=2000
ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;
--Tìm kiếm all
-- NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String caLam)
			
SELECT *
FROM [dbo].[NhanVien]
where tenNV=N'Trần Văn Đạt' or sdt=N'0878146635' or gioiTinh=N'Nam' or diaChi=N'57 Trường Chinh, tpHCM' or ngaySinh='1999-10-01' or chucVu=N'Nhân viên' or cMND='081725000123' or caLam=N'Sáng'
ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;
--2 thuộc tính
