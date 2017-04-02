package DAO;

import DB_model.Recruit;

import java.util.List;

/**
 * Created by Administrator on 2017/4/2.
 */
public interface RecruitDao {
    public boolean saveRecruit(Recruit recruit);

    public boolean deleteRecruit(String leaderStuNum);

    public boolean updateRecruit(Recruit recruit);

    public List<Recruit> findAllRecruitInfo();
}
