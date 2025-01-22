package utilities;

import com.google.common.collect.Table.Cell;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExcelUtils {
    private Object workbook;

    public ExcelUtils(String filePath) {
        try {
            FileInputStream file = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            System.out.println("Error loading Excel file: " + e.getMessage());
        }
    }

    public String getCellData(String sheetName, int row, int col) {
        try {
            if (workbook == null) {
                throw new RuntimeException("Workbook not initialized. Please check the file path.");
            }
            Sheet sheet = ((XSSFWorkbook) workbook).getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet " + sheetName + " not found in Excel file.");
            }
            Row sheetRow = (Row) sheet.getRow(row);
            if (sheetRow == null) {
                throw new RuntimeException("Row " + row + " not found in sheet: " + sheetName);
            }
            @SuppressWarnings("rawtypes")
            Cell cell = sheetRow.getCell(col);
            if (cell == null) {
                return "Cell is empty"; // Prevents NullPointerException
            }
            return cell.toString();
        } catch (Exception e) {
            System.out.println("Error reading cell data: " + e.getMessage());
            return null;
        }
    }

    public void closeWorkbook() {
        try {
            if (workbook != null) {
                ((InputStream) workbook).close();
            }
        } catch (IOException e) {
            System.out.println("Error closing workbook: " + e.getMessage());
        }
    }
}
