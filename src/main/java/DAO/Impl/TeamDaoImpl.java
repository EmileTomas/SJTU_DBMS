package DAO.Impl;

import DAO.TeamDao;
import DB_model.Student.Member;
import DB_model.Team;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */
public class TeamDaoImpl implements TeamDao {
    public void save(Member member) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(member);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(int teamID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Team team = session.get(Team.class, teamID);
            if (team != null)
                session.delete(team);
            //TODO LOG NOT FOUND
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Team find(int teamID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Team team = null;
        try {
            session.beginTransaction();
            team = session.get(Team.class, teamID);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return team;
    }

    public void update(Team team) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(team);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Team> findAllTeams() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Team> teams = null;
        try {
            session.beginTransaction();
            String hql = "from Team ";
            Query query = session.createQuery(hql);
            teams = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return teams;
    }

    public List<Team> findAllKeyTeams() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Team> keyTeams = null;
        try {
            session.beginTransaction();
            String hql = "from Team where teamType=?";
            Query query = session.createQuery(hql).setParameter(0, "key");
            keyTeams = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return keyTeams;
    }

    public List<Team> findAllNormalTeams() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Team> normalTeams = null;
        try {
            session.beginTransaction();
            String hql = "from Team where teamType=?";
            Query query = session.createQuery(hql).setParameter(0, "normal");
            normalTeams = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return normalTeams;
    }

    public List<Team> findAllApplyTeams() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Team> applyTeams = null;
        try {
            session.beginTransaction();
            String hql = "from Team where teamType=?";
            Query query = session.createQuery(hql).setParameter(0, "applying");
            applyTeams = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return applyTeams;
    }

}
