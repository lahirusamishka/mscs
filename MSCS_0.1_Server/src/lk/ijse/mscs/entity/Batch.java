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
public class Batch {

    @Id
    private String bachId;
    private String SupplierOrderId;
    private String SupplierOrderDate;
    private String GRNID;
    private String GRNDate;

    public Batch() {
    }

    public Batch(String SupplierOrderId, String SupplierOrderDate, String GRNID, String GRNDate) {
        this.SupplierOrderId = SupplierOrderId;
        this.SupplierOrderDate = SupplierOrderDate;
        this.GRNID = GRNID;
        this.GRNDate = GRNDate;
    }

    public Batch(String bachId, String SupplierOrderId, String SupplierOrderDate, String GRNID, String GRNDate) {
        this.bachId = bachId;
        this.SupplierOrderId = SupplierOrderId;
        this.SupplierOrderDate = SupplierOrderDate;
        this.GRNID = GRNID;
        this.GRNDate = GRNDate;
    }

    /**
     * @return the bachId
     */
    public String getBachId() {
        return bachId;
    }

    /**
     * @param bachId the bachId to set
     */
    public void setBachId(String bachId) {
        this.bachId = bachId;
    }

    /**
     * @return the SupplierOrderId
     */
    public String getSupplierOrderId() {
        return SupplierOrderId;
    }

    /**
     * @param SupplierOrderId the SupplierOrderId to set
     */
    public void setSupplierOrderId(String SupplierOrderId) {
        this.SupplierOrderId = SupplierOrderId;
    }

    /**
     * @return the SupplierOrderDate
     */
    public String getSupplierOrderDate() {
        return SupplierOrderDate;
    }

    /**
     * @param SupplierOrderDate the SupplierOrderDate to set
     */
    public void setSupplierOrderDate(String SupplierOrderDate) {
        this.SupplierOrderDate = SupplierOrderDate;
    }

    /**
     * @return the GRNID
     */
    public String getGRNID() {
        return GRNID;
    }

    /**
     * @param GRNID the GRNID to set
     */
    public void setGRNID(String GRNID) {
        this.GRNID = GRNID;
    }

    /**
     * @return the GRNDate
     */
    public String getGRNDate() {
        return GRNDate;
    }

    /**
     * @param GRNDate the GRNDate to set
     */
    public void setGRNDate(String GRNDate) {
        this.GRNDate = GRNDate;
    }

    @Override
    public String toString() {
        return "Batch{" + "bachId=" + bachId + ", SupplierOrderId=" + SupplierOrderId + ", SupplierOrderDate=" + SupplierOrderDate + ", GRNID=" + GRNID + ", GRNDate=" + GRNDate + '}';
    }

}
