package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserById(long id);

    public void saveUser(User user);

    public void updateUser( User updatedUser,long id);



    public void deleteUser(long id);
}
