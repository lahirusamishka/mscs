/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.observer;

import java.rmi.Remote;
import java.util.Observer;

/**
 *
 * @author samishka
 */
public interface Subject extends Remote {

    public void registerObserver(Observer1 observer) throws Exception;

    public void unregisterObserver(Observer1 observer) throws Exception;

    public void notifyObservers() throws Exception;
}
