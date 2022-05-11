package vn.myclass.core.data.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import vn.myclass.core.common.utils.HibernateUtils;
import vn.myclass.core.data.dao.GenericDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class AbstractDao <ID extends Serializable, T> implements GenericDao<ID, T> {

    private Class<T> persistenceClass;

    public AbstractDao(){
        this.persistenceClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public String getPersistenceClassName(){
        return persistenceClass.getSimpleName();
    }



    @Override
    public List<T> findAll() {
        List<T> list = new ArrayList<T>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            StringBuilder sql = new StringBuilder("from ");
            sql.append(this.getPersistenceClassName());
            Query query = session.createQuery(sql.toString());
            list = query.list();
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public T update(T entity) {
        T result = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            Object object =  session.merge(entity);
            result = (T) object;
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            throw  e;
        }

        return result;
    }

}
