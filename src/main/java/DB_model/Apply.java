package DB_model;

import DB_model.Student.Leader;
import DB_model.Student.Member;
import DB_model.Util.ApplyState;
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
    @JoinColumn(name = "memberID", referencedColumnName = "stuID", nullable = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Member member;

    @ManyToOne(targetEntity = Leader.class)
    @JoinColumn(name = "leaderID", referencedColumnName = "stuID", nullable = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Leader leader;

    @Enumerated(EnumType.STRING)
    private ApplyState applyState = ApplyState.WAITING;

    public Apply() {
    }

    public Apply(Member member, Leader leader) {
        this.member = member;
        this.leader = leader;
    }

    public int getApplyId() {
        return applyId;
    }

    public Apply setApplyId(int applyId) {
        this.applyId = applyId;
        return this;
    }

    public Member getMember() {
        return member;
    }

    public Apply setMember(Member member) {
        this.member = member;
        return this;
    }

    public Leader getLeader() {
        return leader;
    }

    public Apply setLeader(Leader leader) {
        this.leader = leader;
        return this;
    }

    public ApplyState getApplyState() {
        return applyState;
    }

    public Apply setApplyState(ApplyState applyState) {
        this.applyState = applyState;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apply)) return false;

        Apply apply = (Apply) o;

        if (applyId != apply.applyId) return false;
        if (applyState != apply.applyState) return false;
        if (leader.getStuID() != apply.leader.getStuID()) return false;

        return (member.getStuID() == apply.member.getStuID());
    }

    @Override
    public int hashCode() {
        int result = applyId;
        result = 31 * result + applyState.hashCode();
        result = 31 * result + member.getStuID();
        result = 31 * result + leader.getStuID();

        return result;
    }
}
