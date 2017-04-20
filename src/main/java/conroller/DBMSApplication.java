package conroller;

import DAO.ApplyDao;
import DAO.Impl.ApplyDaoImpl;
import DAO.Impl.LeaderDaoImpl;
import DAO.Impl.MemberDaoImpl;
import DAO.Impl.TeamDaoImpl;
import DAO.LeaderDao;
import DAO.MemberDao;
import DAO.TeamDao;
import DB_model.Student.Leader;
import DB_model.Student.Member;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DBMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(DBMSApplication.class, args);
		LeaderDao leaderDao=new LeaderDaoImpl();
		MemberDao memberDao=new MemberDaoImpl();
		TeamDao teamDao=new TeamDaoImpl();

		Member member1=new Member().setStuNumber("5140309349");
		Member member2=new Member().setStuNumber("5140000000");
		Leader leader1=new Leader().setStuNumber("5130101111");
		Leader leader2=new Leader().setStuNumber("51201211212");

		memberDao.save(member1);
		memberDao.save(member2);

		leaderDao.save(leader1);
		leaderDao.save(leader2);
		member1.setLeader(leader1);
		member2.setLeader(leader1);
		memberDao.update(member1);
		memberDao.update(member2);

		leaderDao.delete(leader1.getStuID());

	}
}
