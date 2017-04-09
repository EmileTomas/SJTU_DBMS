package DAO;

import DB_model.GroupLeader;
import DB_model.GroupMember;
import DB_model.ID;
import DB_model.SpecialStudent;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface GroupLeaderDao {
    public boolean addGroupLeader(GroupLeader groupLeader);
    public boolean deleteGroupLeader(ID leaderID);
    public GroupLeader findGroupLeader(ID leaderID);
    public boolean updateGroupLeader(GroupLeader groupLeader);

    public List<GroupMember> findAllGroupMember(ID leaderID);
    public List<SpecialStudent> findAllSpecialMember(ID leaderID);
}
