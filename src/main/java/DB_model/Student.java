package DB_model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by Administrator on 2017/4/2.
 */
@Entity
public class Student {
    private String stuNum;
    private String leaderStuNum;
    private String name;
    private String educationBg;
    private String department;
    private String phoneNum;
    private String email;
    private String idType;
    private String idNum;
    private Date birthday;

    @Id
    @Column(name = "stuNum")
    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    @Basic
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
    @Column(name = "educationBg")
    public String getEducationBg() {
        return educationBg;
    }

    public void setEducationBg(String educationBg) {
        this.educationBg = educationBg;
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

        Student student = (Student) o;

        if (stuNum != null ? !stuNum.equals(student.stuNum) : student.stuNum != null) return false;
        if (leaderStuNum != null ? !leaderStuNum.equals(student.leaderStuNum) : student.leaderStuNum != null)
            return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (educationBg != null ? !educationBg.equals(student.educationBg) : student.educationBg != null) return false;
        if (department != null ? !department.equals(student.department) : student.department != null) return false;
        if (phoneNum != null ? !phoneNum.equals(student.phoneNum) : student.phoneNum != null) return false;
        if (email != null ? !email.equals(student.email) : student.email != null) return false;
        if (idType != null ? !idType.equals(student.idType) : student.idType != null) return false;
        if (idNum != null ? !idNum.equals(student.idNum) : student.idNum != null) return false;
        if (birthday != null ? !birthday.equals(student.birthday) : student.birthday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stuNum != null ? stuNum.hashCode() : 0;
        result = 31 * result + (leaderStuNum != null ? leaderStuNum.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (educationBg != null ? educationBg.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (idType != null ? idType.hashCode() : 0);
        result = 31 * result + (idNum != null ? idNum.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
