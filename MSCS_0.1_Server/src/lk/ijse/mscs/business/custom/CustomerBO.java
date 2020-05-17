/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom;

import java.util.List;
import lk.ijse.mscs.business.SuperBO;
import lk.ijse.mscs.dto.CustomerDTO;
import lk.ijse.mscs.dto.CustomerOrderDTO;

/**
 *
 * @author samishka
 */
public interface CustomerBO extends SuperBO{
    public boolean addCustomer(CustomerDTO customer) throws Exception;

    public boolean deleteCustomer(String customerId) throws Exception;

    public boolean updateCustomer(CustomerDTO customer) throws Exception;

    public List<CustomerDTO> getAllCustomers() throws Exception;

    public CustomerDTO searchCustomer(String customerOrderId) throws Exception;
}
