/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author samishka
 */
@Entity
public class Reception {

    @Id
    
    private String receptionId;
    private String NIC;
    private String name;
    private String address;
    private String Contact;
    private String Email;

    public Reception() {
    }

    public Reception( String NIC, String name, String address, String Contact, String Email) {

        this.NIC = NIC;
        this.name = name;
        this.address = address;
        this.Contact = Contact;
        this.Email = Email;
    }

    public Reception(String receptionId, String NIC, String name, String address, String Contact, String Email) {
        this.receptionId = receptionId;
        this.NIC = NIC;
        this.name = name;
        this.address = address;
        this.Contact = Contact;
        this.Email = Email;
    }

    /**
     * @return the receptionId
     */
    public String getReceptionId() {
        return receptionId;
    }

    /**
     * @param receptionId the receptionId to set
     */
    public void setReceptionId(String receptionId) {
        this.receptionId = receptionId;
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
        return "Reception{" + "receptionId=" + receptionId + ", NIC=" + NIC + ", name=" + name + ", address=" + address + ", Contact=" + Contact + ", Email=" + Email + '}';
    }

   
}
