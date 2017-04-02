package DB_model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/2.
 */
public class TeacherPK implements Serializable {
    private String teacherNum;
    private String leaderStuNum;

    @Column(name = "teacherNum")
    @Id
    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
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

        TeacherPK teacherPK = (TeacherPK) o;

        if (teacherNum != null ? !teacherNum.equals(teacherPK.teacherNum) : teacherPK.teacherNum != null) return false;
        if (leaderStuNum != null ? !leaderStuNum.equals(teacherPK.leaderStuNum) : teacherPK.leaderStuNum != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teacherNum != null ? teacherNum.hashCode() : 0;
        result = 31 * result + (leaderStuNum != null ? leaderStuNum.hashCode() : 0);
        return result;
    }
}
