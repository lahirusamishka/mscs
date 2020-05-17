/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.mscs.business.custom.SupplierOrderBO;
import lk.ijse.mscs.dto.SupplierOrderDTO;
import lk.ijse.mscs.entity.SupplierOrder;
import lk.ijse.mscs.repository.RepositoryFactory;
import lk.ijse.mscs.repository.custom.SupplierOrderRepository;
import lk.ijse.mscs.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class SupplierOrderBOImpl implements SupplierOrderBO {

    private SupplierOrderRepository supplierOrderRepository;

    public SupplierOrderBOImpl() {
        this.supplierOrderRepository = (SupplierOrderRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.SUPPLIERORDER);
    }

    @Override
    public boolean addSupplierOrder(SupplierOrderDTO supplierOrder) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            supplierOrderRepository.setSession(session);
            session.beginTransaction();
            /*
            private String SupplierOId;
    private String SupplierId;
    private String batchId;
    private String itemBrand;
    private String idescription;
    private int iQty;
    private String date;
             */
            SupplierOrder so = new SupplierOrder(
                    supplierOrder.getSupplierOId(),
                    supplierOrder.getSupplierId(),
                    supplierOrder.getBatchId(),
                    supplierOrder.getItemBrand(),
                    supplierOrder.getIdescription(),
                    supplierOrder.getiQty(),
                    supplierOrder.getDate());

            boolean result = supplierOrderRepository.save(so);

            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean deleteSupplierOrder(String SupplierOrderId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            supplierOrderRepository.setSession(session);
            session.beginTransaction();

            SupplierOrder supplierOrder = supplierOrderRepository.findById(SupplierOrderId);
            boolean result = false;

            if (supplierOrder != null) {
                result = supplierOrderRepository.delete(supplierOrder);
            }
            session.getTransaction().commit();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateSupplierOrder(SupplierOrderDTO supplierOrder) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            supplierOrderRepository.setSession(session);
            session.beginTransaction();
            boolean result = false;
            SupplierOrder so = new SupplierOrder(
                    supplierOrder.getSupplierOId(),
                    supplierOrder.getSupplierId(),
                    supplierOrder.getBatchId(),
                    supplierOrder.getItemBrand(),
                    supplierOrder.getIdescription(),
                    supplierOrder.getiQty(),
                    supplierOrder.getDate());
            result = supplierOrderRepository.update(so);
            session.getTransaction().commit();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SupplierOrderDTO> getAllSupplierOrder() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            supplierOrderRepository.setSession(session);
            session.beginTransaction();

            List<SupplierOrder> supplierOrders = supplierOrderRepository.findAll();
            session.getTransaction().commit();

            if (supplierOrders != null) {
                List<SupplierOrderDTO> alSupplierOrderDTOs = new ArrayList<>();
                for (SupplierOrder supplierOrder : supplierOrders) {
                    SupplierOrderDTO supplierOrder1 = new SupplierOrderDTO(
                            supplierOrder.getSupplierOId(),
                            supplierOrder.getSupplierId(),
                            supplierOrder.getBatchId(),
                            supplierOrder.getItemBrand(),
                            supplierOrder.getIdescription(),
                            supplierOrder.getiQty(),
                            supplierOrder.getDate());

                    alSupplierOrderDTOs.add(supplierOrder1);
                }
                return alSupplierOrderDTOs;

            } else {
                return null;
            }
        }
    }

    @Override
    public SupplierOrderDTO searchSupplierOrder(String supplierOrder) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            supplierOrderRepository.setSession(session);
            session.beginTransaction();

            SupplierOrder so = supplierOrderRepository.findById(supplierOrder);

            if (so != null) {
                SupplierOrderDTO dto = new SupplierOrderDTO(
                        so.getSupplierOId(),
                        so.getSupplierId(),
                        so.getBatchId(),
                        so.getItemBrand(),
                        so.getIdescription(),
                        so.getiQty(),
                        so.getDate()
                );

                session.getTransaction().commit();
                return dto;
            } else {
                session.getTransaction().commit();
                return null;
            }
        }
    }

}
