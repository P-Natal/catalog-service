package com.natal.catalogservice.controller;

import com.natal.catalogservice.facade.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getProductList(){
        List<ProductTO> productsTO;
        productsTO = productService.findProducts();
        if (!productsTO.isEmpty()){
            return ResponseEntity.ok(productsTO);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/type")
    public ResponseEntity<?> getTypeList(){
        List<TypeTO> typesTO;
        typesTO = productService.findTypes();
        if (!typesTO.isEmpty()){
            return ResponseEntity.ok(typesTO);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<?> getProductList(@PathVariable(value = "productCode") String productCode){
        ProductTO productTO;
        productTO = productService.findProductByCode(productCode);
        if (productCode != null){
            return ResponseEntity.ok(productTO);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/type")
    public ResponseEntity<?> createProductType(@RequestBody TypeTO type){
        try{
            productService.persistType(type);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> createProductList(@RequestBody InsertProductsRequest products){
        try{
            productService.persistProducts(products.getProducts());
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
