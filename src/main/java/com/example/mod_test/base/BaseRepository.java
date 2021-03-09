package com.example.mod_test.base;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BaseRepository<T extends BaseClass> extends MongoRepository<T, String> {
    List<T> findAllByActive(Boolean active);

    @Query(value = "{'_id': {'$in' :?0 }, 'active' : {'eq' :?1} }")
    List<T> findAllByIds(List<String> ids, Boolean active);
}
