/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.entity;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lk.ijse.mscs.dto.CustomerOrderDTO;
import lk.ijse.mscs.dto.ItemsDTO;
import lk.ijse.mscs.dto.OrderDetail_PKDTO;

/**
 *
 * @author samishka
 */@Entity
public class OrderDetail implements Serializable{
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private int orderDetailId;
    private int iqty;
    private double unitPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemId", referencedColumnName = "itemId", insertable = false, updatable = false)
    private Item item;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoiceNo", referencedColumnName = "invoiceNo", insertable = false, updatable = false)
    private CustomerOrder customerOrder;

    @EmbeddedId
    private OrderDetail_PK orderDetail_PK;

    public OrderDetail() {
    }

    public OrderDetail(int orderDetailId, int iqty, double unitPrice, Item item, CustomerOrder customerOrder) {
        this.orderDetailId = orderDetailId;
        this.iqty = iqty;
        this.unitPrice = unitPrice;
        this.item = item;
        this.customerOrder = customerOrder;
        
    }

    public OrderDetail(int orderDetailId, int iqty, double unitPrice, Item item, CustomerOrder customerOrder, OrderDetail_PK orderDetail_PK) {
        this.orderDetailId = orderDetailId;
        this.iqty = iqty;
        this.unitPrice = unitPrice;
        this.item = item;
        this.customerOrder = customerOrder;
        this.orderDetail_PK = orderDetail_PK;
    }

    /**
     * @return the orderDetailId
     */
    public int getOrderDetailId() {
        return orderDetailId;
    }

    /**
     * @param orderDetailId the orderDetailId to set
     */
    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
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
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @return the customerOrder
     */
    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    /**
     * @param customerOrder the customerOrder to set
     */
    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    /**
     * @return the orderDetail_PK
     */
    public OrderDetail_PK getOrderDetail_PK() {
        return orderDetail_PK;
    }

    /**
     * @param orderDetail_PK the orderDetail_PK to set
     */
    public void setOrderDetail_PK(OrderDetail_PK orderDetail_PK) {
        this.orderDetail_PK = orderDetail_PK;
    }
    

   
}
