package customEntities;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class XuatFile {
	public static void saveToExcel(DefaultTableModel dtm, String name) {
	    JFileChooser fileChooser = new JFileChooser();
	    fileChooser.setDialogTitle("Specify a file to save");
	    fileChooser.setSelectedFile(new File(name));

	    int userSelection = fileChooser.showSaveDialog(null);

	    if (userSelection == JFileChooser.APPROVE_OPTION) {
	        File fileToSave = fileChooser.getSelectedFile();
	        String filePath = fileToSave.getAbsolutePath();
	        if (!filePath.endsWith(".xlsx")) {
	            filePath += name + ".xlsx";
	        }
	        exportToExcel(dtm, filePath);
	    }
	}
	private static void exportToExcel(DefaultTableModel dtm, String filePath) {
	    Workbook workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("ChiTiet");

	    // Tạo hàng tiêu đề
	    Row headerRow = sheet.createRow(0);
	    for (int i = 0; i < dtm.getColumnCount(); i++) {
	        Cell cell = headerRow.createCell(i);
	        cell.setCellValue(dtm.getColumnName(i));
	    }

	    // Tạo các hàng dữ liệu
	    for (int i = 0; i < dtm.getRowCount(); i++) {
	        Row row = sheet.createRow(i + 1);
	        for (int j = 0; j < dtm.getColumnCount(); j++) {
	            Cell cell = row.createCell(j);
	            cell.setCellValue(dtm.getValueAt(i, j).toString());
	        }
	    }

	    // Ghi dữ liệu vào tệp
	    try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
	        workbook.write(outputStream);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public static void saveToPDF(JFrame frame, String name) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        fileChooser.setSelectedFile(new File(name));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.endsWith(".pdf")) {
                filePath += ".pdf";
            }
            exportToPDF(frame, filePath);
        }
    }

	private static void exportToPDF(JFrame frame, String filePath) {
        try {
            BufferedImage image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = image.createGraphics();
            frame.paint(graphics2D);
            
            Document document = new Document(new Rectangle(frame.getWidth()+100, frame.getHeight()+100));
            // Đặt lề cho tài liệu
            document.setMargins(50, 50, 50, 50);
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            Image pdfImage = Image.getInstance(image, null);
            document.add(pdfImage);
            frame.dispose();
            document.close();
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(filePath));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
