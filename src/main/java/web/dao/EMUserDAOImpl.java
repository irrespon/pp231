package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EMUserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        TypedQuery<User> query=entityManager.createQuery("from User",User.class);
        return query.getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {
        entityManager.createQuery("delete from User where id = :id")
                .setParameter("id",user.getId())
                .executeUpdate();
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class,id);
    }
}
