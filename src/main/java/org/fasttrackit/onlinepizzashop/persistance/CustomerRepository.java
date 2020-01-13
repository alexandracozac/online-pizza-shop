package org.fasttrackit.onlinepizzashop.persistance;

import org.fasttrackit.onlinepizzashop.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
