package com.natal.catalogservice.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "product")
public class ProductEntity extends EntityClass{

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeEntity typeEntity;

    @Column(name = "price", precision=10, scale=2)
    private double price;

    @Column(name = "available")
    private boolean available;

    public ProductEntity() {
    }

    public ProductEntity(String code, String name, TypeEntity typeEntity, double price, boolean available) {
        this.code = code;
        this.name = name;
        this.typeEntity = typeEntity;
        this.price = price;
        this.available = available;
    }
}
