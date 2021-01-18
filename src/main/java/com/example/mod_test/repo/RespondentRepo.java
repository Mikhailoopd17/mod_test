package com.example.mod_test.repo;

import com.example.mod_test.entity.Respondent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RespondentRepo extends MongoRepository<Respondent, String> {
}
