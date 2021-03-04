package com.example.mod_test.rest;

import com.example.commons.users.UserProfile;
import com.example.mod_test.dto.ResponseEntityDTO;
import com.example.mod_test.dto.TestListDTO;
import com.example.mod_test.entity.TestList;
import com.example.mod_test.repo.TestListRepo;
import com.example.mod_test.service.MappingService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.mod_test.ModTestApplication.USER_PROFILE;

@RestController
@RequestMapping(value = "${web.prefix}/testlists", produces = "application/json; charset=UTF-8")
public class TestListController {

    private TestListRepo testListRepo;
    private MappingService mappingService;
    private Class<TestListDTO> testDto;
    private Class<ResponseEntityDTO> responseDto;

    public TestListController(TestListRepo testListRepo, MappingService mappingService) {
        this.testListRepo = testListRepo;
        this.mappingService = mappingService;
        this.responseDto = ResponseEntityDTO.class;
        this.testDto = TestListDTO.class;
    }

    @GetMapping
    public List<TestListDTO> list (@RequestHeader(value = USER_PROFILE, required = false) UserProfile user) {
        List<TestList> lists = testListRepo.findAllByActive(true);
        return lists.stream()
                .map(i -> mappingService.mapObject(i, testDto, responseDto))
                .collect(Collectors.toList());
    }

    @PostMapping
    public TestList create(@RequestBody TestList testList) {
        testList.setCreated(LocalDateTime.now());
        testList.setActive(true);
        return testListRepo.save(testList);
    }
}
