package com.example.mobilefarmweb.excel;

// Java Program to Illustrate Writing
// Data to Excel File using Apache POI

// Import statements
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

import com.example.mobilefarmweb.entity.FeedGroup;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Main class
public class Write {

    // Main driver method
    public static void write()
    {

        // Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Creating a blank Excel sheet
        XSSFSheet sheet
                = workbook.createSheet("Расчеты");

        // Creating an empty TreeMap of string and Object][]
        // type
        Map<String, Object[]> data
                = new TreeMap<String, Object[]>();

        List<Person> list=new ArrayList<>();
        Person person1=new Person();
        person1.setId(5);
        person1.setFirstName("Анна");
        person1.setLastName("Михалевич");
        Person person2=new Person();
        person2.setId(6);
        person2.setFirstName("Данила");
        person2.setLastName("Гайсёнок");
        // Writing data to Object[]
        // using put() method
        list.add(person1);
        list.add(person2);
        Integer index=6;
        data.put("1",
                new Object[] { "ID", "NAME", "LASTNAME" });
        data.put("2",
                new Object[] { 1, "Pankaj", "Kumar" });
        data.put("3",
                new Object[] { 2, "Prakashni", "Yadav" });
        data.put("4", new Object[] { 3, "Ayan", "Mondal" });
        data.put("5", new Object[] { 4, "Virat", "kohli" });
        for (Person person : list) {
            data.put(index.toString(), new Object[]{person.getId(), person.getFirstName(), person.getLastName()});
            index++;
        }

        // Iterating over data and writing it to sheet
        Set<String> keyset = data.keySet();

        int rownum = 0;

        for (String key : keyset) {

            // Creating a new row in the sheet
            Row row = sheet.createRow(rownum++);

            Object[] objArr = data.get(key);

            int cellnum = 0;

            for (Object obj : objArr) {

                // This line creates a cell in the next
                // column of that row
                Cell cell = row.createCell(cellnum++);

                if (obj instanceof String)
                    cell.setCellValue((String)obj);

                else if (obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }

        // Try block to check for exceptions
        try {

            // Writing the workbook
            FileOutputStream out = new FileOutputStream(
                    new File("Название файла.xlsx"));
            workbook.write(out);

            // Closing file output connections
            out.close();

            // Console message for successful execution of
            // program
            System.out.println(
                    "Название файла.xlsx written successfully on disk.");
        }

        // Catch block to handle exceptions
        catch (Exception e) {

            // Display exceptions along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
    }


    public static void writeRation(RationsExcelData requestData, FeedGroup feedGroup)
    {

        // Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Creating a blank Excel sheet
        XSSFSheet sheet
                = workbook.createSheet("Подбор рациона");

        // Creating an empty TreeMap of string and Object][]
        // type
        Map<String, Object[]> data
                = new TreeMap<String, Object[]>();
        List<String> lsTitle1=new ArrayList<>();
        for(String st:requestData.getNameTable1())
        {
            lsTitle1.add(st);
        }

        Integer index=9;
        data.put("1",
                new Object[] { "Название рациона", requestData.getNameRation() });
        data.put("2",
                new Object[] { lsTitle1.get(0), lsTitle1.get(1), lsTitle1.get(2), lsTitle1.get(3), lsTitle1.get(4), lsTitle1.get(5), lsTitle1.get(6), lsTitle1.get(7), lsTitle1.get(8), lsTitle1.get(9), lsTitle1.get(10), lsTitle1.get(11), lsTitle1.get(12), lsTitle1.get(13), lsTitle1.get(14), lsTitle1.get(15), lsTitle1.get(16), lsTitle1.get(17), lsTitle1.get(18), lsTitle1.get(19), lsTitle1.get(20), lsTitle1.get(21), lsTitle1.get(22), lsTitle1.get(23), lsTitle1.get(24), lsTitle1.get(25)});
        data.put("3",
                new Object[] { "Норма" });
        data.put("4",
                new Object[] { feedGroup.getType(), "", feedGroup.getNutrients().getFeedUnit().toString(), feedGroup.getNutrients().getEnergyExchange().toString(),"100%", String.valueOf(feedGroup.getNutrients().getDryMatter().doubleValue()*1000), feedGroup.getNutrients().getDryProtein().toString(), feedGroup.getNutrients().getDigestedProtein().toString(), feedGroup.getNutrients().getRawFat().toString(), feedGroup.getNutrients().getRawFiber().toString(), feedGroup.getNutrients().getStarch().toString(), feedGroup.getNutrients().getSugar().toString(), feedGroup.getNutrients().getCalcium().toString(), feedGroup.getNutrients().getPhosphorus().toString(), feedGroup.getNutrients().getMagnesium().toString(), feedGroup.getNutrients().getPotassium().toString(), feedGroup.getNutrients().getSulfur().toString(), feedGroup.getNutrients().getFerrum().toString(), feedGroup.getNutrients().getCopper().toString(), feedGroup.getNutrients().getZins().toString(), feedGroup.getNutrients().getManganese().toString(), feedGroup.getNutrients().getCobalt().toString(), feedGroup.getNutrients().getIodine().toString(), feedGroup.getNutrients().getCarotene().toString(), feedGroup.getNutrients().getVitaminD().toString(), feedGroup.getNutrients().getVitaminE().toString()  });
        data.put("5", new Object[] { requestData.getDataReal().get(0), requestData.getDataReal().get(1), requestData.getDataReal().get(2), requestData.getDataReal().get(3), requestData.getDataReal().get(4), requestData.getDataReal().get(5), requestData.getDataReal().get(6), requestData.getDataReal().get(7), requestData.getDataReal().get(8), requestData.getDataReal().get(9), requestData.getDataReal().get(10), requestData.getDataReal().get(11), requestData.getDataReal().get(12),  requestData.getDataReal().get(13), requestData.getDataReal().get(14), requestData.getDataReal().get(15), requestData.getDataReal().get(16), requestData.getDataReal().get(17), requestData.getDataReal().get(18), requestData.getDataReal().get(19), requestData.getDataReal().get(20),  requestData.getDataReal().get(21), requestData.getDataReal().get(22), requestData.getDataReal().get(23), requestData.getDataReal().get(24), requestData.getDataReal().get(25)});
        data.put("6", new Object[] { requestData.getVariance().get(0), requestData.getVariance().get(1), requestData.getVariance().get(2), requestData.getVariance().get(3), requestData.getVariance().get(4), requestData.getVariance().get(5), requestData.getVariance().get(6), requestData.getVariance().get(7), requestData.getVariance().get(8), requestData.getVariance().get(9), requestData.getVariance().get(10), requestData.getVariance().get(11), requestData.getVariance().get(12),  requestData.getVariance().get(13), requestData.getVariance().get(14), requestData.getVariance().get(15), requestData.getVariance().get(16), requestData.getVariance().get(17), requestData.getVariance().get(18), requestData.getVariance().get(19), requestData.getVariance().get(20),  requestData.getVariance().get(21), requestData.getVariance().get(22), requestData.getVariance().get(23), requestData.getVariance().get(24), requestData.getVariance().get(25)});
        data.put("7", new Object[] {"Подбор рациона"});
        data.put("8", new Object[] { requestData.getFeedtitle().get(0), requestData.getFeedtitle().get(1), requestData.getFeedtitle().get(2), requestData.getFeedtitle().get(3), requestData.getFeedtitle().get(4), requestData.getFeedtitle().get(5), requestData.getFeedtitle().get(6), requestData.getFeedtitle().get(7), requestData.getFeedtitle().get(8), requestData.getFeedtitle().get(9), requestData.getFeedtitle().get(10), requestData.getFeedtitle().get(11), requestData.getFeedtitle().get(12),  requestData.getFeedtitle().get(13), requestData.getFeedtitle().get(14), requestData.getFeedtitle().get(15), requestData.getFeedtitle().get(16), requestData.getFeedtitle().get(17), requestData.getFeedtitle().get(18), requestData.getFeedtitle().get(19), requestData.getFeedtitle().get(20),  requestData.getFeedtitle().get(21), requestData.getFeedtitle().get(22), requestData.getFeedtitle().get(23), requestData.getFeedtitle().get(24), requestData.getFeedtitle().get(25)});
        for (Object ob : requestData.getFeeds()) {
            System.out.println(ob);
            if (ob instanceof List) {
                List<?> feedList = (List<?>) ob;
                Object[] row = feedList.toArray();
                System.out.println(row);
                data.put(index.toString(), row);

            } else {
                System.out.println("Неизвестный тип объекта");
            }
            index++;
        }

        // Iterating over data and writing it to sheet
        Set<String> keyset = data.keySet();

        int rownum = 0;

        for (String key : keyset) {

            // Creating a new row in the sheet
            Row row = sheet.createRow(rownum++);

            Object[] objArr = data.get(key);

            int cellnum = 0;

            for (Object obj : objArr) {

                // This line creates a cell in the next
                // column of that row
                Cell cell = row.createCell(cellnum++);

                if (obj instanceof String) cell.setCellValue((String)obj);

                else if (obj instanceof Integer) cell.setCellValue((Integer)obj);
            }
        }

        // Try block to check for exceptions
        try {

            // Writing the workbook
            FileOutputStream out = new FileOutputStream(
                    new File("Название файла.xlsx"));
            workbook.write(out);

            // Closing file output connections
            out.close();

            // Console message for successful execution of
            // program
            System.out.println(
                    "Название файла.xlsx written successfully on disk.");
        }

        // Catch block to handle exceptions
        catch (Exception e) {

            // Display exceptions along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
    }
}
