package com.example.mod_test.repo;

import com.example.mod_test.base.BaseRepository;
import com.example.mod_test.entity.Answer;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends BaseRepository<Answer> {
}
