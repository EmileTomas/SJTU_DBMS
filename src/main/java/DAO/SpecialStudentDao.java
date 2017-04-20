package DAO;

import DB_model.Student.SpecialStudent;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface SpecialStudentDao {
    public void save(SpecialStudent specialStudent);

    public void delete(int stuID);

    public SpecialStudent find(int stuID);

    public void update(SpecialStudent specialStudent);

    public List<SpecialStudent> findAllSpecialStudents();
}
