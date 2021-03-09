package com.example.mod_test.entity;

import com.example.mod_test.base.BaseClass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document
public class Respondent extends BaseClass {
    private String firstName;
    private String secondName;
    private String lastName;
    private Integer userId;
    private List<String> testEntryIds;
}
