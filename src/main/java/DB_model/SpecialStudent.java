package DB_model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/4/9.
 */
@Entity
@DiscriminatorValue("SpecialStudent")
public class SpecialStudent extends Student {
    @ManyToOne(targetEntity = GroupLeader.class)
    @JoinColumns(value = {
            @JoinColumn(name="leaderIDType",referencedColumnName = "idType"),
            @JoinColumn(name="leaderIDNum",referencedColumnName = "idNum")
    })
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private GroupLeader groupLeader;

    public GroupLeader getGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(GroupLeader groupLeader) {
        this.groupLeader = groupLeader;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecialStudent specialStudent = (SpecialStudent) o;
        if (groupLeader != null ? !groupLeader.equals(specialStudent.groupLeader) : specialStudent.groupLeader != null) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (groupLeader != null ? groupLeader.hashCode() : 0);
        return result;
    }

}
