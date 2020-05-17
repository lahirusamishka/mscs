/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.service.custom;

import java.util.List;
import lk.ijse.mscs.dto.GRNDTO;
import lk.ijse.mscs.service.SuperService;

/**
 *
 * @author samishka
 */
public interface GRNService extends SuperService{

    public boolean addGRN(GRNDTO grn) throws Exception;

    public boolean deleteGRN(String DTOId) throws Exception;

    public boolean updateGRN(GRNDTO grn) throws Exception;

    public List<GRNDTO> getAllGRN() throws Exception;

    public GRNDTO search(String DTOId) throws Exception;

}
