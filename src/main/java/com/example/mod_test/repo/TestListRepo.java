package com.example.mod_test.repo;

import com.example.mod_test.entity.TestList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TestListRepo extends MongoRepository<TestList, String> {
    List<TestList> findAllByActive(Boolean active);
}
