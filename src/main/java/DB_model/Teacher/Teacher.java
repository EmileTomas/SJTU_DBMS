package DB_model.Teacher;

import DB_model.Id_PK;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Administrator on 2017/4/10.
 */
@Entity
@DiscriminatorColumn(name = "TeacherType",
        discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("NormalTeacher")
public class Teacher {

    @EmbeddedId
    private Id_PK id_pk;

    @Basic
    @Column(name = "teacherNum")
    private String teacherNum;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "jobTitle")
    private String jobTitle;
    @Basic
    @Column(name = "department")
    private String department;
    @Basic
    @Column(name = "phoneNum")
    private String phoneNum;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "birthday")
    private Date birthday;


    public Id_PK getId_pk() {
        return id_pk;
    }

    public void setId_pk(Id_PK id_pk) {
        this.id_pk = id_pk;
    }


    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (id_pk != null ? !id_pk.equals(teacher.id_pk) : teacher.id_pk != null) return false;
        if (teacherNum != null ? !teacherNum.equals(teacher.teacherNum) : teacher.teacherNum != null) return false;
        if (name != null ? !name.equals(teacher.name) : teacher.name != null) return false;
        if (jobTitle != null ? !jobTitle.equals(teacher.jobTitle) : teacher.jobTitle != null) return false;
        if (department != null ? !department.equals(teacher.department) : teacher.department != null) return false;
        if (phoneNum != null ? !phoneNum.equals(teacher.phoneNum) : teacher.phoneNum != null) return false;
        if (email != null ? !email.equals(teacher.email) : teacher.email != null) return false;
        if (birthday != null ? !birthday.equals(teacher.birthday) : teacher.birthday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id_pk != null ? id_pk.hashCode() : 0;
        result = 31 * result + (teacherNum != null ? teacherNum.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
