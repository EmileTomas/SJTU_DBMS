package DAO;

import DB_model.GroupLeader;
import DB_model.ID;
import DB_model.SpecialStudent;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface SpecialStudentDao {
    public boolean addSpecialStudent(SpecialStudent specialStudent);
    public boolean deleteSpecialStudent(ID specialStudentID);
    public SpecialStudent findSpecialStudent(ID specialStudentID);
    public GroupLeader findGroupLeader(ID specialStudentID);
    public boolean updateSpcialStudent(SpecialStudent specialStudent);
}
