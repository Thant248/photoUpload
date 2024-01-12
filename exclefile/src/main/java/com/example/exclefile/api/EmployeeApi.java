package com.example.exclefile.api;

import java.util.Map;
import java.util.*;
import com.example.exclefile.model.enitty.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.exclefile.model.helper.ExcelHelper;
import com.example.exclefile.model.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("files")
public class EmployeeApi {

    private final EmployeeService service;

    @PostMapping("upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){

        if (ExcelHelper.checkExcelFileType(file)) {
            
            service.saveFromExcel(file);
            return ResponseEntity.ok(Map.of("message", "Your ExcelFile has been uploaded to database."));
    }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload excel file");
}


@GetMapping
public List<Employee> getAllEmployee(){

    return service.getAllEmployee();
}
    
}