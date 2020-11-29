package Controller;

import DAO.UserDAO;
import DAOImpl.UserDAOImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class HomeController {

    private static UserDAO userDAO = new UserDAOImpl();

    @FXML
    private TextField userName;

    @FXML
    private TextField password;

    // TODO - Get upcoming appointments when page inits

    public void goToCustomersPage(MouseEvent event) throws Exception {
        try {
            System.out.println("Customers button clicked! Will attempt to go to Customers page now");
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
