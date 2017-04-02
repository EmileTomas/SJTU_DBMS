package DAO;

import DB_model.Apply;

import java.util.List;

/**
 * Created by Administrator on 2017/4/2.
 */
public interface ApplyDao {
    public boolean saveApply(Apply apply);

    public boolean deleteApply(Apply apply);

    public List<Apply> findApplyByStuNum(String stuNum);

    public List<Apply> findApplyByGroup(String leaderStuNum);
}
