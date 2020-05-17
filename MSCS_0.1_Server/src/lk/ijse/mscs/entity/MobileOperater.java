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
public class MobileOperater {

    @Id
    private String MobileOperaterId;
    private String NIC;
    private String name;
    private String address;
    private String Contact;
    private String Email;

    public MobileOperater() {
    }

    public MobileOperater(String NIC, String name, String address, String Contact, String Email) {
        this.NIC = NIC;
        this.name = name;
        this.address = address;
        this.Contact = Contact;
        this.Email = Email;
    }

    public MobileOperater(String MobileOperaterId, String NIC, String name, String address, String Contact, String Email) {
        this.MobileOperaterId = MobileOperaterId;
        this.NIC = NIC;
        this.name = name;
        this.address = address;
        this.Contact = Contact;
        this.Email = Email;
    }

    /**
     * @return the MobileOperaterId
     */
    public String getMobileOperaterId() {
        return MobileOperaterId;
    }

    /**
     * @param MobileOperaterId the MobileOperaterId to set
     */
    public void setMobileOperaterId(String MobileOperaterId) {
        this.MobileOperaterId = MobileOperaterId;
    }

    /**
     * @return the NIC
     */
    public String getNIC() {
        return NIC;
    }

    /**
     * @param NIC the NIC to set
     */
    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the Contact
     */
    public String getContact() {
        return Contact;
    }

    /**
     * @param Contact the Contact to set
     */
    public void setContact(String Contact) {
        this.Contact = Contact;
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

    @Override
    public String toString() {
        return "MobileOperater{" + "MobileOperaterId=" + MobileOperaterId + ", NIC=" + NIC + ", name=" + name + ", address=" + address + ", Contact=" + Contact + ", Email=" + Email + '}';
    }
    
}
