package org.fasttrackit.onlinepizzashop.transfer.review;

import javax.validation.constraints.NotNull;

public class AddReviewToProductRequest {

    @NotNull
    private Long customerId;
    @NotNull
    private Long productId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "AddReviewToProductRequest{" +
                "customerId=" + customerId +
                ", productId=" + productId +
                '}';
    }
}
