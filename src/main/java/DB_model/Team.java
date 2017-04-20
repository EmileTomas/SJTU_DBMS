package DB_model;

import DB_model.Student.Leader;
import DB_model.Teacher.Expert;
import DB_model.Teacher.Instructor;
import DB_model.Util.ApplyState;
import DB_model.Util.TeamType;
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

    @Column(nullable = false,unique = true)
    private String teamName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TeamType teamType;

    private String practiceLocation;

    private Date startTime;

    private Date endTime;

    private int teamIndex;

    @Enumerated(EnumType.STRING)
    private ApplyState applyState=ApplyState.WAITING;


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

    public int getTeamID() {
        return teamID;
    }

    public Team setTeamID(int teamID) {
        this.teamID = teamID;
        return this;
    }

    public int getTeamIndex() {
        return teamIndex;
    }

    public Team setTeamIndex(int teamIndex) {
        this.teamIndex = teamIndex;
        return this;
    }

    public String getTeamName() {
        return teamName;
    }

    public Team setTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public TeamType getTeamType() {
        return teamType;
    }

    public Team setTeamType(TeamType teamType) {
        this.teamType = teamType;
        return this;
    }

    public String getPracticeLocation() {
        return practiceLocation;
    }

    public Team setPracticeLocation(String practiceLocation) {
        this.practiceLocation = practiceLocation;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Team setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Team setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public ApplyState getApplyState() {
        return applyState;
    }

    public Team setApplyState(ApplyState applyState) {
        this.applyState = applyState;
        return this;
    }

    public Leader getLeader() {
        return leader;
    }

    public Team setLeader(Leader leader) {
        this.leader = leader;
        return this;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Team setInstructor(Instructor instructor) {
        this.instructor = instructor;
        return this;
    }

    public Expert getExpert() {
        return expert;
    }

    public Team setExpert(Expert expert) {
        this.expert = expert;
        return this;
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
