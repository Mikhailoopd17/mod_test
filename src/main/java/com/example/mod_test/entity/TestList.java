package com.example.mod_test.entity;

import com.example.mod_test.base.BaseClass;
import com.example.mod_test.base.BaseImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document
public class TestList extends BaseClass implements BaseImpl {
    private String name;
    private Integer level = 1;
    private Integer maxQuestionCount = 10;
    private List<String> answerIds;

    @Override
    public List getEntryIds() {
        return answerIds;
    }

    @Override
    public void setEntryList(List dtos) {}
}
