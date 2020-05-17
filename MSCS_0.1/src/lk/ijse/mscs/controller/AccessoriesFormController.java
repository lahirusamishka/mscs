/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import lk.ijse.mscs.dto.AccessoriesDTO;
import lk.ijse.mscs.proxy.ProxyHandler;
import lk.ijse.mscs.service.ServiceFactory;
import lk.ijse.mscs.service.custom.AccessoriesService;

/**
 * FXML Controller class
 *
 * @author samishka
 */
public class AccessoriesFormController implements Initializable {

    @FXML
    private JFXTextField txtItemCode;
    @FXML
    private JFXTextField txtItemBrand;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private JFXComboBox<?> txtcmboWarranty;
    @FXML
    private JFXTextField txtUnitPrice;
    @FXML
    private JFXTextField txtSalePrice;
    @FXML
    private TableView<?> tblItems;
    @FXML
    private TableColumn<?, ?> clmItemId;
    @FXML
    private TableColumn<?, ?> clmItembrand;
    @FXML
    private TableColumn<?, ?> clmDescription;
    @FXML
    private TableColumn<?, ?> clmQty;
    @FXML
    private TableColumn<?, ?> clmWarranty;
    @FXML
    private TableColumn<?, ?> clmUnitPrice;
    @FXML
    private TableColumn<?, ?> clmSalePrice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnItemUpdateAction(MouseEvent event) {
    }

    public static boolean addAccessoriesController(AccessoriesDTO accessoriesDto) throws Exception {
        AccessoriesService accessoriesService = (AccessoriesService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ACCESSORIES);
        return accessoriesService.addAccessories(accessoriesDto);

    }

    public static boolean updateAccessoriesController(AccessoriesDTO accessoriesDto) throws Exception {
        AccessoriesService accessoriesService = (AccessoriesService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ACCESSORIES);
        return accessoriesService.updateAccessories(accessoriesDto);
    }

    public static boolean deleteAccessoriesController(String accessoriesId) throws Exception {
        AccessoriesService accessoriesService = (AccessoriesService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ACCESSORIES);
        return accessoriesService.deleteAccessories(accessoriesId);
    }

    public static AccessoriesDTO searchAccessoriesController(String accessoriesId) throws Exception {
        AccessoriesService accessoriesService = (AccessoriesService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ACCESSORIES);
        return accessoriesService.searchAccessories(accessoriesId);
    }

    public static List<AccessoriesDTO> getAllAccessories() throws Exception {
        AccessoriesService accessoriesService = (AccessoriesService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ACCESSORIES);
        return accessoriesService.getAllAccessories();
    }

}
