/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.repository.custom.impl;

import java.util.List;
import lk.ijse.mscs.entity.Item;
import lk.ijse.mscs.repository.custom.ItemRepository;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class ItemRepositoryImpl implements ItemRepository {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(Item t) throws Exception {
        return (session.save(t) != null);
    }

    @Override
    public boolean delete(Item t) throws Exception {
        session.delete(t);
        return true;
    }

    @Override
    public boolean update(Item t) throws Exception {
        session.update(t);
        return true;
    }

    @Override
    public Item findById(String id) throws Exception {
        return session.get(Item.class, id);
    }

    @Override
    public List<Item> findAll() throws Exception {
        return session.createQuery("From Item").list();
    }

}
