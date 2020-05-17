/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.mscs.business.custom.FinishedRepairBO;
import lk.ijse.mscs.dto.FinishedRepairDTO;
import lk.ijse.mscs.entity.FinishedRepair;
import lk.ijse.mscs.repository.RepositoryFactory;
import lk.ijse.mscs.repository.custom.FinishedRepairRepository;
import lk.ijse.mscs.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class FinishedRepairBOImpl implements FinishedRepairBO {

    private FinishedRepairRepository finishedRepairRepository;

    public FinishedRepairBOImpl() {
        this.finishedRepairRepository = (FinishedRepairRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.FINISHEDREPAIR);
    }

    @Override
    public boolean addFinishedRepairs(FinishedRepairDTO finishedRepair) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            finishedRepairRepository.setSession(session);
            session.beginTransaction();
            /*
            private String finished_O_Id;// repair man id same finished o id
            private String customerId;  // search  Enter
            private String description;
            private double unitPrice;
            private String customerName;
            private String itemId;
            private String acceptedDate;
            private String contactNo;
            private String defects;
            private String replaceAccessories;
             */
            FinishedRepair fr = new FinishedRepair(
                    finishedRepair.getFinished_O_Id(),
                    finishedRepair.getCustomerId(),
                    finishedRepair.getDescription(),
                    finishedRepair.getUnitPrice(),
                    finishedRepair.getCustomerName(),
                    finishedRepair.getItemId(),
                    finishedRepair.getAcceptedDate(),
                    finishedRepair.getContactNo(),
                    finishedRepair.getDefects(),
                    finishedRepair.getReplaceAccessories());

            boolean result = finishedRepairRepository.save(fr);

            session.getTransaction().commit();

            return result;
        }
    }

    @Override
    public boolean deleteFinishedRepair(String FinishedRepairId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            finishedRepairRepository.setSession(session);

            session.beginTransaction();

            FinishedRepair finishedRepair = finishedRepairRepository.findById(FinishedRepairId);
            boolean result = false;

            if (finishedRepair != null) {
                finishedRepairRepository.delete(finishedRepair);
            }
            session.getTransaction().commit();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateFinishedRepair(FinishedRepairDTO finishedRepair) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            finishedRepairRepository.setSession(session);
            session.beginTransaction();
            FinishedRepair fr = new FinishedRepair(finishedRepair.getFinished_O_Id(),
                    finishedRepair.getCustomerId(),
                    finishedRepair.getDescription(),
                    finishedRepair.getUnitPrice(),
                    finishedRepair.getCustomerName(),
                    finishedRepair.getItemId(),
                    finishedRepair.getAcceptedDate(),
                    finishedRepair.getContactNo(),
                    finishedRepair.getDefects(),
                    finishedRepair.getReplaceAccessories());
                    
            finishedRepairRepository.update(fr);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<FinishedRepairDTO> getAllFinishedRepairs() throws Exception {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            finishedRepairRepository.setSession(session);
            session.beginTransaction();
            
            List<FinishedRepair> finishedRepairs=finishedRepairRepository.findAll();
            
            session.getTransaction().commit();
            if(finishedRepairs!=null){
                List<FinishedRepairDTO> alFinishedRepairDTOs= new ArrayList<>();
                for (FinishedRepair finishedRepair : finishedRepairs) {
                    FinishedRepairDTO frdto= new FinishedRepairDTO(
                    finishedRepair.getFinished_O_Id(),
                    finishedRepair.getCustomerId(),
                    finishedRepair.getDescription(),
                    finishedRepair.getUnitPrice(),
                    finishedRepair.getCustomerName(),
                    finishedRepair.getItemId(),
                    finishedRepair.getAcceptedDate(),
                    finishedRepair.getContactNo(),
                    finishedRepair.getDefects(),
                    finishedRepair.getReplaceAccessories());
                    alFinishedRepairDTOs.add(frdto);
                }
                return alFinishedRepairDTOs;
            }else{
                return null;
            }
                    
        }
    }

    @Override
    public FinishedRepairDTO searchfinishedRepair(String FinishedRepairId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
