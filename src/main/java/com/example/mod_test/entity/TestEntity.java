package com.example.mod_test.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class TestEntity extends BaseClass {
    private String respondent;
    private List<String> responseEntityIds;
}
