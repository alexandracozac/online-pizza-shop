package org.fasttrackit.onlinepizzashop.persistance;

import org.fasttrackit.onlinepizzashop.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> { //id type=long

    Page<Product> findByNameContaining(String partialName, Pageable pageable);

    Page<Product> findByNameContainingAndQuantityGreaterThanEqual(
            String partialName, int minQuantity, Pageable pageable);


}
