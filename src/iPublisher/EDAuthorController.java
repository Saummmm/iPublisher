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

public class EDAuthorController implements Initializable {

    //create form components
    @FXML
    Button btnSave;
    @FXML
    Button btnCancel;
    @FXML
    Button btnDelete;
    @FXML
    TextField txtID;
    @FXML
    TextField txtName;
    @FXML
    TextField txtEmail;
    @FXML
    ComboBox cbAuthor;

    final ObservableList<String> data = FXCollections.observableArrayList();

    private AuthorAdapter authorAdapter;

    //creating model
    public void setModel(AuthorAdapter author) throws SQLException{
        authorAdapter = author;
        buildComboBoxData();
    }

    //save button function
    public void Save()throws SQLException{
        authorAdapter.updateData(txtID.getText(),txtName.getText(),txtEmail.getText(),cbAuthor.getValue().toString()); //send data from textfields to SQL table
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //creating stage with current window
        stage.close(); //closing new stage
    }

    public void update() throws SQLException{
        String temp1 = authorAdapter.getData(cbAuthor.getValue().toString(),"id");
        txtID.setText(temp1);
        String temp2 = authorAdapter.getData(cbAuthor.getValue().toString(),"name");
        txtName.setText(temp2);
        String temp3 = authorAdapter.getData(cbAuthor.getValue().toString(),"email");
        txtEmail.setText(temp3);
    }

    public void Delete() throws SQLException{
        authorAdapter.removeData(cbAuthor.getValue().toString());
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //creating stage with current window
        stage.close(); //closing new stage
    }

    public void Cancel(){
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //creating stage with current window
        stage.close(); //closing new stage
    }

    public void buildComboBoxData() throws SQLException{
        data.addAll(authorAdapter.getAuthorNames());
    }

    public void initialize(URL url, ResourceBundle rb){
        cbAuthor.setItems(data);
    }


}
