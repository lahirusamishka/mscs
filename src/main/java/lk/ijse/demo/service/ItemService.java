package lk.ijse.demo.service;

import lk.ijse.demo.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemService {

    public ArrayList<ItemDTO> getAllItem();

    public ItemDTO getItem(String itemId);

    public Boolean deleteItem(String itemId);

    public boolean saveItem(ItemDTO itemDto);



}
