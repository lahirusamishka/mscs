/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import static lk.ijse.mscs.controller.GRNFormController.deleteGRNController;
import static lk.ijse.mscs.controller.GRNFormController.getAll;
import static lk.ijse.mscs.controller.GRNFormController.updateGRNController;
import lk.ijse.mscs.dto.GRNDTO;
import lk.ijse.mscs.dto.ItemsDTO;
import lk.ijse.mscs.proxy.ProxyHandler;
import lk.ijse.mscs.service.ServiceFactory;
import lk.ijse.mscs.service.custom.GRNService;
import lk.ijse.mscs.service.custom.ItemsService;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author samishka
 */
public class ItemFormController implements Initializable {

    @FXML
    private JFXTextField txtItemCode;
    @FXML
    private TableColumn<?, ?> clmDescription;
    @FXML
    private TableColumn<?, ?> clmWarranty;
    @FXML
    private TableColumn<?, ?> clmUnitPrice;
    @FXML
    private TableColumn<?, ?> clmSalePrice;
    @FXML
    private JFXTextField txtQty;
    private JFXTextField txtDescription;
    @FXML
    private JFXTextField txtUnitPrice;
    @FXML
    private JFXTextField txtItemBrand;
    @FXML
    private JFXTextField txtSalePrice;
    @FXML
    private JFXTextField cmbWarranty;
    @FXML
    private TableView<GRNDTO> tblGRN;
    @FXML
    private TableColumn<?, ?> clmGRN;
    @FXML
    private TableColumn<?, ?> clmBatch;
    @FXML
    private TableColumn<?, ?> clmSupplierOrderId;
    @FXML
    private TableColumn<?, ?> clmBrand;
    @FXML
    private TableColumn<?, ?> clmOrderQty;
    @FXML
    private TableColumn<?, ?> clmOrderDate;
    @FXML
    private TableColumn<?, ?> clmSupplierId;
    @FXML
    private TableColumn<?, ?> clmDeliverDate;
    @FXML
    private TableColumn<?, ?> clmDeliverQTY;
    @FXML
    private JFXTextArea txtAreaDiscription;
    @FXML
    private Label lblPrice;
    @FXML
    private JFXButton btnUpdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnUpdate= new JFXButton();
        // TODO
        setSells();
        tableClickandFill();
        try {
            setTableValues(itemAll());
        } catch (Exception ex) {
            Logger.getLogger(ItemFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnItemUpdateAction(MouseEvent event) {
        try {
            GRNDTO grndto = new GRNDTO();
            grndto.setDescription(txtDescription.getText());
            grndto.setItemBrand(txtItemBrand.getText());
            grndto.setOrderQty(txtQty.getText());
            grndto.setSallingPrice(txtSalePrice.getText());
            grndto.setUnitPrice(Double.parseDouble(txtUnitPrice.getText()));
            grndto.setWarranty(cmbWarranty.getText());
            if (updateGRNController(grndto)) {
                Notifications notificationManager = Notifications.create()
                        .title("Item")
                        .text("     UPDATE!")
                        .hideAfter(Duration.seconds(0.5))
                        .position(Pos.CENTER);
                setTableValues(itemAll());
                //notificationManager.darkStyle();
                notificationManager.show();

            }
        } catch (Exception ex) {
            Logger.getLogger(GRNFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean addItemController(ItemsDTO itemsDTO) throws Exception {
        ItemsService itemsService = (ItemsService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemsService.addItem(itemsDTO);
    }

    public static boolean updateItemController(ItemsDTO itemsDTO) throws Exception {
        ItemsService itemsService = (ItemsService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemsService.updateItem(itemsDTO);
    }

    public static boolean deleteItemController(String itemId) throws Exception {
        ItemsService itemsService = (ItemsService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemsService.deleteItem(itemId);

    }

    public static List<ItemsDTO> getAllItems() throws Exception {
        ItemsService itemsService = (ItemsService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemsService.getAllItems();
    }

    public static ItemsDTO searchItem(String itemId) throws Exception {
        ItemsService itemsService = (ItemsService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemsService.searchItem(itemId);
    }

    public static boolean updateitemController(GRNDTO grndto) throws Exception {
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.updateGRN(grndto);
    }

    public static boolean deleteitemController(String grnId) throws Exception {
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.deleteGRN(grnId);
    }

    public static List<GRNDTO> itemAll() throws Exception {
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.getAllGRN();
    }

    private void setSells() {
        clmGRN.setCellValueFactory(new PropertyValueFactory<>("grnId"));
        clmSupplierId.setCellValueFactory(new PropertyValueFactory<>("SupplierId"));
        clmBatch.setCellValueFactory(new PropertyValueFactory<>("batchId"));
        clmDeliverDate.setCellValueFactory(new PropertyValueFactory<>("deliverdDate"));
        clmDeliverQTY.setCellValueFactory(new PropertyValueFactory<>("deliverdQty"));
        clmDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        clmBrand.setCellValueFactory(new PropertyValueFactory<>("itemBrand"));
        clmOrderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        clmOrderQty.setCellValueFactory(new PropertyValueFactory<>("orderQty"));
        clmSupplierOrderId.setCellValueFactory(new PropertyValueFactory<>("sOrderId"));
        clmSalePrice.setCellValueFactory(new PropertyValueFactory<>("sallingPrice"));
        clmUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        clmWarranty.setCellValueFactory(new PropertyValueFactory<>("warranty"));

    }

    private void setTableValues(List<GRNDTO> all) {
        try {
            ObservableList<GRNDTO> SupplierOrderList = FXCollections.observableArrayList();
            for (GRNDTO grnh : all) {
                SupplierOrderList.add(grnh);
            }
            tblGRN.setItems(SupplierOrderList);
        } catch (NullPointerException e) {
            Logger.getLogger(GRNFormController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void DeleteAction(MouseEvent event) {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to Delete ", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            try {
                if (deleteGRNController(txtItemCode.getText())) {
                    txtAreaDiscription.clear();
                    txtDescription.clear();
                    txtItemBrand.clear();
                    txtItemCode.clear();
                    txtQty.clear();
                    txtSalePrice.clear();
                    txtUnitPrice.clear();
                    Notifications notificationManager = Notifications.create()
                            .title("Item")
                            .text("     DELETE!")
                            .hideAfter(Duration.seconds(1))
                            .position(Pos.BOTTOM_RIGHT);
                    setTableValues(getAll());
                    notificationManager.darkStyle();
                    notificationManager.show();

                }
            } catch (Exception ex) {
                Logger.getLogger(ItemFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void tableClickandFill() {
        tblGRN.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                GRNDTO grndto = tblGRN.getItems().get(tblGRN.getSelectionModel().getSelectedIndex());

                txtItemCode.setText(grndto.getGrnId());
                lblPrice.setText(grndto.getSallingPrice() + ".00");
                txtItemBrand.setText(grndto.getItemBrand());
                txtQty.setText(grndto.getOrderQty());
                txtSalePrice.setText(grndto.getSallingPrice() + ".00");
                txtUnitPrice.setText(grndto.getUnitPrice() + "0");
                cmbWarranty.setText(grndto.getWarranty());
                txtAreaDiscription.setText(grndto.getDescription());
            }

        });
    }

    public static boolean deleteGRNController(String grnId) throws Exception {
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.deleteGRN(grnId);
    }

    @FXML
    private void btnActKey(KeyEvent event) {
       
    }

    @FXML
    private void btnUpdateAction(KeyEvent event) {
         boolean b=txtUnitPrice.getText().isEmpty()||txtSalePrice.getText().isEmpty()||txtQty.getText().isEmpty()|| txtItemCode.getText().isEmpty()||txtItemBrand.getText().isEmpty()||txtDescription.getText().isEmpty();
        if(!b){
            System.out.println("ffg");
            
        }
        btnUpdate.setDisable(true);
    }

}
