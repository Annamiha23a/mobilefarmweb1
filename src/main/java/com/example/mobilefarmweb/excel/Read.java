package com.example.mobilefarmweb.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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
                Cell cell = row.getCell(23); // Получение ячейки по индексу столбца
                if (cell != null && cell.getCellType() == CellType.NUMERIC) { // Проверка наличия ячейки и ее типа
                    double numericValue = cell.getNumericCellValue(); // Получение числового значения ячейки
                    reselv.setShReserve(numericValue);
                } else {
                    // Обработка случая, когда ячейка не является числовой
                }
                //reselv.setShReserve(row.getCell(23).getNumericCellValue());
                cell = row.getCell(24); // Получение ячейки по индексу столбца
                if (cell != null && cell.getCellType() == CellType.NUMERIC) { // Проверка наличия ячейки и ее типа
                    double numericValue = cell.getNumericCellValue(); // Получение числового значения ячейки
                    reselv.setLnReserve(numericValue);
                } else {
                    // Обработка случая, когда ячейка не является числовой
                }
                //reselv.setLnReserve(row.getCell(24).getNumericCellValue());
                cell = row.getCell(25); // Получение ячейки по индексу столбца
                if (cell != null && cell.getCellType() == CellType.NUMERIC) { // Проверка наличия ячейки и ее типа
                    double numericValue = cell.getNumericCellValue(); // Получение числового значения ячейки
                    reselv.setShVolume(numericValue);
                } else {
                    // Обработка случая, когда ячейка не является числовой
                }
                //reselv.setShVolume(row.getCell(25).getNumericCellValue());
                cell = row.getCell(26); // Получение ячейки по индексу столбца
                if (cell != null && cell.getCellType() == CellType.NUMERIC) { // Проверка наличия ячейки и ее типа
                    double numericValue = cell.getNumericCellValue(); // Получение числового значения ячейки
                    reselv.setLnVolume(numericValue);
                } else {
                    // Обработка случая, когда ячейка не является числовой
                }

                //reselv.setLnVolume(row.getCell(26).getNumericCellValue());
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

    public static Reselv readingOne(String name){
        // Try block to check for exceptions
        Reselv reselv=new Reselv();
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
            while (rowIterator.hasNext()) {


                Row row = rowIterator.next();
                String NameBD = row.getCell(3).getStringCellValue();
                if(Objects.equals(NameBD, name)){

                    reselv.setName(row.getCell(3).getStringCellValue());
                    reselv.setAvYield(row.getCell(8).getNumericCellValue());
                    Double doubl=row.getCell(10).getNumericCellValue();
                    reselv.setRatingRB(doubl.intValue());
                    Cell cell = row.getCell(23); // Получение ячейки по индексу столбца
                    if (cell != null && cell.getCellType() == CellType.NUMERIC) { // Проверка наличия ячейки и ее типа
                        double numericValue = cell.getNumericCellValue(); // Получение числового значения ячейки
                        reselv.setShReserve(numericValue);
                    } else {
                        // Обработка случая, когда ячейка не является числовой
                    }
                    //reselv.setShReserve(row.getCell(23).getNumericCellValue());
                    cell = row.getCell(24); // Получение ячейки по индексу столбца
                    if (cell != null && cell.getCellType() == CellType.NUMERIC) { // Проверка наличия ячейки и ее типа
                        double numericValue = cell.getNumericCellValue(); // Получение числового значения ячейки
                        reselv.setLnReserve(numericValue);
                    } else {
                        // Обработка случая, когда ячейка не является числовой
                    }
                    //reselv.setLnReserve(row.getCell(24).getNumericCellValue());
                    cell = row.getCell(25); // Получение ячейки по индексу столбца
                    if (cell != null && cell.getCellType() == CellType.NUMERIC) { // Проверка наличия ячейки и ее типа
                        double numericValue = cell.getNumericCellValue(); // Получение числового значения ячейки
                        reselv.setShVolume(numericValue);
                    } else {
                        // Обработка случая, когда ячейка не является числовой
                    }
                    //reselv.setShVolume(row.getCell(25).getNumericCellValue());
                    cell = row.getCell(26); // Получение ячейки по индексу столбца
                    if (cell != null && cell.getCellType() == CellType.NUMERIC) { // Проверка наличия ячейки и ее типа
                        double numericValue = cell.getNumericCellValue(); // Получение числового значения ячейки
                        reselv.setLnVolume(numericValue);
                    } else {
                        // Обработка случая, когда ячейка не является числовой
                    }

                    //reselv.setLnVolume(row.getCell(26).getNumericCellValue());
                }
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
        return reselv;
    }

    public static List<Reselv> readingOne2(String name){
        // Try block to check for exceptions
        List<Reselv> list = new ArrayList<>();
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
            while (rowIterator.hasNext()) {


                Row row = rowIterator.next();
                String NameBD = row.getCell(3).getStringCellValue();
                if(NameBD.contains(name)){
                    Reselv reselv=new Reselv();
                    reselv.setName(row.getCell(3).getStringCellValue());
                    reselv.setAvYield(row.getCell(8).getNumericCellValue());
                    Double doubl=row.getCell(10).getNumericCellValue();
                    reselv.setRatingRB(doubl.intValue());
                    Cell cell = row.getCell(23); // Получение ячейки по индексу столбца
                    if (cell != null && cell.getCellType() == CellType.NUMERIC) { // Проверка наличия ячейки и ее типа
                        double numericValue = cell.getNumericCellValue(); // Получение числового значения ячейки
                        reselv.setShReserve(numericValue);
                    } else {
                        // Обработка случая, когда ячейка не является числовой
                    }
                    //reselv.setShReserve(row.getCell(23).getNumericCellValue());
                    cell = row.getCell(24); // Получение ячейки по индексу столбца
                    if (cell != null && cell.getCellType() == CellType.NUMERIC) { // Проверка наличия ячейки и ее типа
                        double numericValue = cell.getNumericCellValue(); // Получение числового значения ячейки
                        reselv.setLnReserve(numericValue);
                    } else {
                        // Обработка случая, когда ячейка не является числовой
                    }
                    //reselv.setLnReserve(row.getCell(24).getNumericCellValue());
                    cell = row.getCell(25); // Получение ячейки по индексу столбца
                    if (cell != null && cell.getCellType() == CellType.NUMERIC) { // Проверка наличия ячейки и ее типа
                        double numericValue = cell.getNumericCellValue(); // Получение числового значения ячейки
                        reselv.setShVolume(numericValue);
                    } else {
                        // Обработка случая, когда ячейка не является числовой
                    }
                    //reselv.setShVolume(row.getCell(25).getNumericCellValue());
                    cell = row.getCell(26); // Получение ячейки по индексу столбца
                    if (cell != null && cell.getCellType() == CellType.NUMERIC) { // Проверка наличия ячейки и ее типа
                        double numericValue = cell.getNumericCellValue(); // Получение числового значения ячейки
                        reselv.setLnVolume(numericValue);
                    } else {
                        // Обработка случая, когда ячейка не является числовой
                    }

                    //reselv.setLnVolume(row.getCell(26).getNumericCellValue());

                    list.add(reselv);
                }
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
    public static List<String> readingName(){
        // Try block to check for exceptions
        List<String> list=new ArrayList<>();
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
                String nameOrg= row.getCell(3).getStringCellValue();

                list.add(nameOrg);

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
