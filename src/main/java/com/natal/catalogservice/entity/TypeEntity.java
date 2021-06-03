package com.natal.catalogservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "type")
@NoArgsConstructor
public class TypeEntity extends EntityClass {

    public TypeEntity(String name) {
        this.name = name;
    }

    @Column(name = "name")
    private String name;

}
