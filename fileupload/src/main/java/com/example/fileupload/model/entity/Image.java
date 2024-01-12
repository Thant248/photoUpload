package com.example.fileupload.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ImageData")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String name;

    private String type;
    
    @Column(name ="image_data", length = 10000000)
    private byte[] ImageData;
    
}
