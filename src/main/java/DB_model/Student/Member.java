package DB_model.Student;

import DB_model.Apply;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/9.
 */
@Entity
@DiscriminatorValue("Member")
public class Member extends Student {
    @Embedded
    private Grade grade;

    private String stuNumber;

    private String department;

    @ManyToOne(targetEntity = Leader.class)
    @JoinColumn(name = "leaderID", referencedColumnName = "stuID")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Leader leader;

    @OneToMany(targetEntity = Apply.class,mappedBy ="member")
    private Set<Apply> applies=new HashSet<>();

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

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

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public Set<Apply> getApplies() {
        return applies;
    }

    public void setApplies(Set<Apply> applies) {
        this.applies = applies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        if (!super.equals(o)) return false;

        Member member = (Member) o;

        if (grade != null ? !grade.equals(member.grade) : member.grade != null) return false;
        if (stuNumber != null ? !stuNumber.equals(member.stuNumber) : member.stuNumber != null) return false;
        if (department != null ? !department.equals(member.department) : member.department != null) return false;
        if (leader != null ? !leader.equals(member.leader) : member.leader != null) return false;
        return applies != null ? applies.equals(member.applies) : member.applies == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (stuNumber != null ? stuNumber.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (leader != null ? leader.hashCode() : 0);
        result = 31 * result + (applies != null ? applies.hashCode() : 0);
        return result;
    }
}
