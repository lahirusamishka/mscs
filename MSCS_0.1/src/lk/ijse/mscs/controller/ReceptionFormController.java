/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.controller;

import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.image.impl.IntArgb;
import java.awt.Dialog;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import javax.management.Notification;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lk.ijse.jasper.IJSEJasperViewer;
import lk.ijse.mscs.dto.ReceptionDTO;
import lk.ijse.mscs.proxy.ProxyHandler;
import lk.ijse.mscs.service.ServiceFactory;
import lk.ijse.mscs.service.custom.ReceptionService;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author samishka
 */
public class ReceptionFormController implements Initializable {

    @FXML
    private JFXTextField txtReceptionId;
    @FXML
    private JFXTextField txtContact;
    @FXML
    private JFXTextField txtNIC;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private TableView<ReceptionDTO> tblReception;
    @FXML
    private TableColumn<?, ?> columnReceptionId;
    @FXML
    private TableColumn<?, ?> columnNIC;
    @FXML
    private TableColumn<?, ?> columnName;
    @FXML
    private TableColumn<?, ?> columnAddress;
    @FXML
    private TableColumn<?, ?> columnContact;
    @FXML
    private TableColumn<?, ?> columnEmail;

    /**
     * Initializes the controller class.
     */
    ReceptionDTO receptionDTO;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            setTableValues(getAllReceptionController());
        } catch (Exception ex) {
            Logger.getLogger(ReceptionFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setCellTable();
        setTableValueToTextField();
    }

    @FXML
    private void btnSaveUpdateAction(MouseEvent event) {
        // reception save 

        // System.out.println("Sucess");
        try {
            ReceptionDTO receptionDTO = new ReceptionDTO();

            receptionDTO.setReceptionId(txtReceptionId.getText());
            receptionDTO.setNIC(txtNIC.getText());
            receptionDTO.setName(txtName.getText());
            receptionDTO.setAddress(txtAddress.getText());
            receptionDTO.setContact(txtContact.getText());
            receptionDTO.setEmail(txtEmail.getText());

            if (addReceptionController(receptionDTO)) {
                Notifications notificationManager = Notifications.create()
                        .title("Reception")
                        .text("     SAVE!")
                        .hideAfter(Duration.seconds(1))
                        .position(Pos.BOTTOM_RIGHT);

                notificationManager.darkStyle();
                notificationManager.show();
                setTableValues(getAllReceptionController());
            }
        } catch (Exception ex) {
            Logger.getLogger(ReceptionFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btndeleteAction(MouseEvent event) throws Exception {
        String reception = txtReceptionId.getText();
        String receptionName = "Unknown";
        receptionName = txtName.getText();

        Alert alert = new Alert(AlertType.CONFIRMATION, " Are you sure you want to delete " + " ?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            //do stuff

            if (deleteReceptionController(reception)) {
                System.out.println(" 1");
                try {
                    Notifications notificationManager = Notifications.create()
                            .title("Reception")
                            .text("     DELETED!")
                            .hideAfter(Duration.seconds(1))
                            .position(Pos.BOTTOM_RIGHT);
                    notificationManager.darkStyle();
                    System.out.println(" 2");
                    notificationManager.show();
                    textClear();

                    setTableValues(getAllReceptionController());
                } catch (Exception ex) {
                    Logger.getLogger(ReceptionFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    @FXML
    private void btnUpdateAction(MouseEvent event) {
        String receptionName = "Unknown";
        receptionName = txtName.getText();

        Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to update " + receptionName + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            //do stuff
            try {
                receptionDTO = new ReceptionDTO();

                receptionDTO.setReceptionId(txtReceptionId.getText());
                receptionDTO.setNIC(txtNIC.getText());
                receptionDTO.setName(txtName.getText());
                receptionDTO.setAddress(txtAddress.getText());
                receptionDTO.setContact(txtContact.getText());
                receptionDTO.setEmail(txtEmail.getText());

                if (updateReceptionController(receptionDTO)) {
                    Notifications notificationManager = Notifications.create()
                            .title("Reception")
                            .text("   UPDATE !")
                            .hideAfter(Duration.seconds(1))
                            .position(Pos.BOTTOM_RIGHT);

                    notificationManager.darkStyle();
                    notificationManager.show();
                    setTableValues(getAllReceptionController());
                }
            } catch (Exception ex) {
                Logger.getLogger(ReceptionFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void setCellTable() {
        columnReceptionId.setCellValueFactory(new PropertyValueFactory<>("receptionId"));
        columnNIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        columnContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));

    }

    public static boolean addReceptionController(ReceptionDTO receptionDTO) throws Exception {
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.RECEPTION);
        return receptionService.addReception(receptionDTO);
    }

    public static boolean deleteReceptionController(String receptionId) throws Exception {
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.RECEPTION);
        return receptionService.deleteReception(receptionId);
    }

    public static boolean updateReceptionController(ReceptionDTO receptionDTO) throws Exception {
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.RECEPTION);
        return receptionService.updateReception(receptionDTO);
    }

    public static List<ReceptionDTO> getAllReceptionController() throws Exception {
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.RECEPTION);
        return receptionService.getAllReception();
    }

    private void setTableValues(List<ReceptionDTO> allReceptionController) {
        int number = 1;
        try {
            ObservableList<ReceptionDTO> receptionList = FXCollections.observableArrayList();
            for (ReceptionDTO furniture : allReceptionController) {
                number++;
                receptionList.add(furniture);
            }
            tblReception.setItems(receptionList);
            txtReceptionId.setText("R" + number);
        } catch (NullPointerException e) {
            Logger.getLogger(ReceptionFormController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void setTableValueToTextField() {
        tblReception.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                ReceptionDTO reception = tblReception.getItems().get(tblReception.getSelectionModel().getSelectedIndex());
                txtReceptionId.setText(reception.getReceptionId() + "");
                txtNIC.setText(reception.getNIC());
                txtName.setText(reception.getName());
                txtAddress.setText(reception.getAddress());
                txtContact.setText(reception.getContact());
                txtEmail.setText(reception.getEmail());
            }

        });
    }

    @FXML
    private void btnNewAction(MouseEvent event) throws Exception {

        txtNIC.clear();
        txtNIC.requestFocus();
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtEmail.clear();
        setTableValues(getAllReceptionController());
    }

    private void textClear() {

        txtNIC.clear();
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtEmail.clear();
    }

    @FXML
    private void btnPrintReceptions(MouseEvent event) throws JRException {

        
        
        
        JasperReport compiledReport = (JasperReport) JRLoader.loadObject(ReceptionFormController.class.getResourceAsStream("/lk/ijse/mscs/jusperReports/Reception1s.jasper"));
                HashMap<String, Object> reportParams = new HashMap<>();
                reportParams.put("id", receptionDTO.getReceptionId());
                reportParams.put("name", receptionDTO.getName());
                reportParams.put("address", receptionDTO.getAddress());
                reportParams.put("contact",  receptionDTO.getContact());
                reportParams.put("email",  receptionDTO.getEmail());
                
                JasperPrint filledReport = JasperFillManager.fillReport(compiledReport, reportParams, new JREmptyDataSource());
                IJSEJasperViewer frmJasperViewer = new IJSEJasperViewer(filledReport);
                frmJasperViewer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frmJasperViewer.setTitle("Place Order");
                frmJasperViewer.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
                frmJasperViewer.setVisible(true);
    }
}
