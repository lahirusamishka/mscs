/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.mscs.business.custom.WarrantyBO;
import lk.ijse.mscs.dto.WarrantyDTO;
import lk.ijse.mscs.entity.Warranty;
import lk.ijse.mscs.repository.RepositoryFactory;
import lk.ijse.mscs.repository.custom.WarrantyRepository;
import lk.ijse.mscs.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class WarrantyBOImpl implements WarrantyBO {

    private WarrantyRepository warrantyRepository;

    public WarrantyBOImpl() {
        this.warrantyRepository = (WarrantyRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.WARRANTY);
    }

    @Override
    public boolean addWarranty(WarrantyDTO warranty) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            warrantyRepository.setSession(session);
            session.beginTransaction();
            /*
            private String invoiceNo;
    private String customerId;  // search  Enter
    private String deleveryDate;
    private String itemId;
    private String acceptedDate; // enter
    private String amount;
    private String description;
    private String itemBrand;
    private double unitPrice;
    private String imeiNo;
    private String warranty;
    private String CustomerName;
    private String address;
    private String ContactNo;
    private String Email;
    private String defects;
             */
            Warranty w = new Warranty(
                    warranty.getInvoiceNo(),
                    warranty.getCustomerId(),
                    warranty.getDeleveryDate(),
                    warranty.getItemId(),
                    warranty.getAcceptedDate(),
                    warranty.getAmount(),
                    warranty.getDescription(),
                    warranty.getItemBrand(),
                    warranty.getUnitPrice(),
                    warranty.getImeiNo(),
                    warranty.getWarranty(),
                    warranty.getCustomerName(),
                    warranty.getAddress(),
                    warranty.getContactNo(),
                    warranty.getEmail(),
                    warranty.getDefects());

            boolean result = warrantyRepository.save(w);
            session.getTransaction().commit();

            return result;
        }
    }

    @Override
    public boolean deleteWarranty(String warrantyId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            warrantyRepository.setSession(session);
            session.beginTransaction();

            Warranty warranty = warrantyRepository.findById(warrantyId);
            boolean result = false;

            if (warranty != null) {
                warrantyRepository.delete(warranty);
            }
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateWarranty(WarrantyDTO warranty) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            warrantyRepository.setSession(session);
            session.beginTransaction();

            Warranty warranty1 = new Warranty(
                    warranty.getInvoiceNo(),
                    warranty.getCustomerId(),
                    warranty.getDeleveryDate(),
                    warranty.getItemId(),
                    warranty.getAcceptedDate(),
                    warranty.getAmount(),
                    warranty.getDescription(),
                    warranty.getItemBrand(),
                    warranty.getUnitPrice(),
                    warranty.getImeiNo(),
                    warranty.getWarranty(),
                    warranty.getCustomerName(),
                    warranty.getAddress(),
                    warranty.getContactNo(),
                    warranty.getEmail(),
                    warranty.getDefects());
            warrantyRepository.update(warranty1);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<WarrantyDTO> getAllWarranty() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            warrantyRepository.setSession(session);
            session.beginTransaction();

            List<Warranty> warrantys = warrantyRepository.findAll();

            session.getTransaction().commit();

            if (warrantys != null) {

                List<WarrantyDTO> alWarrantyDTOs = new ArrayList<>();

                for (Warranty warranty : warrantys) {
                    WarrantyDTO dTO = new WarrantyDTO(
                            warranty.getInvoiceNo(),
                            warranty.getCustomerId(),
                            warranty.getDeleveryDate(),
                            warranty.getItemId(),
                            warranty.getAcceptedDate(),
                            warranty.getAmount(),
                            warranty.getDescription(),
                            warranty.getItemBrand(),
                            warranty.getUnitPrice(),
                            warranty.getImeiNo(),
                            warranty.getWarranty(),
                            warranty.getCustomerName(),
                            warranty.getAddress(),
                            warranty.getContactNo(),
                            warranty.getEmail(),
                            warranty.getDefects());

                    alWarrantyDTOs.add(dTO);
                }
                return alWarrantyDTOs;
            } else {
                return null;
            }
        }
    }

    @Override
    public WarrantyDTO search(String warrantyId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
