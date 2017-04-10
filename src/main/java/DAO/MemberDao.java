package DAO;

import DB_model.Leader;
import DB_model.Member;
import DB_model.ID;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface MemberDao {
    public void insert(Member member);

    public void delete(ID memberID);

    public Member find(ID memberID);

    public void update(Member member);
}
