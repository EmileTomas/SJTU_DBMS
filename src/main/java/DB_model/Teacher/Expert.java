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

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expert)) return false;
        if (!super.equals(o)) return false;

        Expert expert = (Expert) o;

        return teams != null ? teams.equals(expert.teams) : expert.teams == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (teams != null ? teams.hashCode() : 0);
        return result;
    }
}
