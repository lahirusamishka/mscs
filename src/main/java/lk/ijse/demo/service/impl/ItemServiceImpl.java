package lk.ijse.demo.service.impl;

import lk.ijse.demo.dto.ItemDTO;
import lk.ijse.demo.entity.Item;
import lk.ijse.demo.repository.ItemRepository;
import lk.ijse.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS , readOnly = true)
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository repository;


    @Override
    public ArrayList<ItemDTO> getAllItem() {
        List<Item> allItems = repository.findAll();

        ArrayList<ItemDTO> allItem = new ArrayList<>();

        for (Item item: allItems) {
            ItemDTO itemDTO= new ItemDTO(item.getId(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());
            allItem.add(itemDTO);
        }
        return allItem;

    }

    @Override
    public ItemDTO getItem(String itemId) {
        Item item = repository.findById(itemId).get();
        ItemDTO itemDTO= new ItemDTO(item.getId(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());
        return itemDTO;
    }

    @Override
    public Boolean deleteItem(String itemId) {
        return null;
    }

    @Override
    public boolean saveItem(ItemDTO itemDto) {
        Item item= new Item(itemDto.getId(),itemDto.getDescription(),itemDto.getUnitPrice(),itemDto.getQtyOnHand());
        repository.save(item);
        return true;
    }


}
