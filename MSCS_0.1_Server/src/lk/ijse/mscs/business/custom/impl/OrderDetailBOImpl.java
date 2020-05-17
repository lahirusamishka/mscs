/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom.impl;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.List;
import lk.ijse.mscs.business.custom.OrderDetailBO;
import lk.ijse.mscs.dto.CustomerDTO;
import lk.ijse.mscs.dto.CustomerOrderDTO;
import lk.ijse.mscs.dto.ItemsDTO;
import lk.ijse.mscs.dto.OperaterOrderDTO;
import lk.ijse.mscs.dto.OrderDetailDTO;
import lk.ijse.mscs.dto.OrderDetail_PKDTO;
import lk.ijse.mscs.entity.Customer;
import lk.ijse.mscs.entity.CustomerOrder;
import lk.ijse.mscs.entity.Item;
import lk.ijse.mscs.entity.OrderDetail;
import lk.ijse.mscs.entity.OrderDetail_PK;
import lk.ijse.mscs.repository.RepositoryFactory;
import lk.ijse.mscs.repository.custom.CustomerOrderRepository;
import lk.ijse.mscs.repository.custom.CustomerRepository;
import lk.ijse.mscs.repository.custom.ItemRepository;
import lk.ijse.mscs.repository.custom.OrderDetailRepository;
import lk.ijse.mscs.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author samishka
 */
public class OrderDetailBOImpl implements OrderDetailBO {

    private OrderDetailRepository orderDetailRepository;
    private CustomerRepository customerRepository;
    private ItemRepository itemRepository;
    private CustomerOrderRepository orderRepositroy;

    public OrderDetailBOImpl() {
        this.orderDetailRepository = (OrderDetailRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ORDERDETAIL);
        this.customerRepository = (CustomerRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.CUSTOMER);
        this.itemRepository = (ItemRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ITEM);
        this.orderRepositroy = (CustomerOrderRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.CUSTOMERORDER);
    }

