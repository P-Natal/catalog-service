package com.natal.catalogservice.service;

import com.natal.catalogservice.controller.dto.ProductTO;
import com.natal.catalogservice.controller.dto.TypeTO;
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
    public List<ProductTO> findProducts() {
        log.info("Iniciando busca por produtos");
        List<ProductTO> products = new ArrayList<>();
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
    public List<TypeTO> findTypes() {
        List<TypeEntity> typeEntities = typeRepository.findAll();
        List<TypeTO> typesTO = new ArrayList<>();
        for (TypeEntity typeEntity : typeEntities){
            typesTO.add(new TypeTO(typeEntity.getId(), typeEntity.getName(), typeEntity.getRegistryDate()));
        }
        return typesTO;
    }

    @Override
    public ProductTO findProductByCode(String productCode) {
        log.info("Iniciando busca por produto com codigo [{}]", productCode);
        ProductTO product;
        try {
            ProductEntity productEntitie = productRepository.findByCode(productCode);
            return adapter.adapt(productEntitie);
        }
        catch (Exception e){
            log.error("Falha ao consultar produtos ", e);
            return null;
        }
    }

    @Override
    public List<ProductTO> findProductsByTypeName(String typeName) {
        return null;
    }

    @Override
    public void insertProduct(Product product) {

    }

    @Override
    public void persistProducts(List<ProductTO> products) {
        List<ProductEntity> productEntities = convertToEntity(products);
        if (!productEntities.isEmpty()){
            productRepository.saveAll(productEntities);
        }
    }

    @Override
    public void persistType(TypeTO type) {
        TypeEntity typeEntity = convertToEntity(type);
        if (typeEntity!=null){
            typeRepository.save(typeEntity);
        }else {
            log.error("Falha ao persistir Type");
        }
    }

    private List<ProductEntity> convertToEntity(List<ProductTO> products) {
        List<ProductEntity> productEntities = new ArrayList<>();
        try {
            for(ProductTO product : products){
                TypeEntity typeEntity = typeRepository.findByName(product.getType());
                if(typeEntity != null){
                    productEntities.add(adapter.adapt(product, typeEntity));
                }
                else {
                    log.error("Tipo de produto recebido inválido! [{}]", product.getType());
                }
            }
        }
        catch (Exception e){
            log.error("Falha ao persistir lista de produtos ", e);
        }
        return productEntities;
    }


    private TypeEntity convertToEntity(TypeTO type) {
        TypeEntity typeEntity = new TypeEntity();
        try {
            typeEntity = adapter.adapt(type);
        }
        catch (Exception e){
            log.error("Falha ao converter objeto transacional para entidade (Type) ", e);
        }
        return typeEntity;
    }

    private boolean isTypeValid(String productType) {
        List<TypeEntity> typeEntities = typeRepository.findAll();
        return typeEntities.stream().anyMatch(n -> n.getName().equals(productType));
    }

}
