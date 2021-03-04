package com.example.mod_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TestList extends BaseClass implements BaseImpl{
    private String name;
    private Integer level = 1;
    private Integer maxQuestionCount = 10;
    private List<String> responseEntityIds;

    @Override
    public List getEntryIds() {
        return responseEntityIds;
    }

    @Override
    public void setEntryList(List dtos) {}
}
