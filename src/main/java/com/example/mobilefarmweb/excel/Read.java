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
        try {

            // Reading file from local directory
            FileInputStream file = new FileInputStream(
                    new File("Название файла.xlsx"));

            // Create Workbook instance holding reference to
            // .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            List<Person> list=new ArrayList<>();
            rowIterator.next();

            // Till there is an element condition holds true
            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();
                Person person=new Person();
                Double doubl=row.getCell(0).getNumericCellValue();
                person.setId(doubl.intValue());
                person.setFirstName(row.getCell(1).getStringCellValue());
                person.setLastName(row.getCell(2).getStringCellValue());
                list.add(person);

            }

            // Closing file output streams
            file.close();
            for (Person person : list) {
                System.out.print(person.getId()+ " ");
                System.out.print(person.getFirstName()+ " ");
                System.out.println(person.getLastName()+ " ");
            }
        }
        // Catch block to handle exceptions
        catch (Exception e) {

            // Display the exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
        return null;
    }
}
