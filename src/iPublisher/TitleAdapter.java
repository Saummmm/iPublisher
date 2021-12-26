package iPublisher;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TitleAdapter {

    Connection connection;

    //constructor
    public TitleAdapter(Connection conn, Boolean reset) throws SQLException{
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                stmt.execute("DROP TABLE Titles");
            } catch (SQLException ex) {

            } finally {
                // Create table of Matches
                stmt.execute("CREATE TABLE Titles (" // create table
                        + "ID CHAR(20) NOT NULL PRIMARY KEY, "
                        + "Name CHAR(15), "
                        + "Author CHAR(15) "
                        + ")");
            }
        }
    }

    //add data to table
    public void insertData(String id, String name, String author) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Titles (ID, Name, Author) VALUES ('" + id + "' , '" + name + "' , '" + author + "')");
    }
    //remove data from table
    public void updateData(String id, String name, String track) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.execute("UPDATE Titles SET ID = '"+id+"' , Name ='"+name+"'WHERE Name = '"+track+"'");
    }
    //remove data from table
    public void removeData(String take) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM Titles WHERE Name = '"+take+"'");

    }
    //sends data to fill textfields
    public String getData(String tit, String type) throws SQLException{
        ResultSet rs;
        Statement stmt = connection.createStatement();
        String temp = "SELECT * FROM Titles";
        rs = stmt.executeQuery(temp);
        String send = "";

        int x=1;

        if(type.equals("id")){
            while(rs.next()){
                while (rs.getString("Name").equals(tit) && x==1){ //loops to find "ID" to corresponding name
                    send = rs.getString("ID");
                    x=0;
                }
            }
        }
        else if(type.equals("name")){
            while(rs.next()){
                while(rs.getString("Name").equals(tit) && x == 1){ //loops to find "name" to corresponding name
                    send = rs.getString("Name");
                    x=0;
                }
            }
        }
        return send; //return string with corresponding data
    }

    //get names of titles from tables
    public ObservableList<String> getTitleNames() throws SQLException{
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM Titles";

        rs = stmt.executeQuery(sqlStatement);
        //add all title names to list
        while(rs.next()){
            list.add(rs.getString("Name"));
        }
        return list; //return list of title names
    }

}


