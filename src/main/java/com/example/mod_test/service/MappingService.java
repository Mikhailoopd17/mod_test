package com.example.mod_test.service;

import com.example.mod_test.base.BaseImpl;
import com.example.mod_test.dto.ResponseEntityDTO;
import com.example.mod_test.entity.*;
import com.example.mod_test.repo.QuestionRepo;
//import com.example.mod_test.repo.ResponseEntityRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MappingService {
    private ModelMapper modelMapper;
    private QuestionRepo questionRepo;
//    private ResponseEntityRepo responseEntityRepo;

    @PostConstruct
    public void init() {

        /*
         * mapping ResponseEntity.class to ResponseEntityDTO.class for questions
         */
//        Converter<String, String> questionConverter =
//                mappingContext -> map(questionRepo.findById(mappingContext.getSource()).get().getQuestion(), String.class);
//        modelMapper.typeMap(ResponseEntity.class, ResponseEntityDTO.class)
//                .addMappings(mapping -> mapping.using(questionConverter).map(ResponseEntity::getQuestionId, ResponseEntityDTO::setQuestion));

    }

    public <S, D> D map(S source, Class<D> clazz) {
        return modelMapper.map(source, clazz);
    }

    public <S, D> void map(S source, D dest) {
        modelMapper.map(source, dest);
    }

    public <S, D> List<D> mapList(List<S> sources, Class<D> clazz){
        return sources.stream()
                .map(s -> map(s, clazz))
                .collect(Collectors.toList());
    }

//    public <S extends BaseImpl, D extends BaseImpl, R> D mapObject(S source, Class<D> main, Class<R> nested) {
//        D dto = map(source, main);
//        if (!source.getEntryIds().isEmpty()) {
//            dto.setEntryList(mapList(responseEntityRepo.findAllByIds(source.getEntryIds()), nested));
//        }
//        return dto;
//    }
}
