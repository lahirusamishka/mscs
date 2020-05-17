/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.awt.Dialog;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import javax.swing.JFrame;
import lk.ijse.jasper.IJSEJasperViewer;
import static lk.ijse.mscs.controller.CustomerFormController.getAllCustomerController;
import static lk.ijse.mscs.controller.ItemFormController.itemAll;
import lk.ijse.mscs.dto.CustomerDTO;
import lk.ijse.mscs.dto.CustomerOrderDTO;
import lk.ijse.mscs.dto.GRNDTO;
import lk.ijse.mscs.dto.ItemsDTO;
import lk.ijse.mscs.dto.OperaterOrderDTO;
import lk.ijse.mscs.dto.OrderDetailDTO;
import lk.ijse.mscs.dto.OrderDetail_PKDTO;
import lk.ijse.mscs.proxy.ProxyHandler;
import lk.ijse.mscs.service.ServiceFactory;
import lk.ijse.mscs.service.custom.CustomerOrderService;
import lk.ijse.mscs.service.custom.CustomerService;
import lk.ijse.mscs.service.custom.GRNService;
import lk.ijse.mscs.service.custom.ItemsService;
import lk.ijse.mscs.service.custom.OrderDetailService;
import lk.ijse.mscs.validation.Validation;
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
public class PlaceOrderController extends Validation implements Initializable {

    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtContact;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private JFXTextField txtUnitPrice;
    @FXML
    private JFXTextField txtAmount;
    @FXML
    private JFXTextField txtInvoiceNo;
    @FXML
    private JFXTextField txtEmiNo;
    @FXML
    private JFXTextField txtWarranty;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtItemBrand;
    @FXML
    private JFXTextField txtDeliveryDate;
    @FXML
    private JFXTextField txtSalePrice;
    @FXML
    private TableView<?> tblCustomerOrder;
    @FXML
    private TableColumn<?, ?> clmInvoiceNo;
    @FXML
    private TableColumn<?, ?> clmCustomerName;
    @FXML
    private TableColumn<?, ?> clmAddress;
    @FXML
    private TableColumn<?, ?> clmContact;
    @FXML
    private TableColumn<?, ?> clmEmail;
    @FXML
    private TableColumn<?, ?> clmItemCode;
    @FXML
    private TableColumn<?, ?> clmItemBrand;
    @FXML
    private TableColumn<?, ?> clmDecription;
    @FXML
    private TableColumn<?, ?> clmQty;
    @FXML
    private TableColumn<?, ?> clmImei;
    @FXML
    private TableColumn<?, ?> clmAmount;
    @FXML
    private TableColumn<?, ?> clmdate;
    @FXML
    private TableColumn<?, ?> clmWaranty;
    @FXML
    private TableColumn<?, ?> clmPrice;
    @FXML
    private JFXTextField cmbCustomerID;

    private ObservableList<String> options2;

    private JFXComboBox<?> cmbItemCode;

    final ObservableList option = FXCollections.observableArrayList();

