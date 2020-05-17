/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.repository.custom.impl;

import java.util.List;
import lk.ijse.mscs.entity.Batch;
import lk.ijse.mscs.repository.custom.BatchRepository;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class BatchRepositoryImpl implements BatchRepository {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public boolean save(Batch t) throws Exception {
        return (session.save(t) !=null);
    }

    @Override
    public boolean delete(Batch t) throws Exception {
        session.delete(t);
        return true;
    }

    @Override
    public boolean update(Batch t) throws Exception {
        session.update(t);
        return true;
    }

    @Override
    public Batch findById(String id) throws Exception {
        return session.get(Batch.class, id);
    }

    @Override
    public List<Batch> findAll() throws Exception {
        return session.createQuery("From Batch").list();
    }

}
