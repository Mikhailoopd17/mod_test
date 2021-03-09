package com.example.mod_test.dto.questions;

import com.example.mod_test.base.BaseParams;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QuestionParams extends BaseParams {
    private String questionText;
}
