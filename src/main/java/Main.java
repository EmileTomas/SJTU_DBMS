import DB_model.GroupLeader;
import DB_model.GroupMember;
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

        GroupMember groupMember=new GroupMember();
        groupMember.setIdNum("00000");
        groupMember.setIdType("SFZ");

        GroupLeader groupLeader=new GroupLeader();
        groupLeader.setIdType("SFZ");
        groupLeader.setIdNum("88888");
        groupLeader.setStuNumber("514103012");
        groupMember.setGroupLeader(groupLeader);

        GroupMember groupMember1=new GroupMember();
        groupMember1.setIdType("TBZ");
        groupMember1.setIdNum("666666");
        groupMember1.setGroupLeader(groupLeader);
        session.persist(groupMember1);
        session.persist(groupMember);

        tx.commit();
        session.close();

        session=sessionFactory.openSession();
        Transaction x=session.beginTransaction();
        List<GroupLeader> pl=session.createQuery("from GroupLeader ").list();
        for(GroupLeader ele:pl){

            System.out.println(ele.getIdNum());
        }
        x.commit();
        session.close();

    }
}