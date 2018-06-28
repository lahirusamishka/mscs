package lk.ijse.demo.repository;

import lk.ijse.demo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository <Item,String> {
}
