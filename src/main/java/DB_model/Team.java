package DB_model;

import DB_model.Student.Leader;
import DB_model.Teacher.Expert;
import DB_model.Teacher.Instructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Administrator on 2017/4/12.
 */
@Entity
@DiscriminatorColumn(name = "TeamType",
        discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("NormalTeam")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamID;

    private int teamIndex;

    private String teamName;

    private String teamType;

    private String practiceLocation;

    private Date startTime;

    private Date endTime;

    private String applyState="Waitting";

    @OneToOne(targetEntity = Leader.class)
    @JoinColumn(name = "leaderID", referencedColumnName = "stuID")
    private Leader leader;

    @ManyToOne(targetEntity = Instructor.class)
    @JoinColumn(name = "InstructorID", referencedColumnName = "teacherID")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Instructor instructor;

    @ManyToOne(targetEntity = Expert.class)
    @JoinColumn(name = "ExpertID", referencedColumnName = "teacherID")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Expert expert;


    public Team() {
    }


    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getTeamIndex() {
        return teamIndex;
    }

    public void setTeamIndex(int teamIndex) {
        this.teamIndex = teamIndex;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamType() {
        return teamType;
    }

    public void setTeamType(String teamType) {
        this.teamType = teamType;
    }

    public String getPracticeLocation() {
        return practiceLocation;
    }

    public void setPracticeLocation(String practiceLocation) {
        this.practiceLocation = practiceLocation;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getApplyState() {
        return applyState;
    }

    public void setApplyState(String applyState) {
        this.applyState = applyState;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
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
        if (!(o instanceof Team)) return false;

        Team team = (Team) o;

        if (teamIndex != team.teamIndex) return false;
        if (teamName != null ? !teamName.equals(team.teamName) : team.teamName != null) return false;
        if (teamType != null ? !teamType.equals(team.teamType) : team.teamType != null) return false;
        if (practiceLocation != null ? !practiceLocation.equals(team.practiceLocation) : team.practiceLocation != null)
            return false;
        if (startTime != null ? !startTime.equals(team.startTime) : team.startTime != null) return false;
        if (endTime != null ? !endTime.equals(team.endTime) : team.endTime != null) return false;
        if (applyState != null ? !applyState.equals(team.applyState) : team.applyState != null) return false;
        if (leader != null ? !(leader.getStuID()==team.leader.getStuID()) : team.leader != null) return false;
        if (instructor != null ? !(instructor.getTeacherId()==team.instructor.getTeacherId()) : team.instructor != null) return false;
        return expert != null ? (expert.getTeacherId()==team.expert.getTeacherId()) : team.expert == null;
    }

    @Override
    public int hashCode() {
        int result = teamIndex;
        result = 31 * result + (teamName != null ? teamName.hashCode() : 0);
        result = 31 * result + (teamType != null ? teamType.hashCode() : 0);
        result = 31 * result + (practiceLocation != null ? practiceLocation.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (applyState != null ? applyState.hashCode() : 0);
        result = 31 * result + (leader != null ? leader.getStuID() : 0);
        result = 31 * result + (instructor != null ? instructor.getTeacherId() : 0);
        result = 31 * result + (expert != null ? expert.getTeacherId() : 0);
        return result;
    }
}
