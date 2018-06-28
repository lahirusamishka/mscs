package lk.ijse.demo.service;

import lk.ijse.demo.dto.CustomerDTO;
import lk.ijse.demo.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


public interface CustomerService {
    public ArrayList<CustomerDTO> getAllCustomer();

    public CustomerDTO getCustomer(String customerId);

    public Boolean DeleteCustomer(String customerId);

    public boolean saveCustomer(CustomerDTO custDto);
}
