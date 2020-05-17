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
import java.util.Date;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import static lk.ijse.mscs.controller.ReceptionFormController.getAllReceptionController;
import static lk.ijse.mscs.controller.SupplierOrderFormController.getAllSupplierOrders;
import lk.ijse.mscs.dto.GRNDTO;
import lk.ijse.mscs.dto.SupplierOrderDTO;
import lk.ijse.mscs.proxy.ProxyHandler;
import lk.ijse.mscs.service.ServiceFactory;
import lk.ijse.mscs.service.custom.GRNService;
import lk.ijse.mscs.service.custom.SupplierOrderService;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author samishka
 */
public class GRNFormController implements Initializable {

    @FXML
    private JFXTextField txtGRNId;
    @FXML
    private JFXTextField txtBatchId;
    @FXML
    private JFXTextField txtSupplierOrderId;
    @FXML
    private JFXTextField txtItemBrandId;
    @FXML
    private JFXTextField txtdescription;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private JFXTextField txtSOrderDate;
    @FXML
    private JFXTextField txtSupplierID;
    @FXML
    private JFXTextField txtDDate;
    @FXML
    private JFXTextField txtDQTY;
    @FXML
    private JFXTextField txtWarranty;
    @FXML
    private JFXTextField txtUnitPrice;
    @FXML
    private JFXTextField txtSalePrice;

    //////////////////////////////////////////
    @FXML
    private TableColumn<?, ?> clmSupplierId;
    //////////////////////////////////////////
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
    private TableColumn<?, ?> clmDescription;
    @FXML
    private TableColumn<?, ?> clmOrderQty;
    @FXML
    private TableColumn<?, ?> clmOrderDate;
    @FXML
    private TableColumn<?, ?> clmDeliverDate;
    @FXML
    private TableColumn<?, ?> clmDeliverQTY;
    @FXML
    private TableColumn<?, ?> clmWarranty;
    @FXML
    private TableColumn<?, ?> clmUnitPrice;
    @FXML
    private TableColumn<?, ?> clmSalePrice;
    @FXML
    private TableView<SupplierOrderDTO> tblSupplierDate;
    @FXML
    private TableColumn<?, ?> clmSupplierIdnew;
    @FXML
    private TableColumn<?, ?> clmSuDatenew;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setCurrentDate();
        setSellTable2();
        setCellTable();

