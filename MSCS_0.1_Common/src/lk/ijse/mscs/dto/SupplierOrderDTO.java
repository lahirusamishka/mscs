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
public class SupplierOrderDTO extends SuperDTO{

    private String SupplierOId;
    private String SupplierId;
    private String batchId;
    private String itemBrand;
    private String idescription;
    private int iQty;
    private String date;
    //private String MP_location;  //  add to jusper form

    public SupplierOrderDTO() {
    }

    public SupplierOrderDTO(String SupplierId, String batchId, String itemBrand, String idescription, int iQty, String date) {
        this.SupplierId = SupplierId;
        this.batchId = batchId;
        this.itemBrand = itemBrand;
        this.idescription = idescription;
        this.iQty = iQty;
        this.date = date;
    }

    public SupplierOrderDTO(String SupplierOId, String SupplierId, String batchId, String itemBrand, String idescription, int iQty, String date) {
        this.SupplierOId = SupplierOId;
        this.SupplierId = SupplierId;
        this.batchId = batchId;
        this.itemBrand = itemBrand;
        this.idescription = idescription;
        this.iQty = iQty;
        this.date = date;
    }

    /**
     * @return the SupplierOId
     */
    public String getSupplierOId() {
        return SupplierOId;
    }

    /**
     * @param SupplierOId the SupplierOId to set
     */
    public void setSupplierOId(String SupplierOId) {
        this.SupplierOId = SupplierOId;
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
     * @return the idescription
     */
    public String getIdescription() {
        return idescription;
    }

    /**
     * @param idescription the idescription to set
     */
    public void setIdescription(String idescription) {
        this.idescription = idescription;
    }

    /**
     * @return the iQty
     */
    public int getiQty() {
        return iQty;
    }

    /**
     * @param iQty the iQty to set
     */
    public void setiQty(int iQty) {
        this.iQty = iQty;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SupplierOrderDTO{" + "SupplierOId=" + SupplierOId + ", SupplierId=" + SupplierId + ", batchId=" + batchId + ", itemBrand=" + itemBrand + ", idescription=" + idescription + ", iQty=" + iQty + ", date=" + date + '}';
    }

}
