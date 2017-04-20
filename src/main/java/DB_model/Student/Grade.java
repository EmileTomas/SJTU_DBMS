package DB_model.Student;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/12.
 */
@Embeddable
public class Grade implements Serializable {
    @Basic
    @Column(name="IntroClassGrade")
    private int introClassGrade;

    @Basic
    @Column(name="subPandectClass")
    private int subPandectClass;

    @Basic
    @Column(name="team")
    private int team;

    @Basic
    @Column(name="participation")
    private int participation;

    @Basic
    @Column(name="report")
    private int report;

    public Grade() { }

    public int getIntroClassGrade() {
        return introClassGrade;
    }

    public Grade setIntroClassGrade(int introClassGrade) {
        this.introClassGrade = introClassGrade;
        return this;
    }

    public int getSubPandectClass() {
        return subPandectClass;
    }

    public Grade setSubPandectClass(int subPandectClass) {
        this.subPandectClass = subPandectClass;
        return this;
    }

    public int getTeam() {
        return team;
    }

    public Grade setTeam(int team) {
        this.team = team;
        return this;
    }

    public int getParticipation() {
        return participation;
    }

    public Grade setParticipation(int participation) {
        this.participation = participation;
        return this;
    }

    public int getReport() {
        return report;
    }

    public Grade setReport(int report) {
        this.report = report;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grade)) return false;

        Grade grade = (Grade) o;

        if (introClassGrade != grade.introClassGrade) return false;
        if (subPandectClass != grade.subPandectClass) return false;
        if (team != grade.team) return false;
        if (participation != grade.participation) return false;
        return report == grade.report;
    }

    @Override
    public int hashCode() {
        int result = introClassGrade;
        result = 31 * result + subPandectClass;
        result = 31 * result + team;
        result = 31 * result + participation;
        result = 31 * result + report;
        return result;
    }
}

