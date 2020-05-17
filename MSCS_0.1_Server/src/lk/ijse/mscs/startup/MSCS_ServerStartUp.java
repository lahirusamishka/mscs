/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.startup;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.mscs.service.impl.ServiceFactoryImpl;

/**
 *
 * @author samishka
 */
public class MSCS_ServerStartUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Registry registry=LocateRegistry.createRegistry(5050);
            registry.rebind("MSCS", ServiceFactoryImpl.getInstance());
            System.out.println("MSCS Server has been started successfully");
        } catch (RemoteException ex) {
            Logger.getLogger(MSCS_ServerStartUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
