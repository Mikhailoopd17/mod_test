package com.example.mod_test.repo;

import com.example.mod_test.entity.ResponseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ResponseEntityRepo extends MongoRepository<ResponseEntity, String> {
    List<ResponseEntity> findAllByActive(Boolean active);
}
