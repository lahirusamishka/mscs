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
public class CustomerOrderDTO extends SuperDTO {

    private String invoiceNo;
    private String deleveryDate;
    private String imeiNo;
    private String warranty;
    private String amount;
    private CustomerDTO customer;

    
    

    public CustomerOrderDTO() {
    }

    public CustomerOrderDTO( String deleveryDate, String imeiNo, String warranty, String amount, CustomerDTO customer) {
        
        this.deleveryDate = deleveryDate;
        this.imeiNo = imeiNo;
        this.warranty = warranty;
        this.amount = amount;
        this.customer = customer;
    }

    /**
     * @return the invoiceNo
     */
    public String getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * @param invoiceNo the invoiceNo to set
     */
    public void setInvoiceNo(String invoiceNo) {
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
    public CustomerDTO getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CustomerOrderDTO{" + "invoiceNo=" + invoiceNo + ", deleveryDate=" + deleveryDate + ", imeiNo=" + imeiNo + ", warranty=" + warranty + ", amount=" + amount + ", customer=" + customer + '}';
    }

    
}
