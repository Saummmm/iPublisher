package iPublisher;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AuthorAdapter {

    Connection connection;

    //constructor function
    public AuthorAdapter(Connection conn, Boolean reset) throws SQLException{
        connection = conn;

        if(reset) {
            Statement stmt = connection.createStatement();
            try {
                stmt.execute("DROP TABLE Author");
            } catch (SQLException ex) {

            } finally {
                stmt.execute("CREATE TABLE Author(" // create table
                        + "ID CHAR(20) NOT NULL PRIMARY KEY,"
                        + "Name CHAR(20),"
                        + "Email CHAR(20),"
                        + "Publisher CHAR(20)"
                        + ")");
            }
        }
    }

    //add data to table
    public void insertData(String id, String name, String email, String pub) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Author (ID,Name,Email,Publisher) VALUES ('"+id+"','"+ name +"', '"+ email +"','"+pub+"')");
    }

    //remove data from table
    public void removeData(String take) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM Author WHERE Name = '"+take+"'");
    }

    //update data on table from editing
    public void updateData(String id, String name, String add, String track) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.execute("UPDATE Author SET ID = '"+id+"' , Name ='"+name+"', Email ='"+add+"' WHERE Name = '"+track+"'");
    }

    //sends data to fill textfields
    public String getData(String aut, String type) throws SQLException{
        ResultSet rs;
        Statement stmt = connection.createStatement();
        String temp = "SELECT * FROM Author";
        rs = stmt.executeQuery(temp);
        String send = "";

        int x=1;

        if(type.equals("id")){
            while(rs.next()){
                while (rs.getString("Name").equals(aut) && x==1){ //loops to find "ID" to corresponding name
                    send = rs.getString("ID");
                    x=0;
                }
            }
        }
        else if(type.equals("name")){
            while(rs.next()){
                while(rs.getString("Name").equals(aut) && x == 1){ //loops to find "name" to corresponding name
                    send = rs.getString("Name");
                    x=0;
                }
            }
        }
        else if(type.equals("email")){
            while(rs.next()){
                while(rs.getString("Name").equals(aut) && x == 1){ //loops to find "email" to corresponding name
                    send = rs.getString("Email");
                    x=0;
                }
            }
        }

        return send; //return string with corresponding data
    }

    //get names of authors from tables
    public ObservableList<String> getAuthorNames() throws SQLException{
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM Author";

        rs = stmt.executeQuery(sqlStatement);
        //add all author names to list
        while(rs.next()){
            list.add(rs.getString("Name"));
        }
        return list; //return list of author names
    }


}
