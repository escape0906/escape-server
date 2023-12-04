package com.example.escape.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Store {

    //    private Long id;
    private String name;
    private String address;

}
