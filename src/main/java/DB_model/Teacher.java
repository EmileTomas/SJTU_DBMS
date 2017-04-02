package DB_model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Administrator on 2017/4/2.
 */
@Entity
@IdClass(TeacherPK.class)
public class Teacher {
    private String teacherNum;
    private String leaderStuNum;
    private String name;
    private String jobTitle;
    private String department;
    private String phoneNum;
    private String email;
    private String idType;
    private String idNum;
    private Date birthday;
    private byte expertFlag;

    @Id
    @Column(name = "teacherNum")
    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
    }

    @Id
    @Column(name = "leaderStuNum")
    public String getLeaderStuNum() {
        return leaderStuNum;
    }

    public void setLeaderStuNum(String leaderStuNum) {
        this.leaderStuNum = leaderStuNum;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "jobTitle")
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Basic
    @Column(name = "department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    @Column(name = "phoneNum")
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "idType")
    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "idNum")
    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "expertFlag")
    public byte getExpertFlag() {
        return expertFlag;
    }

    public void setExpertFlag(byte expertFlag) {
        this.expertFlag = expertFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (expertFlag != teacher.expertFlag) return false;
        if (teacherNum != null ? !teacherNum.equals(teacher.teacherNum) : teacher.teacherNum != null) return false;
        if (leaderStuNum != null ? !leaderStuNum.equals(teacher.leaderStuNum) : teacher.leaderStuNum != null)
            return false;
        if (name != null ? !name.equals(teacher.name) : teacher.name != null) return false;
        if (jobTitle != null ? !jobTitle.equals(teacher.jobTitle) : teacher.jobTitle != null) return false;
        if (department != null ? !department.equals(teacher.department) : teacher.department != null) return false;
        if (phoneNum != null ? !phoneNum.equals(teacher.phoneNum) : teacher.phoneNum != null) return false;
        if (email != null ? !email.equals(teacher.email) : teacher.email != null) return false;
        if (idType != null ? !idType.equals(teacher.idType) : teacher.idType != null) return false;
        if (idNum != null ? !idNum.equals(teacher.idNum) : teacher.idNum != null) return false;
        if (birthday != null ? !birthday.equals(teacher.birthday) : teacher.birthday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teacherNum != null ? teacherNum.hashCode() : 0;
        result = 31 * result + (leaderStuNum != null ? leaderStuNum.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (idType != null ? idType.hashCode() : 0);
        result = 31 * result + (idNum != null ? idNum.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (int) expertFlag;
        return result;
    }
}
