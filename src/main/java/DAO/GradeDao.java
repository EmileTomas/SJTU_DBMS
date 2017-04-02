package DAO;

import DB_model.Grade;

import java.util.List;

/**
 * Created by Administrator on 2017/4/2.
 */
public interface GradeDao {
    public boolean saveGrade(Grade grade);

    public boolean deleteGrade(String StuNum);

    public boolean updateGrade(Grade grade);

    public Grade findGradeByStuNum(String StuNum);

    public List<Grade> findGradeByGroup(String leaderStuNum);

    public List<Grade> findAllGrade();
}
