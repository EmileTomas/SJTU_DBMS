package DAO;

import DB_model.Member;
import DB_model.ID_PK;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface MemberDao {
    public void save(Member member);

    public void delete(ID_PK memberID);

    public void delete(Member member);

    public Member find(ID_PK memberID);

    public void update(Member member);
}
