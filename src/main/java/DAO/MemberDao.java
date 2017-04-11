package DAO;

import DB_model.Id_PK;
import DB_model.Student.Member;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface MemberDao {
    public void save(Member member);

    public void delete(Id_PK memberID);

    public Member find(Id_PK memberID);

    public void update(Member member);

    public List<Member> findAllMembers();
}
