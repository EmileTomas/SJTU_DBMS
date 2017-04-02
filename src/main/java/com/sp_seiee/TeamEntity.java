package com.sp_seiee;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Administrator on 2017/4/2.
 */
@Entity
@Table(name = "team", schema = "socialpractice", catalog = "")
public class TeamEntity {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamEntity that = (TeamEntity) o;

        if (leaderStuNum != null ? !leaderStuNum.equals(that.leaderStuNum) : that.leaderStuNum != null) return false;
        if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null) return false;
        if (projectType != null ? !projectType.equals(that.projectType) : that.projectType != null) return false;
        if (projectIndex != null ? !projectIndex.equals(that.projectIndex) : that.projectIndex != null) return false;
        if (importantFlag != null ? !importantFlag.equals(that.importantFlag) : that.importantFlag != null)
            return false;
        if (practiceLocation != null ? !practiceLocation.equals(that.practiceLocation) : that.practiceLocation != null)
            return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (teacherNum != null ? !teacherNum.equals(that.teacherNum) : that.teacherNum != null) return false;
        if (expertNum != null ? !expertNum.equals(that.expertNum) : that.expertNum != null) return false;

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
        return result;
    }
}
