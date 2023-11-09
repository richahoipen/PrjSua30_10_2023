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