package org.fasttrackit.onlinepizzashop.transfer.review;

import org.fasttrackit.onlinepizzashop.domain.Product;

import javax.validation.constraints.NotNull;

public class SaveReviewRequest {

    @NotNull
    private Long customerId;
    @NotNull
    private Long productId;
    private Product product;
    @NotNull
    private String content;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SaveReviewRequest{" +
                "customerId=" + customerId +
                ", productId=" + productId +
                ", product=" + product +
                ", content='" + content + '\'' +
                '}';
    }
}
