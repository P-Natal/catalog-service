package com.natal.catalogservice.controller;

import lombok.Data;

import java.util.List;

@Data
public class InsertProductsRequest {
    List<ProductTO> products;
}
