import DAO.DaoImpl.*;
import DB_model.Student.Leader;
import DB_model.Student.Member;
import DB_model.module.Id_PK;
import DB_model.Teacher.Expert;

/**
 * Created by Administrator on 2017/4/4.
 */
public class Main {

    public static void main(final String[] args) throws Exception {


        LeaderDaoImpl leaderDao=new LeaderDaoImpl();
        MemberDaoImpl memberDao=new MemberDaoImpl();
        ExpertDaoImpl expertDao=new ExpertDaoImpl();

        Leader leader1=new Leader();
        leader1.setStuNumber("99999999");
        leader1.setId_pk(new Id_PK("TBZ","000000000"));


        Leader leader2=new Leader();
        leader2.setStuNumber("22222222");
        leader2.setId_pk(new Id_PK("TBZ","12507478"));

        Member member1=new Member();
        member1.setStuNumber("5140309349");
        member1.setId_pk(new Id_PK("SFZ","362321199"));


        Member member2=new Member();
        member2.setStuNumber("5140309300");
        member2.setId_pk(new Id_PK("SFZ","36232116699"));

        Expert expert1=new Expert();
        expert1.setTeacherNum("T11111");
        expert1.setId_pk(new Id_PK("SFZ","21964444"));

        Expert expert2=new Expert();
        expert2.setTeacherNum("T2222222");
        expert2.setId_pk(new Id_PK("SFZ","154646"));

        leaderDao.save(leader1);
        expertDao.save(expert1);
        /**
         * Teacher and Instructor test

        LeaderDaoImpl leaderDao=new LeaderDaoImpl();
        ExpertDaoImpl expertDao=new ExpertDaoImpl();
        InstructorDaoImpl instructorDao=new InstructorDaoImpl();

        Leader leader1=new Leader();
        leader1.setStuNumber("1111111");
        leader1.setID_PK(new Id_PK("SFZ","3623211669"));

        Leader leader2=new Leader();
        leader2.setStuNumber("22222222");
        leader2.setID_PK(new Id_PK("TBZ","12507478"));

        Expert expert1=new Expert();
        expert1.setTeacherNum("T11111");
        expert1.setId_pk(new Id_PK("SFZ","21964444"));

        Expert expert2=new Expert();
        expert2.setTeacherNum("T2222222");
        expert2.setId_pk(new Id_PK("SFZ","154646"));

        expertDao.save(expert1);
        expertDao.save(expert2);
        expert1.setEmail("123");
        expert2.setEmail("234");
        expertDao.update(expert1);
        expertDao.update(expert2);

        Instructor instructor1=new Instructor();
        instructor1.setTeacherNum("I11111111");
        instructor1.setId_pk(new Id_PK("SFZ","I66666"));

        Instructor instructor2=new Instructor();
        instructor2.setTeacherNum("I2222222");
        instructor2.setId_pk(new Id_PK("SFZ","I122222"));

        instructorDao.save(instructor1);
        instructorDao.save(instructor2);
        instructor1.setEmail("123@12");
        instructor2.setEmail("2222222@14");
        instructorDao.update(instructor1);
        instructorDao.update(instructor2);


        leader1.setExpert(expert1);
        leader2.setExpert(expert1);
        leaderDao.save(leader1);

        leaderDao.save(leader2);


        //Please Figure out the delete
        List<Leader> leaders=new ArrayList<Leader>(expert1.getLeaders());
        System.out.println(expert1.getLeaders().size());
        */

    }
}