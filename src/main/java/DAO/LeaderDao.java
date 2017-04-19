package DAO;

import DB_model.Student.Leader;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface LeaderDao {
    public void save(Leader leader);

    public void delete(int leaderID);

    public Leader find(int leaderID);

    public void update(Leader leader);

    public List<Leader> findAllLeaders();
}
