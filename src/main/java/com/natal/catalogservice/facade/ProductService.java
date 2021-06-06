package com.natal.catalogservice.facade;


import com.natal.catalogservice.controller.ProductTO;
import com.natal.catalogservice.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> findProducts();
    List<Product> findProductsByTypeName(String typeName);
    void insertProduct(Product product);
    void persistProducts(List<ProductTO> products);
}
