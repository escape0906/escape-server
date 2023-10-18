package com.example.escape.entity;

import lombok.Getter;

import javax.persistence.*;

@Table(name = "theme")
@Getter
@Entity
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String thumbnail;
    private String genre;
    private String store;
    private String address;
    private int playTime;
    private String recommendedPeople;
    private int maximumPeople;
}
