package iPublisher;
import javafx.beans.*;

public class Report {

    private int publicationsPerYear;
    private String[] titlesPublished;

    public int getPublicationsPerYear() {
        return publicationsPerYear;
    }

    public String[] getTitlesPublished() {
        return titlesPublished;
    }

    public void setPublicationsPerYear(int publicationsPerYear) {
        this.publicationsPerYear = publicationsPerYear;
    }

    public void setTitlesPublished(String[] titlesPublished) {
        this.titlesPublished = titlesPublished;
    }
}
