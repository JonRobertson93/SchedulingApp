import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * The main method that starts the program
     * @param args none
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Login.fxml"));
        Controller.LoginController controller = new Controller.LoginController();
        loader.setController(controller);

        Parent root = loader.load();
        primaryStage.setTitle("Cello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }



}
