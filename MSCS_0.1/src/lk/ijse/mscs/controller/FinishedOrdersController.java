/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import lk.ijse.mscs.dto.FinishedRepairDTO;
import lk.ijse.mscs.proxy.ProxyHandler;
import lk.ijse.mscs.service.ServiceFactory;
import lk.ijse.mscs.service.custom.FinishedRepairsService;

/**
 * FXML Controller class
 *
 * @author samishka
 */
public class FinishedOrdersController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public static boolean addFinishedController(FinishedRepairDTO finishedRepairDTO) throws Exception {
        FinishedRepairsService finishedRepairsService = (FinishedRepairsService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FINISHEDREPAIR);
        return finishedRepairsService.addFinishedRepairs(finishedRepairDTO);

    }

    public static boolean updateFinishedController(FinishedRepairDTO finishedRepairDTO) throws Exception {
        FinishedRepairsService finishedRepairsService = (FinishedRepairsService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FINISHEDREPAIR);
        return finishedRepairsService.updateFinishedRepair(finishedRepairDTO);
    }

    public static boolean deleteFinishedController(String finishedRepairId) throws Exception {
        FinishedRepairsService finishedRepairsService = (FinishedRepairsService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FINISHEDREPAIR);
        return finishedRepairsService.deleteFinishedRepair(finishedRepairId);
    }

    public static FinishedRepairDTO searchFinishedController(String finishedRepairId) throws Exception {
        FinishedRepairsService finishedRepairsService = (FinishedRepairsService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FINISHEDREPAIR);
        return finishedRepairsService.searchfinishedRepair(finishedRepairId);
    }

    public static List<FinishedRepairDTO> getAllFinisheds() throws Exception {
        FinishedRepairsService finishedRepairsService = (FinishedRepairsService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FINISHEDREPAIR);
        return finishedRepairsService.getAllFinishedRepairs();
    }
}
