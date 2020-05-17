/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.dto;

import java.util.List;

/**
 *
 * @author samishka
 */
public class OperaterOrderDTO extends SuperDTO{
    private CustomerDTO  Customer;
    private CustomerOrderDTO customerOrder;
    private ItemsDTO items;
    private List<OrderDetailDTO> list;

    public OperaterOrderDTO() {
    }

    public OperaterOrderDTO(CustomerDTO Customer, CustomerOrderDTO customerOrder, ItemsDTO items, List<OrderDetailDTO> list) {
        this.Customer = Customer;
        this.customerOrder = customerOrder;
        this.items = items;
        this.list = list;
    }

    /**
     * @return the Customer
     */
    public CustomerDTO getCustomer() {
        return Customer;
    }

    /**
     * @param Customer the Customer to set
     */
    public void setCustomer(CustomerDTO Customer) {
        this.Customer = Customer;
    }

    /**
     * @return the customerOrder
     */
    public CustomerOrderDTO getCustomerOrder() {
        return customerOrder;
    }

    /**
     * @param customerOrder the customerOrder to set
     */
    public void setCustomerOrder(CustomerOrderDTO customerOrder) {
        this.customerOrder = customerOrder;
    }

    /**
     * @return the items
     */
    public ItemsDTO getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(ItemsDTO items) {
        this.items = items;
    }

    /**
     * @return the list
     */
    public List<OrderDetailDTO> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<OrderDetailDTO> list) {
        this.list = list;
    }

  

    
}
