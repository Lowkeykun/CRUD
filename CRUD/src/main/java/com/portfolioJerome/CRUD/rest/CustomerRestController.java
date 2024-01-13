package com.portfolioJerome.CRUD.rest;

import com.portfolioJerome.CRUD.common.Customer;
import com.portfolioJerome.CRUD.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {

    private final CustomerRepository customerRepository;

    public CustomerRestController (CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @GetMapping
    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }

    record NewCustomer(String name,
                       String email,
                       Integer age){

    }
    @PostMapping
    public void addCustomer(@RequestBody NewCustomer request){
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);
        customerRepository.save(customer);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable Integer id){
        customerRepository.deleteById(id);
    }
    @PutMapping("{id}")
    public void updateCustomer(@PathVariable Integer id, @RequestBody NewCustomer request){
        Customer customerUpdate = customerRepository.findById(id).orElse(null);
        customerUpdate.setName(request.name);
        customerUpdate.setEmail(request.email);
        customerUpdate.setAge(request.age);
        customerRepository.save(customerUpdate);
    }
}
