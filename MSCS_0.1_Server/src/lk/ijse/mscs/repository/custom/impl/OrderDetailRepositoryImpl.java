/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.repository.custom.impl;

import java.util.List;
import lk.ijse.mscs.entity.OrderDetail;
import lk.ijse.mscs.repository.custom.OrderDetailRepository;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class OrderDetailRepositoryImpl implements OrderDetailRepository {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(OrderDetail t) throws Exception {
        return (session.save(t) != null);
    }

    @Override
    public boolean delete(OrderDetail t) throws Exception {
        session.delete(t);
        return true;
    }

    @Override
    public boolean update(OrderDetail t) throws Exception {
        session.update(t);
        return true;
    }

    @Override
    public OrderDetail findById(String id) throws Exception {
        return session.get(OrderDetail.class, id);
    }

    @Override
    public List<OrderDetail> findAll() throws Exception {
        return session.createQuery("From OrderDetail").list();
    }

}
