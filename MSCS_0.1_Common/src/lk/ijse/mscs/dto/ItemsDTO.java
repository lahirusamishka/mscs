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
public class ItemsDTO extends SuperDTO{

    private String itemId; // getting the GRN id;
    private String itemBrand;
    private String description;
    private int Qty;
    private String warranty;
    private double unitPrice;
    private double sallingPrice;// enter

    public ItemsDTO() {
    }

    public ItemsDTO( String itemBrand, String description, int Qty, String warranty, double unitPrice, double sallingPrice) {
        
        this.itemBrand = itemBrand;
        this.description = description;
        this.Qty = Qty;
        this.warranty = warranty;
        this.unitPrice = unitPrice;
        this.sallingPrice = sallingPrice;
    }

    public ItemsDTO(String itemId, String itemBrand, String description, int Qty, String warranty, double unitPrice, double sallingPrice) {
        this.itemId = itemId;
        this.itemBrand = itemBrand;
        this.description = description;
        this.Qty = Qty;
        this.warranty = warranty;
        this.unitPrice = unitPrice;
        this.sallingPrice = sallingPrice;
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
     * @return the Qty
     */
    public int getQty() {
        return Qty;
    }

    /**
     * @param Qty the Qty to set
     */
    public void setQty(int Qty) {
        this.Qty = Qty;
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
    public double getSallingPrice() {
        return sallingPrice;
    }

    /**
     * @param sallingPrice the sallingPrice to set
     */
    public void setSallingPrice(double sallingPrice) {
        this.sallingPrice = sallingPrice;
    }

    @Override
    public String toString() {
        return "ItemsDTO{" + "itemId=" + itemId + ", itemBrand=" + itemBrand + ", description=" + description + ", Qty=" + Qty + ", warranty=" + warranty + ", unitPrice=" + unitPrice + ", sallingPrice=" + sallingPrice + '}';
    }

    

}
