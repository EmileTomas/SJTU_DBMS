package DB_model.Student;

import DB_model.IDInfo;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Administrator on 2017/4/9.
 */
@Entity
@DiscriminatorColumn(name="studentType",
    discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("NormalStudent")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stuID;

    private String name;

    private String educationBg;

    private String phoneNum;

    private String email;

    private String school;

    private Date birthday;

    @Embedded
    private IDInfo IDInfo;

    public Student() {
    }


    public int getStuID() {
        return stuID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducationBg() {
        return educationBg;
    }

    public void setEducationBg(String educationBg) {
        this.educationBg = educationBg;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public DB_model.IDInfo getIDInfo() {
        return IDInfo;
    }

    public void setIDInfo(DB_model.IDInfo IDInfo) {
        this.IDInfo = IDInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (educationBg != null ? !educationBg.equals(student.educationBg) : student.educationBg != null) return false;
        if (phoneNum != null ? !phoneNum.equals(student.phoneNum) : student.phoneNum != null) return false;
        if (email != null ? !email.equals(student.email) : student.email != null) return false;
        if (school != null ? !school.equals(student.school) : student.school != null) return false;
        if (birthday != null ? !birthday.equals(student.birthday) : student.birthday != null) return false;
        return IDInfo != null ? IDInfo.equals(student.IDInfo) : student.IDInfo == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (educationBg != null ? educationBg.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (IDInfo != null ? IDInfo.hashCode() : 0);
        return result;
    }
}
