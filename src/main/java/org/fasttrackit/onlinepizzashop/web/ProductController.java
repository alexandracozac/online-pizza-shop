package org.fasttrackit.onlinepizzashop.web;


import org.fasttrackit.onlinepizzashop.domain.Product;
import org.fasttrackit.onlinepizzashop.service.ProductService;
import org.fasttrackit.onlinepizzashop.transfer.product.GetProductsRequest;
import org.fasttrackit.onlinepizzashop.transfer.product.ProductResponse;
import org.fasttrackit.onlinepizzashop.transfer.product.SaveProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid SaveProductRequest request) {
        Product product = productService.createProduct(request);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Product product = productService.getProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getProducts(GetProductsRequest request, Pageable pageable) {
        Page<ProductResponse> products = productService.getProducts(request, pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody @Valid SaveProductRequest request) {
        Product product = productService.updateProduct(id, request);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
