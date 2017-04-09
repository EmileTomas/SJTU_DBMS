package DAO;

import DB_model.GroupLeader;
import DB_model.GroupMember;
import DB_model.ID;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface GroupMemberDao {
    public boolean addGroupMember(GroupMember groupMember);
    public boolean deleteGroupMember(ID memberID);
    public GroupMember findGroupMember(ID memberID);
    public GroupLeader findGroupLeader(ID memberID);
    public boolean updateGroupMember(GroupMember groupMember);
}
