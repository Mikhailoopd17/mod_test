package com.example.mod_test.dto;

import com.example.mod_test.base.BaseImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TestListDTO implements BaseImpl<ResponseEntityDTO> {
    private String name;
    private Integer level = 1;
    private Integer maxQuestionCount = 10;
    @JsonIgnore
    private List<String> responseEntityIds;
    private List<ResponseEntityDTO> responseEntities;

    @JsonIgnore
    @Override
    public List<String> getEntryIds() {
        return responseEntityIds;
    }

    @JsonIgnore
    @Override
    public void setEntryList(List<ResponseEntityDTO> dtos) {
        this.responseEntities = dtos;
    }
}
