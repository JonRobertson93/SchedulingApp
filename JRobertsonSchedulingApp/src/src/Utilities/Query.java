// TODO - MAY END UP DELETING THIS
package Utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static Utilities.DBConnection.conn;

public class Query {
    private static ResultSet result;

    public static void makeQuery(String query){
        try{
            Statement stmt = conn.createStatement();
            // determine query execution
            if(query.toLowerCase().startsWith("select"))
                result = stmt.executeQuery(query);
            if(query.toLowerCase().startsWith("delete")|| query.toLowerCase().startsWith("insert")|| query.toLowerCase().startsWith("update"))
                stmt.executeUpdate(query);
        }
        catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    public static ResultSet getResult(){
        return result;
    }
}