package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserDao dao;

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }


    @Override
    @Transactional
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return dao.getUserById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        dao.saveUser(user);
    }


    @Override
    @Transactional
    public void updateUser(User updatedUser,int id) {
     User user = getUserById(id);
     user.setName(updatedUser.getName());
     user.setSurname(updatedUser.getSurname());
     user.setEmail(updatedUser.getEmail());
     dao.updateUser(user);
    }



    @Override
    @Transactional
    public void deleteUser(int id) { dao.deleteUser(id); }


}