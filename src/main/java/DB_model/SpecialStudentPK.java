package DB_model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/2.
 */
public class SpecialStudentPK implements Serializable {
    private String name;
    private String leaderStuNum;

    @Column(name = "name")
    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "leaderStuNum")
    @Id
    public String getLeaderStuNum() {
        return leaderStuNum;
    }

    public void setLeaderStuNum(String leaderStuNum) {
        this.leaderStuNum = leaderStuNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecialStudentPK that = (SpecialStudentPK) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (leaderStuNum != null ? !leaderStuNum.equals(that.leaderStuNum) : that.leaderStuNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (leaderStuNum != null ? leaderStuNum.hashCode() : 0);
        return result;
    }
}
