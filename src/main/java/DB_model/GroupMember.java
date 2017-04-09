package DB_model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/4/9.
 */
@Entity
@DiscriminatorValue("GroupMember")
public class GroupMember extends Student {
    @Basic
    @Column(name = "stuNumber", nullable = false)
    private String stuNumber;

    @Basic
    @Column(name = "department")
    private String department;

    @ManyToOne(targetEntity = GroupLeader.class)
    @JoinColumns(value = {
            @JoinColumn(name = "leaderIDType", referencedColumnName = "idType"),
            @JoinColumn(name = "leaderIDNum", referencedColumnName = "idNum")
    })
    @Cascade(CascadeType.ALL)
    private GroupLeader groupLeader;

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public GroupLeader getGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(GroupLeader groupLeader) {
        this.groupLeader = groupLeader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupMember groupMember = (GroupMember) o;

        if (stuNumber != null ? !stuNumber.equals(groupMember.stuNumber) : groupMember.stuNumber != null) return false;
        if (department != null ? !department.equals(groupMember.department) : groupMember.department != null) return false;
        if (groupLeader != null ? !groupLeader.equals(groupMember.groupLeader) : groupMember.groupLeader != null) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (stuNumber != null ? stuNumber.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (groupLeader != null ? groupLeader.hashCode() : 0);

        return result;
    }

}
