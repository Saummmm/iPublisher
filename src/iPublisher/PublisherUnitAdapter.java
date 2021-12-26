package iPublisher;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PublisherUnitAdapter {

    Connection connection;

    //constructor function
    public PublisherUnitAdapter(Connection conn, Boolean reset) throws SQLException{
        connection = conn;
        if(reset){
            Statement stmt = connection.createStatement();
            try{
                stmt.execute("DROP TABLE PublisherUnit");
            } catch (SQLException ex){

            } finally{

                stmt.execute("CREATE TABLE PublisherUnit(" // create table
                        + "ID CHAR(10),"
                        + "Name CHAR(20),"
                        + "Address CHAR(20)"
                        +")");
            }
        }
    }

    //add data to table
    public void insertData(String id, String name, String add) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO PublisherUnit (ID,Name,Address) VALUES ('"+id+"','"+ name +"','"+ add +"')");
    }
    //update data on table from editing
    public void updateData(String id, String name, String add, String track) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.execute("UPDATE PublisherUnit SET ID = '"+id+"' , Name ='"+name+"', Address ='"+add+"' WHERE Name = '"+track+"'");
    }
    //sends data to fill textfields
    public String getData(String pubUnit, String type) throws SQLException{
        ResultSet rs;
        Statement stmt = connection.createStatement();
        String temp = "SELECT * FROM PublisherUnit";
        rs = stmt.executeQuery(temp);
        String send = "";

        int x=1;

        if(type.equals("id")){
            while(rs.next()){
                while (rs.getString("Name").equals(pubUnit) && x==1){ //loops to find "ID" to corresponding name
                    send = rs.getString("ID");
                    x=0;
                }
            }
        }
        else if(type.equals("name")){
            while(rs.next()){
                while(rs.getString("Name").equals(pubUnit) && x == 1){ //loops to find "name" to corresponding name
                    send = rs.getString("Name");
                    x=0;
                }
            }
        }
        else if(type.equals("address")){
            while(rs.next()){
                while(rs.getString("Name").equals(pubUnit) && x == 1){ //loops to find "address" to corresponding name
                    send = rs.getString("Address");
                    x=0;
                }
            }
        }
        return send; //return string with corresponding data
    }
    //remove data from table
    public void removeData(String take) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM PublisherUnit WHERE Name = '"+take+"'");

    }

    //get names of publisher unit names from tables
    public ObservableList<String> getPublisherUnitNames() throws SQLException{
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM PublisherUnit";

        rs = stmt.executeQuery(sqlStatement);
        //add all publishing unit names to list
        while(rs.next()){
            list.add(rs.getString("Name"));
        }
        return list; //return list of publishing unit names
    }


}
