package org.fasttrackit.onlinepizzashop.persistance;

import org.fasttrackit.onlinepizzashop.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
