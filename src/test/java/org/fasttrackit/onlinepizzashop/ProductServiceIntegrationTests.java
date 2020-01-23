package org.fasttrackit.onlinepizzashop;

import org.fasttrackit.onlinepizzashop.domain.Product;
import org.fasttrackit.onlinepizzashop.exception.ResourceNotFoundException;
import org.fasttrackit.onlinepizzashop.service.ProductService;
import org.fasttrackit.onlinepizzashop.steps.ProductSteps;
import org.fasttrackit.onlinepizzashop.transfer.product.SaveProductRequest;
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
public class ProductServiceIntegrationTests {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductSteps productSteps;

    @Test
    public void testCreateProduct_whenValidRequest_thenProductIsSaved() {
        productSteps.createProduct();
    }

    @Test(expected = TransactionSystemException.class)
    public void testCreateProduct_whenInvalidRequest_thenThrowException() {
        SaveProductRequest request = new SaveProductRequest();

        productService.createProduct(request);
    }

    @Test
    public void testGetProduct_whenExistingProduct_thenReturnProduct() {
        Product createdProduct = productSteps.createProduct();

        Product product = productService.getProduct(createdProduct.getId());

        assertThat(product, notNullValue());
        assertThat(product.getId(), is(createdProduct.getId()));
        assertThat(product.getName(), is(createdProduct.getName()));
        assertThat(product.getPrice(), is(createdProduct.getPrice()));
        assertThat(product.getQuantity(), is(createdProduct.getQuantity()));
        assertThat(product.getDescription(), is(createdProduct.getDescription()));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetProduct_whenNonExistingProduct_thenThrowResourceNotFoundException() {
        productService.getProduct(9999999999L);
    }

    @Test
    public void testUpdateProduct_whenValidRequest_thenReturnUpdatedProduct() {
        Product createdProduct = productSteps.createProduct();

        SaveProductRequest request = new SaveProductRequest();
        request.setName(createdProduct.getName() + " updated");
        request.setDescription(createdProduct.getDescription() + " updated");
        request.setPrice(createdProduct.getPrice() + 2);
        request.setQuantity(createdProduct.getQuantity() + 10);

        Product updatedProduct =
                productService.updateProduct(createdProduct.getId(), request);

        assertThat(updatedProduct, notNullValue());
        assertThat(updatedProduct.getId(), is(createdProduct.getId()));
        assertThat(updatedProduct.getName(), is(request.getName()));
        assertThat(updatedProduct.getDescription(), is(request.getDescription()));
        assertThat(updatedProduct.getPrice(), is(request.getPrice()));
        assertThat(updatedProduct.getQuantity(), is(request.getQuantity()));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testDeleteProduct_whenExistingProduct_thenProductIsDeleted() {
        Product product = productSteps.createProduct();

        productService.deleteProduct(product.getId());

        productService.getProduct(product.getId());
    }

}