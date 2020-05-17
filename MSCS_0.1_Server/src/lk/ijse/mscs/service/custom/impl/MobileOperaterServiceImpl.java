/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import lk.ijse.mscs.business.BOFactory;
import lk.ijse.mscs.business.custom.MobileOperaterBO;
import lk.ijse.mscs.dto.MobileOperaterDTO;
import lk.ijse.mscs.service.custom.MobileOperaterService;

/**
 *
 * @author samishka
 */
public class MobileOperaterServiceImpl extends UnicastRemoteObject implements MobileOperaterService {

    private MobileOperaterBO mobileOperaterBO;

    public MobileOperaterServiceImpl() throws RemoteException {
        this.mobileOperaterBO = (MobileOperaterBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.MOBILEOPERATER);
    }

    @Override
    public boolean addOperater(MobileOperaterDTO operater) throws Exception {
        boolean result = mobileOperaterBO.addOperater(operater);
        return result;
    }

    @Override
    public boolean deleteOperater(String operaterId) throws Exception {
        boolean result=mobileOperaterBO.deleteOperater(operaterId);
        return result;
    }

    @Override
    public boolean updateOperater(MobileOperaterDTO operater) throws Exception {
        boolean result = false;
        result = mobileOperaterBO.updateOperater(operater);
        return result;
    }

    @Override
    public List<MobileOperaterDTO> getAllOperater() throws Exception {
        return mobileOperaterBO.getAllOperater();
    }

    @Override
    public MobileOperaterDTO searchOperater(String operaterId) throws Exception {
        return mobileOperaterBO.searchOperater(operaterId);
        
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
