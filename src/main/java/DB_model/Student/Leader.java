package DB_model.Student;

import DB_model.Apply;
import DB_model.Team;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("Leader")
public class Leader extends Student {
    @Column(nullable = false,unique = true)
    private String stuNumber;

    private String department;

    @Embedded
    private Grade grade;

    @OneToMany(targetEntity = Member.class, mappedBy = "leader")
    private Set<Member> members = new HashSet<>();

    @OneToMany(targetEntity = SpecialStudent.class, mappedBy = "leader")
    private Set<SpecialStudent> specialStudents = new HashSet<>();

    @OneToMany(targetEntity = Apply.class,mappedBy = "leader")
    private Set<Apply> applies=new HashSet<>();

    @OneToOne(targetEntity = Team.class,mappedBy = "leader")
    private Team team;

    public String getStuNumber() {
        return stuNumber;
    }

    public Leader setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public Leader setDepartment(String department) {
        this.department = department;
        return this;
    }

    public Grade getGrade() {
        return grade;
    }

    public Leader setGrade(Grade grade) {
        this.grade = grade;
        return this;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public Leader setMembers(Set<Member> members) {
        this.members = members;
        return this;
    }

    public Set<SpecialStudent> getSpecialStudents() {
        return specialStudents;
    }

    public Leader setSpecialStudents(Set<SpecialStudent> specialStudents) {
        this.specialStudents = specialStudents;
        return this;
    }

    public Set<Apply> getApplies() {
        return applies;
    }

    public Leader setApplies(Set<Apply> applies) {
        this.applies = applies;
        return this;
    }

    public Team getTeam() {
        return team;
    }

    public Leader setTeam(Team team) {
        this.team = team;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Leader)) return false;
        if (!super.equals(o)) return false;

        Leader leader = (Leader) o;

        if (grade != null ? !grade.equals(leader.grade) : leader.grade != null) return false;
        if (stuNumber != null ? !stuNumber.equals(leader.stuNumber) : leader.stuNumber != null) return false;
        if (department != null ? !department.equals(leader.department) : leader.department != null) return false;
        return team != null ? (team.getTeamID()==leader.team.getTeamID()) : leader.team == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (stuNumber != null ? stuNumber.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (team != null ? team.getTeamID() : 0);
        return result;
    }
}

