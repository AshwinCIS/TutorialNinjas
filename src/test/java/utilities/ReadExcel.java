package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadExcel {

    public static String[][] readData(String filename) throws IOException {

        FileInputStream fis = new FileInputStream("./testData/"+ filename +".xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0); 

        int rowCount = sheet.getPhysicalNumberOfRows(); // actual rows
        int colCount = sheet.getRow(0).getLastCellNum(); // header columns

        String[][] data = new String[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            XSSFRow row = sheet.getRow(i);

            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] =
                        (row.getCell(j) == null)
                                ? ""
                                : row.getCell(j).toString();
            }
        }

        wb.close();
        fis.close();
        return data;
    }
}
