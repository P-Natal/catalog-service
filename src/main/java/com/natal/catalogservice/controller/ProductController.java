package com.natal.catalogservice.controller;

import com.natal.catalogservice.domain.Product;
import com.natal.catalogservice.facade.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProductList(){
        return productService.findProducts();
    }

    @PostMapping
    public void setProductList(@RequestBody List<ProductTO> products){
        productService.persistProducts(products);
    }
}
