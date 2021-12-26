package iPublisher;
import javafx.beans.*;

public class Record {
    private int saleOfBooks;
    private int profitMargin;

    public int getProfitMargin() {
        return profitMargin;
    }

    public int getSaleOfBooks() {
        return saleOfBooks;
    }

    public void setProfitMargin(int profitMargin) {
        this.profitMargin = profitMargin;
    }

    public void setSaleOfBooks(int saleOfBooks) {
        this.saleOfBooks = saleOfBooks;
    }
}
