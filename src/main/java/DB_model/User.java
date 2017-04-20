package DB_model;

import DB_model.Util.UserType;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/4/17.
 */
@Entity
public class User  {
    @Id
    private String account;

    @Column(nullable = false,unique = true)
    private int stuID;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;

    public User() {
    }

    public User(String account, int stuID, UserType userType) {
        this.account = account;
        this.stuID = stuID;
        this.userType = userType;
    }

    public String getAccount() {
        return account;
    }

    public User setAccount(String account) {
        this.account = account;
        return this;
    }

    public int getStuID() {
        return stuID;
    }

    public User setStuID(int stuID) {
        this.stuID = stuID;
        return this;
    }

    public UserType getUserType() {
        return userType;
    }

    public User setUserType(UserType userType) {
        this.userType = userType;
        return this;
    }
}
