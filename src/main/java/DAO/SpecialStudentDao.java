package DAO;

import DB_model.SpecialStudent;
import DB_model.SpecialStudentPK;

import java.util.List;

/**
 * Created by Administrator on 2017/4/2.
 */
public interface SpecialStudentDao {
    public boolean saveSpecialStudent(SpecialStudent specialStudent);

    public boolean deleteSpecialStudent(SpecialStudentPK specialStudentPK);

    public boolean updateSpecialStudent(SpecialStudent specialStudent);

    public SpecialStudent findSpecialStudent(SpecialStudentPK specialStudentPK);

    public List<SpecialStudent> findSpeciaLStudentByGroup(String leaderStuNum);

    public List<SpecialStudent> findAllSpeciaLStudent();


}
