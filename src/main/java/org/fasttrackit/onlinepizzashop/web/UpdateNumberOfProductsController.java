package org.fasttrackit.onlinepizzashop.web;


import org.fasttrackit.onlinepizzashop.service.CartService;
import org.fasttrackit.onlinepizzashop.transfer.cart.UpdateNumberOfProductsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/carts/update")
public class UpdateNumberOfProductsController {


    private final CartService cartService;

    @Autowired
    public UpdateNumberOfProductsController(CartService cartService) {
        this.cartService = cartService;
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCart(@PathVariable("id") long id,
                                     @RequestBody @Valid UpdateNumberOfProductsRequest request) {
        cartService.updateNumberOfProductsRequest(id, request);
        return new ResponseEntity(HttpStatus.OK);
    }
}
