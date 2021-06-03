package com.natal.catalogservice.facade;


import com.natal.catalogservice.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductFacade {

    List<Product> findProducts();

    List<Product> findProductsByTypeName(String typeName);

    void insertProduct(Product product);

}
