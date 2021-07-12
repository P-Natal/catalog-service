package com.natal.catalogservice.facade;


import com.natal.catalogservice.controller.ProductTO;
import com.natal.catalogservice.controller.TypeTO;
import com.natal.catalogservice.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductTO> findProducts();
    List<TypeTO> findTypes();
    ProductTO findProductByCode(String productCode);
    void persistProducts(List<ProductTO> products);
    void persistType(TypeTO type);
}
