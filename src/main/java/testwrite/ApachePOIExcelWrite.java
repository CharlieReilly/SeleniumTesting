package testwrite;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ApachePOIExcelWrite {

    private static final String FILE_NAME = System.getProperty("user.dir") + "\\Usrnme_&_Password.xlsx";

    public static void main(String[] args) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();
        XSSFSheet sheet = workbook.createSheet("Username And Password");
//        Object[][] datatypes = {
//                {"Datatype", "Type", "Size(in bytes)"}
//                {"Datatype", "Type", "Size(in bytes)"},
//                {"int", "Primitive", 2},
//                {"float", "Primitive", 4},
//                {"double", "Primitive", 8},
//                {"char", "Primitive", 1},
//                {"String", "Non-Primitive", "No fixed size"}
//        };
//
////        int rowNum = 0;
//        System.out.println("Creating excel");
//
////        for (Object[] datatype : datatypes) {
//            Row row = sheet.createRow(0);
////            Row row = sheet.createRow(rowNum++);
//            int colNum = 0;
////            for (Object field : datatype) {
        		Row row = sheet.createRow(0);
                Cell cell = row.createCell(0);
                cell.setCellValue("Username: ");
                Cell cell1 = row.createCell(1);
                cell1.setCellValue("Charlie Reillydfgh");
                Row row2 = sheet.createRow(1);
                Cell cell2a = row2.createCell(0);
                cell2a.setCellValue("Email: ");
                Cell cell2b = row2.createCell(1);
                cell2b.setCellValue("charlie.reilly@qa.comdfgh");
                
//                if (field instanceof String) {
//                    cell.setCellValue((String) field);
//                } else if (field instanceof Integer) {
//                    cell.setCellValue((Integer) field);
//                }
            
        


        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}