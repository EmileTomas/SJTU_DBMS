package DAO.DaoImpl;

import DAO.InstructorDao;
import DB_model.Team.Team;
import DB_model.module.Id_PK;
import DB_model.Teacher.Instructor;
import Util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
public class InstructorDaoImpl implements InstructorDao {
    public void save(Instructor instructor) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(Id_PK instructorID) {
        Instructor instructor = find(instructorID);

        if (instructor != null) {

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            //Clear the key in leaders
            session.update(instructor);                 //For lazy load
            Hibernate.initialize(instructor.getTeams());
            List<Team> teams = new ArrayList<Team>(instructor.getTeams());
            if (teams.size() != 0) {
                for (Team team : teams) {
                    team.setInstructor(null);
                    session.update(team);
                }
            }

            session.delete(instructor);
            session.getTransaction().commit();
        }
    }


    public Instructor find(Id_PK instructorID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Instructor instructor = null;
        try {
            session.beginTransaction();
            String hql = "from Instructor as instructors where instructors.id_pk.idType=? and instructors.id_pk.idNum=?";
            Query query = session.createQuery(hql)
                    .setParameter(0, instructorID.getIdType())
                    .setParameter(1, instructorID.getIdNum());
            instructor = (Instructor) query.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return instructor;
    }

    public void update(Instructor instructor) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(instructor);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Instructor> findAllInstructors() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Instructor> instructors = null;
        try {
            session.beginTransaction();
            String hql = "from Leader";
            Query query = session.createQuery(hql);
            instructors = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return instructors;
    }
}
