package iPublisher;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Saum
 */
public class MainController implements Initializable {

    @FXML
    private MenuBar mainMenu;

    private PublisherUnitAdapter publisherUnit;
    private AuthorAdapter author;
    private TitleAdapter title;
    private Connection conn;

    @FXML
    public void showAbout() throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("About.fxml"));
        Parent About = (Parent) fxmlLoader.load();

        Scene scene = new Scene(About);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPublisher/WesternLogo.png"));
        stage.setTitle("About Us");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML //open window for adding publisher units
    public void AddPublisherUnit() throws Exception{
        publisherUnit = new PublisherUnitAdapter(conn, false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPublisherUnit.fxml"));
        Parent addPublisherUnit = (Parent) fxmlLoader.load();
        AddPublisherUnitController addPublisherUnitController = (AddPublisherUnitController) fxmlLoader.getController();
        addPublisherUnitController.setModel(publisherUnit);

        Scene scene = new Scene(addPublisherUnit);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPublisher/WesternLogo.png"));
        stage.setTitle("Add Publisher Unit");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }

    @FXML //open window for adding authors
    public void AddAuthor() throws Exception{
        author = new AuthorAdapter(conn, false);
        publisherUnit = new PublisherUnitAdapter(conn, false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddAuthor.fxml"));
        Parent addAuthor = (Parent) fxmlLoader.load();
        AddAuthorController authorController = (AddAuthorController) fxmlLoader.getController();
        authorController.setModel(publisherUnit,author);

        Scene scene = new Scene(addAuthor);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPublisher/WesternLogo.png"));
        stage.setTitle("Add Author");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }

    @FXML //open window for adding titles
    public void AddTitle() throws Exception{
        title = new TitleAdapter(conn, false);
        author = new AuthorAdapter(conn, false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddTitle.fxml"));
        Parent addATitle = (Parent) fxmlLoader.load();
        AddTitleController titleController = (AddTitleController) fxmlLoader.getController();
        titleController.setModel(title,author);

        Scene scene = new Scene(addATitle);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPublisher/WesternLogo.png"));
        stage.setTitle("Add Title");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }
    //open window for editing/deleting publisher units
    public void EDPublisherUnit() throws Exception{
        publisherUnit = new PublisherUnitAdapter(conn,false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EDPublisherUnit.fxml"));
        Parent EDPublisherUnit = (Parent) fxmlLoader.load();
        EDPublisherUnitController edPublisherUnit = (EDPublisherUnitController) fxmlLoader.getController();
        edPublisherUnit.setModel(publisherUnit);

        Scene scene = new Scene(EDPublisherUnit);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPublisher/WesternLogo.png"));
        stage.setTitle("Edit/Delete Publisher Unit");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }
    //open window for editing/deleting authors
    public void EDAuthor() throws Exception{
        author = new AuthorAdapter(conn,false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EDAuthor.fxml"));
        Parent EDAuthor = (Parent) fxmlLoader.load();
        EDAuthorController edAuthorController = (EDAuthorController) fxmlLoader.getController();
        edAuthorController.setModel(author);

        Scene scene = new Scene(EDAuthor);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPublisher/WesternLogo.png"));
        stage.setTitle("Edit/Delete Publisher Unit");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }

    //open window for editing/deleting title windows
    public void EDTitle() throws Exception{
        title = new TitleAdapter(conn,false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EDTitle.fxml"));
        Parent EDTitle = (Parent) fxmlLoader.load();
        EDTitleController edTitleController = (EDTitleController) fxmlLoader.getController();
        edTitleController.setModel(title);

        Scene scene = new Scene(EDTitle);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPublisher/WesternLogo.png"));
        stage.setTitle("Edit/Delete Publisher Unit");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }

    @FXML //exit
    public void exit() {
        Stage stage = (Stage) mainMenu.getScene().getWindow();
        stage.close();
    }

    @FXML //reset data for publisher unit, author, and title tables.
    public void resetDB() throws SQLException {
        // create Teams model
        publisherUnit = new PublisherUnitAdapter(conn, true);
        author = new AuthorAdapter(conn,true);
        title = new TitleAdapter(conn,true);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Create a named constant for the URL
            // NOTE: This value is specific for Java DB
            String DB_URL = "jdbc:derby:TeamDB;create=true";
            // Create a connection to the database
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException ex) {

        }
    }

}

