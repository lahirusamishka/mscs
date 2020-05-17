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
public class FinishedRepairDTO extends SuperDTO{

    private String finished_O_Id;// repair man id same finished o id
    private String customerId;  // search  Enter
    private String description;
    private double unitPrice;
    private String customerName;
    private String itemId;
    private String acceptedDate;
    private String contactNo;
    private String defects;
    private String replaceAccessories;

    public FinishedRepairDTO() {
    }

    public FinishedRepairDTO(String customerId, String description, double unitPrice, String customerName, String itemId, String acceptedDate, String contactNo, String defects, String replaceAccessories) {

        this.customerId = customerId;
        this.description = description;
        this.unitPrice = unitPrice;
        this.customerName = customerName;
        this.itemId = itemId;
        this.acceptedDate = acceptedDate;
        this.contactNo = contactNo;
        this.defects = defects;
        this.replaceAccessories = replaceAccessories;
    }

    public FinishedRepairDTO(String finished_O_Id, String customerId, String description, double unitPrice, String customerName, String itemId, String acceptedDate, String contactNo, String defects, String replaceAccessories) {
        this.finished_O_Id = finished_O_Id;
        this.customerId = customerId;
        this.description = description;
        this.unitPrice = unitPrice;
        this.customerName = customerName;
        this.itemId = itemId;
        this.acceptedDate = acceptedDate;
        this.contactNo = contactNo;
        this.defects = defects;
        this.replaceAccessories = replaceAccessories;
    }

    /**
     * @return the finished_O_Id
     */
    public String getFinished_O_Id() {
        return finished_O_Id;
    }

    /**
     * @param finished_O_Id the finished_O_Id to set
     */
    public void setFinished_O_Id(String finished_O_Id) {
        this.finished_O_Id = finished_O_Id;
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
     * @return the contactNo
     */
    public String getContactNo() {
        return contactNo;
    }

    /**
     * @param contactNo the contactNo to set
     */
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
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

    /**
     * @return the replaceAccessories
     */
    public String getReplaceAccessories() {
        return replaceAccessories;
    }

    /**
     * @param replaceAccessories the replaceAccessories to set
     */
    public void setReplaceAccessories(String replaceAccessories) {
        this.replaceAccessories = replaceAccessories;
    }

    @Override
    public String toString() {
        return "FinishedRepairDTO{" + "finished_O_Id=" + finished_O_Id + ", customerId=" + customerId + ", description=" + description + ", unitPrice=" + unitPrice + ", customerName=" + customerName + ", itemId=" + itemId + ", acceptedDate=" + acceptedDate + ", contactNo=" + contactNo + ", defects=" + defects + ", replaceAccessories=" + replaceAccessories + '}';
    }

}
