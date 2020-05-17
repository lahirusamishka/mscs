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
public class CustomerDTO extends SuperDTO{
    
    private String CustomerId;
    private String customerName;
    private String customerAddress;
    private String conatactNo;
    private String Email;
    private List<CustomerOrderDTO> order;

    public CustomerDTO() {
    }

    public CustomerDTO(String customerName, String customerAddress, String conatactNo, String Email, List<CustomerOrderDTO> order) {
    
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.conatactNo = conatactNo;
        this.Email = Email;
        this.order = order;
    }

    public CustomerDTO(String CustomerId, String customerName, String customerAddress, String conatactNo, String Email, List<CustomerOrderDTO> order) {
        this.CustomerId = CustomerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.conatactNo = conatactNo;
        this.Email = Email;
        this.order = order;
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

    /**
     * @return the order
     */
    public List<CustomerOrderDTO> getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(List<CustomerOrderDTO> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" + "CustomerId=" + CustomerId + ", customerName=" + customerName + ", customerAddress=" + customerAddress + ", conatactNo=" + conatactNo + ", Email=" + Email + ", order=" + order + '}';
    }

    
}
