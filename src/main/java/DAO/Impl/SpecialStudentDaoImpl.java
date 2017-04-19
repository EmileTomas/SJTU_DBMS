package DAO.Impl;

import DAO.SpecialStudentDao;
import DB_model.Student.SpecialStudent;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
public class SpecialStudentDaoImpl implements SpecialStudentDao {
    public void save(SpecialStudent specialStudent) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(specialStudent);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(int specialStudentID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            SpecialStudent specialStudent = session.get(SpecialStudent.class, specialStudentID);
            if (specialStudent != null)
                session.delete(specialStudent);
            //TODO LOG NOT FOUND
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }


    public SpecialStudent find(int specialStudentID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        SpecialStudent specialStudent = null;
        try {
            session.beginTransaction();
            specialStudent = session.get(SpecialStudent.class, specialStudentID);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return specialStudent;
    }

    public void update(SpecialStudent specialStudent) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(specialStudent);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }


    public List<SpecialStudent> findAllSpecialStudents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<SpecialStudent> specialStudents = null;
        try {
            session.beginTransaction();
            String hql = "from SpecialStudent ";
            Query query = session.createQuery(hql);
            specialStudents = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return specialStudents;
    }
}
