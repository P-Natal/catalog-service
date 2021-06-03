package com.natal.catalogservice.controller;

import com.natal.catalogservice.domain.Product;
import com.natal.catalogservice.facade.ProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductFacade productFacade;

    @GetMapping("/all")
    public List<Product> getProductList(){
        return productFacade.findProducts();
    }

}
