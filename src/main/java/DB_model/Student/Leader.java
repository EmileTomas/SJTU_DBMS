package DB_model.Student;

import DB_model.Teacher.Expert;
import DB_model.Teacher.Instructor;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("Leader")
public class Leader extends Student {
    @Basic
    @Column(name = "stuNumber")
    private String stuNumber;

    @Basic
    @Column(name = "department")
    private String department;

    @OneToMany(targetEntity = Member.class, mappedBy = "leader")
    private Set<Member> members = new HashSet<>();


    @OneToMany(targetEntity = SpecialStudent.class, mappedBy = "leader")
    private Set<SpecialStudent> specialStudents = new HashSet<>();

    @ManyToOne(targetEntity = Instructor.class)
    @JoinColumns(value = {
            @JoinColumn(name = "InstructorIDType", referencedColumnName = "idType"),
            @JoinColumn(name = "InstructorIDNum", referencedColumnName = "idNum")
    })
    @Cascade(CascadeType.SAVE_UPDATE)
    private Instructor instructor;

    @ManyToOne(targetEntity = Expert.class)
    @JoinColumns(value = {
            @JoinColumn(name = "ExpertIDType", referencedColumnName = "idType"),
            @JoinColumn(name = "ExpertIDNum", referencedColumnName = "idNum")
    })
    @Cascade(CascadeType.SAVE_UPDATE)
    private Expert expert;


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

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public Set<SpecialStudent> getSpecialStudents() {
        return specialStudents;
    }

    public void setSpecialStudents(Set<SpecialStudent> specialStudents) {
        this.specialStudents = specialStudents;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Leader leader = (Leader) o;

        if (stuNumber != null ? !stuNumber.equals(leader.stuNumber) : leader.stuNumber != null) return false;
        if (department != null ? !department.equals(leader.department) : leader.department != null) return false;
        if (instructor != null ? !instructor.equals(leader.instructor) : leader.instructor != null) return false;
        if (expert != null ? !expert.equals(leader.expert) : leader.expert != null) return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (stuNumber != null ? stuNumber.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (instructor != null ? instructor.hashCode() : 0);
        result = 31 * result + (expert != null ? expert.hashCode() : 0);

        return result;
    }

}
