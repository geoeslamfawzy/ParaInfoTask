package utils;

import constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceUtilis {
    static FileInputStream fis = null;
    public FileInputStream getFileInputStream(){
        File srcFile = new File(FrameworkConstants.getDataFilePath("PackagesData.xlsx"));
        try{
            fis = new FileInputStream(srcFile);
        }catch (FileNotFoundException e) {
            System.out.println("Test Data File is not found : " + e.getMessage() + "Check the file path");
        }
        return fis;
    }

    public Object [][] getExcelData() throws IOException {
        fis = getFileInputStream();
        XSSFWorkbook workBook= new XSSFWorkbook(fis);
        XSSFSheet sheet = workBook.getSheetAt(0);

        int totalNumberOfRows = sheet.getLastRowNum()+1;
        int totalNumberOfColumns = 4;

        String[][] arrayExcelData = new String[totalNumberOfRows][totalNumberOfColumns];
        for (int i = 0; i<totalNumberOfRows; i++) {
            for (int j = 0; j<totalNumberOfColumns; j++){
                XSSFRow row = sheet.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();
            }
        }

        return arrayExcelData;
    }
}
