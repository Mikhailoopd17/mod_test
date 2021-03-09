package com.example.mod_test.dto;

import com.example.mod_test.base.BaseClass;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseEntityDTO extends BaseClass {
    private String question;
    private String answer;
}
