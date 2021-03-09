package com.example.mod_test.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Data
public abstract class BaseParams {
    private List<String> ids;
    private Boolean withDeleted;
    private String orderBy;
    private Sort.Direction orderDir = Sort.Direction.ASC;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateFrom;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateTo;

    public void setOrderDir(String orderDir) {
        if (orderDir != null) {
            switch (orderDir) {
                case ("asc"):
                    this.orderDir = Sort.Direction.ASC;
                    break;
                case ("desc"):
                    this.orderDir = Sort.Direction.DESC;
            }
        }
    }


}
