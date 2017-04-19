package DAO;

import DB_model.Teacher.Instructor;

import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
public interface InstructorDao {
    public void save(Instructor instructor);

    public void delete(int instructorID);

    public Instructor find(int instructorID);

    public void update(Instructor Instructor);

    public List<Instructor> findAllInstructors();
}
