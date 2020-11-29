package DAO;
import Model.User;
import java.util.List;

public interface UserDAO {
    String getPasswordByUserName(String name) throws Exception;
   // List<User> getAllUsers() throws Exception;
}
