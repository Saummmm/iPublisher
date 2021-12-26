package iPublisher;
import javafx.beans.*;

public class Book {

    private String titleName;
    private String bookID;

    public String getBookID() {
        return bookID;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
