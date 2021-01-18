package com.example.mod_test.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseEntity extends BaseClass {
    private String questionId;
    private String answer;
}
