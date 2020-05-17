/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.mscs.business.custom.BatchBO;
import lk.ijse.mscs.dto.BatchDTO;
import lk.ijse.mscs.entity.Batch;
import lk.ijse.mscs.repository.RepositoryFactory;
import lk.ijse.mscs.repository.custom.BatchRepository;
import lk.ijse.mscs.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class BatchBOImpl implements BatchBO {

    private BatchRepository batchRepository;

    public BatchBOImpl() {
        this.batchRepository = (BatchRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.BATCH);
    }

    @Override
    public boolean addBatch(BatchDTO batch) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            batchRepository.setSession(session);
            session.beginTransaction();

            Batch b = new Batch(
                    batch.getBachId(),
                    batch.getGRNID(),
                    batch.getGRNDate(),
                    batch.getSupplierOrderDate(),
                    batch.getSupplierOrderId());

            boolean result = batchRepository.save(b);

            session.getTransaction().commit();

            return result;
        }
    }

    @Override
    public boolean deleteBatch(String bacthId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            batchRepository.setSession(session);

            session.beginTransaction();

            Batch b = batchRepository.findById(bacthId);
            boolean result = false;

            if (b != null) {
                batchRepository.delete(b);
            }
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateBatch(BatchDTO batch) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            batchRepository.setSession(session);

            session.beginTransaction();

            Batch b = new Batch(
                    batch.getBachId(),
                    batch.getGRNDate(),
                    batch.getGRNID(),
                    batch.getSupplierOrderDate(),
                    batch.getSupplierOrderId());

            batchRepository.update(b);

            session.getTransaction().commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public List<BatchDTO> getAllBatch() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            batchRepository.setSession(session);
            session.beginTransaction();

            List<Batch> batchs = batchRepository.findAll();

            session.getTransaction().commit();

            if (batchs != null) {
                List<BatchDTO> alBatch = new ArrayList<>();

                for (Batch batch : batchs) {
                    BatchDTO batchDTO = new BatchDTO(
                            batch.getBachId(),
                            batch.getGRNDate(),
                            batch.getGRNID(),
                            batch.getSupplierOrderDate(),
                            batch.getSupplierOrderId());

                    alBatch.add(batchDTO);
                }
                return alBatch;
            } else {
                return null;
            }

        }
    }

    @Override
    public BatchDTO searchBatch(String batchId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
