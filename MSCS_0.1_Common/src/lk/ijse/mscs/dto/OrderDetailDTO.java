/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.dto;

/**
 *
 * @author samishka
 */
public class OrderDetailDTO extends SuperDTO {

    private int iqty;
    private double unitPrice;
    private ItemsDTO items;
    private CustomerOrderDTO customerOrder;
    private OrderDetail_PKDTO orderDetail_PK;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int iqty, double unitPrice, ItemsDTO items, CustomerOrderDTO customerOrder, OrderDetail_PKDTO orderDetail_PK) {
        this.iqty = iqty;
        this.unitPrice = unitPrice;
        this.items = items;
        this.customerOrder = customerOrder;
        this.orderDetail_PK = orderDetail_PK;
    }

    /**
     * @return the iqty
     */
    public int getIqty() {
        return iqty;
    }

    /**
     * @param iqty the iqty to set
     */
    public void setIqty(int iqty) {
        this.iqty = iqty;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
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
     * @return the orderDetail_PK
     */
    public OrderDetail_PKDTO getOrderDetail_PK() {
        return orderDetail_PK;
    }

    /**
     * @param orderDetail_PK the orderDetail_PK to set
     */
    public void setOrderDetail_PK(OrderDetail_PKDTO orderDetail_PK) {
        this.orderDetail_PK = orderDetail_PK;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" + "iqty=" + iqty + ", unitPrice=" + unitPrice + ", items=" + items + ", customerOrder=" + customerOrder + ", orderDetail_PK=" + orderDetail_PK + '}';
    }

}
