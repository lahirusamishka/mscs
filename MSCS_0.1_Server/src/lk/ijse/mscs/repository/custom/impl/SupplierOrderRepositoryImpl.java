/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.repository.custom.impl;

import java.util.List;
import lk.ijse.mscs.entity.SupplierOrder;
import lk.ijse.mscs.repository.custom.SupplierOrderRepository;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class SupplierOrderRepositoryImpl implements SupplierOrderRepository {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(SupplierOrder t) throws Exception {
        return (session.save(t) != null);
    }

    @Override
    public boolean delete(SupplierOrder t) throws Exception {
        session.delete(t);
        return true;
    }

    @Override
    public boolean update(SupplierOrder t) throws Exception {
        session.update(t);
        return true;
    }

    @Override
    public SupplierOrder findById(String id) throws Exception {
        return session.get(SupplierOrder.class, id);
    }

    @Override
    public List<SupplierOrder> findAll() throws Exception {
        return session.createQuery("From SupplierOrder").list();
    }

}