    @FXML
    private TableView<CustomerDTO> tblCustomer;
    @FXML
    private TableColumn<?, ?> columnCustomerID;
    @FXML
    private TableColumn<?, ?> columnName;
    @FXML
    private TableColumn<?, ?> columnAddress;
    @FXML
    private TableColumn<?, ?> columnContact;
    @FXML
    private TableColumn<?, ?> columnEmail;
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
    private TableColumn<?, ?> clmSupplierId;
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
    private JFXTextField cmbItemCode12;
    @FXML
    private JFXTextField txtBalance;
    @FXML
    private Label lblTotal;
    @FXML
    private Label lblTotal11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setDataforTextfeild();
        setSells();
        clicktoloadTextFeeld();
        tableClickandFill();
        setCellTable();
        try {
            setTableValues1(itemAll());
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            setItemvaluesAll(getAllItems());
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            setTableValues(getAllCustomerController());
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFXComboBox box = new JFXComboBox(option);
        setCellTable();
        loadCob();
        setSellTable();

        try {
            fillComboBox();

            System.out.println("1");
        } catch (Exception ex) {
            Logger.getLogger(SupplierOrderFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnSaveAction(MouseEvent event) throws JRException {
//        try {
        String Itemcode = cmbItemCode12.getText();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(cmbCustomerID.getText());
        customerDTO.setCustomerName(txtName.getText());
        customerDTO.setCustomerAddress(txtAddress.getText());
        customerDTO.setConatactNo(txtContact.getText());
        customerDTO.setEmail(txtEmail.getText());

        CustomerOrderDTO order = new CustomerOrderDTO();
        order.setCustomer(customerDTO);

        order.setAmount(txtAmount.getText());
        order.setDeleveryDate(txtDeliveryDate.getText());
        order.setImeiNo(txtEmiNo.getText());
        order.setInvoiceNo(txtInvoiceNo.getText());
        order.setWarranty(txtWarranty.getText());

        ItemsDTO itm = new ItemsDTO();
        itm.setItemId(Itemcode);
        itm.setDescription(txtDescription.getText());
        itm.setItemBrand(txtItemBrand.getText());
        itm.setQty(Integer.parseInt(txtQty.getText()));
        itm.setSallingPrice(Double.parseDouble(txtSalePrice.getText()));
        itm.setUnitPrice(Double.parseDouble(txtUnitPrice.getText()));
        itm.setWarranty(txtWarranty.getText());
        List<OrderDetailDTO> orderdetail = new ArrayList<>();
        OrderDetailDTO dto = new OrderDetailDTO();
        dto.setIqty(Integer.parseInt(txtQty.getText()));
        dto.setUnitPrice(Double.parseDouble(txtUnitPrice.getText()));
        dto.setItems(itm);
        OrderDetail_PKDTO or = new OrderDetail_PKDTO();
        or.setItemId(Itemcode);
        or.setInvoiceNo(txtInvoiceNo.getText());
        dto.setOrderDetail_PK(or);
        orderdetail.add(dto);
        OperaterOrderDTO oparator = new OperaterOrderDTO();
        oparator.setCustomer(customerDTO);
        oparator.setCustomerOrder(order);
        oparator.setList(orderdetail);
        oparator.setItems(itm);
        try {
            if (PlaceOrder(oparator)) {
                
                
                
                
                
                Notifications notificationManager = Notifications.create()
                        .title("Order Save")
                        .text("     SAVE!")
                        .hideAfter(Duration.seconds(1))
                        .position(Pos.BOTTOM_RIGHT);
                notificationManager.darkStyle();
                setTableValues1(itemAll());
                notificationManager.show();

                JasperReport compiledReport = (JasperReport) JRLoader.loadObject(ReceptionFormController.class.getResourceAsStream("/lk/ijse/mscs/jusperReports/PlaceOrder1.jasper"));
                HashMap<String, Object> reportParams = new HashMap<>();
                reportParams.put("cid", customerDTO.getCustomerId());
                reportParams.put("name", customerDTO.getCustomerName());
                reportParams.put("address", customerDTO.getCustomerAddress());
                reportParams.put("contact", customerDTO.getConatactNo());
                reportParams.put("email", customerDTO.getEmail());
                reportParams.put("iid", itm.getItemId());
                reportParams.put("brand", itm.getItemBrand());
                reportParams.put("description", itm.getDescription());
                reportParams.put("unitprice", itm.getUnitPrice());
                reportParams.put("warranty", itm.getWarranty());
                reportParams.put("total", itm.getUnitPrice());
                JasperPrint filledReport = JasperFillManager.fillReport(compiledReport, reportParams, new JREmptyDataSource());
                IJSEJasperViewer frmJasperViewer = new IJSEJasperViewer(filledReport);
                frmJasperViewer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frmJasperViewer.setTitle("Place Order");
                frmJasperViewer.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
                frmJasperViewer.setVisible(true);

            }
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void btnNewAction(MouseEvent event) throws Exception {
        setTableValues(getAllCustomerController());
        setTableValues1(itemAll());
        setItemvaluesAll(getAllItems());
        txtDescription.clear();

    }

//    public static boolean addCustomerOrderController(CustomerOrderDTO customerOrderDTO) throws Exception {
//        CustomerOrderService customerOrderService = (CustomerOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMERORDER);
//        return customerOrderService.addCustomerOrder(customerOrderDTO);
//
//    }
//
//    public static boolean updateCustomerOrderController(CustomerOrderDTO customerOrderDTO) throws Exception {
//        CustomerOrderService customerOrderService = (CustomerOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMERORDER);
//        return customerOrderService.updateCustomerOrder(customerOrderDTO);
//    }
//
//    public static boolean deleteCustomerOrderController(String custOrderId) throws Exception {
//        CustomerOrderService customerOrderService = (CustomerOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMERORDER);
//        return customerOrderService.deleteCustomerOrder(custOrderId);
//    }
//
//    public static CustomerOrderDTO searchCustomerOrderController(String custOrderId) throws Exception {
//        CustomerOrderService customerOrderService = (CustomerOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMERORDER);
//        return customerOrderService.searchCustomerOrder(custOrderId);
//    }
//
    @FXML
    private void btnSearchAction(MouseEvent event) {
    }

    private void loadCob() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD E");
        txtDeliveryDate.setText(simpleDateFormat.format(date));
    }

    private void setSellTable() {
        clmInvoiceNo.setCellValueFactory(new PropertyValueFactory<>("invoiceNo"));
        clmCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        clmContact.setCellValueFactory(new PropertyValueFactory<>("conatactNo"));
        clmEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        clmItemCode.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        clmItemBrand.setCellValueFactory(new PropertyValueFactory<>("itemBrand"));
        clmDecription.setCellValueFactory(new PropertyValueFactory<>("description"));
        clmQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        clmImei.setCellValueFactory(new PropertyValueFactory<>("imeiNo"));
        clmAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        clmdate.setCellValueFactory(new PropertyValueFactory<>("deleveryDate"));
        clmWaranty.setCellValueFactory(new PropertyValueFactory<>("warranty"));
        clmPrice.setCellValueFactory(new PropertyValueFactory<>("sallingPrice"));
    }

    private void fillComboBox() throws Exception {
        System.out.println("2");
        List<CustomerDTO> allSupplierController = getAllCustomerController();

        ObservableList<Object> list2 = null;

        for (CustomerDTO cdto : allSupplierController) {
            //cmbCustomerID.getItems().add(cdto.getCustomerId());
        }
        // CustomerDTO cdto = searchAllCustomer(cmbCustomerID.getSelectionModel().getSelectedItem());
//        if (cdto != null) {
//            txtContact.setText(cdto.getConatactNo());
//            txtEmail.setText(cdto.getEmail());
//            txtAddress.setText(cdto.getCustomerAddress());
//            txtContact.setText(cdto.getConatactNo());
//            txtName.setText(cdto.getCustomerName());
//        }
//        
    }

    private void setCellTable() {
        columnCustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        columnContact.setCellValueFactory(new PropertyValueFactory<>("conatactNo"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));

    }

    private void setTableValues(List<CustomerDTO> allCustomerController) {

        try {
            ObservableList<CustomerDTO> customerList = FXCollections.observableArrayList();
            for (CustomerDTO furniture : allCustomerController) {
                customerList.add(furniture);
            }
            tblCustomer.setItems(customerList);
        } catch (NullPointerException e) {
            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void clicktoloadTextFeeld() {
        cmbCustomerID.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                try {
                    fillComboBox();
                } catch (Exception ex) {
                    Logger.getLogger(PlaceOrderController.class.getName()).log(Level.SEVERE, null, ex);
                }
                CustomerDTO reception = tblCustomer.getItems().get(tblCustomer.getSelectionModel().getSelectedIndex());
                cmbCustomerID.setText(reception.getCustomerId());
                txtName.setText(reception.getCustomerName());
                txtAddress.setText(reception.getCustomerAddress());
                txtContact.setText(reception.getConatactNo());
                txtEmail.setText(reception.getEmail());

            }

        });
    }

    private void setDataforTextfeild() {

        tblCustomer.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                try {
                    fillComboBox();
                } catch (Exception ex) {
                    Logger.getLogger(PlaceOrderController.class.getName()).log(Level.SEVERE, null, ex);
                }
                CustomerDTO reception = tblCustomer.getItems().get(tblCustomer.getSelectionModel().getSelectedIndex());
                cmbCustomerID.setText(reception.getCustomerId());
                txtName.setText(reception.getCustomerName());
                txtAddress.setText(reception.getCustomerAddress());
                txtContact.setText(reception.getConatactNo());
                txtEmail.setText(reception.getEmail());

            }

        });

    }

