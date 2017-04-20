package DB_model.Teacher;

import DB_model.Team;

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
    @OneToMany(targetEntity = Team.class, mappedBy = "instructor")
    private Set<Team> teams = new HashSet<>();

    public Instructor() {
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
