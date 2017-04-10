package DAO;

import DB_model.ID_PK;
import DB_model.Student.Leader;
import DB_model.Teacher.Expert;

import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
public interface ExpertDao {
    public void save(Expert expert);

    public void delete(ID_PK ExpertID);

    public void delete(Expert expert);

    public Expert find(ID_PK ExpertID);

    public void update(Expert expert);

    public List<Expert> findAllExperts();
}
