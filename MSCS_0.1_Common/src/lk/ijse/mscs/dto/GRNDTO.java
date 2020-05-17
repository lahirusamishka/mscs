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
public class GRNDTO extends SuperDTO{

    private String grnId; 
    private String batchId; // combobox
    private String sOrderId; // Search Supplier OrderTable
    private String itemBrand;                                 //itemtable         //accessories
    private String description;                               //itemtable         //accessories
    private String orderQty;                                  //itemtable         //accessories
    private String orderDate;
    private String SupplierId;
    private String deliverdDate; // enter 
    private String deliverdQty; // enter
    private String warranty;  // enter                        //itemtable
    private double unitPrice; // enter                        //itemtable
    private String sallingPrice;                              //itemtable

    public GRNDTO() {
    }

    public GRNDTO(String batchId, String sOrderId, String itemBrand, String description, String orderQty, String orderDate, String SupplierId, String deliverdDate, String deliverdQty, String warranty, double unitPrice, String sallingPrice) {
        this.batchId = batchId;
        this.sOrderId = sOrderId;
        this.itemBrand = itemBrand;
        this.description = description;
        this.orderQty = orderQty;
        this.orderDate = orderDate;
        this.SupplierId = SupplierId;
        this.deliverdDate = deliverdDate;
        this.deliverdQty = deliverdQty;
        this.warranty = warranty;
        this.unitPrice = unitPrice;
        this.sallingPrice = sallingPrice;
    }

    public GRNDTO(String grnId, String batchId, String sOrderId, String itemBrand, String description, String orderQty, String orderDate, String SupplierId, String deliverdDate, String deliverdQty, String warranty, double unitPrice, String sallingPrice) {
        this.grnId = grnId;
        this.batchId = batchId;
        this.sOrderId = sOrderId;
        this.itemBrand = itemBrand;
        this.description = description;
        this.orderQty = orderQty;
        this.orderDate = orderDate;
        this.SupplierId = SupplierId;
        this.deliverdDate = deliverdDate;
        this.deliverdQty = deliverdQty;
        this.warranty = warranty;
        this.unitPrice = unitPrice;
        this.sallingPrice = sallingPrice;
    }

    /**
     * @return the grnId
     */
    public String getGrnId() {
        return grnId;
    }

    /**
     * @param grnId the grnId to set
     */
    public void setGrnId(String grnId) {
        this.grnId = grnId;
    }

    /**
     * @return the batchId
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * @param batchId the batchId to set
     */
    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    /**
     * @return the sOrderId
     */
    public String getsOrderId() {
        return sOrderId;
    }

    /**
     * @param sOrderId the sOrderId to set
     */
    public void setsOrderId(String sOrderId) {
        this.sOrderId = sOrderId;
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
     * @return the orderQty
     */
    public String getOrderQty() {
        return orderQty;
    }

    /**
     * @param orderQty the orderQty to set
     */
    public void setOrderQty(String orderQty) {
        this.orderQty = orderQty;
    }

    /**
     * @return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the SupplierId
     */
    public String getSupplierId() {
        return SupplierId;
    }

    /**
     * @param SupplierId the SupplierId to set
     */
    public void setSupplierId(String SupplierId) {
        this.SupplierId = SupplierId;
    }

    /**
     * @return the deliverdDate
     */
    public String getDeliverdDate() {
        return deliverdDate;
    }

    /**
     * @param deliverdDate the deliverdDate to set
     */
    public void setDeliverdDate(String deliverdDate) {
        this.deliverdDate = deliverdDate;
    }

    /**
     * @return the deliverdQty
     */
    public String getDeliverdQty() {
        return deliverdQty;
    }

    /**
     * @param deliverdQty the deliverdQty to set
     */
    public void setDeliverdQty(String deliverdQty) {
        this.deliverdQty = deliverdQty;
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
     * @return the sallingPrice
     */
    public String getSallingPrice() {
        return sallingPrice;
    }

    /**
     * @param sallingPrice the sallingPrice to set
     */
    public void setSallingPrice(String sallingPrice) {
        this.sallingPrice = sallingPrice;
    }

    @Override
    public String toString() {
        return "GRNDTO{" + "grnId=" + grnId + ", batchId=" + batchId + ", sOrderId=" + sOrderId + ", itemBrand=" + itemBrand + ", description=" + description + ", orderQty=" + orderQty + ", orderDate=" + orderDate + ", SupplierId=" + SupplierId + ", deliverdDate=" + deliverdDate + ", deliverdQty=" + deliverdQty + ", warranty=" + warranty + ", unitPrice=" + unitPrice + ", sallingPrice=" + sallingPrice + '}';
    }

}
