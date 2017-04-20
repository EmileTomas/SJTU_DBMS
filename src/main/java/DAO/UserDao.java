package DAO;

import DB_model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */
public interface UserDao {
    public void save(User user);

    public void delete(String account);

    public User find(String account);

    public void update(User user);

    public List<User> findAllUser();

    public List<User> findRootUser();

    public List<User> findNormalUser();
}
