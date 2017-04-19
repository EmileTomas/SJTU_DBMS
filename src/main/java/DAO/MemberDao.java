package DAO;

import DB_model.Student.Member;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface MemberDao {
    public void save(Member member);

    public void delete(int memberID);

    public Member find(int memberID);

    public void update(Member member);

    public List<Member> findAllMembers();
}
