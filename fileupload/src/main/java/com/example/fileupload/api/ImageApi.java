package com.example.fileupload.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileupload.model.service.ImageService;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController

public class ImageApi{

    @Autowired
    private ImageService service;
   
   @PostMapping("upload")
    public ResponseEntity<?> uploadImage (@RequestParam("file") MultipartFile file) throws IOException{

        String uploadImage = service.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);

    }


    
    @GetMapping("download/${name}")
    public ResponseEntity<?> downloadImage (@PathVariable String name){

        byte[] imageData = service.downloadImage(name);

        return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.valueOf("img/png")).body(imageData);
    }


    
}
