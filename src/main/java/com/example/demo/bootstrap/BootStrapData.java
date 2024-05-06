package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!customerRepository.existsById(99L) && customerRepository.count() <= 1) {
            // Retrieve an existing division from the repository
            Division WesternUnitedStates = divisionRepository.findById(4L).orElse(null);

            Customer customer1 = new Customer("Chaz", "Williams", "123 Postal Rd", "12345", "123-456-7890", WesternUnitedStates);
            Customer customer2 = new Customer("Michael", "Brown", "567 Pine St", "24680", "777-777-7777", WesternUnitedStates);
            Customer customer3 = new Customer("Sarah", "Davis", "890 Maple Ave", "97531", "888-888-8888", WesternUnitedStates);
            Customer customer4 = new Customer("David", "Miller", "901 Cedar Ln", "86420", "999-999-9999", WesternUnitedStates);
            Customer customer5 = new Customer("Jennifer", "Wilson", "234 Birch Blvd", "80263", "000-000-0000", WesternUnitedStates);

            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
            customerRepository.save(customer4);
            customerRepository.save(customer5);
        }
    }
}
