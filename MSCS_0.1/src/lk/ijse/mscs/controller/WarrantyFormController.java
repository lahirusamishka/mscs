/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import lk.ijse.mscs.dto.WarrantyDTO;
import lk.ijse.mscs.proxy.ProxyHandler;
import lk.ijse.mscs.service.ServiceFactory;
import lk.ijse.mscs.service.custom.WarrantyService;

/**
 * FXML Controller class
 *
 * @author samishka
 */
public class WarrantyFormController implements Initializable {

    @FXML
    private JFXTextField txtDateAccept;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setLoadDate();
    } 
    
    public static boolean addWarrantyController(WarrantyDTO warrantydto)throws Exception{
        WarrantyService warrantyService=(WarrantyService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.WARRANTY);
        return warrantyService.addWarranty(warrantydto);
        
    }
    public static boolean updateWarrantyController(WarrantyDTO warrantydto)throws Exception{
        WarrantyService warrantyService=(WarrantyService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.WARRANTY);
        return warrantyService.updateWarranty(warrantydto);
    }
    public static boolean deleteWarrantyController(String warrantyId)throws Exception{
        WarrantyService warrantyService=(WarrantyService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.WARRANTY);
        return warrantyService.deleteWarranty(warrantyId);
    }
    public static WarrantyDTO searchWarrantyController(String warrantyId)throws Exception{
        WarrantyService warrantyService=(WarrantyService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.WARRANTY);
        return warrantyService.search(warrantyId);
    }
    public static List<WarrantyDTO> getAll() throws Exception{
        WarrantyService warrantyService=(WarrantyService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.WARRANTY);
        return warrantyService.getAllWarranty();
    }

    private void setLoadDate() {
         Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD E");
        txtDateAccept.setText(simpleDateFormat.format(date));
    }
    
}
