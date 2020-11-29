package DAOImpl;

import Utilities.DBConnection;
import Model.User;
import DAO.UserDAO;


import java.sql.*;


public class UserDAOImpl implements UserDAO {

    private static User user = null;

    @Override
    public String getPasswordByUserName(String userName) throws Exception {
        try {
            String password = null;
            DBConnection.makeConnection();
            Connection conn = DBConnection.conn;
            String query = "SELECT Password FROM users WHERE User_Name = '" + userName + "'";
            System.out.println("SQL to execute is: " + query);
            // error is here when we execute the query
            Statement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery(query);
            System.out.println("RESULT OBJ " + result);

            while(result.next()) {
                password = result.getString("Password");
                System.out.println("Password is: " + password);
            }
           // System.out.println("result is: " + result);
            // set user fields based on result set returned from query
            return password;

        } catch(Exception e) {
            System.out.println("Error executing getUserByName(): " + e);
            e.printStackTrace();
        }
        DBConnection.closeConnection();

        return "Pokemon";
    }

//    @Override
//    public  ObservableList<User> getAllUsers() throws Exception {
//        try {
//            DBConnection.makeConnection();
//            String query = "SELECT * FROM users";
//            System.out.println("SQL to execute is: " + query);
//            result = statement.executeQuery(query);
//
//            // set user fields based on result set returned from query
//            return result.get;
//
//        } catch(SQLException e) {
//            System.out.println("Error executing getUserByName(): " + e.getMessage());
//        }
//        return null;
//    }
//    }



    // TODO - OLD METHODS - USE FOR REFERENCE THEN DELETE
//    @Override
//    public User getUserByName(String userName) throws Exception {
//        // type is name or phone, value is the name or the phone #
//        DBConnection.makeConnection();
//        String sqlStatement="select * FROM user WHERE userName  = '" + userName+ "'";
//        //  String sqlStatement="select FROM address";
//        Query.makeQuery(sqlStatement);
//        User userResult;
//        ResultSet result=Query.getResult();
//        while(result.next()){
//            int userid=result.getInt("userid");
//            String userNameG=result.getString("userName");
//            String password=result.getString("password");
//            String createDate=result.getString("createDate");
//            String createdBy=result.getString("createBy");
//            String lastUpdate=result.getString("lastUpdate");
//            String lastUpdateby=result.getString("lastUpdatedBy");
//            Calendar createDateCalendar= TimeFlies.stringToCalendar(createDate);
//            Calendar lastUpdateCalendar=TimeFlies.stringToCalendar(lastUpdate);
//            //   s(int addressId, String address, String address2, int cityId, String postalCode, String phone, Calendar createDate, String createdBy, Calendar lastUpdate, String lastUpdateBy)
//            userResult= new User(userid, userName, password, createDateCalendar, createdBy, lastUpdateCalendar, lastUpdateby);
//            return userResult;
//        }
//        DBConnection.closeConnection();
//        return null;
//    }
//
//    @Override
//    public  ObservableList<User> getAllUsers() throws Exception {
//        ObservableList<User> allUsers= FXCollections.observableArrayList();
//        DBConnection.makeConnection();
//        String sqlStatement="select * from user";
//        Query.makeQuery(sqlStatement);
//        ResultSet result=Query.getResult();
//
//        while(result.next()){
//            int userid=result.getInt("userid");
//            String userNameG=result.getString("userName");
//            String password=result.getString("password");
//            String createDate=result.getString("createDate");
//            String createdBy=result.getString("createdBy");
//            String lastUpdate=result.getString("lastUpdate");
//            String lastUpdateby=result.getString("lastUpdateBy");
//            Calendar createDateCalendar=TimeFlies.stringToCalendar(createDate);
//            Calendar lastUpdateCalendar=TimeFlies.stringToCalendar(lastUpdate);
//            //   s(int addressId, String address, String address2, int cityId, String postalCode, String phone, Calendar createDate, String createdBy, Calendar lastUpdate, String lastUpdateBy)
//            User userResult= new User(userid, userNameG, password, createDateCalendar, createdBy, lastUpdateCalendar, lastUpdateby);
//            allUsers.add(userResult);
//
//        }
//        DBConnection.closeConnection();
//        return allUsers;
//    }
}

