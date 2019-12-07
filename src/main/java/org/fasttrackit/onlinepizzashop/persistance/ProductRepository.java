package org.fasttrackit.onlinepizzashop.persistance;

import org.fasttrackit.onlinepizzashop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { //id type=long



}
