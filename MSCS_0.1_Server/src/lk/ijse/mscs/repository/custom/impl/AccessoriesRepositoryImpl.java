/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.repository.custom.impl;

import java.util.List;
import lk.ijse.mscs.entity.Accessories;

import lk.ijse.mscs.repository.custom.AccessoriesRepository;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class AccessoriesRepositoryImpl implements AccessoriesRepository {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public boolean save(Accessories t) throws Exception {
        return (session.save(t) !=null);
    }

    @Override
    public boolean delete(Accessories t) throws Exception {
        session.delete(t);
        return true;
    }

    @Override
    public boolean update(Accessories t) throws Exception {
        session.update(t);
        return true;
    }

    @Override
    public Accessories findById(String id) throws Exception {
        return session.get(Accessories.class, id);
    }

    @Override
    public List<Accessories> findAll() throws Exception {
        return session.createQuery("From Accessories").list();
    }

}
