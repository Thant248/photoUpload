package com.example.fileupload.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultiPartFile {
    

    private String name;

    private String  email;

    private MultiPartFile multiPartFile;
}
