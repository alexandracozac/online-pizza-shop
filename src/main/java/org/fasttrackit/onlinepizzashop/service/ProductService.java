package org.fasttrackit.onlinepizzashop.service;

import org.fasttrackit.onlinepizzashop.persistance.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

    private final ProductRepository productRepository;     //IoC

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



}
