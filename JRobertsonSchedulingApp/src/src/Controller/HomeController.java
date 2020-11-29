package Controller;

import DAO.CustomerDAO;
import DAO.UserDAO;
import DAOImpl.CustomerDAOImpl;
import DAOImpl.UserDAOImpl;
import Model.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class HomeController {

    private static CustomerDAO customerDAO = new CustomerDAOImpl();

    @FXML
    private TextField userName;

    @FXML
    private TextField password;

    // TODO - Get upcoming appointments when page inits

    public void goToCustomersPage(MouseEvent event) throws Exception {
        try {
            System.out.println("Customers button clicked! Will attempt to go to Customers page now");
            // todo - delete - just testing DB connection and Customer files now
            List<Customer> allCustomers = customerDAO.getAllCustomers();
            for (Customer customer : allCustomers) {
                System.out.println(customer.getCustomerName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void goToAppointmentsPage(MouseEvent event) throws Exception {
        try {
            System.out.println("Appointments button clicked! Will attempt to go to Appointments page now");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void goToReportsPage(MouseEvent event) throws Exception {
        try {
            System.out.println("Reports button clicked! Will attempt to go to Reports page now");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
