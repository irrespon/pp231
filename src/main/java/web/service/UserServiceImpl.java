package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.dao.UserDAOImpl;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;// = new UserDAOImpl();

    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Override
    public User getById(long id) {
        return userDAO.getById(id);
    }
}
