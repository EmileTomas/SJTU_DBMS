package DB_model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/2.
 */
public class ApplyPK implements Serializable {
    private String stuNum;
    private String leaderStuNum;

    @Column(name = "stuNum")
    @Id
    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
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

        ApplyPK applyPK = (ApplyPK) o;

        if (stuNum != null ? !stuNum.equals(applyPK.stuNum) : applyPK.stuNum != null) return false;
        if (leaderStuNum != null ? !leaderStuNum.equals(applyPK.leaderStuNum) : applyPK.leaderStuNum != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stuNum != null ? stuNum.hashCode() : 0;
        result = 31 * result + (leaderStuNum != null ? leaderStuNum.hashCode() : 0);
        return result;
    }
}
