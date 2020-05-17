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
public class SupplierDTO extends SuperDTO{

    private String SupplierId;
    private String NIC;
    private String name;
    private String address;
    private String Contact;
    private String Email;

    public SupplierDTO() {
    }

    public SupplierDTO(String NIC, String name, String address, String Contact, String Email) {
        this.NIC = NIC;
        this.name = name;
        this.address = address;
        this.Contact = Contact;
        this.Email = Email;
    }

    public SupplierDTO(String SupplierId, String NIC, String name, String address, String Contact, String Email) {
        this.SupplierId = SupplierId;
        this.NIC = NIC;
        this.name = name;
        this.address = address;
        this.Contact = Contact;
        this.Email = Email;
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
        return "SupplierDTO{" + "SupplierId=" + SupplierId + ", NIC=" + NIC + ", name=" + name + ", address=" + address + ", Contact=" + Contact + ", Email=" + Email + '}';
    }

}
