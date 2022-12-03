package com.natal.catalogservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ProductTO {

    private Long id;

    @JsonProperty(required = true)
    private String code;

    @JsonProperty(required = true)
    private String name;

    @JsonProperty(required = true)
    private String type;

    @JsonProperty(required = true)
    private double price;

    @JsonProperty(required = true)
    private boolean available;

    private Date registryDate;

    private Date lastUpdate;
}
