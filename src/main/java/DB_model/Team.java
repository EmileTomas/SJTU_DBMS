package DB_model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by Administrator on 2017/4/2.
 */
@Entity
public class Team {
    private String leaderStuNum;
    private String projectName;
    private String projectType;
    private String projectIndex;
    private Byte importantFlag;
    private String practiceLocation;
    private Date startTime;
    private Date endTime;
    private String teacherNum;
    private String expertNum;
    private String applyStatus;

    @Id
    @Column(name = "leaderStuNum")
    public String getLeaderStuNum() {
        return leaderStuNum;
    }

    public void setLeaderStuNum(String leaderStuNum) {
        this.leaderStuNum = leaderStuNum;
    }

    @Basic
    @Column(name = "projectName")
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Basic
    @Column(name = "projectType")
    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    @Basic
    @Column(name = "projectIndex")
    public String getProjectIndex() {
        return projectIndex;
    }

    public void setProjectIndex(String projectIndex) {
        this.projectIndex = projectIndex;
    }

    @Basic
    @Column(name = "importantFlag")
    public Byte getImportantFlag() {
        return importantFlag;
    }

    public void setImportantFlag(Byte importantFlag) {
        this.importantFlag = importantFlag;
    }

    @Basic
    @Column(name = "practiceLocation")
    public String getPracticeLocation() {
        return practiceLocation;
    }

    public void setPracticeLocation(String practiceLocation) {
        this.practiceLocation = practiceLocation;
    }

    @Basic
    @Column(name = "startTime")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "endTime")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "teacherNum")
    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
    }

    @Basic
    @Column(name = "expertNum")
    public String getExpertNum() {
        return expertNum;
    }

    public void setExpertNum(String expertNum) {
        this.expertNum = expertNum;
    }

    @Basic
    @Column(name = "applyStatus")
    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (leaderStuNum != null ? !leaderStuNum.equals(team.leaderStuNum) : team.leaderStuNum != null) return false;
        if (projectName != null ? !projectName.equals(team.projectName) : team.projectName != null) return false;
        if (projectType != null ? !projectType.equals(team.projectType) : team.projectType != null) return false;
        if (projectIndex != null ? !projectIndex.equals(team.projectIndex) : team.projectIndex != null) return false;
        if (importantFlag != null ? !importantFlag.equals(team.importantFlag) : team.importantFlag != null)
            return false;
        if (practiceLocation != null ? !practiceLocation.equals(team.practiceLocation) : team.practiceLocation != null)
            return false;
        if (startTime != null ? !startTime.equals(team.startTime) : team.startTime != null) return false;
        if (endTime != null ? !endTime.equals(team.endTime) : team.endTime != null) return false;
        if (teacherNum != null ? !teacherNum.equals(team.teacherNum) : team.teacherNum != null) return false;
        if (expertNum != null ? !expertNum.equals(team.expertNum) : team.expertNum != null) return false;
        if (applyStatus != null ? !applyStatus.equals(team.applyStatus) : team.applyStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = leaderStuNum != null ? leaderStuNum.hashCode() : 0;
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (projectType != null ? projectType.hashCode() : 0);
        result = 31 * result + (projectIndex != null ? projectIndex.hashCode() : 0);
        result = 31 * result + (importantFlag != null ? importantFlag.hashCode() : 0);
        result = 31 * result + (practiceLocation != null ? practiceLocation.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (teacherNum != null ? teacherNum.hashCode() : 0);
        result = 31 * result + (expertNum != null ? expertNum.hashCode() : 0);
        result = 31 * result + (applyStatus != null ? applyStatus.hashCode() : 0);
        return result;
    }
}
