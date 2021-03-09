package com.example.mod_test.rest;

import com.example.mod_test.base.BaseController;
import com.example.mod_test.base.Page;
import com.example.mod_test.base.PageParams;
import com.example.mod_test.dto.questions.QuestionParams;
import com.example.mod_test.entity.Question;
import com.example.mod_test.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${web.prefix}/questions", produces = "application/json; charset=UTF-8")
public class QuestionController extends BaseController<Question, QuestionService, QuestionParams> {

    @Autowired
    private QuestionService questionService;

    public QuestionController(QuestionService service) {
        super(service);
    }


}
