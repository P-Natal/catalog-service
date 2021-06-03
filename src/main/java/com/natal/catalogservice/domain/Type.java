package com.natal.catalogservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Type {

    private Long id;

    private String name;

    private Date registryDate;

}
