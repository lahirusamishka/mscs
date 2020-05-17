/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author samishka
 */
@Entity
public class Customer {
    @Id
    private String CustomerId;
    private String customerName;
    private String customerAddress;
    private String conatactNo;
    private String Email;

    public Customer() {
    }

    public Customer(String customerName, String customerAddress, String conatactNo, String Email) {
        
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.conatactNo = conatactNo;
        this.Email = Email;
    }

    public Customer(String CustomerId, String customerName, String customerAddress, String conatactNo, String Email) {
        this.CustomerId = CustomerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.conatactNo = conatactNo;
        this.Email = Email;
    }

    /**
     * @return the CustomerId
     */
    public String getCustomerId() {
        return CustomerId;
    }

    /**
     * @param CustomerId the CustomerId to set
     */
    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the customerAddress
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * @param customerAddress the customerAddress to set
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     * @return the conatactNo
     */
    public String getConatactNo() {
        return conatactNo;
    }

    /**
     * @param conatactNo the conatactNo to set
     */
    public void setConatactNo(String conatactNo) {
        this.conatactNo = conatactNo;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Customer{" + "CustomerId=" + CustomerId + ", customerName=" + customerName + ", customerAddress=" + customerAddress + ", conatactNo=" + conatactNo + ", Email=" + Email + '}';
    }
    

    
}
