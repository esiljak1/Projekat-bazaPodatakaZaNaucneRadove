package ba.unsa.etf.rpr.projekat;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

public class MainWindowController {
    public ImageView imgLogo;
    public MainWindowController() {
    }
    @FXML
    public void initialize(){
        imgLogo.setImage(new Image(new File("@/../Resources/images/logo.png").toURI().toString(), 300, 250, false, false));
    }

    public void loginAction(ActionEvent actionEvent){
        LogScreenController ctrl = new LogScreenController();
        ResourceBundle bundle = ResourceBundle.getBundle("translation");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoginScreen.fxml"), bundle);
        loader.setController(ctrl);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 300, 300));
        stage.setResizable(false);

        Node node = (Node) actionEvent.getSource();
        Stage st = (Stage) node.getScene().getWindow();
        st.close();

        stage.show();
    }
    public void guestAction(ActionEvent actionEvent){
        SWWMainController ctrl = new SWWMainController(null, ScientificDAO.getInstance());
        ResourceBundle bundle = ResourceBundle.getBundle("translation");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SWWMain.fxml"), bundle);
        loader.setController(ctrl);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("SWW");
        stage.setScene(new Scene(root, 600, 400));
        stage.setResizable(false);

        Node node = (Node) actionEvent.getSource();
        Stage st = (Stage) node.getScene().getWindow();
        st.close();

        stage.show();
    }
}
