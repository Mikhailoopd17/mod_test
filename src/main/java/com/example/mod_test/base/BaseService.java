package com.example.mod_test.base;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public class BaseService<T extends BaseClass, R extends BaseRepository, P extends BaseParams> {
    public MongoTemplate mongoTemplate;
    private R repository;
    private Class<T> tClass;

    public List<T> getList(Boolean withDeleted) {
        if (withDeleted) {
            return repository.findAll();
        } else {
            return repository.findAllByActive(true);
        }
    }

    public Page<T> getListByParams(PageParams<P> params) {
        final P requestParams = params.getParams();
        Query query = new Query();

        if (requestParams.getIds() != null && !requestParams.getIds().isEmpty()) {
            query.addCriteria(Criteria.where("_id").in(requestParams.getIds()));
        }
        if (requestParams.getWithDeleted() == null || !requestParams.getWithDeleted()) {
            query.addCriteria(Criteria.where("active").is(true));
        }
        if (requestParams.getDateFrom() != null && requestParams.getDateTo() != null) {
            query.addCriteria(Criteria.where("created").gte(requestParams.getDateFrom()).lt(requestParams.getDateTo()));
        }

        if (requestParams.getOrderBy() != null) {
            query.with(Sort.by(requestParams.getOrderDir(), requestParams.getOrderBy()));
        }
        long count = mongoTemplate.count(query, tClass);

        query.limit(params.getPageSize());
        query.skip(params.getPage() > 1 ? (params.getPage() - 1) * params.getPageSize() : 0);

        List<T> list = mongoTemplate.find(query, tClass);

        return new Page<>(count, list);
    }

    public T create(T entity) {
        entity.setActive(true);
        entity.setCreated(LocalDateTime.now());
        return (T)repository.save(entity);
    }

    public T update(T entity) {
        return (T)repository.save(entity);
    }

    public void delete(String id) {
        T entity = (T) repository.findById(id).get();
        entity.setActive(Boolean.FALSE);
        repository.save(entity);
    }

    public void deleteForever(String id) {
        repository.deleteById(id);
    }
}
