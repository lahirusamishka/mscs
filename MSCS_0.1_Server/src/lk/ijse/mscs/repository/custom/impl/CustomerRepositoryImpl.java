/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.repository.custom.impl;

import java.util.List;
import lk.ijse.mscs.entity.Customer;

import lk.ijse.mscs.repository.custom.CustomerRepository;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class CustomerRepositoryImpl implements CustomerRepository {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(Customer t) throws Exception {
        return (session.save(t) != null);
    }

    @Override
    public boolean delete(Customer t) throws Exception {
        session.delete(t);
        return true;
    }

    @Override
    public boolean update(Customer t) throws Exception {
        session.update(t);
        return true;
    }

    @Override
    public Customer findById(String id) throws Exception {
        return session.get(Customer.class, id);
    }

    @Override
    public List<Customer> findAll() throws Exception {
        return session.createQuery("From Customer").list();
    }

}
