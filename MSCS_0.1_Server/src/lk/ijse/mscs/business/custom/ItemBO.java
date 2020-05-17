/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom;

import java.util.List;
import lk.ijse.mscs.business.SuperBO;
import lk.ijse.mscs.dto.ItemsDTO;

/**
 *
 * @author samishka
 */
public interface ItemBO extends SuperBO {

    public boolean addItem(ItemsDTO items) throws Exception;

    public boolean deleteItem(String itemId) throws Exception;

    public boolean updateItem(ItemsDTO items) throws Exception;

    public List<ItemsDTO> getAllItems() throws Exception;

    public ItemsDTO searchItem(String itemId) throws Exception;
}
