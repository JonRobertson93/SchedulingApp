package DAOImpl;

import DAO.CustomerDAO;
import Utilities.DBConnection;
import Model.Customer;
import Utilities.DateParser;
import Utilities.Query;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.Calendar;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public Customer getCustomerById(int id) {

        // todo - return real stuff
        return null;
    }

    @Override
    public ObservableList<Customer> getAllCustomers() throws Exception {
        try {
            ObservableList<Customer> allCustomers = FXCollections.observableArrayList();
            DBConnection.makeConnection();
            String query = "select * from customers";
            Query.makeQuery(query);
            ResultSet result = Query.getResult();

            // loop through result and create new Customer objects from data
            while(result.next()) {
                // store all as variables
                int customerId = result.getInt("Customer_ID");
                String customerName = result.getString("Customer_Name");
                String address = result.getString("Address");
                String postalCode = result.getString("Postal_Code");
                String phone = result.getString("Phone");
                String createDate = result.getString("Create_Date");
                String createdBy = result.getString("Created_By");
                String lastUpdate = result.getString("Last_Update");
                String lastUpdatedBy = result.getString("Last_Updated_By");
                int divisionId = result.getInt("Division_ID");
                // convert string dates to calendar objects to perform localization tasks
                Calendar createDateCalendar = DateParser.convertStringToCalendar(createDate);
                Calendar lastUpdateCalendar = DateParser.convertStringToCalendar(lastUpdate);

                // add variables from above to a new Customer object
                Customer customer = new Customer(customerId, customerName, address, postalCode, phone, createDateCalendar, createdBy, lastUpdateCalendar, lastUpdatedBy, divisionId);
                allCustomers.add(customer);
            }
            return allCustomers;

        } catch (Exception e) {
            e.printStackTrace();
        }
        DBConnection.closeConnection();



        // todo - return real stuff
        return null;

    }
}
