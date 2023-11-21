package com.example.escape.dto;

import com.example.escape.util.Type;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@Setter
@ToString
public class SearchCondition {

    private String keyword;
    private Type type;
    private Integer difficult;
    private String address;

    public boolean hasDifficult() {
        return difficult != null;
    }

    public boolean hasAddress() {
        return StringUtils.hasText(address);
    }

}
