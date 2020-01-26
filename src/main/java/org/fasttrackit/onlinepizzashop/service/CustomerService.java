package org.fasttrackit.onlinepizzashop.service;

import org.fasttrackit.onlinepizzashop.domain.Customer;
import org.fasttrackit.onlinepizzashop.exception.ResourceNotFoundException;
import org.fasttrackit.onlinepizzashop.persistance.CustomerRepository;
import org.fasttrackit.onlinepizzashop.transfer.customer.SaveCustomerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.RollbackException;


@Service
public class CustomerService {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(CustomerService.class);

    // IoC - Inversion of Control
    private final CustomerRepository customerRepository;


    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public Customer createCustomer(SaveCustomerRequest request) {
        LOGGER.info("Creating customer {} ", request);
        Customer customer = new Customer();

        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());


        return customerRepository.save(customer);
    }

    public Customer getCustomer(long id) {
        LOGGER.info("Retrieving customer {}", id);

//        // using Optional
        return customerRepository.findById(id)
                // lambda expression
                .orElseThrow(() -> new RollbackException(
                        "Customer " + id + " does not exist."));
    }

    public Customer updateCustomer(long id, SaveCustomerRequest request) {
        LOGGER.info("Updating customer {}: {}", id, request);

        Customer customer = getCustomer(id);

        BeanUtils.copyProperties(request, customer);

        return customerRepository.save(customer);
    }

    public void deleteCustomer(long id) {
        LOGGER.info("Deleting customer {}", id);
        customerRepository.deleteById(id);
        LOGGER.info("Deleted customer {}", id);
    }
}


