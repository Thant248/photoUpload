package com.example.exclefile.model.service;

import java.util.*;
import com.example.exclefile.model.enitty.*;
import com.example.exclefile.model.helper.ExcelHelper;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.exclefile.model.repository.EmployeeReposiotry;

import lombok.RequiredArgsConstructor;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeReposiotry reposiotry;

    public void saveFromExcel(MultipartFile file){
    
        try {
            List<Employee> employees = ExcelHelper.convetExcelToListOfEmployee(file.getInputStream());
        reposiotry.saveAll(employees);
        } catch (IOException o) {
            o.printStackTrace();
            
    }
}

    public List<Employee> getAllEmployee() {
        return reposiotry.findAll();
    }

}
