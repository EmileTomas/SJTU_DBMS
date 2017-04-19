package DAO;

import DB_model.Apply;

/**
 * Created by Administrator on 2017/4/18.
 */
public interface ApplyDao {
    public void save(Apply apply);

    public void delete(int applyID);

    public Apply find(int applyID);

    public void update(Apply apply);
}
