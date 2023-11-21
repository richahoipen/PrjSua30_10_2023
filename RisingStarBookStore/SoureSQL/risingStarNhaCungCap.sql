﻿use RisingStar
--đổi kiểu dữ liệu thành nvarchar(50)
ALTER TABLE NhaCungCap
ALTER COLUMN tenNCC nvarchar(50);
ALTER TABLE NhaCungCap
ALTER COLUMN diaChi nvarchar(100);
ALTER TABLE KhachHang
ALTER COLUMN diaChi nvarchar(100);
--Lọc dữ liệu
select*from [dbo].[NhaCungCap]
ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;
--Nạp dữ liệu
--NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdtNCC, String email) 
DECLARE @NextIndex INT;
SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT)), 0) + 1 FROM NhaCungCap;
DECLARE @NewMaKH VARCHAR(20);
SET @NewMaKH = 'NCC' + CAST(@NextIndex AS VARCHAR);
INSERT INTO NhaCungCap(maNCC,tenNCC,sdtNCC,email,diaChi)
VALUES (@NewMaKH, 'Kim Khánh', '02333272029', 'khanh@gmail.com', '5 Võ Nguyễn Giáp Tp. Đà Nẵng');
--Cập nhật
UPDATE [dbo].[NhaCungCap]
SET [tenNCC] = 'Van Minh',
    [diaChi] = '12 Nguyễn Thông',
    [sdtNCC] = '0981646632',
    [email] = 'vm@gmail.com'
WHERE [maNCC] = 'NCC1'
--Nạp
DECLARE @NextIndex INT;
SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT)), 0) + 1 FROM NhaCungCap;
DECLARE @NewMaNCC VARCHAR(20);
SET @NewMaNCC = 'NCC' + CAST(@NextIndex AS VARCHAR);
INSERT [dbo].[NhaCungCap] ([diaChi], [email], [maNCC], [sdtNCC], [tenNCC]) 
VALUES (N'45 Tôn Ðản Quận 4', N'mc@gmail.com', @NewMaNCC, N'02838452708', N'mcBook');
--xóa hết
DELETE FROM NhaCungCap;
--Update
UPDATE [dbo].[NhaCungCap] SET [tenNCC]= 'Minh' , [sdtNCC]= '098166354' ,[email]= 'mgit@gmail.com' ,[diaChi]= '34 Nguyễn Thông' WHERE [maNCC]= 'NCC1'
--Lấy mã theo tên
select TOP 1 maNCC from [dbo].[NhaCungCap]
where tenNCC=N'Văn Đạt'
--Lấy tên theo mã
select tenNCC from [dbo].[NhaCungCap]
where maNCC=N'NCC4'
