package DAO.DaoImpl;

import DAO.TeamDao;
import DB_model.Student.Member;
import DB_model.Team.Team;

import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */
public class TeamDaoImpl implements TeamDao{
    public void save(Member member);

    public void delete(int index);

    public Team findByTeamIndex(int index);

    public void update(Team team);

    public List<Team> findAllMTeams();

    public List<Team> findAllKeyTeam();

    public List<Team> findAllNormalTeam();

    public List<Team> findAllApplyTeam();

}
