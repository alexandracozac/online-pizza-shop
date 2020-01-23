package org.fasttrackit.onlinepizzashop;

import org.fasttrackit.onlinepizzashop.domain.Cart;
import org.fasttrackit.onlinepizzashop.domain.Customer;
import org.fasttrackit.onlinepizzashop.domain.Product;
import org.fasttrackit.onlinepizzashop.exception.ResourceNotFoundException;
import org.fasttrackit.onlinepizzashop.service.CartService;
import org.fasttrackit.onlinepizzashop.steps.CustomerSteps;
import org.fasttrackit.onlinepizzashop.steps.ProductSteps;
import org.fasttrackit.onlinepizzashop.transfer.cart.AddProductToCartRequest;
import org.fasttrackit.onlinepizzashop.transfer.cart.CartResponse;
import org.fasttrackit.onlinepizzashop.transfer.product.GetProductsRequest;
import org.fasttrackit.onlinepizzashop.transfer.product.ProductInCartResponse;
import org.fasttrackit.onlinepizzashop.transfer.product.ProductResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceIntegrationTests {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerSteps customerSteps;

    @Autowired
    private ProductSteps productSteps;

    @Test
    public void testAddToCart_whenValidRequest_thenCreateCart() throws ResourceNotFoundException {
        Product product = productSteps.createProduct();
        Customer customer = customerSteps.createCustomer();

        AddProductToCartRequest request = new AddProductToCartRequest();
        request.setCustomerId(customer.getId());
        request.setProductId(product.getId());

        cartService.addProductToCart(request);

        CartResponse cart = cartService.getCart(customer.getId());

        assertThat(cart, notNullValue());
        assertThat(cart.getId(), notNullValue());

        assertThat(cart.getProducts(), notNullValue());
        assertThat(cart.getProducts(), hasSize(1));

        ProductInCartResponse productInCartResponse = cart.getProducts().iterator().next();
        assertThat(productInCartResponse, notNullValue());
        assertThat(productInCartResponse.getId(), is(request.getProductId()));
        assertThat(productInCartResponse.getName(), is(product.getName()));
        assertThat(productInCartResponse.getPrice(), is(product.getPrice()));

    }
}
