package DB_model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/4/9.
 */
@Entity
@DiscriminatorValue("Member")
public class Member extends Student {
    @Basic
    @Column(name = "stuNumber", nullable = false)
    private String stuNumber;

    @Basic
    @Column(name = "department")
    private String department;

    @ManyToOne(targetEntity = Leader.class)
    @JoinColumns(value = {
            @JoinColumn(name = "leaderIDType", referencedColumnName = "idType"),
            @JoinColumn(name = "leaderIDNum", referencedColumnName = "idNum")
    })
    @Cascade(CascadeType.SAVE_UPDATE)
    private Leader leader;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (stuNumber != null ? !stuNumber.equals(member.stuNumber) : member.stuNumber != null) return false;
        if (department != null ? !department.equals(member.department) : member.department != null) return false;
        if (leader != null ? !leader.equals(member.leader) : member.leader != null) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (stuNumber != null ? stuNumber.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (leader != null ? leader.hashCode() : 0);

        return result;
    }

}
