package DB_model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@DiscriminatorValue("GroupLeader")
public class GroupLeader extends Student {
    @Basic
    @Column(name = "stuNumber")
    private String stuNumber;

    @Basic
    @Column(name = "department")
    private String department;


    @OneToMany(targetEntity = GroupMember.class, mappedBy = "groupLeader")
    private Set<GroupMember> groupMembers = new HashSet<>();


    @OneToMany(targetEntity = SpecialStudent.class, mappedBy = "groupLeader")
    private Set<SpecialStudent> specialStudents = new HashSet<>();

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

    public Set<GroupMember> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(Set<GroupMember> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public Set<SpecialStudent> getSpecialStudents() {
        return specialStudents;
    }

    public void setSpecialStudents(Set<SpecialStudent> specialStudents) {
        this.specialStudents = specialStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupLeader groupLeader = (GroupLeader) o;

        if (stuNumber != null ? !stuNumber.equals(groupLeader.stuNumber) : groupLeader.stuNumber != null) return false;
        if (department != null ? !department.equals(groupLeader.department) : groupLeader.department != null) return false;
        if (groupMembers != null ? !groupMembers.equals(groupLeader.groupMembers) : groupLeader.groupMembers != null) return false;
        if (specialStudents != null ? !specialStudents.equals(groupLeader.specialStudents) : groupLeader.specialStudents != null) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (stuNumber != null ? stuNumber.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (groupMembers != null ? groupMembers.hashCode() : 0);
        result = 31 * result + (specialStudents != null ? specialStudents.hashCode() : 0);

        return result;
    }

}
