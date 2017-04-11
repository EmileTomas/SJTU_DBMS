package DAO;

import DB_model.Id_PK;
import DB_model.Teacher.Expert;

import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
public interface ExpertDao {
    public void save(Expert expert);

    public void delete(Id_PK ExpertID);

    public Expert find(Id_PK ExpertID);

    public void update(Expert expert);

    public List<Expert> findAllExperts();
}
