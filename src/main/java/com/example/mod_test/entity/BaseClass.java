package com.example.mod_test.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseClass {
    @Id
    private String id;
    private LocalDateTime created;
    private Boolean active;
}
