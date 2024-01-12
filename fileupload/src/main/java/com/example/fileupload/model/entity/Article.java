package com.example.fileupload.model.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Article {
    

    private int id;

    public Article(){}

    public Article(int id){
        this.id = id;
    }
}
