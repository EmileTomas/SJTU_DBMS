package DAO;

import DB_model.Student.Member;
import DB_model.Team;

import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */
public interface TeamDao {
    public void save(Member member);

    public void delete(int teamID);

    public Team find(int teamID);

    public void update(Team team);

    public List<Team> findAllTeams();

    public List<Team> findAllKeyTeams();

    public List<Team> findAllNormalTeams();

    public List<Team> findAllApplyTeams();

}
