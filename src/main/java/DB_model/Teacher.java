package DB_model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Administrator on 2017/4/2.
 */
@Entity
@Table(name = "teacher", schema = "socialpractice", catalog = "")
public class Teacher {
    private String teacherNum;
    private String leaderNum;
    private String name;
    private String jobTitle;
    private String department;
    private String phoneNum;
    private String email;
    private String idType;
    private String idNum;
    private Date birthday;

    @Id
    @Column(name = "teacherNum")
    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
    }

    @Basic
    @Column(name = "leaderNum")
    public String getLeaderNum() {
        return leaderNum;
    }

    public void setLeaderNum(String leaderNum) {
        this.leaderNum = leaderNum;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher that = (Teacher) o;

        if (teacherNum != null ? !teacherNum.equals(that.teacherNum) : that.teacherNum != null) return false;
        if (leaderNum != null ? !leaderNum.equals(that.leaderNum) : that.leaderNum != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (jobTitle != null ? !jobTitle.equals(that.jobTitle) : that.jobTitle != null) return false;
        if (department != null ? !department.equals(that.department) : that.department != null) return false;
        if (phoneNum != null ? !phoneNum.equals(that.phoneNum) : that.phoneNum != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (idType != null ? !idType.equals(that.idType) : that.idType != null) return false;
        if (idNum != null ? !idNum.equals(that.idNum) : that.idNum != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teacherNum != null ? teacherNum.hashCode() : 0;
        result = 31 * result + (leaderNum != null ? leaderNum.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (idType != null ? idType.hashCode() : 0);
        result = 31 * result + (idNum != null ? idNum.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
