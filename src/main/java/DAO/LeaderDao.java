package DAO;

import DB_model.Leader;
import DB_model.Member;
import DB_model.ID;
import DB_model.SpecialStudent;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface LeaderDao {
    public void insert(Leader leader);

    public void delete(ID leaderID);

    public Leader find(ID leaderID);

    public void update(Leader leader);
}
