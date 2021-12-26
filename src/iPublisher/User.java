package iPublisher;
import javafx.beans.*;

public class User {

    private String userName;
    private String userID;

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
