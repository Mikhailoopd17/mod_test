package com.example.mod_test.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseClass {
    private String id;
    private LocalDateTime created;
    private Boolean active;
}
