package com.example.mod_test.rest;

import com.example.mod_test.entity.Question;
import com.example.mod_test.entity.ResponseEntity;
import com.example.mod_test.repo.QuestionRepo;
import com.example.mod_test.repo.ResponseEntityRepo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "${web.prefix}/responses", produces = "application/json; charset=UTF-8")
public class ResponseEntityController {
    private ResponseEntityRepo responseEntityRepo;
    private QuestionRepo questionRepo;

    public ResponseEntityController(ResponseEntityRepo responseEntityRepo, QuestionRepo questionRepo) {
        this.responseEntityRepo = responseEntityRepo;
        this.questionRepo = questionRepo;
    }

    @GetMapping
    public List<ResponseEntity> list() {
        return responseEntityRepo.findAllByActive(true);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ResponseEntity entity) {
        Question question = questionRepo.findById(entity.getQuestionId()).get();
        entity.setCreated(LocalDateTime.now());
        entity.setActive(true);

        return responseEntityRepo.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        ResponseEntity entity = responseEntityRepo.findById(id).get();
        entity.setActive(false);
        responseEntityRepo.save(entity);
    }
}
