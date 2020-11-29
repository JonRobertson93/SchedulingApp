package DAO;

import Model.Customer;
import javafx.collections.ObservableList;


public interface CustomerDAO {
    ObservableList<Customer> getAllCustomers() throws Exception;
    Customer getCustomerById(int id);
}
