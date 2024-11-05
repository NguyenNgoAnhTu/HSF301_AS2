//package controller;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//
//import hsf301.fe.pojo.Account;
//import hsf301.fe.pojo.Customer;
//import hsf301.fe.service.AccountService;
//import hsf301.fe.service.CustomerService;
//import hsf301.fe.service.IAccountService;
//import hsf301.fe.service.ICustomerService;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TablePosition;
//import javafx.scene.control.TextField;
//import javafx.scene.control.TableView.TableViewSelectionModel;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.stage.Stage;
//
//public class SignupController implements Initializable{
//	    @FXML private TextField txtName;
//	    @FXML private TextField txtMobile;
//	    @FXML private TextField txtEmail;
//	    @FXML private TextField txtAccountName;
//	    @FXML private TextField txtIdentityCard;
//	    @FXML private TextField txtLicenceNumber;
//	    @FXML private PasswordField txtPassword;
//	    @FXML private DatePicker txtBirthday;
//	    @FXML private DatePicker txtLicenceDate;
//	    @FXML private ComboBox<String> txtRole;
//	    
//	    
//	    private ICustomerService customerService;
//	    private IAccountService accountService;
//	    @SuppressWarnings("unchecked")
//		@Override
//		public void initialize(URL arg0, ResourceBundle arg1) {
//	        ObservableList<String> roles = FXCollections.observableArrayList();
//	        accountService.findAll().forEach(account -> {
//	            if (!roles.contains(account.getRole())) {
//	                if(account.getRole().equals("customer"))
//	                	roles.add(account.getRole());
//	            }
//	        });
//
//	        // Populate the ComboBox with roles
//	        txtRole.setItems(roles);
//	       
//		}
//		
//		public SignupController() {
//	    	String file = "hibernate.cfg.xml";
//	    	customerService = new CustomerService(file);
//	    	accountService = new AccountService(file);
//	    	
//	    }
//		@FXML
//	    public void btnSignupAction() throws IOException {
//	    	Account newAccount = new Account();
//	    	newAccount.setAccountName(txtAccountName.getText());
//	    	newAccount.setRole(txtRole.getValue());
//	    	
//	    	Customer newCustomer = new Customer();
//	        newCustomer.setCustomerName(txtName.getText());
//	        newCustomer.setMobile(txtMobile.getText());
//	        newCustomer.setEmail(txtEmail.getText());
//	        newCustomer.setBirthday(txtBirthday.getValue());
//	        newCustomer.setIdentityCard(txtIdentityCard.getText());
//	        newCustomer.setLicenceNumber(txtLicenceNumber.getText());
//	        newCustomer.setLicenceDate(txtLicenceDate.getValue());
//	        newCustomer.setPassword(txtPassword.getText());
//	        newCustomer.setAccount(newAccount);
//	        
//	        customerService.save(newCustomer); // Save to the database
//	        
//	        String email = txtEmail.getText();
//			String pass = txtPassword.getText();
//			Customer customer = customerService.searchByEmail(email);
//			Account account = accountService.findById(customer.getAccount().getAccountId());
//			if(customer !=null && customer.getPassword().equals(pass) ) {
//				Stage win = (Stage) txtEmail.getScene().getWindow();
//				win.close();
//				System.out.println(account.getRole());
//				if(account.getRole().equals( "customer") ) {
//				FXMLLoader loader = new FXMLLoader(getClass().getResource("../application/Customer.fxml"));
//				Parent root = loader.load();
//				CustomerController cController = loader.getController();
//				cController.setCustomerId(customer.getCustomerId());
////				CustomerController Ccontroller = new CustomerController(customer);
////				loader.setController(Ccontroller);
//				
//				Scene scene = new Scene(root);
//				Stage primaryStage = new Stage();
//				primaryStage.setScene(scene);
//				primaryStage.show();
//				} else if(account.getRole().equals( "admin")){
//					FXMLLoader loader = new FXMLLoader(getClass().getResource("../application/admin.fxml"));
//					Parent root = loader.load();
//					AdminController aController = loader.getController();
////					aController.setCustomerId(customer.getCustomerId());
////					CustomerController Ccontroller = new CustomerController(customer);
////					loader.setController(Ccontroller);
//					
//					Scene scene = new Scene(root);
//					Stage primaryStage = new Stage();
//					primaryStage.setScene(scene);
//					primaryStage.show();
//				} else {
//					Alert alert = new Alert(Alert.AlertType.INFORMATION);
//					alert.setHeaderText("Login unsuccessfully");
//					alert.setContentText("You have no permission to access this function!");
//					alert.showAndWait();
//				}}
//				else {
//					Alert alert = new Alert(Alert.AlertType.INFORMATION);
//					alert.setHeaderText("Login unsuccessfully");
//					alert.setContentText("You have no permission to access this function!");
//					alert.showAndWait();
//				}
//	       
//	    }
//}