    private void setSells() {
        //item
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

    private void setItemvaluesAll(List<ItemsDTO> allItems) {

    }

    private void setTableValues1(List<GRNDTO> itemAll) throws Exception {
        int invoice = 1001;
        try {
            ObservableList<GRNDTO> SupplierOrderList = FXCollections.observableArrayList();
            for (GRNDTO grnh : itemAll) {

                SupplierOrderList.add(grnh);
                invoice++;
            }

            txtInvoiceNo.setText(invoice + "");
            tblGRN.setItems(SupplierOrderList);

        } catch (NullPointerException e) {
            Logger.getLogger(GRNFormController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void tableClickandFill() {
        tblGRN.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                GRNDTO grndto = tblGRN.getItems().get(tblGRN.getSelectionModel().getSelectedIndex());
                cmbItemCode12.setText(grndto.getBatchId());
                txtDescription.setText(grndto.getDescription());
                txtItemBrand.setText(grndto.getItemBrand());
                txtQty.setText(grndto.getOrderQty());
                txtSalePrice.setText(grndto.getSallingPrice());
                txtUnitPrice.setText(grndto.getUnitPrice() + "");
                txtWarranty.setText(grndto.getWarranty());
                lblTotal.setText(grndto.getSallingPrice() + ".00/=");
            }
        });
    }


    public static boolean PlaceOrder(OperaterOrderDTO oparatorDTO) throws Exception {
        OrderDetailService oreDetailService = (OrderDetailService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERDETAIL);
        return oreDetailService.addPlaceOrder(oparatorDTO);
    }

    public static boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerService.addCustomer(customerDTO);
    }

