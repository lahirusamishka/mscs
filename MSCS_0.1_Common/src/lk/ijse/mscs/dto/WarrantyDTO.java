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
public class WarrantyDTO extends SuperDTO {

    private String invoiceNo;
    private String customerId;  // search  Enter
    private String deleveryDate;
    private String itemId;
    private String acceptedDate; // enter
    private String amount;
    private String description;
    private String itemBrand;
    private double unitPrice;
    private String imeiNo;
    private String warranty;
    private String CustomerName;
    private String address;
    private String ContactNo;
    private String Email;
    private String defects;  // enter

    public WarrantyDTO() {
    }

    public WarrantyDTO(String customerId, String deleveryDate, String itemId, String acceptedDate, String amount, String description, String itemBrand, double unitPrice, String imeiNo, String warranty, String CustomerName, String address, String ContactNo, String Email, String defects) {
        this.customerId = customerId;
        this.deleveryDate = deleveryDate;
        this.itemId = itemId;
        this.acceptedDate = acceptedDate;
        this.amount = amount;
        this.description = description;
        this.itemBrand = itemBrand;
        this.unitPrice = unitPrice;
        this.imeiNo = imeiNo;
        this.warranty = warranty;
        this.CustomerName = CustomerName;
        this.address = address;
        this.ContactNo = ContactNo;
        this.Email = Email;
        this.defects = defects;
    }

    public WarrantyDTO(String invoiceNo, String customerId, String deleveryDate, String itemId, String acceptedDate, String amount, String description, String itemBrand, double unitPrice, String imeiNo, String warranty, String CustomerName, String address, String ContactNo, String Email, String defects) {
        this.invoiceNo = invoiceNo;
        this.customerId = customerId;
        this.deleveryDate = deleveryDate;
        this.itemId = itemId;
        this.acceptedDate = acceptedDate;
        this.amount = amount;
        this.description = description;
        this.itemBrand = itemBrand;
        this.unitPrice = unitPrice;
        this.imeiNo = imeiNo;
        this.warranty = warranty;
        this.CustomerName = CustomerName;
        this.address = address;
        this.ContactNo = ContactNo;
        this.Email = Email;
        this.defects = defects;
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
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the acceptedDate
     */
    public String getAcceptedDate() {
        return acceptedDate;
    }

    /**
     * @param acceptedDate the acceptedDate to set
     */
    public void setAcceptedDate(String acceptedDate) {
        this.acceptedDate = acceptedDate;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the itemBrand
     */
    public String getItemBrand() {
        return itemBrand;
    }

    /**
     * @param itemBrand the itemBrand to set
     */
    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
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
     * @return the CustomerName
     */
    public String getCustomerName() {
        return CustomerName;
    }

    /**
     * @param CustomerName the CustomerName to set
     */
    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the ContactNo
     */
    public String getContactNo() {
        return ContactNo;
    }

    /**
     * @param ContactNo the ContactNo to set
     */
    public void setContactNo(String ContactNo) {
        this.ContactNo = ContactNo;
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
     * @return the defects
     */
    public String getDefects() {
        return defects;
    }

    /**
     * @param defects the defects to set
     */
    public void setDefects(String defects) {
        this.defects = defects;
    }

    @Override
    public String toString() {
        return "WarrantyDTO{" + "invoiceNo=" + invoiceNo + ", customerId=" + customerId + ", deleveryDate=" + deleveryDate + ", itemId=" + itemId + ", acceptedDate=" + acceptedDate + ", amount=" + amount + ", description=" + description + ", itemBrand=" + itemBrand + ", unitPrice=" + unitPrice + ", imeiNo=" + imeiNo + ", warranty=" + warranty + ", CustomerName=" + CustomerName + ", address=" + address + ", ContactNo=" + ContactNo + ", Email=" + Email + ", defects=" + defects + '}';
    }

}
