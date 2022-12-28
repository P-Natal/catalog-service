package com.natal.catalogservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
public class ProductTO {

    private Long id;

    @JsonProperty(required = true)
    @NotBlank
    private String code;

    @JsonProperty(required = true)
    @NotBlank
    private String name;

    @JsonProperty(required = true)
    @NotBlank
    private String type;

    @JsonProperty(required = true)
    @NotNull
    private double price;

    @JsonProperty(required = true)
    @NotNull
    private boolean available;

    private Date registryDate;

    private Date lastUpdate;
}
