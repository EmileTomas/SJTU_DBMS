package DAO.Impl;

import DAO.ApplyDao;
import DB_model.Apply;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Created by Administrator on 2017/4/19.
 */
public class ApplyDaoImpl implements ApplyDao {
    public void save(Apply apply){
        Session session= HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.beginTransaction();
            session.save(apply);
            session.getTransaction().commit();
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(int applyID){
        Session session= HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.beginTransaction();
            Apply apply=session.get(Apply.class,applyID);
            if(apply!=null)
                session.delete(apply);
            //TODO Log Not Found
            session.getTransaction().commit();
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Apply find(int applyID){
        Session session= HibernateUtil.getSessionFactory().getCurrentSession();
        Apply apply=null;
        try {
            session.beginTransaction();
            apply=session.get(Apply.class,applyID);
            session.getTransaction().commit();
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return apply;
    }

    public void update(Apply apply){
        Session session= HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.beginTransaction();
            session.update(apply);
            session.getTransaction().commit();
        }catch(HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
