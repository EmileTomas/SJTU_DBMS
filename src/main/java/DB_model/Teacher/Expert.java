package DB_model.Teacher;

/**
 * Created by Administrator on 2017/4/10.
 */

import DB_model.Team;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("Expert")
public class Expert extends Teacher {
    @OneToMany(targetEntity = Team.class, mappedBy = "instructor")
    private Set<Team> teams = new HashSet<>();

    public Expert() {
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public Expert setTeams(Set<Team> teams) {
        this.teams = teams;
        return this;
    }
}
