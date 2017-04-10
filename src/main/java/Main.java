import DAO.DaoImpl.LeaderDaoImpl;
import DAO.DaoImpl.MemberDaoImpl;
import DAO.DaoImpl.SpecialStudentDaoImpl;
import DB_model.*;
import DB_model.Student.Leader;
import DB_model.Student.Member;

/**
 * Created by Administrator on 2017/4/4.
 */
public class Main {

    public static void main(final String[] args) throws Exception {
        LeaderDaoImpl leaderDao=new LeaderDaoImpl();
        MemberDaoImpl memberDao=new MemberDaoImpl();
        SpecialStudentDaoImpl specialStudentDao=new SpecialStudentDaoImpl();


        Leader leader=new Leader();
        leader.setStuNumber("1111111");
        leader.setID_PK(new ID_PK("SFZ","3623211669"));


        Member member=new Member();
        ID_PK id_pk=new ID_PK("SFZ","362321199");
        member.setStuNumber("5140309349");
        member.setID_PK(id_pk);
        member.setLeader(leader);
        memberDao.save(member);

        Member member2=new Member();
        member2.setStuNumber("5140309300");
        member2.setID_PK(new ID_PK("SFZ","36232116699"));
        member2.setLeader(leader);
        memberDao.save(member2);

        Leader leader1=new Leader();
        leader1.setStuNumber("99999999");
        leader1.setID_PK(new ID_PK("TBZ","000000000"));
        member2.setLeader(leader1);
        memberDao.update(member2);

        memberDao.delete(id_pk);

        System.out.println(leader.getMembers().size());




    }
}