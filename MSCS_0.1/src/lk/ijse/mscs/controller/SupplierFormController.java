/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.controller;

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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import static lk.ijse.mscs.controller.SupplierFormController.getAllSupplierController;
import lk.ijse.mscs.dto.SupplierDTO;
import lk.ijse.mscs.proxy.ProxyHandler;
import lk.ijse.mscs.service.ServiceFactory;
import lk.ijse.mscs.service.custom.SupplierService;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author samishka
 */
public class SupplierFormController implements Initializable {

    @FXML
    private TableView<SupplierDTO> tblSupplier;
    @FXML
    private TableColumn<?, ?> clmSupplierId;
    @FXML
    private TableColumn<?, ?> clmNIC;
    @FXML
    private TableColumn<?, ?> clmName;
    @FXML
    private TableColumn<?, ?> clmAddress;
    @FXML
    private TableColumn<?, ?> clmContact;
    @FXML
    private TableColumn<?, ?> clmEmail;
    @FXML
    private JFXTextField txtSupplierId;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtNIC;
    @FXML
    private JFXTextField txtContact;
    @FXML
    private JFXTextField txtEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setCellTable();
        setTableValueToTextField();
        //IdGenarater();
        try {
            // TODO
            setTableValues(getAllSupplierController());
        } catch (Exception ex) {
            Logger.getLogger(SupplierFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean addSupplier(SupplierDTO supplierDTO) throws Exception {
        SupplierService supplierService = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return supplierService.addSupplier(supplierDTO);
    }

    public static boolean deleteSupplier(String spplirtId) throws Exception {
        SupplierService supplierService = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return supplierService.deleteSupplier(spplirtId);
    }

    public static boolean UpdateSupplier(SupplierDTO supplierDTO) throws Exception {
        SupplierService supplierService = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return supplierService.updateSupplier(supplierDTO);
    }

    public static List<SupplierDTO> getAllSupplierController() throws Exception {
        SupplierService supplierService = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return supplierService.getAllSupplier();
    }

    public static SupplierDTO searchSupplier(String supplierId) throws Exception {
        SupplierService supplierService = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return supplierService.searchSupplier(supplierId);
    }

    @FXML
    private void btnDeleteAction(MouseEvent event) {

        String supplierId = txtSupplierId.getText();

        Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to delete " + " ?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            try {
                //do stuff

                if (deleteSupplier(supplierId)) {

                    Notifications notificationManager = Notifications.create()
                            .title("Supplier")
                            .text("     DELETED!")
                            .hideAfter(Duration.seconds(1))
                            .position(Pos.BOTTOM_RIGHT);
                    notificationManager.darkStyle();
                    notificationManager.show();
                    setTableValues(getAllSupplierController());
                }
            } catch (Exception ex) {
                Logger.getLogger(SupplierFormController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @FXML
    private void btnSaveAction(MouseEvent event) {
        //IdGenarater();
        try {
            SupplierDTO supplierDTO = new SupplierDTO();
            supplierDTO.setSupplierId(txtSupplierId.getText());
            supplierDTO.setNIC(txtNIC.getText());
            supplierDTO.setName(txtName.getText());
            supplierDTO.setAddress(txtAddress.getText());
            supplierDTO.setContact(txtContact.getText());
            supplierDTO.setEmail(txtEmail.getText());

            if (addSupplier(supplierDTO)) {
                Notifications notificationManager = Notifications.create()
                        .title("Supplier")
                        .text("     SAVE!")
                        .hideAfter(Duration.seconds(1))
                        .position(Pos.BOTTOM_RIGHT);
                notificationManager.darkStyle();

                notificationManager.show();
                setTableValues(getAllSupplierController());

            }
        } catch (Exception ex) {
            Logger.getLogger(SupplierFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnUpdateAction(MouseEvent event) {

        Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to update  ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            //do stuff
            try {
                SupplierDTO supplierDTO = new SupplierDTO();
                supplierDTO.setSupplierId(txtSupplierId.getText());
                supplierDTO.setNIC(txtNIC.getText());
                supplierDTO.setName(txtName.getText());
                supplierDTO.setAddress(txtAddress.getText());
                supplierDTO.setContact(txtContact.getText());
                supplierDTO.setEmail(txtEmail.getText());

                if (UpdateSupplier(supplierDTO)) {
                    Notifications notificationManager = Notifications.create()
                            .title("Supplier")
                            .text("     UPDATE!")
                            .hideAfter(Duration.seconds(1))
                            .position(Pos.BOTTOM_RIGHT);
                    notificationManager.darkStyle();
                    notificationManager.show();
                    setTableValues(getAllSupplierController());
                }
            } catch (Exception ex) {
                Logger.getLogger(SupplierFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void btnNew(MouseEvent event) throws Exception {

        txtNIC.clear();
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtEmail.clear();
        setTableValues(getAllSupplierController());

    }

    private void textClear() {
        txtSupplierId.clear();
        txtNIC.clear();
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtEmail.clear();

    }

    private void setTableValues(List<SupplierDTO> allSupplierController) {
        int number = 1001;
        try {
            ObservableList<SupplierDTO> SupplierList = FXCollections.observableArrayList();

            for (SupplierDTO supplierDTO : allSupplierController) {
                number++;
                SupplierList.add(supplierDTO);
            }
            tblSupplier.setItems(SupplierList);
            txtSupplierId.setText("S" + number);
        } catch (NullPointerException e) {
            Logger.getLogger(ReceptionFormController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setCellTable() {
        clmSupplierId.setCellValueFactory(new PropertyValueFactory<>("SupplierId"));
        clmNIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        clmName.setCellValueFactory(new PropertyValueFactory<>("name"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        clmContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        clmEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
    }

    public void setTableValueToTextField() {
        tblSupplier.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                SupplierDTO reception = tblSupplier.getItems().get(tblSupplier.getSelectionModel().getSelectedIndex());
                txtSupplierId.setText(reception.getSupplierId());
                txtNIC.setText(reception.getNIC());
                txtName.setText(reception.getName());
                txtAddress.setText(reception.getAddress());
                txtContact.setText(reception.getContact());
                txtEmail.setText(reception.getEmail());
            }

        });
    }
//    private void IdGenarater() {
//        int idnumber = tblSupplier.getItems().size();
//        idnumber++;
//        txtSupplierId.setText("" + idnumber);
//
//    }
}
