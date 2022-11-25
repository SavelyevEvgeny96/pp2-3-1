package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private  EntityManager manager;

    @Override
    public List<User> getAllUsers() {
        List<User> users = manager.createQuery("from User").getResultList();
        return users;
    }

    @Override
    public User getUserById(long id) {
        return manager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        manager.persist(user);
    }

    @Override
    public void updateUser(User updatedUser,long id) {
    }

    @Override
    public void deleteUser(long id) { manager.remove(getUserById(id)); }
}
