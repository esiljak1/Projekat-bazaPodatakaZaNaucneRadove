package ba.unsa.etf.rpr.projekat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class SearchPaperController {
    private ObservableList<ScientificWork> list = FXCollections.observableArrayList();
    public TableView<ScientificWork> tableScWorks;
    public TableColumn<ScientificWork, String> columnName;
    public TableColumn<ScientificWork, List<Author>> columnAuthors;
    public TableColumn<ScientificWork, String[]> columnTags;

    public SearchPaperController(List<ScientificWork> list) {
        this.list.setAll(list);
    }
    @FXML
    public void initialize(){
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAuthors.setCellValueFactory(new PropertyValueFactory<>("authors"));
        columnTags.setCellValueFactory(new PropertyValueFactory<>("tags"));
        tableScWorks.setItems(list);

        tableScWorks.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            ReadDocumentController ctrl = new ReadDocumentController(newVal.getName());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ReadDocument.fxml"));
            loader.setController(ctrl);
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setTitle(newVal.getName());
            stage.setScene(new Scene(root, 400, 600));
            stage.show();
        });
    }
}
