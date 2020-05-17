/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
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
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.table.TableModel;
import lk.ijse.jasper.IJSEJasperViewer;
import lk.ijse.jasper.JasperUtil;
import lk.ijse.jasper.Report;
import lk.ijse.mscs.dto.CustomerDTO;
import lk.ijse.mscs.observer.Observer1;
import lk.ijse.mscs.observer.Subject;
import lk.ijse.mscs.proxy.ProxyHandler;
import lk.ijse.mscs.service.ServiceFactory;
import lk.ijse.mscs.service.custom.CustomerService;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperReportsContext;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author samishka
 */
@Report("lk.ijse.mscs.jusperReports")
public class CustomerFormController implements Initializable, Observer1 {

    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtContact;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private TableColumn<?, ?> columnName;
    @FXML
    private TableColumn<?, ?> columnAddress;
    @FXML
    private TableColumn<?, ?> columnContact;
    @FXML
    private TableColumn<?, ?> columnEmail;
    @FXML
    private JFXTextField txtCustomerId;
    @FXML
    private TableView<CustomerDTO> tblCustomer;
    @FXML
    private TableColumn<?, ?> columnCustomerID;

    private Subject subject;
    private boolean update = false;
    private String reservedCustomerId = "";

    // private CustomerService customerService;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            subject = (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
            subject.registerObserver(this);
            subject.registerObserver(this);
            updateObservers();
            setCellTable();
            try {
                setTableValues(getAllCustomerController());
            } catch (Exception ex) {
                Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
            setTableValuesForTextFeald();
            try {
                txtClearMethod();
            } catch (Exception ex) {
                Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnSearchAction(MouseEvent event) throws Exception {
        CustomerDTO cdto = searchCustomerController(txtCustomerId.getText());

        txtName.setText(cdto.getCustomerName());
        txtAddress.setText(cdto.getCustomerAddress());
        txtContact.setText(cdto.getConatactNo());
        txtEmail.setText(cdto.getEmail());
    }

    @FXML
    private void btnSaveAction(MouseEvent event) {

        try {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(txtCustomerId.getText());
            customerDTO.setCustomerName(txtName.getText());
            customerDTO.setCustomerAddress(txtAddress.getText());
            customerDTO.setConatactNo(txtContact.getText());
            customerDTO.setEmail(txtEmail.getText());
            boolean added = addCustomerController(customerDTO);
            if (added) {
                Notifications notificationManager = Notifications.create()
                        .title("Reception")
                        .text("     SAVE!")
                        .hideAfter(Duration.seconds(1))
                        .position(Pos.BOTTOM_RIGHT);
                notificationManager.darkStyle();
                txtClearMethod();
                notificationManager.show();
                setTableValues(getAllCustomerController());
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btndeleteAction(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, " Are you sure you want to delete " + " ?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {

            try {
                if (deleteCustomerController(txtCustomerId.getText())) {
                    Notifications notificationManager = Notifications.create()
                            .title("Customer")
                            .text("    DELETED!")
                            .hideAfter(Duration.seconds(1))
                            .position(Pos.CENTER);
                    notificationManager.show();
                    setTableValues(getAllCustomerController());
                    txtClearMethod();
                }
            } catch (Exception ex) {
                Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void btnUpdateAction(MouseEvent event) {
        try {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(txtCustomerId.getText());
            customerDTO.setCustomerName(txtName.getText());
            customerDTO.setCustomerAddress(txtAddress.getText());
            customerDTO.setConatactNo(txtContact.getText());
            customerDTO.setEmail(txtEmail.getText());
            boolean added = updateCustomerController(customerDTO);
            if (added) {
                Notifications notificationManager = Notifications.create()
                        .title("Customer")
                        .text("     UPDATE!")
                        .hideAfter(Duration.seconds(1))
                        .position(Pos.CENTER);
                notificationManager.show();
                setTableValues(getAllCustomerController());
                txtClearMethod();
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnNewAction(MouseEvent event) throws Exception {

        releaseCustomer(txtCustomerId.getText());
        reservedCustomerId = "";
        txtAddress.clear();
        txtContact.clear();
        txtEmail.clear();
        txtName.clear();
        setTableValues(getAllCustomerController());
    }

    public static boolean addCustomerController(CustomerDTO customerDTO) throws Exception {
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerService.addCustomer(customerDTO);
    }

    public static boolean updateCustomerController(CustomerDTO customerDTO) throws Exception {
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerService.updateCustomer(customerDTO);
    }

    public static boolean deleteCustomerController(String customerDTO) throws Exception {
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerService.deleteCustomer(customerDTO);
    }

    public static List<CustomerDTO> getAllCustomerController() throws Exception {
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerService.getAllCustomers();
    }

    public static CustomerDTO searchCustomerController(String customerId) throws Exception {
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerService.searchCustomer(customerId);
    }

    public static boolean reserveCustomer(String customerID) throws Exception {
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerService.reserve(customerID);
    }

    public static boolean releaseCustomer(String customerID) throws Exception {
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerService.release(customerID);
    }

    private void setCellTable() {
        columnCustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        columnContact.setCellValueFactory(new PropertyValueFactory<>("conatactNo"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));

    }

    private void setTableValues(List<CustomerDTO> allCustomerController) {
        int number = 100;
        try {
            ObservableList<CustomerDTO> customerList = FXCollections.observableArrayList();
            for (CustomerDTO furniture : allCustomerController) {
                number++;
                customerList.add(furniture);
            }
            tblCustomer.setItems(customerList);
            txtCustomerId.setText("C" + number);
            System.out.println(number);
        } catch (NullPointerException e) {
            Logger.getLogger(ReceptionFormController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setTableValuesForTextFeald() {
        tblCustomer.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("acction in");
                if (tblCustomer.getSelectionModel().getSelectedIndex() == -1) {
                    //button set enable code
                    update = false;
                    return;
                }

                if (reservedCustomerId == "") {

                    try {
                        releaseCustomer(reservedCustomerId);

                        int number = tblCustomer.getSelectionModel().getSelectedIndex();
                        reservedCustomerId = number + "";

                        boolean reserveCustomer = reserveCustomer(reservedCustomerId);

                        if (reserveCustomer) {
                            update = true;
                            int rews = tblCustomer.getSelectionModel().getSelectedIndex();
                            CustomerDTO reception = tblCustomer.getItems().get(tblCustomer.getSelectionModel().getSelectedIndex());

                            txtCustomerId.setText(reception.getCustomerId());
                            txtName.setText(reception.getCustomerName());
                            txtAddress.setText(reception.getCustomerAddress());
                            txtContact.setText(reception.getConatactNo());
                            txtEmail.setText(reception.getEmail());

                        } else {
                            update = false;
                            System.out.println("Sorryyy");
                            tblCustomer.clipProperty();
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

        });
    }

    private void txtClearMethod() throws Exception {
        txtAddress.clear();
        txtContact.clear();
        txtEmail.clear();
        txtName.clear();
        setTableValues(getAllCustomerController());
    }

    @Override
    public void updateObservers() throws Exception {
        setTableValues(getAllCustomerController());
    }

    @FXML
    private void btnPrint(MouseEvent event) {

    }

    @FXML
    private void btnprintAction(MouseEvent event) {
    }

}
