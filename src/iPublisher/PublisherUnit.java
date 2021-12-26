package iPublisher;
import javafx.beans.*;

public class PublisherUnit {

    private String publisherUnitName;
    private String publisherUnitAddress;
    private String publisherUnitID;

    public String getPublisherUnitAddress() {
        return publisherUnitAddress;
    }

    public String getPublisherUnitID() {
        return publisherUnitID;
    }

    public String getPublisherUnitName() {
        return publisherUnitName;
    }

    public void setPublisherUnitAddress(String publisherUnitAddress) {
        this.publisherUnitAddress = publisherUnitAddress;
    }

    public void setPublisherUnitID(String publisherUnitID) {
        this.publisherUnitID = publisherUnitID;
    }

    public void setPublisherUnitName(String publisherUnitName) {
        this.publisherUnitName = publisherUnitName;
    }
}
