/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lk.ijse.mscs.dto.BatchDTO;
import lk.ijse.mscs.dto.SupplierDTO;
import lk.ijse.mscs.dto.SupplierOrderDTO;
import lk.ijse.mscs.proxy.ProxyHandler;
import lk.ijse.mscs.service.ServiceFactory;
import lk.ijse.mscs.service.custom.BatchService;
import lk.ijse.mscs.service.custom.SupplierOrderService;
import lk.ijse.mscs.service.custom.SupplierService;
import lk.ijse.mscs.validation.Validation;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author samishka
 */
public class SupplierOrderFormController extends Validation implements Initializable {

    @FXML
    private JFXTextField txtSOrderId;
    @FXML
    private JFXComboBox<Object> txtSupplierId;
    @FXML
    private JFXTextField txtBatchId;
    @FXML
    private JFXTextField txtDate;
    @FXML
    private TableView<SupplierOrderDTO> tblSupplierOrder;
    @FXML
    private TableColumn<?, ?> clmsOrderId;
    @FXML
    private TableColumn<?, ?> clmSupplierId;
    @FXML
    private TableColumn<?, ?> clmBtachId;
    @FXML
    private TableColumn<?, ?> clmItemBrand;
    @FXML
    private TableColumn<?, ?> clmDescription;
    @FXML
    private TableColumn<?, ?> clmQty;
    @FXML
    private JFXComboBox<String> txtItemBrand;
    @FXML
    private JFXTextField txtdescription;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private TableColumn<?, ?> clmDate;

