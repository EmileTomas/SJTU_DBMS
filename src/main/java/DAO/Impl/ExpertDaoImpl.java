package DAO.Impl;

import DAO.ExpertDao;
import DB_model.Teacher.Expert;
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
public class ExpertDaoImpl implements ExpertDao {
    public void save(Expert expert) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(expert);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(int expertID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Expert expert = session.get(Expert.class, expertID);
            if(expert!=null){
                Hibernate.initialize(expert.getTeams());
                List<Team> teams = new ArrayList<Team>(expert.getTeams());
                for (Team team : teams) {
                    team.setExpert(null);
                    session.update(teams);
                }
                session.delete(expert);
            }
            //TODO Log Not Found Here
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Expert find(int expertID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Expert expert = null;
        try {
            session.beginTransaction();
            expert = session.get(Expert.class, expertID);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return expert;
    }

    public void update(Expert expert) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(expert);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Expert> findAllExperts() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Expert> experts = null;
        try {
            session.beginTransaction();
            String hql = "from Expert";
            Query query = session.createQuery(hql);
            experts = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return experts;
    }
}
