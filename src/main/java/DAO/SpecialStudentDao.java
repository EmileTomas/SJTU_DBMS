package DAO;

import DB_model.Leader;
import DB_model.ID;
import DB_model.SpecialStudent;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface SpecialStudentDao {
    public void insert(SpecialStudent specialStudent);

    public void delete(ID specialStudentID);

    public SpecialStudent find(ID specialStudentID);

    public void delete(SpecialStudent specialStudent);
}
