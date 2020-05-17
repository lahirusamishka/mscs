/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.repository.custom.impl;

import java.util.List;
import lk.ijse.mscs.entity.GRN;
import lk.ijse.mscs.repository.custom.GRNRepository;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class GRNRepositoryImpl implements GRNRepository {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(GRN t) throws Exception {
        return (session.save(t) != null);
    }

    @Override
    public boolean delete(GRN t) throws Exception {
        session.delete(t);
        return true;
    }

    @Override
    public boolean update(GRN t) throws Exception {
        session.update(t);
        return true;
    }

    @Override
    public GRN findById(String id) throws Exception {
        return session.get(GRN.class, id);
    }

    @Override
    public List<GRN> findAll() throws Exception {
        return session.createQuery("From GRN").list();
    }

}
