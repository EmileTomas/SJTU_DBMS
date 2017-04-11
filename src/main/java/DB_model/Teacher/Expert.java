package DB_model.Teacher;

/**
 * Created by Administrator on 2017/4/10.
 */

import DB_model.Student.Leader;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("Expert")
public class Expert extends Teacher {

    @OneToMany(targetEntity = Leader.class, mappedBy = "expert")
    private Set<Leader> leaders = new HashSet<>();

    public Set<Leader> getLeaders() {
        return leaders;
    }

    public void setLeaders(Set<Leader> leaders) {
        this.leaders = leaders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
