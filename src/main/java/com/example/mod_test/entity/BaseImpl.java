package com.example.mod_test.entity;

import java.util.List;

public interface BaseImpl<D> {
    List getEntryIds();

    void setEntryList(List<D> dtos);
}
