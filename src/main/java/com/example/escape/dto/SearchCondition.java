package com.example.escape.dto;

import com.example.escape.util.Type;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class SearchCondition {

    @NotBlank
    private String keyword;
    private Type type;
    private Integer[] difficult;
    private String[] address;

    public boolean hasDifficult() {
        return difficult != null && difficult.length != 0;
    }

    public boolean hasAddress() {
        return address != null && address.length != 0;
    }

}