    /**
     * Initializes the controller class.
     */
    final ObservableList option = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JFXComboBox box = new JFXComboBox(option);
        try {
            loadCombo();
        } catch (Exception ex) {
            Logger.getLogger(SupplierOrderFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            setTableValues(getAllSupplierOrders());
        } catch (Exception ex) {
            Logger.getLogger(SupplierOrderFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

        LoadCombo();
        dateShowDate();

        setCellTable();
        setTableValueToTextField();
        try {
            fillComboBox();
            System.out.println("1");
        } catch (Exception ex) {
            Logger.getLogger(SupplierOrderFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnSaveUpdateAction(MouseEvent event) {
        try {
            SupplierOrderDTO supplierOrderDTO = new SupplierOrderDTO();

            supplierOrderDTO.setSupplierOId(txtSOrderId.getText());
            supplierOrderDTO.setSupplierId(txtSupplierId.getSelectionModel().getSelectedItem().toString());
            supplierOrderDTO.setBatchId(txtBatchId.getText());
            supplierOrderDTO.setItemBrand(txtItemBrand.getSelectionModel().getSelectedItem().toString());
            supplierOrderDTO.setIdescription(txtdescription.getText());
            supplierOrderDTO.setiQty(Integer.parseInt(txtQty.getText()));
            supplierOrderDTO.setDate(txtDate.getText());

            if (addSupplierOrderController(supplierOrderDTO)) {
                
                
                
                Notifications notificationManager = Notifications.create()
                        .title("Supplier Order")
                        .text("     SAVE!")
                        .hideAfter(Duration.seconds(1))
                        .position(Pos.CENTER);
                setTableValues(getAllSupplierOrders());
                //notificationManager.darkStyle();
                notificationManager.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(SupplierOrderFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btndeleteAction(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, " Are you sure you want to delete " + " ?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            try {
                if (deleteSupplierOrderController(txtSOrderId.getText())) {
                    Notifications notificationManager = Notifications.create()
                            .title("Supplier Order")
                            .text("     DELETE!")
                            .hideAfter(Duration.seconds(1))
                            .position(Pos.CENTER);
                    setTableValues(getAllSupplierOrders());
                    //notificationManager.darkStyle();
                    notificationManager.show();
                }
            } catch (Exception ex) {
                Logger.getLogger(SupplierOrderFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void btnUpdateAction(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, " Are you sure you want to delete " + " ?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            try {
                SupplierOrderDTO supplierOrderDTO = new SupplierOrderDTO();
                supplierOrderDTO.setSupplierOId(txtSOrderId.getText());
                supplierOrderDTO.setSupplierId(txtSupplierId.getSelectionModel().getSelectedItem().toString());
                supplierOrderDTO.setBatchId(txtBatchId.getText());
                supplierOrderDTO.setItemBrand(txtItemBrand.getSelectionModel().getSelectedItem().toString());
                supplierOrderDTO.setIdescription(txtdescription.getText());
                supplierOrderDTO.setiQty(Integer.parseInt(txtQty.getText().toString()));
                supplierOrderDTO.setDate(txtDate.getText());

                if (updateSupplierOrderController(supplierOrderDTO)) {
                    System.out.println("SupplierOrder");
                    Notifications notificationManager = Notifications.create()
                            .title("Supplier Order")
                            .text("     UPDATE!")
                            .hideAfter(Duration.seconds(1))
                            .position(Pos.CENTER);
                    setTableValues(getAllSupplierOrders());
                    //notificationManager.darkStyle();
                    notificationManager.show();
                }
            } catch (Exception ex) {
                Logger.getLogger(SupplierOrderFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void btnNewAction(MouseEvent event) throws Exception {
        txtQty.clear();
        txtdescription.clear();
        setTableValues(getAllSupplierOrders());
    }

    private void btnSearchAction(MouseEvent event) {
        try {
            SupplierOrderDTO sodto = searchSupplierOrders(txtSOrderId.getText());
            txtBatchId.setText(sodto.getBatchId());
            txtDate.setText(sodto.getDate());
            txtItemBrand.setValue(sodto.getItemBrand());
            txtQty.setText(sodto.getiQty() + "");
            txtSOrderId.setText(sodto.getSupplierOId());
            txtSupplierId.setValue(sodto.getSupplierId());
            txtdescription.setText(sodto.getIdescription());

        } catch (Exception ex) {
            Logger.getLogger(SupplierOrderFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void LoadCombo() {
        txtItemBrand.setItems(list);
    }
    ObservableList<String> list = FXCollections.observableArrayList("Apple", "Sony", "Samsung", "Xiaomi", "Nokia");

    private void dateShowDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD E");
        txtDate.setText(simpleDateFormat.format(date));

    }

    public static boolean addSupplierOrderController(SupplierOrderDTO supplierOrderDTO) throws Exception {
        SupplierOrderService supplierOrderService = (SupplierOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIERORDER);
        return supplierOrderService.addSupplierOrder(supplierOrderDTO);
    }

    public static boolean deleteSupplierOrderController(String supplierId) throws Exception {
        SupplierOrderService supplierOrderService = (SupplierOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIERORDER);
        return supplierOrderService.deleteSupplierOrder(supplierId);
    }

    public static boolean updateSupplierOrderController(SupplierOrderDTO supplierOrderDTO) throws Exception {
        SupplierOrderService supplierOrderService = (SupplierOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIERORDER);
        return supplierOrderService.updateSupplierOrder(supplierOrderDTO);
    }

    public static List<SupplierOrderDTO> getAllSupplierOrders() throws Exception {
        SupplierOrderService supplierOrderService = (SupplierOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIERORDER);
        return supplierOrderService.getAllSupplierOrder();
    }

    public static SupplierOrderDTO searchSupplierOrders(String SupplierOId) throws Exception {
        SupplierOrderService supplierOrderService = (SupplierOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIERORDER);
        return supplierOrderService.searchSupplierOrder(SupplierOId);
    }
    ////////////////////////Batch Controllers

    public static boolean addBatchController(BatchDTO batchDTO) throws Exception {
        BatchService batchService = (BatchService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.BATCH);
        return batchService.addBatch(batchDTO);
    }

    public static boolean deleteBatchController(String batchId) throws Exception {
        BatchService batchService = (BatchService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.BATCH);
        return batchService.deleteBatch(batchId);
    }

    public static boolean updateBatchController(BatchDTO batchDTO) throws Exception {
        BatchService batchService = (BatchService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.BATCH);
        return batchService.updateBatch(batchDTO);
    }

    public static List<BatchDTO> getAllBatch() throws Exception {
        BatchService batchService = (BatchService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.BATCH);
        return batchService.getAllBatch();
    }

    private void setTableValues(List<SupplierOrderDTO> allSupplierOrders) {
        int number = 1001;
        try {
            ObservableList<SupplierOrderDTO> SupplierOrderList = FXCollections.observableArrayList();
            for (SupplierOrderDTO supp : allSupplierOrders) {

                number++;
                SupplierOrderList.add(supp);
            }
            tblSupplierOrder.setItems(SupplierOrderList);
            txtSOrderId.setText("T" + number);
            txtBatchId.setText("B" + number);
        } catch (NullPointerException e) {
            Logger.getLogger(SupplierOrderFormController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setCellTable() {

        clmsOrderId.setCellValueFactory(new PropertyValueFactory<>("SupplierOId"));
        clmSupplierId.setCellValueFactory(new PropertyValueFactory<>("SupplierId"));
        clmBtachId.setCellValueFactory(new PropertyValueFactory<>("batchId"));
        clmItemBrand.setCellValueFactory(new PropertyValueFactory<>("itemBrand"));
        clmQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        clmDescription.setCellValueFactory(new PropertyValueFactory<>("idescription"));
        clmDate.setCellValueFactory(new PropertyValueFactory<>("date"));

    }

    private void setTableValueToTextField() {
        tblSupplierOrder.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                SupplierOrderDTO supplierOrder = tblSupplierOrder.getItems().get(tblSupplierOrder.getSelectionModel().getSelectedIndex());

                txtBatchId.setText(supplierOrder.getBatchId());
                txtDate.setText(supplierOrder.getDate());
                txtItemBrand.setValue(supplierOrder.getItemBrand());
                txtSOrderId.setText(supplierOrder.getSupplierOId());
                txtQty.setText(supplierOrder.getiQty() + "");
                txtSupplierId.setValue(supplierOrder.getSupplierId());
                txtdescription.setText(supplierOrder.getIdescription());
            }

        });
    }

    public void fillComboBox() throws Exception {
        System.out.println("2");
        List<SupplierDTO> allSupplierController = getAllSupplierController();

        ObservableList<Object> list2 = null;

        for (SupplierDTO supplierDTO : allSupplierController) {
            String supname = supplierDTO.getSupplierId();

            System.out.println(supplierDTO);
            System.out.println("3");
            list2 = FXCollections.observableArrayList();
            list2.add(supname);
            /*
             private void LoadCombo() {
        txtItemBrand.setItems(list);
    }
    ObservableList<String> list = FXCollections.observableArrayList("Apple", "Sony", "Samsung", "Xiaomi", "Nokia");
             */
        }
        txtSupplierId.setItems(list2);
    }

    private void loadCombo() throws Exception {
        fillComboBox();

        txtSupplierId.setValue("S001");

//        SupplierDTO dTO= (SupplierDTO) getAllSupplierController();
//        for (SupplierDTO obsdfject : dTO) {
//            
//        }
    }

    public static List<SupplierDTO> getAllSupplierController() throws Exception {
        SupplierService supplierService = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return supplierService.getAllSupplier();
    }

}
