package com.example.mod_test.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
public class PageParams<T> implements Serializable {
    private int pageSize = 20;
    private int page = 1;
    private T params;
}
