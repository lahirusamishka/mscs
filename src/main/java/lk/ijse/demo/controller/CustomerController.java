package lk.ijse.demo.controller;

import lk.ijse.demo.dto.CustomerDTO;
import lk.ijse.demo.entity.Customer;
import lk.ijse.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController     // controller annotaion + responsebody
@CrossOrigin
@RequestMapping(value = "api/v1/customers/")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CustomerDTO> getAllCustomers() {
        //return "hello rest ApI";
        return service.getAllCustomer();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO getCustomer(@PathVariable("id") String CustomerID) {
        return service.getCustomer(CustomerID);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteCustomer(@PathVariable("id") String CustomerID) {
        return service.DeleteCustomer(CustomerID);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveCustomer(@RequestBody CustomerDTO customer) {
        return service.saveCustomer(customer);
    }



}
