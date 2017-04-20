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
    @Column(nullable = false,unique = true)
    private String stuNumber;

    private String department;

    @Embedded
    private Grade grade;

    @ManyToOne(targetEntity = Leader.class)
    @JoinColumn(name = "leaderID", referencedColumnName = "stuID")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Leader leader;

    @OneToMany(targetEntity = Apply.class,mappedBy ="member")
    private Set<Apply> applies=new HashSet<>();

    public String getStuNumber() {
        return stuNumber;
    }

    public Member setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public Member setDepartment(String department) {
        this.department = department;
        return this;
    }

    public Grade getGrade() {
        return grade;
    }

    public Member setGrade(Grade grade) {
        this.grade = grade;
        return this;
    }

    public Leader getLeader() {
        return leader;
    }

    public Member setLeader(Leader leader) {
        this.leader = leader;
        return this;
    }

    public Set<Apply> getApplies() {
        return applies;
    }

    public Member setApplies(Set<Apply> applies) {
        this.applies = applies;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        if (!super.equals(o)) return false;

        Member member = (Member) o;

        if (stuNumber != null ? !stuNumber.equals(member.stuNumber) : member.stuNumber != null) return false;
        if (department != null ? !department.equals(member.department) : member.department != null) return false;
        if (grade != null ? !grade.equals(member.grade) : member.grade != null) return false;
        return leader != null ? (leader.getStuID()==member.leader.getStuID()) : member.leader == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (stuNumber != null ? stuNumber.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (leader != null ? leader.getStuID() : 0);
        return result;
    }
}
