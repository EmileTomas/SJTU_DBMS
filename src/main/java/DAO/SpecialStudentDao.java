package DAO;

import DB_model.Student.SpecialStudent;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface SpecialStudentDao {
    public void save(SpecialStudent specialStudent);

    public void delete(int specialStudentID);

    public void update(SpecialStudent specialStudent);

    public SpecialStudent find(int specialStudentID);

    public List<SpecialStudent> findAllSpecialStudents();
}
