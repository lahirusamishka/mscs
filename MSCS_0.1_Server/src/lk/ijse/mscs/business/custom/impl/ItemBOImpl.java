/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.mscs.business.custom.ItemBO;
import lk.ijse.mscs.dto.ItemsDTO;
import lk.ijse.mscs.entity.Item;
import lk.ijse.mscs.repository.RepositoryFactory;
import lk.ijse.mscs.repository.custom.ItemRepository;
import lk.ijse.mscs.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class ItemBOImpl implements ItemBO {

    private ItemRepository itemRepository;

    public ItemBOImpl() {
        this.itemRepository = (ItemRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ITEM);
    }

    @Override
    public boolean addItem(ItemsDTO items) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            itemRepository.setSession(session);

            session.beginTransaction();
            /*
            private String itemId; // getting the GRN id;
    private String itemBrand;
    private String description;
    private String Qty;
    private String warranty;
    private double unitPrice;
    private double sallingPrice;
             */
            Item i = new Item(
                    items.getItemId(),
                    items.getItemBrand(),
                    items.getDescription(),
                    items.getQty(),
                    items.getWarranty(),
                    items.getUnitPrice(),
                    items.getSallingPrice());

            boolean result = itemRepository.save(i);

            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean deleteItem(String itemId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            itemRepository.setSession(session);

            session.beginTransaction();

            Item i = itemRepository.findById(itemId);
            boolean result = false;

            if (i != null) {
                itemRepository.delete(i);
            }
            session.getTransaction().commit();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateItem(ItemsDTO items) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            itemRepository.setSession(session);

            session.beginTransaction();

            Item i = new Item(items.getItemId(),
                    items.getItemBrand(),
                    items.getDescription(),
                    items.getQty(),
                    items.getWarranty(),
                    items.getUnitPrice(),
                    items.getSallingPrice());
            itemRepository.update(i);

            session.getTransaction().commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ItemsDTO> getAllItems() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            itemRepository.setSession(session);

            session.beginTransaction();

            List<Item> items = itemRepository.findAll();

            session.getTransaction().commit();

            if (items != null) {
                List<ItemsDTO> alItemsDTOs = new ArrayList<>();

                for (Item item : items) {
                    ItemsDTO dTO = new ItemsDTO(
                            item.getItemId(),
                            item.getItemBrand(),
                            item.getDescription(),
                            item.getQty(),
                            item.getWarranty(),
                            item.getUnitPrice(),
                            item.getSallingPrice());
                    alItemsDTOs.add(dTO);
                }
                return alItemsDTOs;
            }else{
                return null;
            }
        }
    }

    @Override
    public ItemsDTO searchItem(String itemId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
