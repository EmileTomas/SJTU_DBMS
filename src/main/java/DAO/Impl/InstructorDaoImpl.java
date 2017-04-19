package DAO.Impl;

import DAO.InstructorDao;
import DB_model.Teacher.Instructor;
import DB_model.Team;
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

    public void delete(int instructorID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, instructorID);
            if (instructor != null) {
                Hibernate.initialize(instructor.getTeams());
                List<Team> teams = new ArrayList<Team>(instructor.getTeams());
                for (Team team : teams) {
                    team.setInstructor(null);
                    session.update(teams);
                }
                session.delete(instructor);
            }
            //TODO Log Not Found Here

            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }


    public Instructor find(int instructorID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Instructor instructor = null;
        try {
            session.beginTransaction();
            instructor = session.get(Instructor.class, instructorID);
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
            String hql = "from Instructor";
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
