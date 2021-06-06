package com.natal.catalogservice.controller;

import lombok.Data;

import java.util.Date;

@Data
public class ProductTO {

    private Long id;

    private String code;

    private String name;

    private String type;

    private int price;

    private boolean available;

    private Date registryDate;

    private Date lastUpdate;
}
