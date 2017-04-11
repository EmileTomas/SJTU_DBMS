package DB_model.Teacher;

import DB_model.Student.Leader;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/10.
 */
@Entity
@DiscriminatorValue("Instructor")
public class Instructor extends Teacher {
    @OneToMany(targetEntity = Leader.class, mappedBy = "instructor")
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
