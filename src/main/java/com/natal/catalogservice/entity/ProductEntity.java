package com.natal.catalogservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "product")
@NoArgsConstructor
public class ProductEntity extends EntityClass{

    public ProductEntity(String name, TypeEntity typeEntity, int price) {
        this.name = name;
        this.typeEntity = typeEntity;
        this.price = price;
    }

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeEntity typeEntity;

    @Column(name = "price")
    private int price;

}
