package com.natal.catalogservice.service;

import com.natal.catalogservice.domain.Product;
import com.natal.catalogservice.entity.ProductEntity;
import com.natal.catalogservice.entity.TypeEntity;
import com.natal.catalogservice.facade.ProductService;
import com.natal.catalogservice.repository.ProductRepository;
import com.natal.catalogservice.repository.TypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ProductFacade implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private Adapter adapter;

    @Override
    public List<Product> findProducts() {
        log.info("Iniciando busca por produtos");
        List<Product> products = new ArrayList<>();
        try {
            List<ProductEntity> productEntities = productRepository.findAll();
            for (ProductEntity p : productEntities){
                products.add(adapter.adapt(p));
            }
            return products;
        }
        catch (Exception e){
            log.error("Falha ao consultar produtos ", e);
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
        try {
            ProductEntity productEntity = adapter.adapt(product);
            ProductEntity productEntityPersisted = productRepository.save(productEntity);
            log.info("sucesso ao persistir produto: {}", productEntityPersisted);
        }
        catch (Exception e){
            log.error("erro ao persistir produto ", e);
        }
    }


}
