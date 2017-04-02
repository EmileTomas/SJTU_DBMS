package com.sp_seiee;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/2.
 */
public class OtherschoolstudentEntityPK implements Serializable {
    private String name;
    private String leaderNum;

    @Column(name = "name")
    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "leaderNum")
    @Id
    public String getLeaderNum() {
        return leaderNum;
    }

    public void setLeaderNum(String leaderNum) {
        this.leaderNum = leaderNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OtherschoolstudentEntityPK that = (OtherschoolstudentEntityPK) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (leaderNum != null ? !leaderNum.equals(that.leaderNum) : that.leaderNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (leaderNum != null ? leaderNum.hashCode() : 0);
        return result;
    }
}
