package iPublisher;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class AddPublisherUnitController {

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
    TextField txtAddress;

    //instances of adapters classes used in this class
    private PublisherUnitAdapter publisherUnitAdapter;

    //creating model
    public void setModel(PublisherUnitAdapter pubUnit){
        publisherUnitAdapter = pubUnit;
    }

    //save button function
    public void save() throws SQLException {
        publisherUnitAdapter.insertData(txtID.getText(),txtName.getText(),txtAddress.getText()); //send in from textfields to SQL table
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //creating stage with current window
        stage.close(); //closing new stage
    }

    //button cancel function
    public void cancel(){
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //create stage with current window
        stage.close(); //closing new stage
    }

}
