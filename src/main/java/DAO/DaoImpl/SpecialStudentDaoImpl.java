package DAO.DaoImpl;

import DAO.SpecialStudentDao;
import DB_model.module.Id_PK;
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

    public void delete(Id_PK specialStudentID) {
        SpecialStudent specialStudent = find(specialStudentID);
        if (specialStudent != null){
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            try {
                session.beginTransaction();
                session.delete(specialStudent);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        }
    }


    /**
     * @param specialStudentID
     * @return if more than one instance matches LeaderID, throw exception
     */
    public SpecialStudent find(Id_PK specialStudentID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        SpecialStudent specialStudent = null;
        try {
            session.beginTransaction();
            String hql = "from SpecialStudent as spStu where spStu.id_pk.idType=? and spStu.id_pk.idNum=?";
            Query query = session.createQuery(hql)
                    .setParameter(0, specialStudentID.getIdType())
                    .setParameter(1, specialStudentID.getIdNum());
            specialStudent = (SpecialStudent) query.uniqueResult();
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


    public List<SpecialStudent> findAllSpecialStudents(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<SpecialStudent> specialStudents = null;
        try {
            session.beginTransaction();
            String hql = "from SpecialStudent ";
            Query query = session.createQuery(hql);
            specialStudents= query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return specialStudents;
    }
}
