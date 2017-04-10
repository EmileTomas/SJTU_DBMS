package DAO;

import DB_model.Student.Leader;
import DB_model.ID_PK;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface LeaderDao {
    public void save(Leader leader);

    public void delete(ID_PK leaderID);

    public void delete(Leader leader);

    public Leader find(ID_PK leaderID);

    public void update(Leader leader);

    public List<Leader> findAllLeaders();
}
