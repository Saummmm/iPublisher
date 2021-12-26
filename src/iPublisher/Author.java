package iPublisher;
import javafx.beans.*;

public class Author {

    private String authorName;
    private String authorEmail;
    private String authorID;

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public String getAuthorID() {
        return authorID;
    }

    public String getAuthorName() {
        return authorName;
    }
}

