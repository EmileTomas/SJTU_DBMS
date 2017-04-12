package DB_model.Student;

import DB_model.module.Id_PK;
import DB_model.Student.module.Grade;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Date;

/**
 * Created by Administrator on 2017/4/9.
 */
@Entity
@DiscriminatorColumn(name="studentType",
    discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorValue("NormalStudent")
public class Student {
    @EmbeddedId
    private Id_PK id_pk;

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

    private Grade grade;

    public Id_PK getId_pk() {
        return id_pk;
    }

    public void setId_pk(Id_PK id_pk) {
        this.id_pk = id_pk;
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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (id_pk != null ? !id_pk.equals(student.id_pk) : student.id_pk != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (educationBg != null ? !educationBg.equals(student.educationBg) : student.educationBg != null) return false;
        if (phoneNum != null ? !phoneNum.equals(student.phoneNum) : student.phoneNum != null) return false;
        if (email != null ? !email.equals(student.email) : student.email != null) return false;
        if (school != null ? !school.equals(student.school) : student.school != null) return false;
        if (birthday != null ? !birthday.equals(student.birthday) : student.birthday != null) return false;
        return grade != null ? grade.equals(student.grade) : student.grade == null;
    }

    @Override
    public int hashCode() {
        int result = id_pk != null ? id_pk.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (educationBg != null ? educationBg.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        return result;
    }
}