    public static List<GRNDTO> itemAll() throws Exception {
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.getAllGRN();
    }

    public static List<CustomerDTO> getAllCustomerController() throws Exception {
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerService.getAllCustomers();
    }

    public static List<ItemsDTO> getAllItems() throws Exception {
        ItemsService itemsService = (ItemsService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemsService.getAllItems();
    }

    public static List<CustomerDTO> getAllCustomer() throws Exception {
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerService.getAllCustomers();
    }

    public static CustomerDTO searchAllCustomer(String customerid) throws Exception {
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        //CustomerDTO customerDTO
        CustomerDTO searchCustomer = customerService.searchCustomer(customerid);
        return searchCustomer;
    }

    public static CustomerDTO searchCustomerController1(String customerId) throws Exception {
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerService.searchCustomer(customerId);
    }
    public static GRNDTO searchGRNController(String grnId) throws Exception {
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.search(grnId);
    }

    @FXML
    private void SearchActionCustomer(MouseEvent event) throws Exception {
        CustomerDTO cdto = searchCustomerController1(cmbCustomerID.getText());

        txtName.setText(cdto.getCustomerName());
        txtAddress.setText(cdto.getCustomerAddress());
        txtContact.setText(cdto.getConatactNo());
        txtEmail.setText(cdto.getEmail());
    }

    @FXML
    private void SearchActionItem(MouseEvent event) throws Exception {
        GRNDTO grndto= new GRNDTO();
        grndto=searchGRNController(cmbItemCode12.getText());
        System.out.println("kkl");
        
        txtItemBrand.setText(grndto.getItemBrand());
        txtDescription.setText(grndto.getDescription());
        txtQty.setText(grndto.getDeliverdQty());
        txtSalePrice.setText(grndto.getSallingPrice());
    }

}
