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
import org.springframework.transaction.TransactionSystemException;

import javax.persistence.RollbackException;
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



    @Test(expected = TransactionSystemException.class)
    public void testAddToCart_whenValidRequest_thenCreateCart() throws RollbackException {


        Customer customer = customerSteps.createCustomer();
        Product product = productSteps.createProduct();

        AddProductToCartRequest request = new AddProductToCartRequest();
        request.setCustomerId(customer.getId());
        request.setProductId(product.getId());

        cartService.addProductToCart(request);

        CartResponse cart = cartService.getCart(customer.getId());

        assertThat(cart, notNullValue());
        assertThat(cart.getId(), is(customer.getId()));
        assertThat(cart.getProducts(),notNullValue());
        assertThat(cart.getProducts(), hasSize(1));

        Iterator<ProductInCartResponse> iterator = cart.getProducts().iterator();
        assertThat(iterator.hasNext(), is(true));

        ProductInCartResponse productFromCart = cart.getProducts().iterator().next();

        assertThat(productFromCart, notNullValue());
        assertThat(productFromCart.getId(), is(product.getId()));
        assertThat(productFromCart.getName(), is(product.getName()));
        assertThat(productFromCart.getPrice(), is(product.getPrice()));
        //assertThat(productFromCart.getQuantity(), is(product.getQuantity()));



    }

}
