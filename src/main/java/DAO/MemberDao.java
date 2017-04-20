package DAO;

import DB_model.Student.Member;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface MemberDao {
    public void save(Member member);

    public void delete(int stuID);

    public Member find(int stuID);

    public void update(Member member);

    public List<Member> findAllMembers();
}
