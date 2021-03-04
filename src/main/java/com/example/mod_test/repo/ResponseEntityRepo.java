package com.example.mod_test.repo;

import com.example.mod_test.entity.ResponseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseEntityRepo extends MongoRepository<ResponseEntity, String> {
    List<ResponseEntity> findAllByActive(Boolean active);

    @Query(value = "{ '_id' : {'$in' : ?0 } }")
    List<ResponseEntity> findAllByIds(List<String> ids);
}
