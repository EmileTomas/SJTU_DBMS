package DB_model.Student;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/12.
 */
@Embeddable
public class Grade implements Serializable {
    private int introClassGrade;

    private int subPandectClass;

    private int team;

    private int participation;

    private int report;

    public Grade() { }

    public int getIntroClassGrade() {
        return introClassGrade;
    }

    public void setIntroClassGrade(int introClassGrade) {
        this.introClassGrade = introClassGrade;
    }

    public int getSubPandectClass() {
        return subPandectClass;
    }

    public void setSubPandectClass(int subPandectClass) {
        this.subPandectClass = subPandectClass;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public int getParticipation() {
        return participation;
    }

    public void setParticipation(int participation) {
        this.participation = participation;
    }

    public int getReport() {
        return report;
    }

    public void setReport(int report) {
        this.report = report;
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

