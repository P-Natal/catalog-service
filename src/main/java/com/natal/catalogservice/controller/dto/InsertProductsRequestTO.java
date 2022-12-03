package com.natal.catalogservice.controller.dto;

import com.natal.catalogservice.controller.dto.ProductTO;
import lombok.Data;

import java.util.List;

@Data
public class InsertProductsRequestTO {
    List<ProductTO> products;
}
