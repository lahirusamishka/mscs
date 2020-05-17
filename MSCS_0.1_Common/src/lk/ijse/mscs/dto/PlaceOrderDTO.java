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
public class PlaceOrderDTO extends SuperDTO{
    private CustomerDTO customer;
    private CustomerOrderDTO customerOrder;
    private ItemsDTO items;
    private List<OrderDetailDTO> orderDetailDTO;

    public PlaceOrderDTO() {
    }

    public PlaceOrderDTO(CustomerDTO customer, CustomerOrderDTO customerOrder, ItemsDTO items, List<OrderDetailDTO> orderDetailDTO) {
        this.customer = customer;
        this.customerOrder = customerOrder;
        this.items = items;
        this.orderDetailDTO = orderDetailDTO;
    }

    /**
     * @return the customer
     */
    public CustomerDTO getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
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
     * @return the orderDetailDTO
     */
    public List<OrderDetailDTO> getOrderDetailDTO() {
        return orderDetailDTO;
    }

    /**
     * @param orderDetailDTO the orderDetailDTO to set
     */
    public void setOrderDetailDTO(List<OrderDetailDTO> orderDetailDTO) {
        this.orderDetailDTO = orderDetailDTO;
    }

    @Override
    public String toString() {
        return "PlaceOrderDTO{" + "customer=" + customer + ", customerOrder=" + customerOrder + ", items=" + items + ", orderDetailDTO=" + orderDetailDTO + '}';
    }
    
    
}
