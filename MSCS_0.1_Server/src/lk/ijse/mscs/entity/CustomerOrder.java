/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lk.ijse.mscs.dto.CustomerDTO;

/**
 *
 * @author samishka
 */
@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int invoiceNo;
    private String deleveryDate;
    private String imeiNo;
    private String warranty;
    private String amount;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    public CustomerOrder() {
    }

    public CustomerOrder(String deleveryDate, String imeiNo, String warranty, String amount, Customer customer) {
        this.deleveryDate = deleveryDate;
        this.imeiNo = imeiNo;
        this.warranty = warranty;
        this.amount = amount;
        this.customer = customer;
    }

    public CustomerOrder(int invoiceNo, String deleveryDate, String imeiNo, String warranty, String amount, Customer customer) {
        this.invoiceNo = invoiceNo;
        this.deleveryDate = deleveryDate;
        this.imeiNo = imeiNo;
        this.warranty = warranty;
        this.amount = amount;
        this.customer = customer;
    }

    /**
     * @return the invoiceNo
     */
    public int getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * @param invoiceNo the invoiceNo to set
     */
    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    /**
     * @return the deleveryDate
     */
    public String getDeleveryDate() {
        return deleveryDate;
    }

    /**
     * @param deleveryDate the deleveryDate to set
     */
    public void setDeleveryDate(String deleveryDate) {
        this.deleveryDate = deleveryDate;
    }

    /**
     * @return the imeiNo
     */
    public String getImeiNo() {
        return imeiNo;
    }

    /**
     * @param imeiNo the imeiNo to set
     */
    public void setImeiNo(String imeiNo) {
        this.imeiNo = imeiNo;
    }

    /**
     * @return the warranty
     */
    public String getWarranty() {
        return warranty;
    }

    /**
     * @param warranty the warranty to set
     */
    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" + "invoiceNo=" + invoiceNo + ", deleveryDate=" + deleveryDate + ", imeiNo=" + imeiNo + ", warranty=" + warranty + ", amount=" + amount + ", customer=" + customer + '}';
    }
    

}
