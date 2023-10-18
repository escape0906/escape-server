package com.example.escape.dto;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class ThemeDetailDto {

    private Long id;
    private String title;
    private String thumbnail;
    private String genre;
    private String store;
    private String address;
    private Integer playTime;
    private String recommendedPeople;
    private Integer maximumPeople;

}
