package iPublisher;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.source.doctree.TextTree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddAuthorController implements Initializable {

    //create form components
    @FXML
    Button btnSave;
    @FXML
    Button btnCancel;
    @FXML
    TextField txtID;
    @FXML
    TextField txtName;
    @FXML
    TextField txtEmail;
    @FXML
    ComboBox cbPublisherUnit;

    final ObservableList<String> data = FXCollections.observableArrayList();

    //instances of adapters classes used in this class
    private AuthorAdapter authorAdapter;
    private PublisherUnitAdapter publisherUnitAdapter;

    //creating model
    public void setModel(PublisherUnitAdapter pubUnit, AuthorAdapter author) throws SQLException {
        authorAdapter = author;
        publisherUnitAdapter = pubUnit;
        buildComboBoxData();
    }

    //save button function
    public void save() throws SQLException {
        authorAdapter.insertData(txtID.getText(),txtName.getText(),txtEmail.getText(), cbPublisherUnit.getValue().toString()); //send info from textfields to SQL table
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //creating stage with current window
        stage.close(); //closing new stage
    }

    public void cancel(){
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //creating stage with current window
        stage.close(); //closing new stage
    }

    //populates combobox with data
    public void buildComboBoxData() throws SQLException {
        data.addAll(publisherUnitAdapter.getPublisherUnitNames());
    }

    //initialize combobox
    public void initialize(URL url, ResourceBundle rb) {
        cbPublisherUnit.setItems(data);
    }


}
