package com.example.mod_test.rest;

import com.example.mod_test.entity.Respondent;
import com.example.mod_test.repo.RespondentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${web.prefix}/respondents", produces = "application/json; charset=UTF-8")
public class RespondentController {
    private RespondentRepo respondentRepo;

    @Autowired
    public RespondentController(RespondentRepo respondentRepo) {
        this.respondentRepo = respondentRepo;
    }

    @GetMapping
    public List<Respondent> list () {
        return respondentRepo.findAll();
    }

    @PostMapping
    public Respondent create(@RequestBody Respondent respondent) {
        return respondentRepo.save(respondent);
    }

    @PutMapping("/{id}")
    public Respondent update(@RequestBody Respondent newRespondent,
                             @PathVariable String id) {
        Respondent oldRespondent = respondentRepo.findById(id).get();
        oldRespondent.setLastName(newRespondent.getLastName());
        oldRespondent.setSecondName(newRespondent.getSecondName());
        oldRespondent.setFirstName(newRespondent.getFirstName());

        return respondentRepo.save(oldRespondent);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        respondentRepo.deleteById(id);
    }
 }
