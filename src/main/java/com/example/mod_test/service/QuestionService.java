package com.example.mod_test.service;

import com.example.mod_test.base.BaseService;
import com.example.mod_test.dto.questions.QuestionParams;
import com.example.mod_test.entity.Question;
import com.example.mod_test.repo.QuestionRepo;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "singleton")
public class QuestionService extends BaseService<Question, QuestionRepo, QuestionParams> {

    public QuestionService(MongoTemplate mongoTemplate, QuestionRepo repository) {
        super(mongoTemplate, repository, Question.class);
    }
}
