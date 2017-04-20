package DB_model.Student;

import DB_model.Util.IDInfo;
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
    private IDInfo idInfo;

    public int getStuID() {
        return stuID;
    }

    public Student setStuID(int stuID) {
        this.stuID = stuID;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getEducationBg() {
        return educationBg;
    }

    public Student setEducationBg(String educationBg) {
        this.educationBg = educationBg;
        return this;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public Student setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Student setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSchool() {
        return school;
    }

    public Student setSchool(String school) {
        this.school = school;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Student setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public IDInfo getIdInfo() {
        return idInfo;
    }

    public Student setIdInfo(IDInfo idInfo) {
        this.idInfo = idInfo;
        return this;
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
        return idInfo != null ? idInfo.equals(student.idInfo) : student.idInfo == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (educationBg != null ? educationBg.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (idInfo != null ? idInfo.hashCode() : 0);
        return result;
    }
}
