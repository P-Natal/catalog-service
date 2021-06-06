package com.natal.catalogservice.service;

import com.natal.catalogservice.domain.Product;
import com.natal.catalogservice.domain.Type;
import com.natal.catalogservice.entity.ProductEntity;
import com.natal.catalogservice.entity.TypeEntity;
import org.springframework.stereotype.Component;
import com.natal.catalogservice.controller.*;

@Component
public class Adapter {

    public Product adapt(ProductEntity entity){
        return new Product(
                entity.getId(),
                entity.getCode(),
                entity.getName(),
                adapt(entity.getTypeEntity()),
                entity.getPrice(),
                entity.isAvailable(),
                entity.getRegistryDate(),
                entity.getLastUpdate()
        );
    }

    public Type adapt(TypeEntity entity){
        return new Type(
                entity.getId(),
                entity.getName(),
                entity.getRegistryDate()
        );
    }

    public ProductEntity adapt(Product product){
        return new ProductEntity(
                product.getCode(),
                product.getName(),
                adapt(product.getType()),
                product.getPrice(),
                product.isAvailable()
        );
    }

    public ProductEntity adapt(ProductTO product){
        return new ProductEntity(
                product.getCode(),
                product.getName(),
                new TypeEntity(product.getType()),
                product.getPrice(),
                product.isAvailable()
        );
    }

    public TypeEntity adapt(Type type){
        return new TypeEntity(
                type.getName()
        );
    }

}
