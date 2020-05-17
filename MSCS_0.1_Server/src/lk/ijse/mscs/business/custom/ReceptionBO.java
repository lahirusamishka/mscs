/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom;

import java.util.List;
import lk.ijse.mscs.business.SuperBO;
import lk.ijse.mscs.dto.ReceptionDTO;

/**
 *
 * @author samishka
 */
public interface ReceptionBO extends SuperBO {

    public boolean addReception(ReceptionDTO reception) throws Exception;

    public boolean deleteReception(String receptionId) throws Exception;

    public boolean updateReception(ReceptionDTO reception) throws Exception;

    public List<ReceptionDTO> getAllReception() throws Exception;

    public ReceptionDTO searchReception(String receptionId) throws Exception;
}
