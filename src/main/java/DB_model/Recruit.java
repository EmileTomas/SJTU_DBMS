package DB_model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/4/2.
 */
@Entity
public class Recruit {
    private String leaderStuNum;
    private short numToHire;
    private Timestamp deadline;
    private String teamDescribe;
    private String requirement;

    @Id
    @Column(name = "leaderStuNum")
    public String getLeaderStuNum() {
        return leaderStuNum;
    }

    public void setLeaderStuNum(String leaderStuNum) {
        this.leaderStuNum = leaderStuNum;
    }

    @Basic
    @Column(name = "numToHire")
    public short getNumToHire() {
        return numToHire;
    }

    public void setNumToHire(short numToHire) {
        this.numToHire = numToHire;
    }

    @Basic
    @Column(name = "deadline")
    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    @Basic
    @Column(name = "teamDescribe")
    public String getTeamDescribe() {
        return teamDescribe;
    }

    public void setTeamDescribe(String teamDescribe) {
        this.teamDescribe = teamDescribe;
    }

    @Basic
    @Column(name = "requirement")
    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recruit recruit = (Recruit) o;

        if (numToHire != recruit.numToHire) return false;
        if (leaderStuNum != null ? !leaderStuNum.equals(recruit.leaderStuNum) : recruit.leaderStuNum != null)
            return false;
        if (deadline != null ? !deadline.equals(recruit.deadline) : recruit.deadline != null) return false;
        if (teamDescribe != null ? !teamDescribe.equals(recruit.teamDescribe) : recruit.teamDescribe != null)
            return false;
        if (requirement != null ? !requirement.equals(recruit.requirement) : recruit.requirement != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = leaderStuNum != null ? leaderStuNum.hashCode() : 0;
        result = 31 * result + (int) numToHire;
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (teamDescribe != null ? teamDescribe.hashCode() : 0);
        result = 31 * result + (requirement != null ? requirement.hashCode() : 0);
        return result;
    }
}
