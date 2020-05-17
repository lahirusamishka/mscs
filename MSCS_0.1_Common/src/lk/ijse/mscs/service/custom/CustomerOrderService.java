/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.service.custom;

import java.util.List;
import lk.ijse.mscs.dto.CustomerOrderDTO;
import lk.ijse.mscs.service.SuperService;

/**
 *
 * @author samishka
 */
public interface CustomerOrderService extends SuperService{

    public boolean addCustomerOrder(CustomerOrderDTO customerOrder) throws Exception;

    public boolean deleteCustomerOrder(String customerOrderId) throws Exception;

    public boolean updateCustomerOrder(CustomerOrderDTO customerOrder) throws Exception;

    public List<CustomerOrderDTO> getAllCustomerOrders() throws Exception;

    public CustomerOrderDTO searchCustomerOrder(String customerOrderId) throws Exception;
}
