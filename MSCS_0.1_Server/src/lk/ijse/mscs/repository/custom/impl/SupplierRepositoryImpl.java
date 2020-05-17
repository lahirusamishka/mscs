/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.repository.custom.impl;

import java.util.List;
import lk.ijse.mscs.entity.Supplier;
import lk.ijse.mscs.repository.custom.SupplierRepository;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class SupplierRepositoryImpl implements SupplierRepository {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(Supplier t) throws Exception {
        return (session.save(t) != null);
    }

    @Override
    public boolean delete(Supplier t) throws Exception {
        session.delete(t);
        return true;
    }

    @Override
    public boolean update(Supplier t) throws Exception {
        session.update(t);
        return true;
    }

    @Override
    public Supplier findById(String id) throws Exception {
        return session.get(Supplier.class, id);
    }

    @Override
    public List<Supplier> findAll() throws Exception {
        return session.createQuery("From Supplier").list();
    }

}
