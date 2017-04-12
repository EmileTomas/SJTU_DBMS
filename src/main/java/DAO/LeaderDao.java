package DAO;

import DB_model.module.Id_PK;
import DB_model.Student.Leader;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface LeaderDao {
    public void save(Leader leader);

    public void delete(Id_PK leaderID);

    public Leader find(Id_PK leaderID);

    public void update(Leader leader);

    public List<Leader> findAllLeaders();
}
