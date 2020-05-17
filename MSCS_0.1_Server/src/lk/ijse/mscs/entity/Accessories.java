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
public class Accessories {

    @Id
    private String itemId; // getting the GRN id;
    private String itemBrand;
    private String description;
    private String Qty;

    public Accessories() {
    }

    public Accessories(String itemBrand, String description, String Qty) {
        this.itemBrand = itemBrand;
        this.description = description;
        this.Qty = Qty;
    }

    public Accessories(String itemId, String itemBrand, String description, String Qty) {
        this.itemId = itemId;
        this.itemBrand = itemBrand;
        this.description = description;
        this.Qty = Qty;
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
    public String getQty() {
        return Qty;
    }

    /**
     * @param Qty the Qty to set
     */
    public void setQty(String Qty) {
        this.Qty = Qty;
    }

    @Override
    public String toString() {
        return "Accessories{" + "itemId=" + itemId + ", itemBrand=" + itemBrand + ", description=" + description + ", Qty=" + Qty + '}';
    }
    

}
