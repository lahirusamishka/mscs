/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.repository.custom.impl;

import java.util.List;
import lk.ijse.mscs.entity.FinishedRepair;
import lk.ijse.mscs.repository.custom.FinishedRepairRepository;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class FinishedRepairRepositoryImpl implements FinishedRepairRepository{
private Session session;
    @Override
    public void setSession(Session session) {
         this.session=session;
    }

    @Override
    public boolean save(FinishedRepair t) throws Exception {
        return (session.save(t) !=null);
    }

    @Override
    public boolean delete(FinishedRepair t) throws Exception {
        session.delete(t);
        return true;
    }

    @Override
    public boolean update(FinishedRepair t) throws Exception {
        session.update(t);
        return true;
    }

    @Override
    public FinishedRepair findById(String id) throws Exception {
        return session.get(FinishedRepair.class, id);
    }

    @Override
    public List<FinishedRepair> findAll() throws Exception {
        return session.createQuery("From finishedrepair").list();
    }
    
}
