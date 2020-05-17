/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.mscs.business.custom.MobileOperaterBO;
import lk.ijse.mscs.dto.MobileOperaterDTO;
import lk.ijse.mscs.entity.MobileOperater;
import lk.ijse.mscs.repository.RepositoryFactory;
import lk.ijse.mscs.repository.custom.MobileOperaterRepository;
import lk.ijse.mscs.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class MobileOperaterBOImpl implements MobileOperaterBO {

    private MobileOperaterRepository mobileOperaterRepository;

    public MobileOperaterBOImpl() {
        this.mobileOperaterRepository = (MobileOperaterRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.MOBILEOPERATER);
    }

    @Override
    public boolean addOperater(MobileOperaterDTO operater) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            mobileOperaterRepository.setSession(session);

            session.beginTransaction();
            /*
            private String MobileOperaterId;
    private String NIC;
    private String name;
    private String address;
    private String Contact;
    private String Email;
             */
            MobileOperater mo = new MobileOperater(
                    operater.getMobileOperaterId(),
                    operater.getNIC(),
                    operater.getName(),
                    operater.getAddress(),
                    operater.getContact(),
                    operater.getEmail());
            boolean result = mobileOperaterRepository.save(mo);

            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean deleteOperater(String operaterId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            mobileOperaterRepository.setSession(session);

            session.beginTransaction();

            MobileOperater mo = mobileOperaterRepository.findById(operaterId);
            boolean result = false;
            if (mo != null) {
                mobileOperaterRepository.delete(mo);
                result=true;
             
                
            }
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateOperater(MobileOperaterDTO operater) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            mobileOperaterRepository.setSession(session);

            session.beginTransaction();

            MobileOperater mo = new MobileOperater(
                    operater.getMobileOperaterId(),
                    operater.getNIC(),
                    operater.getName(),
                    operater.getAddress(),
                    operater.getContact(),
                    operater.getEmail());

            mobileOperaterRepository.update(mo);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<MobileOperaterDTO> getAllOperater() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            mobileOperaterRepository.setSession(session);

            session.beginTransaction();

            List<MobileOperater> mobileOperaters = mobileOperaterRepository.findAll();
            session.getTransaction().commit();
            if (mobileOperaters != null) {
                List<MobileOperaterDTO> alOperaterDTOs = new ArrayList<>();

                for (MobileOperater mobileOperater : mobileOperaters) {
                    MobileOperaterDTO dTO = new MobileOperaterDTO(
                            mobileOperater.getMobileOperaterId(),
                            mobileOperater.getNIC(),
                            mobileOperater.getName(),
                            mobileOperater.getAddress(),
                            mobileOperater.getContact(),
                            mobileOperater.getEmail());
                    alOperaterDTOs.add(dTO);
                }
                return alOperaterDTOs;
            }else{
                return null;
            }
        }
    }

    @Override
    public MobileOperaterDTO searchOperater(String operaterId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
