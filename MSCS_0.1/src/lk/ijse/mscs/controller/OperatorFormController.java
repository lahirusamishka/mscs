/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.controller;

import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.scene.control.skin.TableViewSkin;
import com.sun.javafx.scene.control.skin.VirtualFlow;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import static lk.ijse.mscs.controller.ReceptionFormController.getAllReceptionController;
import lk.ijse.mscs.dto.MobileOperaterDTO;
import lk.ijse.mscs.proxy.ProxyHandler;
import lk.ijse.mscs.service.ServiceFactory;
import lk.ijse.mscs.service.custom.MobileOperaterService;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author samishka
 */
public class OperatorFormController implements Initializable {

    @FXML
    private TableView<MobileOperaterDTO> tblSupplier;
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
    private JFXTextField txtOperatorId;
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
    @FXML
    private TableColumn<?, ?> clmOperatorId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setCellTable();

        try {
            setTableValues(getAllMobileOperators());
        } catch (Exception ex) {
            Logger.getLogger(OperatorFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setTableValueToTextField();
        txtClears();
    }

    @FXML
    private void btnDeleteAction(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, " Are you sure you want to delete " + " ?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            try {
                if (deleteOperatorController(txtOperatorId.getText())) {
                    Notifications notificationManager = Notifications.create()
                            .title("Operator")
                            .text("     DELETE!")
                            .hideAfter(Duration.seconds(1))
                            .position(Pos.CENTER);
                    setTableValues(getAllMobileOperators());
                    txtClears();
                    //notificationManager.darkStyle();
                    notificationManager.show();
                }
            } catch (Exception ex) {
                Logger.getLogger(OperatorFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void btnSaveAction(MouseEvent event) {
        try {
            MobileOperaterDTO mobileOperaterDTO = new MobileOperaterDTO();
            mobileOperaterDTO.setMobileOperaterId(txtOperatorId.getText());
            mobileOperaterDTO.setNIC(txtNIC.getText());
            mobileOperaterDTO.setName(txtName.getText());
            mobileOperaterDTO.setAddress(txtAddress.getText());
            mobileOperaterDTO.setContact(txtContact.getText());
            mobileOperaterDTO.setEmail(txtEmail.getText());

            if (addOperatorController(mobileOperaterDTO)) {
                Notifications notificationManager = Notifications.create()
                        .title("Operator")
                        .text("     SAVE!")
                        .hideAfter(Duration.seconds(1))
                        .position(Pos.CENTER);

                //notificationManager.darkStyle();
                notificationManager.show();

                setTableValues(getAllMobileOperators());
            }

        } catch (Exception ex) {
            Logger.getLogger(OperatorFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnUpdateAction(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, " Are you sure you want to delete " + " ?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            try {
                MobileOperaterDTO mobileOperaterDTO = new MobileOperaterDTO();
                mobileOperaterDTO.setMobileOperaterId(txtOperatorId.getText());
                mobileOperaterDTO.setNIC(txtNIC.getText());
                mobileOperaterDTO.setName(txtName.getText());
                mobileOperaterDTO.setAddress(txtAddress.getText());
                mobileOperaterDTO.setContact(txtContact.getText());
                mobileOperaterDTO.setEmail(txtEmail.getText());

                if (updateOperatorController(mobileOperaterDTO)) {
                    Notifications notificationManager = Notifications.create()
                            .title("Operator")
                            .text("     UPDATE!")
                            .hideAfter(Duration.seconds(1))
                            .position(Pos.CENTER);

                    //notificationManager.darkStyle();
                    notificationManager.show();
                    setTableValues(getAllMobileOperators());
                }

            } catch (Exception ex) {
                Logger.getLogger(OperatorFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void btnNew(MouseEvent event) throws Exception {
        txtAddress.clear();
        txtContact.clear();
        txtEmail.clear();
        txtNIC.clear();
        txtName.clear();
        setTableValues(getAllMobileOperators());

    }

    @FXML
    private void btnSearchAction(MouseEvent event) {
        try {
            MobileOperaterDTO mobileOperaterDTO = searchMobileOperaterController(txtOperatorId.getText());
            txtAddress.setText(mobileOperaterDTO.getAddress());
            txtContact.setText(mobileOperaterDTO.getContact());
            txtEmail.setText(mobileOperaterDTO.getEmail());
            txtNIC.setText(mobileOperaterDTO.getNIC());
            txtName.setText(mobileOperaterDTO.getName());

        } catch (Exception ex) {
            Logger.getLogger(OperatorFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean addOperatorController(MobileOperaterDTO mobileOperaterDTO) throws Exception {
        MobileOperaterService mobileOperaterService = (MobileOperaterService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.MOBILEOPERATER);
        return mobileOperaterService.addOperater(mobileOperaterDTO);
    }

    public static boolean deleteOperatorController(String operatorId) throws Exception {
        MobileOperaterService mobileOperaterService = (MobileOperaterService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.MOBILEOPERATER);
        return mobileOperaterService.deleteOperater(operatorId);

    }

    public static boolean updateOperatorController(MobileOperaterDTO mobileOperaterDTO) throws Exception {
        MobileOperaterService mobileOperaterService = (MobileOperaterService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.MOBILEOPERATER);
        return mobileOperaterService.updateOperater(mobileOperaterDTO);
    }

    public static List<MobileOperaterDTO> getAllMobileOperators() throws Exception {
        MobileOperaterService mobileOperaterService = (MobileOperaterService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.MOBILEOPERATER);
        return mobileOperaterService.getAllOperater();
    }

    public static MobileOperaterDTO searchMobileOperaterController(String moId) throws Exception {
        MobileOperaterService mobileOperaterService = (MobileOperaterService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.MOBILEOPERATER);
        return mobileOperaterService.searchOperater(moId);
    }

    private void setCellTable() {
        clmOperatorId.setCellValueFactory(new PropertyValueFactory<>("MobileOperaterId"));
        clmNIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        clmName.setCellValueFactory(new PropertyValueFactory<>("name"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        clmContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        clmEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
    }

    private void setTableValues(List<MobileOperaterDTO> allMobileOperators) {
        int number = 1;
        try {
            ObservableList<MobileOperaterDTO> receptionList = FXCollections.observableArrayList();
            for (MobileOperaterDTO mobileOperaterDTO : allMobileOperators) {
                number++;
                receptionList.add(mobileOperaterDTO);
            }
            tblSupplier.setItems(receptionList);
            txtOperatorId.setText(number + "");
        } catch (NullPointerException e) {
            Logger.getLogger(ReceptionFormController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setTableValueToTextField() {
        tblSupplier.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                MobileOperaterDTO reception = tblSupplier.getItems().get(tblSupplier.getSelectionModel().getSelectedIndex());
                txtOperatorId.setText(reception.getMobileOperaterId());
                txtNIC.setText(reception.getNIC());
                txtName.setText(reception.getName());
                txtAddress.setText(reception.getAddress());
                txtContact.setText(reception.getContact());
                txtEmail.setText(reception.getEmail());
            }

        });
    }

//    private VirtualFlow<?> loadVirtualFlow() {
//        return (VirtualFlow<?>) ((TableViewSkin<?>) tblSupplier.getSkin()).getChildren().get(1);
//    }

    private void txtClears() {
        txtAddress.clear();
        txtContact.clear();
        txtEmail.clear();
        txtNIC.clear();
        txtName.clear();
        
    }
}
