package org.fasttrackit.onlinepizzashop.web;


import org.fasttrackit.onlinepizzashop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/carts/remove")
public class RemoveFromCartController {

    private final CartService cartService;

    @Autowired
    public RemoveFromCartController(CartService cartService) {
        this.cartService = cartService;
    }

    @DeleteMapping("/{id}/{itemId}")
    public ResponseEntity removeProductFromCart(@PathVariable("id") long id, @PathVariable("itemId") long itemId) {
        cartService.deleteProductFromCart(id, itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
