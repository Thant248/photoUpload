package com.example.fileupload.model.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileupload.model.entity.Image;
import com.example.fileupload.model.reposiotry.ImageRepo;
import com.example.fileupload.model.utils.ImageUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepo repository;

 
    public String uploadImage(MultipartFile file) throws IOException {

        Image image = repository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .ImageData(ImageUtils.compressImage(file.getBytes()))
                .build());

        if (image != null) {

            return "File Upload success " + file.getOriginalFilename();
        }

        return null;
    }


    public byte[] downloadImage(String fileName) {

        Optional<Image> imageData = repository.findByName(fileName);

        byte[] images = ImageUtils.decompressImage(imageData.get().getImageData());

        return images;
    }

}
