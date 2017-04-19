package DAO;

import DB_model.Teacher.Expert;

import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
public interface ExpertDao {
    public void save(Expert expert);

    public void delete(int expertId);

    public Expert find(int expertID);

    public void update(Expert expert);

    public List<Expert> findAllExperts();
}
