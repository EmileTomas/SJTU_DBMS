package DB_model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/4/2.
 */
@Entity
public class Grade {
    private String stuNum;
    private Byte introClass;
    private Byte subIntroClass;
    private Byte team;
    private Byte participation;
    private Byte report;

    @Id
    @Column(name = "stuNum")
    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    @Basic
    @Column(name = "introClass")
    public Byte getIntroClass() {
        return introClass;
    }

    public void setIntroClass(Byte introClass) {
        this.introClass = introClass;
    }

    @Basic
    @Column(name = "subIntroClass")
    public Byte getSubIntroClass() {
        return subIntroClass;
    }

    public void setSubIntroClass(Byte subIntroClass) {
        this.subIntroClass = subIntroClass;
    }

    @Basic
    @Column(name = "team")
    public Byte getTeam() {
        return team;
    }

    public void setTeam(Byte team) {
        this.team = team;
    }

    @Basic
    @Column(name = "participation")
    public Byte getParticipation() {
        return participation;
    }

    public void setParticipation(Byte participation) {
        this.participation = participation;
    }

    @Basic
    @Column(name = "report")
    public Byte getReport() {
        return report;
    }

    public void setReport(Byte report) {
        this.report = report;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grade grade = (Grade) o;

        if (stuNum != null ? !stuNum.equals(grade.stuNum) : grade.stuNum != null) return false;
        if (introClass != null ? !introClass.equals(grade.introClass) : grade.introClass != null) return false;
        if (subIntroClass != null ? !subIntroClass.equals(grade.subIntroClass) : grade.subIntroClass != null)
            return false;
        if (team != null ? !team.equals(grade.team) : grade.team != null) return false;
        if (participation != null ? !participation.equals(grade.participation) : grade.participation != null)
            return false;
        if (report != null ? !report.equals(grade.report) : grade.report != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stuNum != null ? stuNum.hashCode() : 0;
        result = 31 * result + (introClass != null ? introClass.hashCode() : 0);
        result = 31 * result + (subIntroClass != null ? subIntroClass.hashCode() : 0);
        result = 31 * result + (team != null ? team.hashCode() : 0);
        result = 31 * result + (participation != null ? participation.hashCode() : 0);
        result = 31 * result + (report != null ? report.hashCode() : 0);
        return result;
    }
}