    @Override
    public boolean addOrderDetails(List<OrderDetailDTO> list) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            orderDetailRepository.setSession(session);
            session.beginTransaction();
            boolean result1 = false;
            boolean result2 = false;
            for (OrderDetailDTO orderDetailDTO : list) {

                CustomerOrderDTO orderDTO = orderDetailDTO.getCustomerOrder();
                CustomerDTO customerDTO = orderDTO.getCustomer();

                Customer customer = new Customer();

                customer.setCustomerId(customerDTO.getCustomerId());
                customer.setCustomerName(customerDTO.getCustomerName());
                customer.setCustomerAddress(customerDTO.getCustomerAddress());
                customer.setConatactNo(customerDTO.getConatactNo());
                customer.setEmail(customerDTO.getEmail());
                /////////////////////////////////////////////////////////////////////

                CustomerOrder customerOrder = new CustomerOrder();

                customerOrder.setCustomer(customer);
                customerOrder.setInvoiceNo(Integer.parseInt(orderDTO.getInvoiceNo()));
                customerOrder.setDeleveryDate(orderDTO.getDeleveryDate());
                customerOrder.setWarranty(orderDTO.getWarranty());
                customerOrder.setImeiNo(orderDTO.getImeiNo());
                customerOrder.setAmount(orderDTO.getAmount());
                ////////////////////////////////2

                OrderDetail orderDetail = new OrderDetail();

                ItemsDTO itemDTO = orderDetailDTO.getItems();
                Item item = new Item();

                item.setItemId(itemDTO.getItemId());
                item.setDescription(itemDTO.getDescription());
                item.setItemBrand(itemDTO.getItemBrand());
                item.setQty(itemDTO.getQty());
                item.setSallingPrice(itemDTO.getSallingPrice());
                item.setUnitPrice(itemDTO.getUnitPrice());
                item.setWarranty(itemDTO.getWarranty());
                //////            

                orderDetail.setCustomerOrder(customerOrder);
                orderDetail.setItem(item);
                orderDetail.setIqty(orderDetail.getIqty());
                orderDetail.setUnitPrice(orderDetailDTO.getUnitPrice());

                OrderDetail_PKDTO orderDetail_PKDTO = orderDetailDTO.getOrderDetail_PK();

                OrderDetail_PK orderDetailpk = new OrderDetail_PK();//

                orderDetailpk.setItemId(orderDetail_PKDTO.getItemId());
                orderDetailpk.setInvoiceNo(orderDetail_PKDTO.getInvoiceNo());

                /*j*/ orderDetail.setOrderDetail_PK(orderDetailpk);

                result1 = orderDetailRepository.save(orderDetail);
                result2 = itemRepository.update(item);
            }
            if (result1 && result2) {
                session.getTransaction().commit();
                return true;
            } else {
                session.getTransaction().rollback();
                return false;
            }

        }

    }

    @Override
    public boolean addPlaceOrder(OperaterOrderDTO operator) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        boolean reult1 = false;
        boolean reult2 = false;
        boolean reult3 = false;
        boolean reult4 = false;
            orderDetailRepository.setSession(session);
            customerRepository.setSession(session);
            itemRepository.setSession(session);
            orderRepositroy.setSession(session);
            session.beginTransaction();

            
              
        CustomerDTO customerDTO = operator.getCustomer();
        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setCustomerAddress(customerDTO.getCustomerAddress());
        customer.setConatactNo(customerDTO.getConatactNo());
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setEmail(customerDTO.getEmail());
        //reult1=customerRepository.save(customer);
        
         CustomerOrderDTO order =operator.getCustomerOrder();
            CustomerOrder orders=new CustomerOrder();
            orders.setCustomer(customer);               //ok
            //orders.setInvoiceNo(Integer.parseInt(order.getInvoiceNo()));//ok
            orders.setDeleveryDate(order.getDeleveryDate());//ok
            orders.setImeiNo(order.getImeiNo());//ok
            orders.setWarranty(order.getWarranty());
            orders.setAmount(order.getAmount());
            reult2=orderRepositroy.save(orders);
            
        List<OrderDetailDTO> detaillist = operator.getList();

            //reult1 = customerRepository.save(customer);
            for (OrderDetailDTO orderDetailDTO : detaillist) {
                 
                ItemsDTO itemDTO = orderDetailDTO.getItems();
                Item item = new Item();

                item.setItemId(itemDTO.getItemId());
                item.setItemBrand(itemDTO.getItemBrand());
                item.setDescription(itemDTO.getDescription());
                item.setQty(itemDTO.getQty());
                item.setWarranty(itemDTO.getWarranty());
                item.setUnitPrice(itemDTO.getUnitPrice());
                item.setSallingPrice(itemDTO.getSallingPrice());

              //  reult3 = itemRepository.update(item);
                OrderDetail orderDetail = new OrderDetail();
                
                orderDetail.setItem(item);
                orderDetail.setCustomerOrder(orders);
                orderDetail.setIqty(orderDetail.getIqty());
                orderDetail.setUnitPrice(orderDetailDTO.getUnitPrice());

                OrderDetail_PKDTO orderDetail_PKDTO = orderDetailDTO.getOrderDetail_PK();

                OrderDetail_PK orderDec = new OrderDetail_PK();
                orderDec.setItemId(orderDetail_PKDTO.getItemId());
                orderDec.setInvoiceNo(orderDetail_PKDTO.getInvoiceNo());

                orderDetail.setOrderDetail_PK(orderDec);

                reult4 = orderDetailRepository.save(orderDetail);
            }
           
            
           
            if (reult2 && reult4) {
                session.getTransaction().commit();
                return true;
            } else {
                session.getTransaction().rollback();
                return false;
            }
            } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        

    }

    @Override
    public List<OrderDetailDTO> getallOrderDetails() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updatePlaceOrder(OperaterOrderDTO operator) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletePlaceOrder(String OID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
