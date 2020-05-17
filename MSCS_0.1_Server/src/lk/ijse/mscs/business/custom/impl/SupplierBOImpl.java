/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.mscs.business.custom.SupplierBO;
import lk.ijse.mscs.dto.SupplierDTO;
import lk.ijse.mscs.entity.Supplier;
import lk.ijse.mscs.repository.RepositoryFactory;
import lk.ijse.mscs.repository.custom.SupplierRepository;
import lk.ijse.mscs.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class SupplierBOImpl implements SupplierBO {

    private SupplierRepository supplierRepository;

    public SupplierBOImpl() {
        this.supplierRepository = (SupplierRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.SUPPLIER);
    }

    @Override
    public boolean addSupplier(SupplierDTO supplier) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            supplierRepository.setSession(session);
            session.beginTransaction();
            /*
            private String SupplierId;
    private String NIC;
    private String name;
    private String address;
    private String Contact;
    private String Email;
             */
            Supplier supplier1 = new Supplier(
                    supplier.getSupplierId(),
                    supplier.getNIC(),
                    supplier.getName(),
                    supplier.getAddress(),
                    supplier.getContact(),
                    supplier.getEmail());
            boolean result = supplierRepository.save(supplier1);

            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean deleteSupplier(String supplierId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            supplierRepository.setSession(session);
            session.beginTransaction();

            Supplier supplier = supplierRepository.findById(supplierId);
            boolean result = false;

            if (supplier != null) {
                supplierRepository.delete(supplier);
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
    public boolean updateSupplier(SupplierDTO supplier) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            supplierRepository.setSession(session);
            session.beginTransaction();
            Supplier supplier1 = new Supplier(
                    supplier.getSupplierId(),
                    supplier.getNIC(),
                    supplier.getName(),
                    supplier.getAddress(),
                    supplier.getContact(),
                    supplier.getEmail());
            boolean resul=false;
            if(supplierRepository.update(supplier1)){
                resul=true;
            }

            session.getTransaction().commit();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SupplierDTO> getAllSupplier() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            supplierRepository.setSession(session);
            session.beginTransaction();

            List<Supplier> suppliers = supplierRepository.findAll();

            session.getTransaction().commit();

            if (suppliers != null) {
                List<SupplierDTO> alSupplierDTOs = new ArrayList<>();

                for (Supplier supplier : suppliers) {
                    SupplierDTO dTO = new SupplierDTO(
                            supplier.getSupplierId(),
                            supplier.getNIC(),
                            supplier.getName(),
                            supplier.getAddress(),
                            supplier.getContact(),
                            supplier.getEmail());
                    alSupplierDTOs.add(dTO);
                }
                return alSupplierDTOs;
            } else {
                return null;
            }
        }
    }

    @Override
    public SupplierDTO searchSupplier(String supplierId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
