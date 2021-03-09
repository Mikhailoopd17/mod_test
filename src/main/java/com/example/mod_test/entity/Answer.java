package com.example.mod_test.entity;

import com.example.mod_test.base.BaseClass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Answer extends BaseClass {
    private String questionId;
    private String answer;
}
