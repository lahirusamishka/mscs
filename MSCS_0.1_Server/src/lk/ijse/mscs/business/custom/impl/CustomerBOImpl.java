/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import javax.swing.text.DefaultEditorKit;
import lk.ijse.mscs.business.custom.CustomerBO;
import lk.ijse.mscs.dto.CustomerDTO;
import lk.ijse.mscs.entity.Customer;
import lk.ijse.mscs.repository.RepositoryFactory;
import lk.ijse.mscs.repository.custom.CustomerRepository;
import lk.ijse.mscs.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class CustomerBOImpl implements CustomerBO {
    
    private CustomerRepository customerRepository;
    
    public CustomerBOImpl() {
        this.customerRepository = (CustomerRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.CUSTOMER);
    }
    
    @Override
    public boolean addCustomer(CustomerDTO customer) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            customerRepository.setSession(session);
            session.beginTransaction();
            
            Customer co = new Customer(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getConatactNo(),
                    customer.getEmail());
            
            boolean result = customerRepository.save(co);
            
            session.getTransaction().commit();
            return result;
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean deleteCustomer(String customerId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            customerRepository.setSession(session);
            session.beginTransaction();
            
            Customer co = customerRepository.findById(customerId);
            boolean result = false;
            
            if (co != null) {
                result =customerRepository.delete(co);
            }
            session.getTransaction().commit();
            return result;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean updateCustomer(CustomerDTO customer) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            customerRepository.setSession(session);
            
            session.beginTransaction();
            boolean result;
            Customer co = new Customer(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getConatactNo(),
                    customer.getEmail());
            result =customerRepository.update(co);
            session.getTransaction().commit();
            
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            customerRepository.setSession(session);
            session.beginTransaction();
            List<Customer> customerOrders = customerRepository.findAll();
            session.getTransaction().commit();
            
            if (customerOrders != null) {
                List<CustomerDTO> alCustomer = new ArrayList<>();
                for (Customer customer : customerOrders) {
                    CustomerDTO customerOrderDTO = new CustomerDTO();
                    
                    customerOrderDTO.setConatactNo(customer.getConatactNo());
                    customerOrderDTO.setCustomerAddress(customer.getCustomerAddress());
                    customerOrderDTO.setCustomerId(customer.getCustomerId());
                    customerOrderDTO.setCustomerName(customer.getCustomerName());
                    customerOrderDTO.setEmail(customer.getEmail());
                    
                    alCustomer.add(customerOrderDTO);
                }
                return alCustomer;
            } else {
                return null;
            }
        }
    }
    
    @Override
    public CustomerDTO searchCustomer(String customerOrderId) throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            customerRepository.setSession(session);
            session.beginTransaction();
            
            Customer cutomer=customerRepository.findById(customerOrderId);
            CustomerDTO c=new CustomerDTO();
            c.setCustomerName(cutomer.getCustomerName());
            c.setCustomerAddress(cutomer.getCustomerAddress());
            c.setConatactNo(cutomer.getConatactNo());
            c.setEmail(cutomer.getEmail());
            session.getTransaction().commit();
            return c;
            
        }
            
    }
    
}
