import DB_model.Leader;
import DB_model.Member;
import Util.HibernateUtil;
import org.hibernate.*;
import java.util.List;

/**
 * Created by Administrator on 2017/4/4.
 */
public class Main {

    public static void main(final String[] args) throws Exception {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();

        Member member =new Member();
        member.setIdNum("00000");
        member.setIdType("SFZ");

        Leader leader =new Leader();
        leader.setIdType("SFZ");
        leader.setIdNum("88888");
        leader.setStuNumber("514103012");
        member.setLeader(leader);

        Member member1 =new Member();
        member1.setIdType("TBZ");
        member1.setIdNum("666666");
        member1.setLeader(leader);
        session.persist(member1);
        session.persist(member);

        tx.commit();
        session.close();

        session=sessionFactory.openSession();
        Transaction x=session.beginTransaction();
        List<Leader> pl=session.createQuery("from Leader ").list();
        for(Leader ele:pl){

            System.out.println(ele.getIdNum());
        }
        x.commit();
        session.close();

    }
}