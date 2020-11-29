package Controller;

import DAO.UserDAO;
import DAOImpl.UserDAOImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class LoginController {

    private static UserDAO userDAO = new UserDAOImpl();

    @FXML
    private TextField userName;
    private String formattedUser;

    @FXML
    private TextField password;
    private String formattedPassword;

    public void loginClicked(MouseEvent event) throws Exception {
        try {
            formatTextFields();
            System.out.println("Login button clicked! Will attempt to login now");
            System.out.println("User entered " + formattedPassword + " as the password and " + formattedUser + " as the username...");
            String password = userDAO.getPasswordByUserName(formattedUser);
            System.out.println("Password retrieved is: " + password);
            if (formattedPassword.equals(password)) {
                System.out.println("PASSWORDS MATCH! YOU MAY ENTER!");
                routeToHome(event);
            } else {
                // todo - error message/dialog - use example from other project
                System.out.println("YOU MAY NOT ENTER! BAD PASSWORD!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void routeToHome(MouseEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Home.fxml"));
            Controller.HomeController homeController = new Controller.HomeController();
            loader.setController(homeController);

            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Home - Welcome");
            window.setScene(scene);
            window.show();
        } catch (IOException exception) {}

    }

    public void formatTextFields() {
        formattedUser = userName.getText();
        formattedPassword = password.getText();
    }

}
