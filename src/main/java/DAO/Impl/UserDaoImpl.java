package DAO.Impl;

import DAO.UserDao;
import DB_model.User;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */
public class UserDaoImpl implements UserDao {
    public void save(User user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(String account) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            User user = session.get(User.class, account);
            session.delete(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public User find(String account) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        User user = null;
        try {
            session.beginTransaction();
            user = session.get(User.class, account);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return user;
    }

    public void update(User user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<User> findAllUser() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<User> users = null;
        try {
            session.beginTransaction();
            String hql = "FROM User";
            users = session.createQuery(hql).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return users;
    }

    public List<User> findRootUser() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<User> roots = null;
        try {
            session.beginTransaction();
            String hql = "from User where userType=?";
            Query query = session.createQuery(hql).setParameter(0, "root");
            roots = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return roots;
    }

    public List<User> findNormalUser() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<User> normalUsers = null;
        try {
            session.beginTransaction();
            String hql = "from User where userType=?";
            Query query = session.createQuery(hql).setParameter(0, "normal");
            normalUsers = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return normalUsers;
    }

}
