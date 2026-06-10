package utilities;

import java.io.InputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    public static Object[][] getTestData(String sheetName)
            throws Exception {

        // Read Excel file from resources folder

        InputStream inputStream =
                ExcelUtility.class
                .getClassLoader()
                .getResourceAsStream("TestData.xlsx");


        // Open Workbook

        XSSFWorkbook workbook =
                new XSSFWorkbook(inputStream);


        // Get Sheet

        XSSFSheet sheet =
                workbook.getSheet(sheetName);


        // Get Total Rows

        int totalRows =
                sheet.getLastRowNum();


        // Get Total Columns

        int totalCols =
                sheet.getRow(0)
                     .getLastCellNum();


        // Create Object Array

        Object[][] data =
        		new Object[totalRows][totalCols];


        // Prevent scientific notation

        DataFormatter formatter =
                new DataFormatter();


        // Read Data

        for(int r = 1; r <= totalRows; r++) {

            for(int c = 0; c < totalCols; c++) {

                data[r - 1][c] =

                        formatter.formatCellValue(
                                sheet.getRow(r)
                                     .getCell(c));
            }
        }


        // Close Workbook

        workbook.close();

        inputStream.close();


        return data;
    }
}