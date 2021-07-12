package com.natal.catalogservice.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class TypeTO {

    private Long id;

    @JsonProperty(required = true)
    private String name;

    private Date registryDate;
}

