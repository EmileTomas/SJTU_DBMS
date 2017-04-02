package DAO;

import DB_model.Teacher;
import DB_model.TeacherPK;

import java.util.List;

/**
 * Created by Administrator on 2017/4/2.
 */
public interface TeacherDao {
    public boolean saveTeacher(Teacher teacher);

    public boolean deleteTeacher(TeacherPK teacherPK);

    public boolean updateTeacher(Teacher teacher);

    public List<Teacher> findTeacherByTcNum(String teacherNum);

    public List<Teacher> findTeacherByTeam(String leaderStuNum);

    public List<Teacher> findExpertByTeam(String leaderStuNum);
}
