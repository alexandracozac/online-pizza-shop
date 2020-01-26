package org.fasttrackit.onlinepizzashop;

import org.fasttrackit.onlinepizzashop.domain.Customer;
import org.fasttrackit.onlinepizzashop.domain.Product;
import org.fasttrackit.onlinepizzashop.exception.ResourceNotFoundException;
import org.fasttrackit.onlinepizzashop.service.CartService;
import org.fasttrackit.onlinepizzashop.service.CustomerService;
import org.fasttrackit.onlinepizzashop.steps.CustomerSteps;
import org.fasttrackit.onlinepizzashop.steps.ProductSteps;
import org.fasttrackit.onlinepizzashop.transfer.cart.AddProductToCartRequest;
import org.fasttrackit.onlinepizzashop.transfer.cart.CartResponse;
import org.fasttrackit.onlinepizzashop.transfer.customer.SaveCustomerRequest;
import org.fasttrackit.onlinepizzashop.transfer.product.ProductInCartResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceIntegrationTests {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerSteps customerSteps;


    @Test(expected = TransactionSystemException.class)
    public void testCreateCustomer_whenValidRequest_thenCustomerIsSaved() {
        customerSteps.createCustomer();
    }


    @Test(expected = TransactionSystemException.class)
    public void testCreateCustomer_whenInvalidRequest_thenThrowException() {
        SaveCustomerRequest request = new SaveCustomerRequest();

        customerService.createCustomer(request);
    }

    @Test(expected = TransactionSystemException.class)
    public void testGetCustomer_whenExistingCustomer_thenReturnCustomer() {
        Customer createCustomer = customerSteps.createCustomer();
        Customer customer = customerService.getCustomer(createCustomer.getId());

        assertThat(customer, notNullValue());
        assertThat(customer.getId(), is(createCustomer.getId()));
        assertThat(customer.getFirstName(), is(createCustomer.getFirstName()));
        assertThat(customer.getLastName(), is(createCustomer.getLastName()));
    }


    @Test(expected = TransactionSystemException.class)
    public void testUpdateCustomer_whenValidRequest_thenReturnUpdatedCustomer() {
        Customer createdCustomer = customerSteps.createCustomer();

        SaveCustomerRequest request = new SaveCustomerRequest();
        request.setFirstName(createdCustomer.getFirstName() + "updated");
        request.setLastName(createdCustomer.getLastName() + "updated");

        Customer updatedCustomer = customerService.updateCustomer(createdCustomer.getId(), request);

        assertThat(updatedCustomer, notNullValue());
        assertThat(updatedCustomer.getId(), is(createdCustomer.getId()));
        assertThat(updatedCustomer.getFirstName(), is(request.getFirstName()));
        assertThat(updatedCustomer.getLastName(), is(request.getLastName()));
    }


}