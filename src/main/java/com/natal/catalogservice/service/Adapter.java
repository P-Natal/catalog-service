package com.natal.catalogservice.service;

import com.natal.catalogservice.controller.dto.ProductTO;
import com.natal.catalogservice.controller.dto.TypeTO;
import com.natal.catalogservice.domain.Product;
import com.natal.catalogservice.domain.Type;
import com.natal.catalogservice.entity.ProductEntity;
import com.natal.catalogservice.entity.TypeEntity;
import org.springframework.stereotype.Component;

@Component
public class Adapter {

    public ProductTO adapt(ProductEntity entity){
        return new ProductTO(
                entity.getId(),
                entity.getCode(),
                entity.getName(),
                entity.getTypeEntity().getName(),
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

    public ProductEntity adapt(ProductTO product, TypeEntity typeEntity){
        return new ProductEntity(
                product.getCode(),
                product.getName(),
                typeEntity,
                product.getPrice(),
                product.isAvailable()
        );
    }

    public TypeEntity adapt(Type type){
        return new TypeEntity(
                type.getName()
        );
    }

    public TypeEntity adapt(TypeTO type) {
        return new TypeEntity(
                type.getName()
        );
    }
}