        try {
            // TODO
            setTableValues2(getAll());
            setTableValues(getAllSupplierOrders());
        } catch (Exception ex) {
            Logger.getLogger(GRNFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setTableValueToTextField();
        setTableValueToTextFieal2();
    }

    @FXML
    private void btnSaveUpdateAction(MouseEvent event) {

        try {
            GRNDTO grndto = new GRNDTO();
            grndto.setGrnId(txtGRNId.getText());
            grndto.setSupplierId(txtSupplierID.getText());
            grndto.setBatchId(txtBatchId.getText());
            grndto.setDeliverdDate(txtDDate.getText());
            grndto.setDeliverdQty(txtDQTY.getText());
            grndto.setDescription(txtdescription.getText());
            grndto.setItemBrand(txtItemBrandId.getText());
            grndto.setOrderDate(txtSOrderDate.getText());
            grndto.setOrderQty(txtQty.getText());
            grndto.setsOrderId(txtSupplierOrderId.getText());
            grndto.setSallingPrice(txtSalePrice.getText());
            grndto.setUnitPrice(Double.parseDouble(txtUnitPrice.getText()));
            grndto.setWarranty(txtWarranty.getText());

            if (addGRNController(grndto)) {
                Notifications notificationManager = Notifications.create()
                        .title("GRN")
                        .text("     SAVE!")
                        .hideAfter(Duration.seconds(1))
                        .position(Pos.BOTTOM_RIGHT);
                setTableValues2(getAll());
                notificationManager.darkStyle();
                notificationManager.show();

            }
        } catch (Exception ex) {
            Logger.getLogger(GRNFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btndeleteAction(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to update ", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            try {
                if (deleteGRNController(txtGRNId.getText())) {
                    Notifications notificationManager = Notifications.create()
                            .title("GRN")
                            .text("     DELETE!")
                            .hideAfter(Duration.seconds(1))
                            .position(Pos.BOTTOM_RIGHT);
                    setTableValues2(getAll());
                    notificationManager.darkStyle();
                    notificationManager.show();
                }
            } catch (Exception ex) {
                Logger.getLogger(GRNFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void btnUpdateAction(MouseEvent event) {
        try {
            GRNDTO grndto = new GRNDTO();
            grndto.setGrnId(txtGRNId.getText());
            grndto.setSupplierId(txtSupplierID.getText());
            grndto.setBatchId(txtBatchId.getText());
            grndto.setDeliverdDate(txtDDate.getText());
            grndto.setDeliverdQty(txtDQTY.getText());
            grndto.setDescription(txtdescription.getText());
            grndto.setItemBrand(txtItemBrandId.getText());
            grndto.setOrderDate(txtSOrderDate.getText());
            grndto.setOrderQty(txtQty.getText());
            grndto.setsOrderId(txtSupplierOrderId.getText());
            grndto.setSallingPrice(txtSalePrice.getText());
            grndto.setUnitPrice(Double.parseDouble(txtUnitPrice.getText()));
            grndto.setWarranty(txtWarranty.getText());

            if (updateGRNController(grndto)) {
                Notifications notificationManager = Notifications.create()
                        .title("GRN")
                        .text("     UPDATE!")
                        .hideAfter(Duration.seconds(1))
                        .position(Pos.BOTTOM_RIGHT);
                setTableValues2(getAll());
                notificationManager.darkStyle();
                notificationManager.show();

            }
        } catch (Exception ex) {
            Logger.getLogger(GRNFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnNewAction(MouseEvent event) throws Exception {

        txtSupplierID.clear();
        txtBatchId.clear();
        txtDQTY.clear();
        txtdescription.clear();
        txtItemBrandId.clear();
        txtSOrderDate.clear();
        txtQty.clear();
        txtSupplierOrderId.clear();
        txtSalePrice.clear();
        txtUnitPrice.clear();
        txtWarranty.clear();
        setTableValues2(getAll());
    }

    public static List<SupplierOrderDTO> getAllSupplierOrders() throws Exception {
        SupplierOrderService supplierOrderService = (SupplierOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIERORDER);
        return supplierOrderService.getAllSupplierOrder();
    }

    private void setTableValues(List<SupplierOrderDTO> allSupplierOrders) {
        int number = 1001;
        try {
            ObservableList<SupplierOrderDTO> SupplierOrderList = FXCollections.observableArrayList();
            for (SupplierOrderDTO grnh : allSupplierOrders) {
                number++;
                SupplierOrderList.add(grnh);
            }
            tblSupplierDate.setItems(SupplierOrderList);

        } catch (NullPointerException e) {
            Logger.getLogger(GRNFormController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setCellTable() {

        clmSupplierIdnew.setCellValueFactory(new PropertyValueFactory<>("SupplierOId"));
        clmSuDatenew.setCellValueFactory(new PropertyValueFactory<>("date"));

    }

    private void setTableValueToTextField() {
        tblSupplierDate.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                /*
                private String SupplierOId;
    private String SupplierId;
    private String batchId;
    private String itemBrand;
    private String idescription;
    private int iQty;
    private String date;
                 */
                SupplierOrderDTO supplierOrder = tblSupplierDate.getItems().get(tblSupplierDate.getSelectionModel().getSelectedIndex());

                txtSupplierID.setText(supplierOrder.getSupplierOId());
                txtBatchId.setText(supplierOrder.getBatchId());
                txtItemBrandId.setText(supplierOrder.getItemBrand());
//                txtSOrderDate
                txtSOrderDate.setText(supplierOrder.getDate());
                txtSupplierOrderId.setText(supplierOrder.getSupplierOId());
                txtdescription.setText(supplierOrder.getIdescription());
                txtQty.setText(supplierOrder.getiQty() + "");

//                txtBatchId.setText(supplierOrder.getBatchId());
//                txtDate.setText(supplierOrder.getDate());
//                txtItemBrand.setValue(supplierOrder.getItemBrand());
//                txtSOrderId.setText(supplierOrder.getSupplierOId());
//                txtQty.setText(supplierOrder.getiQty()+"");
//                txtSupplierId.setText(supplierOrder.getSupplierId());
//                txtdescription.setText(supplierOrder.getIdescription());
            }

        });
    }

    private void setCurrentDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD E");
        txtDDate.setText(dateFormat.format(date));

    }

    public static boolean addGRNController(GRNDTO grndto) throws Exception {
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.addGRN(grndto);

    }

    public static boolean updateGRNController(GRNDTO grndto) throws Exception {
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.updateGRN(grndto);
    }

    public static boolean deleteGRNController(String grnId) throws Exception {
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.deleteGRN(grnId);
    }

    public static GRNDTO searchGRNController(String grnId) throws Exception {
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.search(grnId);
    }

    public static List<GRNDTO> getAll() throws Exception {
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.getAllGRN();
    }

    private void setSellTable2() {
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

    private void setTableValues2(List<GRNDTO> all) {
        int number = 1001;
        try {
            ObservableList<GRNDTO> SupplierOrderList = FXCollections.observableArrayList();
            for (GRNDTO grnh : all) {
                number++;
                SupplierOrderList.add(grnh);
            }
            tblGRN.setItems(SupplierOrderList);
            txtGRNId.setText("G" + number);
        } catch (NullPointerException e) {
            Logger.getLogger(GRNFormController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setTableValueToTextFieal2() {
        tblGRN.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                GRNDTO grndto = tblGRN.getItems().get(tblGRN.getSelectionModel().getSelectedIndex());

                txtGRNId.setText(grndto.getGrnId());
                txtSupplierID.setText(grndto.getSupplierId());
                txtBatchId.setText(grndto.getBatchId());
                txtDDate.setText(grndto.getDeliverdDate());
                txtDQTY.setText(grndto.getDeliverdQty());
                txtdescription.setText(grndto.getDescription());
                txtItemBrandId.setText(grndto.getItemBrand());
                txtSOrderDate.setText(grndto.getsOrderId());
                txtQty.setText(grndto.getOrderQty());
                txtSupplierOrderId.setText(grndto.getsOrderId());
                txtSalePrice.setText(grndto.getSallingPrice());
                txtUnitPrice.setText(grndto.getUnitPrice() + "");
                txtWarranty.setText(grndto.getWarranty());
            }

        });
    }
}
