package DB_model.Team;

import DB_model.Student.Leader;
import DB_model.Teacher.Expert;
import DB_model.Teacher.Instructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
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
    @Column(name = "teamID")
    private int teamID;

    @Basic
    @Column(name = "teamIndex",unique = true)
    private int teamIndex;

    @Basic
    @Column(name = "teamName")
    private String teamName;

    @Basic
    @Column(name = "teamType")
    private String teamType;

    @Basic
    @Column(name = "practiceLocation")
    private String practiceLocation;

    @Basic
    @Column(name = "startTime")
    private Date startTime;

    @Basic
    @Column(name = "endTime")
    private Date endTime;

    @Basic
    @Column(name = "applyState")
    private String applyState="Waitting";

    @OneToOne(targetEntity = Leader.class)
    @JoinColumns(value = {
            @JoinColumn(name = "leaderIDType", referencedColumnName = "idType"),
            @JoinColumn(name = "leaderIDNum", referencedColumnName = "idNum")
    })
    private Leader leader;

    @ManyToOne(targetEntity = Instructor.class)
    @JoinColumns(value = {
            @JoinColumn(name = "InstructorIDType", referencedColumnName = "idType"),
            @JoinColumn(name = "InstructorIDNum", referencedColumnName = "idNum")
    })
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Instructor instructor;


    @ManyToOne(targetEntity = Expert.class)
    @JoinColumns(value = {
            @JoinColumn(name = "ExpertIDType", referencedColumnName = "idType"),
            @JoinColumn(name = "ExpertIDNum", referencedColumnName = "idNum")
    })
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Expert expert;


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

        if (teamID != team.teamID) return false;
        if (teamIndex != team.teamIndex) return false;
        if (teamName != null ? !teamName.equals(team.teamName) : team.teamName != null) return false;
        if (teamType != null ? !teamType.equals(team.teamType) : team.teamType != null) return false;
        if (practiceLocation != null ? !practiceLocation.equals(team.practiceLocation) : team.practiceLocation != null)
            return false;
        if (startTime != null ? !startTime.equals(team.startTime) : team.startTime != null) return false;
        if (endTime != null ? !endTime.equals(team.endTime) : team.endTime != null) return false;
        if (applyState != null ? !applyState.equals(team.applyState) : team.applyState != null) return false;
        if (leader != null ? !leader.equals(team.leader) : team.leader != null) return false;
        if (instructor != null ? !instructor.equals(team.instructor) : team.instructor != null) return false;
        return expert != null ? expert.equals(team.expert) : team.expert == null;
    }

    @Override
    public int hashCode() {
        int result = teamID;
        result = 31 * result + teamIndex;
        result = 31 * result + (teamName != null ? teamName.hashCode() : 0);
        result = 31 * result + (teamType != null ? teamType.hashCode() : 0);
        result = 31 * result + (practiceLocation != null ? practiceLocation.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (applyState != null ? applyState.hashCode() : 0);
        result = 31 * result + (leader != null ? leader.hashCode() : 0);
        result = 31 * result + (instructor != null ? instructor.hashCode() : 0);
        result = 31 * result + (expert != null ? expert.hashCode() : 0);
        return result;
    }
}
