package DAO;

import DB_model.Student;

import java.util.List;

/**
 * Created by Administrator on 2017/4/2.
 */
public interface StudentDao {
    public boolean saveStudent(Student student);

    public boolean deleteStudent(String stuNum);

    public boolean updateStudent(Student student);

    public Student findStudentByStuNum(String stuNum);

    public List<Student> findStudentByName(String name);

    public boolean studentValid(String stuNum);
}
