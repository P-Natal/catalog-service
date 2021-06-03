package com.natal.catalogservice.service;

import com.natal.catalogservice.domain.Product;
import com.natal.catalogservice.entity.ProductEntity;
import com.natal.catalogservice.entity.TypeEntity;
import com.natal.catalogservice.facade.ProductFacade;
import com.natal.catalogservice.repository.ProductRepository;
import com.natal.catalogservice.repository.TypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductService implements ProductFacade {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private Adapter adapter;

    @Override
    public List<Product> findProducts() {
        List<Product> products = new ArrayList<>();
        List<ProductEntity> productEntities = productRepository.findAll();

        for (ProductEntity p : productEntities){
            products.add(adapter.adapt(p));
        }

        return products;
    }

    @Override
    public List<Product> findProductsByTypeName(String typeName) {
        List<Product> products = new ArrayList<>();

        TypeEntity typeEntity = typeRepository.findByName(typeName);
        if (typeEntity==null){
            log.error("erro ao buscar type");
        }
        else {
            log.info("sucesso ao buscar type: {}", typeEntity);
        }

        List<ProductEntity> productEntities = productRepository.findByType(typeEntity);
        if (productEntities==null){
            log.error("erro ao buscar produtos");
        }
        else {
            log.info("sucesso ao buscar produtos: {}", productEntities);
        }

        for (ProductEntity p : productEntities){
            products.add(adapter.adapt(p));
        }

        return products;
    }


    @Override
    public void insertProduct(Product product){
        ProductEntity productEntity = adapter.adapt(product);
        ProductEntity productEntityPersisted = productRepository.save(productEntity);
        if (productEntityPersisted==null){
            log.error("erro ao persistir produto");
        }
        else {
            log.info("sucesso ao persistir produto: {}", productEntityPersisted);
        }
    }


}
