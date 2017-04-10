package DB_model.Student;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by Administrator on 2017/4/9.
 */
@Entity
@DiscriminatorValue("SpecialStudent")
public class SpecialStudent extends Student {
    @ManyToOne(targetEntity = Leader.class)
    @JoinColumns(value = {
            @JoinColumn(name = "leaderIDType", referencedColumnName = "idType"),
            @JoinColumn(name = "leaderIDNum", referencedColumnName = "idNum")}
            )
    @Cascade(CascadeType.SAVE_UPDATE)
    private Leader leader;

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecialStudent specialStudent = (SpecialStudent) o;
        if (leader != null ? !leader.equals(specialStudent.leader) : specialStudent.leader != null) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (leader != null ? leader.hashCode() : 0);
        return result;
    }
}