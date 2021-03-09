//package com.example.mod_test.rest;
//
//import com.example.mod_test.dto.ResponseEntityDTO;
//import com.example.mod_test.entity.Question;
//import com.example.mod_test.entity.ResponseEntity;
//import com.example.mod_test.repo.QuestionRepo;
//import com.example.mod_test.repo.ResponseEntityRepo;
//import com.example.mod_test.service.MappingService;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping(value = "${web.prefix}/responses", produces = "application/json; charset=UTF-8")
//public class ResponseEntityController {
//    private ResponseEntityRepo responseEntityRepo;
//    private QuestionRepo questionRepo;
//    private MappingService mappingService;
//    private Class<ResponseEntityDTO> dtoClass;
//
//    public ResponseEntityController(ResponseEntityRepo responseEntityRepo, QuestionRepo questionRepo, MappingService mappingService) {
//        this.responseEntityRepo = responseEntityRepo;
//        this.questionRepo = questionRepo;
//        this.mappingService = mappingService;
//        this.dtoClass = ResponseEntityDTO.class;
//    }
//
//    @GetMapping
//    public List<ResponseEntityDTO> list() {
//
//        return mappingService.mapList(responseEntityRepo.findAllByActive(true), dtoClass);
////                responseEntityRepo.findAllByActive(true).stream().map(entity -> mappingService.map(entity, dtoClass)).collect(Collectors.toList());
//    }
//
//    @PostMapping
//    public ResponseEntity create(@RequestBody ResponseEntity entity) {
//        Question question = questionRepo.findById(entity.getQuestionId()).get();
//        entity.setCreated(LocalDateTime.now());
//        entity.setActive(true);
//
//        return responseEntityRepo.save(entity);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable String id) {
//        ResponseEntity entity = responseEntityRepo.findById(id).get();
//        entity.setActive(false);
//        responseEntityRepo.save(entity);
//    }
//}
