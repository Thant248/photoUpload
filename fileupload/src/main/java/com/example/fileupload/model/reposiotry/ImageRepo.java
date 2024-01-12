package com.example.fileupload.model.reposiotry;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.fileupload.model.entity.Image;

public interface ImageRepo extends JpaRepositoryImplementation<Image, Integer> {

    Optional<Image> findByName(String name);
}
