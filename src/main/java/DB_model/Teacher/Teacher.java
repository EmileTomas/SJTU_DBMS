package DB_model.Teacher;

import DB_model.Util.IDInfo;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;

    @Column(nullable = false,unique = true)
    private String teacherNum;

    private String name;

    private String jobTitle;

    private String department;

    private String phoneNum;

    private String email;

    private Date birthday;

    @Embedded
    private IDInfo idInfo;

    public Teacher() {
    }

    public int getTeacherId() {
        return teacherId;
    }

    public Teacher setTeacherId(int teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    public IDInfo getIdInfo() {
        return idInfo;
    }

    public Teacher setIdInfo(IDInfo idInfo) {
        this.idInfo = idInfo;
        return this;
    }

    public String getTeacherNum() {
        return teacherNum;
    }

    public Teacher setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
        return this;
    }

    public String getName() {
        return name;
    }

    public Teacher setName(String name) {
        this.name = name;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Teacher setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public Teacher setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public Teacher setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Teacher setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Teacher setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;

        Teacher teacher = (Teacher) o;

        if (idInfo != null ? !idInfo.equals(teacher.idInfo) : teacher.idInfo != null) return false;
        if (teacherNum != null ? !teacherNum.equals(teacher.teacherNum) : teacher.teacherNum != null) return false;
        if (name != null ? !name.equals(teacher.name) : teacher.name != null) return false;
        if (jobTitle != null ? !jobTitle.equals(teacher.jobTitle) : teacher.jobTitle != null) return false;
        if (department != null ? !department.equals(teacher.department) : teacher.department != null) return false;
        if (phoneNum != null ? !phoneNum.equals(teacher.phoneNum) : teacher.phoneNum != null) return false;
        if (email != null ? !email.equals(teacher.email) : teacher.email != null) return false;
        return birthday != null ? birthday.equals(teacher.birthday) : teacher.birthday == null;
    }

    @Override
    public int hashCode() {
        int result = idInfo != null ? idInfo.hashCode() : 0;
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
