package org.fasttrackit.onlinepizzashop.steps;


import org.fasttrackit.onlinepizzashop.domain.Product;
import org.fasttrackit.onlinepizzashop.service.ProductService;
import org.fasttrackit.onlinepizzashop.transfer.product.SaveProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@Component
public class ProductSteps {

    @Autowired
    private ProductService productService;


    public Product createProduct(){

        SaveProductRequest request = new SaveProductRequest();
        request.setName("Pizza Margherita");
        request.setDescription("Tomato sauce, mozzarella");
        request.setPrice(12.0);
        request.setQuantity(50);

        Product createdProduct = productService.createProduct(request);

        assertThat(createdProduct, notNullValue());
        assertThat(createdProduct.getId(), notNullValue());
        assertThat(createdProduct.getId(), greaterThan(0L));
        assertThat(createdProduct.getName(), is(request.getName()));
        assertThat(createdProduct.getPrice(), is(request.getPrice()));
        assertThat(createdProduct.getQuantity(), is(request.getQuantity()));
        assertThat(createdProduct.getDescription(), is(request.getDescription()));

        return createdProduct;



    }

}
