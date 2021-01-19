package com.example.mod_test.rest;

import com.example.mod_test.entity.Question;
import com.example.mod_test.repo.QuestionRepo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "${web.prefix}/questions", produces = "application/json; charset=UTF-8")
public class QuestionController {
    private QuestionRepo questionRepo;

    public QuestionController(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @GetMapping
    public List<Question> list() {
        return questionRepo.findAllByActive(true);
    }

    @PostMapping
    public Question create(@RequestBody Question question) {
        question.setCreated(LocalDateTime.now());
        question.setActive(true);
        return questionRepo.save(question);
    }

    @PutMapping("/{id}")
    public Question update(@RequestBody Question newQuestion,
                           @PathVariable String id) {
        Question oldQuestion = questionRepo.findById(id).get();

        if (newQuestion.getActive() != null) {
            oldQuestion.setActive(newQuestion.getActive());
        }
        if (newQuestion.getQuestion().isEmpty()) {
            oldQuestion.setQuestion(newQuestion.getQuestion());
        }
        if (newQuestion.getPrompt().isEmpty()) {
            oldQuestion.setQuestion(newQuestion.getQuestion());
        }
        return questionRepo.save(oldQuestion);
    }

    @DeleteMapping("/{id}")
    public Question delete(@PathVariable String id) {
        Question question = questionRepo.findById(id).get();
        question.setActive(false);
        return questionRepo.save(question);
    }
}
