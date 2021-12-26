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

public class AddTitleController implements Initializable {

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
    ComboBox cbAuthor;

    final ObservableList<String> data = FXCollections.observableArrayList();

    //instances of adapters classes used in this class
    private TitleAdapter titleAdapter;
    private AuthorAdapter authorAdapter;

    //creating model
    public void setModel(TitleAdapter title, AuthorAdapter author) throws SQLException {
        titleAdapter = title;
        authorAdapter = author;
        buildComboBoxData();
    }

    //save button function
    public void Save() throws SQLException{
        titleAdapter.insertData(txtID.getText(),txtName.getText(),cbAuthor.getValue().toString()); //send data from textfields to SQL table
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //creating stage with current window
        stage.close(); //closing new stage
    }

    //cancel button function
    public void Cancel(){
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //creating stage with current window
        stage.close(); //closing new stage
    }

    //populates combobox
    public void buildComboBoxData() throws SQLException {
        data.addAll(authorAdapter.getAuthorNames());
    }
    //initialize combobox
    public void initialize(URL url, ResourceBundle rb) {
        cbAuthor.setItems(data);
    }





}
