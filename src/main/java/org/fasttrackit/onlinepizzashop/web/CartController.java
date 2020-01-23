package org.fasttrackit.onlinepizzashop.web;


import org.fasttrackit.onlinepizzashop.service.CartService;
import org.fasttrackit.onlinepizzashop.transfer.cart.AddProductToCartRequest;
import org.fasttrackit.onlinepizzashop.transfer.cart.CartResponse;
import org.fasttrackit.onlinepizzashop.transfer.product.GetProductsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {

        this.cartService = cartService;
    }

    @PutMapping
    public ResponseEntity addProductToCart(@RequestBody @Valid AddProductToCartRequest request){

        cartService.addProductToCart(request);
        return new ResponseEntity(HttpStatus.NO_CONTENT); //204

    }

    @GetMapping("/{id}") //variables
    public ResponseEntity<CartResponse> getCart(@PathVariable("id") long id){         //show cart
        CartResponse cart = cartService.getCart(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") Long id) {
        cartService.deleteCart(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
