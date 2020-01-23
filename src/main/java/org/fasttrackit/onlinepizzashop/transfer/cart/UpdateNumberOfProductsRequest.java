package org.fasttrackit.onlinepizzashop.transfer.cart;

import javax.validation.constraints.NotNull;

public class UpdateNumberOfProductsRequest {

    @NotNull
    private Long productId;
    @NotNull
    private Integer newNumber;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getNewNumber() {
        return newNumber;
    }

    public void setNewNumber(Integer newNumber) {
        this.newNumber = newNumber;
    }


    @Override
    public String toString() {
        return "UpdateNumberOfProductsRequest{" +
                "productId=" + productId +
                ", newNumber=" + newNumber +
                '}';
    }
}
