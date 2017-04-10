package DAO;

import DB_model.Student.Member;
import DB_model.ID_PK;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface MemberDao {
    public void save(Member member);

    public void delete(ID_PK memberID);

    public void delete(Member member);

    public Member find(ID_PK memberID);

    public void update(Member member);

    public List<Member> findAllMembers();
}
