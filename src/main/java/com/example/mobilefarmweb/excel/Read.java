package com.example.mobilefarmweb.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Read {
    public static List<Reselv> reading(){
        // Try block to check for exceptions
        List<Reselv> list=new ArrayList<>();
        try {

            // Reading file from local directory
            FileInputStream file = new FileInputStream(
                    new File("Расчеты.xlsx"));

            // Create Workbook instance holding reference to
            // .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();

            rowIterator.next();
            rowIterator.next();
            rowIterator.next();
            // Till there is an element condition holds true
            Integer i=0;
            while (rowIterator.hasNext()) {
                i++;
                Row row = rowIterator.next();
                Reselv reselv=new Reselv();
                reselv.setNumber(i);
                reselv.setName(row.getCell(3).getStringCellValue());
                reselv.setAvYield(row.getCell(8).getNumericCellValue());
                Double doubl=row.getCell(10).getNumericCellValue();
                reselv.setRatingRB(doubl.intValue());
                reselv.setShReserve(row.getCell(11).getNumericCellValue());
                reselv.setLnReserve(row.getCell(12).getNumericCellValue());
                list.add(reselv);

            }

            // Closing file output streams
            file.close();
        }
        // Catch block to handle exceptions
        catch (Exception e) {

            // Display the exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
        return list;
    }
}
