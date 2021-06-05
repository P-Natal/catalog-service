package com.natal.catalogservice.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "type")
public class TypeEntity extends EntityClass {

    @Column(name = "name")
    private String name;

    public TypeEntity() {
    }

    public TypeEntity(String name) {
        this.name = name;
    }
}
