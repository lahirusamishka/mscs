/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.repository.custom.impl;

import java.util.List;
import lk.ijse.mscs.entity.MobileOperater;
import lk.ijse.mscs.repository.custom.MobileOperaterRepository;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class MobileOperaterRepositoryImpl implements MobileOperaterRepository{
    private Session session;
    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(MobileOperater t) throws Exception {
        return (session.save(t) != null);
    }

    @Override
    public boolean delete(MobileOperater t) throws Exception {
        session.delete(t);
        return true;
    }

    @Override
    public boolean update(MobileOperater t) throws Exception {
        session.update(t);
        return true;
    }

    @Override
    public MobileOperater findById(String id) throws Exception {
        return session.get(MobileOperater.class, id);
    }

    @Override
    public List<MobileOperater> findAll() throws Exception {
        return session.createQuery("From MobileOperater").list();
    }
    
}
