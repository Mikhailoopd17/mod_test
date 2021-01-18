package com.example.mod_test.repo;

import com.example.mod_test.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepo extends MongoRepository<Question, String> {
    List<Question> findAllByActive(Boolean active);
}
