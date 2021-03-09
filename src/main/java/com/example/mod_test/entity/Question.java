package com.example.mod_test.entity;

import com.example.mod_test.base.BaseClass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class Question extends BaseClass {
    private String question;
    private String prompt;
}
