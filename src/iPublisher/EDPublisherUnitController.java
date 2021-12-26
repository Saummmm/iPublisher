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
import org.w3c.dom.Text;

public class EDPublisherUnitController implements Initializable{

    //create form components
    @FXML
    Button btnSave;
    @FXML
    Button btnDelete;
    @FXML
    Button btnCancel;
    @FXML
    TextField txtID;
    @FXML
    TextField txtName;
    @FXML
    TextField txtAddress;
    @FXML
    ComboBox cbPublishingUnit;


    final ObservableList<String> data = FXCollections.observableArrayList();

    //instances of adapters classes used in this class
    private PublisherUnitAdapter publisherUnitAdapter;

    //creating model
    public void setModel(PublisherUnitAdapter pub) throws SQLException{
        publisherUnitAdapter = pub;
        buildComboBoxData();
    }

    //save button function
    public void Save() throws SQLException{
        publisherUnitAdapter.updateData(txtID.getText(),txtName.getText(),txtAddress.getText(),cbPublishingUnit.getValue().toString()); //send data from textfields to SQL table
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //creating stage with current window
        stage.close(); //closing new stage
    }

    //after selecting item from combobox, fill textfields
    public void update() throws SQLException{
        String temp1 = publisherUnitAdapter.getData(cbPublishingUnit.getValue().toString(),"id"); //fills id textfield
        txtID.setText(temp1);
        String temp2 = publisherUnitAdapter.getData(cbPublishingUnit.getValue().toString(),"name"); //fills name textfield
        txtName.setText(temp2);
        String temp3 = publisherUnitAdapter.getData(cbPublishingUnit.getValue().toString(),"address"); //fills address textfield
        txtAddress.setText(temp3);
    }

    //delete button function
    public void Delete() throws SQLException{
        publisherUnitAdapter.removeData(cbPublishingUnit.getValue().toString()); //remove selected publisher unit
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //creating stage with current window
        stage.close(); //closing new stage
    }

    //cancel button function
    public void Cancel(){
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //creating stage with current window
        stage.close(); //closing new stage
    }

    //populates combobox
    public void buildComboBoxData() throws SQLException{
        data.addAll(publisherUnitAdapter.getPublisherUnitNames());
    }

    //initialize combobox
    public void initialize(URL url, ResourceBundle rb){
        cbPublishingUnit.setItems(data);
    }


}
