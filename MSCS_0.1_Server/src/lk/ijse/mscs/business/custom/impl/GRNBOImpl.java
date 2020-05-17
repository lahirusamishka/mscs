/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.mscs.business.custom.GRNBO;
import lk.ijse.mscs.dto.GRNDTO;
import lk.ijse.mscs.entity.GRN;
import lk.ijse.mscs.repository.RepositoryFactory;
import lk.ijse.mscs.repository.custom.GRNRepository;
import lk.ijse.mscs.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class GRNBOImpl implements GRNBO {

    private GRNRepository gRNRepository;

    public GRNBOImpl() {
        this.gRNRepository = (GRNRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.GRN);

    }

    @Override
    public boolean addGRN(GRNDTO grn) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            gRNRepository.setSession(session);
            session.beginTransaction();
            /*
    private String grnId; // auto fill                        //itemtable         //accessories
    private String batchId; // combobox
    private String sOrderId; // Search Supplier OrderTable
    private String itemBrand;                                 //itemtable         //accessories
    private String description;                               //itemtable         //accessories
    private String orderQty;                                  //itemtable         //accessories
    private String orderDate;
    private String SupplierId;// end 
    private String deliverdDate; // enter 
    private String deliverdQty; // enter
    private String warranty;  // enter                        //itemtable
    private double unitPrice; // enter                        //itemtable
    private String sallingPrice;
             */
            GRN grn1 = new GRN(
                    grn.getGrnId(),
                    grn.getBatchId(),
                    grn.getsOrderId(),
                    grn.getItemBrand(),
                    grn.getDescription(),
                    grn.getOrderQty(),
                    grn.getOrderDate(),
                    grn.getSupplierId(),
                    grn.getDeliverdDate(),
                    grn.getDeliverdQty(),
                    grn.getWarranty(),
                    grn.getUnitPrice(),
                    grn.getSallingPrice());
            boolean result = gRNRepository.save(grn1);

            session.getTransaction().commit();

            return result;

        }
    }

    @Override
    public boolean deleteGRN(String DTOId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            gRNRepository.setSession(session);
            session.beginTransaction();

            GRN grn = gRNRepository.findById(DTOId);
            boolean result = false;
            if (grn != null) {
                result = gRNRepository.delete(grn);
            }
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updateGRN(GRNDTO grn) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            gRNRepository.setSession(session);
            session.beginTransaction();
            boolean result = false;
            GRN grn1 = new GRN(grn.getGrnId(),
                    grn.getBatchId(),
                    grn.getsOrderId(),
                    grn.getItemBrand(),
                    grn.getDescription(),
                    grn.getOrderQty(),
                    grn.getOrderDate(),
                    grn.getSupplierId(),
                    grn.getDeliverdDate(),
                    grn.getDeliverdQty(),
                    grn.getWarranty(),
                    grn.getUnitPrice(),
                    grn.getSallingPrice());
            result = gRNRepository.update(grn1);
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<GRNDTO> getAllGRN() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            gRNRepository.setSession(session);
            session.beginTransaction();

            List<GRN> grns = gRNRepository.findAll();
            session.getTransaction().commit();
            if (grns != null) {
                List<GRNDTO> alGrndtos = new ArrayList<>();

                for (GRN grn : grns) {
                    GRNDTO grndto = new GRNDTO(
                            grn.getGrnId(),
                            grn.getBatchId(),
                            grn.getsOrderId(),
                            grn.getItemBrand(),
                            grn.getDescription(),
                            grn.getOrderQty(),
                            grn.getOrderDate(),
                            grn.getSupplierId(),
                            grn.getDeliverdDate(),
                            grn.getDeliverdQty(),
                            grn.getWarranty(),
                            grn.getUnitPrice(),
                            grn.getSallingPrice());
                    alGrndtos.add(grndto);
                }
                return alGrndtos;
            } else {
                return null;
            }
        }
    }

    @Override
    public GRNDTO search(String DTOId) throws Exception {
        /*
            Customer cutomer=customerRepository.findById(customerOrderId);
            CustomerDTO c=new CustomerDTO();
            c.setCustomerName(cutomer.getCustomerName());
            c.setCustomerAddress(cutomer.getCustomerAddress());
            c.setConatactNo(cutomer.getConatactNo());
            c.setEmail(cutomer.getEmail());
            session.getTransaction().commit();
            return c;
         */
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            gRNRepository.setSession(session);
            session.beginTransaction();

            GRN grns = gRNRepository.findById(DTOId);
            GRNDTO grndto = new GRNDTO();
            grndto.setItemBrand(grns.getItemBrand());
            grndto.setDescription(grns.getDescription());
            grndto.setDeliverdQty(grndto.getDeliverdQty());
            grndto.setSallingPrice(grns.getSallingPrice());
            session.getTransaction().commit();
            return grndto;

          

        }

    }
}
