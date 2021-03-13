package com.example.mod_test.base;


import com.example.commons.Exception.UserExceptions;
import com.example.commons.users.RoleType;
import com.example.commons.users.UserProfile;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
public class BaseController<T extends BaseClass, S extends BaseService, P extends BaseParams> {
    private S service;

    @GetMapping
    public List<T> getList(@RequestParam(value = "withDeleted", required = false, defaultValue = "true") Boolean withDeleted) {
        return service.getList(withDeleted);
    }

    @PostMapping("/by_params")
    public Page<T> getListByParams(
            @RequestHeader(value = "profile", required = false) UserProfile user,
            @RequestBody PageParams<P> params) {
        checkRules(user);
        return service.getListByParams(params);
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        return (T) service.create(entity);
    }

    @PutMapping("/{id}")
    public T update(@PathVariable String id,
                    @RequestBody T entity) {
        return (T) service.update(entity);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable String id) {
       service.delete(id);
       return HttpStatus.OK;
    }

    @DeleteMapping("/{id}/forever")
    public HttpStatus deleteForever(@PathVariable String id) {
        service.deleteForever(id);
        return HttpStatus.OK;
    }

    private void checkRules(UserProfile userProfile) {
        if (userProfile == null) {
            throw new UserExceptions.Forbidden("Доступ запрещен");
        }

        if (!userProfile.getRole().equals(RoleType.ADMIN))  {
            throw new UserExceptions.Forbidden("Доступ запрещен");
        }


    }
}
