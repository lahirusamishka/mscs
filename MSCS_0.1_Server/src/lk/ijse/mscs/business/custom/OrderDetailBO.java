/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom;

import java.util.List;
import lk.ijse.mscs.business.SuperBO;
import lk.ijse.mscs.dto.OperaterOrderDTO;
import lk.ijse.mscs.dto.OrderDetailDTO;

/**
 *
 * @author samishka
 */
public interface OrderDetailBO extends SuperBO {

    public boolean addOrderDetails(List<OrderDetailDTO> list) throws Exception;

    public boolean addPlaceOrder(OperaterOrderDTO operator) throws Exception;

    public List<OrderDetailDTO> getallOrderDetails() throws Exception;

    public boolean updatePlaceOrder(OperaterOrderDTO operator) throws Exception;

    public boolean deletePlaceOrder(String OID) throws Exception;
}
