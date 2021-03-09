package com.example.mod_test.entity;

import com.example.mod_test.base.BaseClass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Getter
@Setter
@Document
public class TestEntity extends BaseClass {
    private String respondentId;
    private String testListId;
    private List<String> answerIds;
}
