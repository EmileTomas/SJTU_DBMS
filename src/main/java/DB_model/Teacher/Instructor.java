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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructor instructor = (Instructor) o;
        if (leaders != null ? !leaders.equals(instructor.leaders) : instructor.leaders != null) return false;
        return super.equals(o);
    }


    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (leaders != null ? leaders.hashCode() : 0);
        return result;
    }
}
