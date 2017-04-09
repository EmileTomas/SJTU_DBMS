package DB_model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Administrator on 2017/4/9.
 */
@Entity
@DiscriminatorColumn(name="studentType",
    discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("NormalStudent")
@IdClass(StudentPK.class)
public class Student {
    @Id
    @Column(name = "idType")
    private String idType;

    @Id
    @Column(name = "idNum")
    private String idNum;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "educationBg")
    private String educationBg;
    @Basic
    @Column(name = "phoneNum")
    private String phoneNum;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name="school")
    private String school;

    @Basic
    @Column(name = "birthday")
    private Date birthday;

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (idType != null ? !idType.equals(student.idType) : student.idType != null) return false;
        if (idNum != null ? !idNum.equals(student.idNum) : student.idNum != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (educationBg != null ? !educationBg.equals(student.educationBg) : student.educationBg != null) return false;
        if (phoneNum != null ? !phoneNum.equals(student.phoneNum) : student.phoneNum != null) return false;
        if (email != null ? !email.equals(student.email) : student.email != null) return false;
        if (birthday != null ? !birthday.equals(student.birthday) : student.birthday != null) return false;
        if (school != null ? !school.equals(student.school) : student.school != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idType != null ? idType.hashCode() : 0;
        result = 31 * result + (idNum != null ? idNum.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (educationBg != null ? educationBg.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);

        return result;
    }
}
