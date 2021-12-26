package iPublisher;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sun.source.doctree.TextTree;
import javafx.beans.binding.ObjectExpression;
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

public class EDTitleController implements Initializable{

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
    ComboBox cbTitle;

    final ObservableList<String> data = FXCollections.observableArrayList();

    private TitleAdapter titleAdapter;

    //creating model
    public void setModel(TitleAdapter tit) throws SQLException{
        titleAdapter = tit;
        buildComboBoxData();
    }
    //save button function
    public void Save()throws SQLException{
        titleAdapter.updateData(txtID.getText(),txtName.getText(),cbTitle.getValue().toString()); //send data from textfields to SQL table
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //creating stage with current window
        stage.close(); //closing new stage
    }

    //after selecting item from combobox, fill textfields
    public void update() throws SQLException{
        String temp1 = titleAdapter.getData(cbTitle.getValue().toString(),"id"); //fills id textfield
        txtID.setText(temp1);
        String temp2 = titleAdapter.getData(cbTitle.getValue().toString(),"name"); //fills name textfield
        txtName.setText(temp2);
    }

    //delete button function
    public void Delete() throws SQLException{
        titleAdapter.removeData(cbTitle.getValue().toString()); //deletes selected title
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
        data.addAll(titleAdapter.getTitleNames());
    }
    //initialize combo
    public void initialize(URL url, ResourceBundle rb){
        cbTitle.setItems(data);
    }
}
