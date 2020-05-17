/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.service.custom;

import java.util.List;
import lk.ijse.mscs.dto.CustomerDTO;
import lk.ijse.mscs.dto.CustomerOrderDTO;
import lk.ijse.mscs.service.SuperService;

/**
 *
 * @author samishka
 */
public interface CustomerService extends SuperService {

    public boolean addCustomer(CustomerDTO customer) throws Exception;

    public boolean deleteCustomer(String customerid) throws Exception;

    public boolean updateCustomer(CustomerDTO customer) throws Exception;

    public List<CustomerDTO> getAllCustomers() throws Exception;

    public CustomerDTO searchCustomer(String customerId) throws Exception;

    public List<CustomerDTO> findAllCustomers(String CustID) throws Exception;
}
