package com.example.mod_test.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Page<T> implements Serializable {
    private Long total;
    private List<T> entryList;
}
