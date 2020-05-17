/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.repository.custom.impl;

import java.util.List;
import lk.ijse.mscs.entity.CustomerOrder;
import lk.ijse.mscs.repository.custom.CustomerOrderRepository;
import org.hibernate.Session;


/**
 *
 * @author samishka
 *//**
 *
 * @author samishka
 */






public class CustomerOrderRepositoryImpl implements CustomerOrderRepository {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(CustomerOrder t) throws Exception {
        return (session.save(t) != null);
    }

    @Override
    public boolean delete(CustomerOrder t) throws Exception {
        session.delete(t);
        return true;
    }

    @Override
    public boolean update(CustomerOrder t) throws Exception {
        session.update(t);
        return true;
    }

    @Override
    public CustomerOrder findById(String id) throws Exception {
        return session.get(CustomerOrder.class, id);
    }

    @Override
    public List<CustomerOrder> findAll() throws Exception {
        return session.createQuery("FROM customerorder").list();
    }

}
