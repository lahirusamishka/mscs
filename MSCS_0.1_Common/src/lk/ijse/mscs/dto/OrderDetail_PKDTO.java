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
public class OrderDetail_PKDTO extends SuperDTO{
    private String itemId;
    private String invoiceNo;

    public OrderDetail_PKDTO() {
    }

    public OrderDetail_PKDTO(String itemId, String invoiceNo) {
        this.itemId = itemId;
        this.invoiceNo = invoiceNo;
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

    @Override
    public String toString() {
        return "OrderDetail_PKDTO{" + "itemId=" + itemId + ", invoiceNo=" + invoiceNo + '}';
    }
    
    
}
