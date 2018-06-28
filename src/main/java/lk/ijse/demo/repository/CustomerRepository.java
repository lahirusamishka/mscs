package lk.ijse.demo.repository;

import lk.ijse.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> { // first Entitiy ,second Entity Id data type
}
