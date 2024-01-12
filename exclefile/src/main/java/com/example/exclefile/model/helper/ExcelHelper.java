package com.example.exclefile.model.helper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

import com.example.exclefile.model.enitty.Employee;


public class ExcelHelper {

    private static final String EXCEL_FILE_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    public static boolean checkExcelFileType(MultipartFile file){

        String type = file.getContentType();
        
        if(type.equals(EXCEL_FILE_TYPE)){
            return true;
        }else{
            return false;
        }
    }

    public static List<Employee> convetExcelToListOfEmployee(InputStream is) {

        List<Employee> list = new ArrayList<>();

        try {

            XSSFWorkbook works = new XSSFWorkbook(is);

            XSSFSheet sheet = works.getSheet("emp_data");

            int rowNumber = 0;

            Iterator<Row> rows =  sheet.iterator();

            while (rows.hasNext()) {
                
                Row row = rows.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cell = row.iterator();

                int cid = 0;

                Employee emp = new Employee();

                while (cell.hasNext()) {
                    
                    Cell cells = cell.next();

                    switch (cid) {
                        case 0:
                            emp.setId((int) cells.getNumericCellValue());
                            break;
                        case 1:
                            emp.setFirstName(cells.getStringCellValue());
                            break;
                        case 2:
                            emp.setLastName(cells.getStringCellValue());
                            break;
                        case 3:
                            emp.setAddress(cells.getStringCellValue());
                            break;
                        case 4:
                          emp.setAge((int) cells.getNumericCellValue());
                            break;
                        case 5:
                            emp.setEmail(cells.getStringCellValue());
                            break;
                        case 6:
                            emp.setGender(cells.getStringCellValue());
                            break;
                        case 7:
                            emp.setGoal(cells.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;
                }
               list.add(emp);
            }

        } catch (IOException e) {

            e.printStackTrace();
    
        }

        return list;
    }

}
