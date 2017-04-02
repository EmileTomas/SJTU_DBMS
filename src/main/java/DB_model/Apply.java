package DB_model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by Administrator on 2017/4/2.
 */
@Entity
@IdClass(ApplyPK.class)
public class Apply {
    private String stuNum;
    private String leaderStuNum;

    @Id
    @Column(name = "stuNum")
    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    @Id
    @Column(name = "leaderStuNum")
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

        Apply apply = (Apply) o;

        if (stuNum != null ? !stuNum.equals(apply.stuNum) : apply.stuNum != null) return false;
        if (leaderStuNum != null ? !leaderStuNum.equals(apply.leaderStuNum) : apply.leaderStuNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stuNum != null ? stuNum.hashCode() : 0;
        result = 31 * result + (leaderStuNum != null ? leaderStuNum.hashCode() : 0);
        return result;
    }
}
