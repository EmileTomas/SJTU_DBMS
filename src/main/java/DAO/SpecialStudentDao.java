package DAO;

import DB_model.Id_PK;
import DB_model.Student.SpecialStudent;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface SpecialStudentDao {
    public void save(SpecialStudent specialStudent);

    public void delete(Id_PK specialStudentID);

    public void update(SpecialStudent specialStudent);

    public List<SpecialStudent> findAllSpecialStudents();
}
