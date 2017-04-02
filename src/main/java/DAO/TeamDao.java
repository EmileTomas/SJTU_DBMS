package DAO;

import DB_model.Team;

import java.util.List;

/**
 * Created by Administrator on 2017/4/2.
 */
public interface TeamDao {
    public boolean saveTeam(Team team);

    public boolean deleteTeam(String leaderNum);

    public boolean updateTeam(Team team);

    public Team findTeamByLeaderStuNum(String leaderStuNum);

    public List<Team> findImportantTeam();

    public List<Team> findUnimportantTeam();

    public List<Team> findAllTeam();

    public List<Team> findApplyingTeam();

    public List<Team> findPassedTeam();
}
