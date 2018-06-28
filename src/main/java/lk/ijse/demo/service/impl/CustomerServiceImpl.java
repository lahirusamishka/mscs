package lk.ijse.demo.service.impl;

import lk.ijse.demo.dto.CustomerDTO;
import lk.ijse.demo.entity.Customer;
import lk.ijse.demo.repository.CustomerRepository;
import lk.ijse.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() {
        List<Customer> customers = repository.findAll();

        ArrayList<CustomerDTO> alcustomers = new ArrayList<>();

        for (Customer customer : customers){
            CustomerDTO customerDTO= new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());

            alcustomers.add(customerDTO);
        }

        return alcustomers;
    }

    @Override
    public CustomerDTO getCustomer(String customerId) {
        Customer customer= repository.findById(customerId).get();
        CustomerDTO customerDTO= new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());
        return customerDTO;
    }

    @Override
    public Boolean DeleteCustomer(String customerId) {
        repository.deleteById(customerId);
        return true;
    }

    @Override
    public boolean saveCustomer(CustomerDTO custDto) {
        Customer customer= new Customer(custDto.getId(),custDto.getName(),custDto.getAddress());
        repository.save(customer);
        return true;
    }

}
