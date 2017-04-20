package DB_model.Student;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Administrator on 2017/4/9.
 */
@Entity
@DiscriminatorValue("SpecialStudent")
public class SpecialStudent extends Student {
    @ManyToOne(targetEntity = Leader.class)
    @JoinColumn(name = "leaderID", referencedColumnName = "stuID",nullable = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Leader leader;

    public SpecialStudent() {
    }

    public Leader getLeader() {
        return leader;
    }

    public SpecialStudent setLeader(Leader leader) {
        this.leader = leader;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpecialStudent)) return false;
        if (!super.equals(o)) return false;

        SpecialStudent that = (SpecialStudent) o;

        return leader != null ? (leader.getStuID()==that.leader.getStuID()) : that.leader == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (leader != null ? leader.getStuID() : 0);
        return result;
    }
}
