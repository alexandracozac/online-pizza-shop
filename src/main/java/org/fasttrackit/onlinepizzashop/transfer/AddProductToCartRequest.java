package org.fasttrackit.onlinepizzashop.transfer;

import javax.validation.constraints.NotNull;

public class AddProductToCartRequest {

    @NotNull
    private Long cartId;
    @NotNull
    private Long productId;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "AddProductToCartRequest{" +
                "cartId=" + cartId +
                ", productId=" + productId +
                '}';
    }
}
