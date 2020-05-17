/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.mscs.business.custom.ReceptionBO;
import lk.ijse.mscs.dto.ReceptionDTO;
import lk.ijse.mscs.entity.Reception;
import lk.ijse.mscs.repository.RepositoryFactory;
import lk.ijse.mscs.repository.custom.ReceptionRepository;
import lk.ijse.mscs.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class ReceptionBOImpl implements ReceptionBO {

    private ReceptionRepository receptionRepository;

    public ReceptionBOImpl() {
        this.receptionRepository = (ReceptionRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.RECEPTION);
    }

    @Override
    public boolean addReception(ReceptionDTO reception) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            receptionRepository.setSession(session);
            session.beginTransaction();
            /*
            private String receptionId;
    private String NIC;
    private String name;
    private String address;
    private String Contact;
    private String Email;
             */
            Reception r = new Reception(
                    reception.getReceptionId(),
                    reception.getNIC(),
                    reception.getName(),
                    reception.getAddress(),
                    reception.getContact(),
                    reception.getEmail());
            boolean result = receptionRepository.save(r);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean deleteReception(String receptionId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            receptionRepository.setSession(session);
            session.beginTransaction();

            Reception r = receptionRepository.findById(receptionId);
            boolean result = false;
            if (r != null) {
                receptionRepository.delete(r);
                result = true;
            }
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateReception(ReceptionDTO reception) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            receptionRepository.setSession(session);
            session.beginTransaction();
            Reception reception1 = new Reception(
                    reception.getReceptionId(),
                    reception.getNIC(),
                    reception.getName(),
                    reception.getAddress(),
                    reception.getContact(),
                    reception.getEmail());
            receptionRepository.update(reception1);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ReceptionDTO> getAllReception() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            receptionRepository.setSession(session);
            session.beginTransaction();

            List<Reception> receptions = receptionRepository.findAll();
            session.getTransaction().commit();
            if (receptions != null) {
                List<ReceptionDTO> alReceptionDTOs = new ArrayList<>();

                for (Reception reception : receptions) {
                    ReceptionDTO dTO = new ReceptionDTO(
                            reception.getReceptionId(),
                            reception.getNIC(),
                            reception.getName(),
                            reception.getAddress(),
                            reception.getContact(),
                            reception.getEmail());
                    alReceptionDTOs.add(dTO);
                }
                return alReceptionDTOs;
            } else {
                return null;
            }
        }
    }

    @Override
    public ReceptionDTO searchReception(String receptionId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
