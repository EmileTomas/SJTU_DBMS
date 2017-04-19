package DB_model;

import DB_model.Student.Leader;
import DB_model.Student.Member;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/4/17.
 */
@Entity
public class Apply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applyId;

    @ManyToOne(targetEntity = Member.class)
    @JoinColumn(name = "memberID",referencedColumnName = "stuID")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Member member;

    @ManyToOne(targetEntity = Leader.class)
    @JoinColumn(name="leaderID",referencedColumnName = "stuID")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Leader leader;

    private String state;

    public Apply() {
    }

    public Apply(Member member, Leader leader) {
        this.member = member;
        this.leader = leader;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apply)) return false;

        Apply apply = (Apply) o;

        if (member != null ? !member.equals(apply.member) : apply.member != null) return false;
        if (leader != null ? !leader.equals(apply.leader) : apply.leader != null) return false;
        return state != null ? state.equals(apply.state) : apply.state == null;
    }

    @Override
    public int hashCode() {
        int result = member != null ? member.hashCode() : 0;
        result = 31 * result + (leader != null ? leader.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
