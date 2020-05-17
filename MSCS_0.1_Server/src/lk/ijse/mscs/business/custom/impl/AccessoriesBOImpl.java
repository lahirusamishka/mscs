/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.mscs.business.custom.AccessoriesBO;
import lk.ijse.mscs.dto.AccessoriesDTO;
import lk.ijse.mscs.entity.Accessories;
import lk.ijse.mscs.repository.RepositoryFactory;
import lk.ijse.mscs.repository.custom.AccessoriesRepository;
import lk.ijse.mscs.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class AccessoriesBOImpl implements AccessoriesBO {

    private AccessoriesRepository accessoriesRepository;

    public AccessoriesBOImpl() {
        this.accessoriesRepository = (AccessoriesRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ACCESSORIES);
    }

    @Override
    public boolean addAccessories(AccessoriesDTO accessories) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            accessoriesRepository.setSession(session);

            session.beginTransaction();
            Accessories a = new Accessories(
                    accessories.getItemId(),
                    accessories.getItemBrand(),
                    accessories.getDescription(),
                    accessories.getQty()
            );

            boolean result = accessoriesRepository.save(a);

            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean deleteAccessories(String AccessoriesId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            accessoriesRepository.setSession(session);

            session.beginTransaction();

            Accessories accessories = accessoriesRepository.findById(AccessoriesId);
            boolean result = false;

            if (accessories != null) {

                accessoriesRepository.delete(accessories);
            }
            session.getTransaction().commit();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateAccessories(AccessoriesDTO accessories) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            accessoriesRepository.setSession(session);

            session.beginTransaction();

            Accessories a = new Accessories(
                    accessories.getItemId(),
                    accessories.getItemBrand(),
                    accessories.getDescription(),
                    accessories.getQty());
            accessoriesRepository.update(a);

            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public List<AccessoriesDTO> getAllAccessories() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            accessoriesRepository.setSession(session);

            session.beginTransaction();
            List<Accessories> accessories = accessoriesRepository.findAll();
            session.getTransaction().commit();

            if (accessories != null) {
                List<AccessoriesDTO> allAccessories = new ArrayList<>();

                for (Accessories accessory : accessories) {
                    AccessoriesDTO accessoriesDTO = new AccessoriesDTO(
                            accessory.getItemId(),
                            accessory.getItemBrand(),
                            accessory.getDescription(),
                            accessory.getQty());
                    allAccessories.add(accessoriesDTO);
                }
                return  allAccessories;
            }else{
                return null;
            }
        }
    }

    @Override
    public AccessoriesDTO searchAccessories(String accessories) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
