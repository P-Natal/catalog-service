package com.natal.catalogservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Product {

    private Long id;

    private String code;

    private String name;

    private Type type;

    private int price;

    private boolean available;

    private Date registryDate;

    private Date lastUpdate;
}
