package web.dao;

import web.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class UserDAOImpl implements UserDAO{

    private static final AtomicLong AUTO_ID = new AtomicLong(0);
    private static Map<Long,User> users = new HashMap<>();

    static {
        User user1 = new User("A","B");
        user1.setId(AUTO_ID.getAndIncrement());
        User user2 = new User("C","D");
        user2.setId(AUTO_ID.getAndIncrement());
        users.put(user1.getId(),user1);
        users.put(user2.getId(),user2);
    }

    @Override
    public List<User> allUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void add(User user) {
        user.setId(AUTO_ID.getAndIncrement());
        users.put(user.getId(),user);
    }

    @Override
    public void delete(User user) {
        users.remove(user.getId());
    }

    @Override
    public void edit(User user) {
        users.put(user.getId(),user);
    }

    @Override
    public User getById(long id) {
        return users.get(id);
    }
}
