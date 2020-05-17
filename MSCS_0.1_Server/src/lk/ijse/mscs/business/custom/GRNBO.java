/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom;

import java.util.List;
import lk.ijse.mscs.business.SuperBO;
import lk.ijse.mscs.dto.GRNDTO;

/**
 *
 * @author samishka
 */
public interface GRNBO extends SuperBO {

    public boolean addGRN(GRNDTO grn) throws Exception;

    public boolean deleteGRN(String DTOId) throws Exception;

    public boolean updateGRN(GRNDTO grn) throws Exception;

    public List<GRNDTO> getAllGRN() throws Exception;

    public GRNDTO search(String DTOId) throws Exception;
}
