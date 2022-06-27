package com.spring.mvc.architect.dao;

import com.spring.mvc.architect.entity.myEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class myEntityDAOImpl implements myEntityDAO {
    //    @Autowired
    //    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<myEntity> getAllEntity() {
        // Создаем сессию для Hibernate
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(myEntity.class)
                .buildSessionFactory();
        Session session = (Session) factory.getCurrentSession();
        session.beginTransaction();

        List<myEntity> allEntity = session.createQuery("from myEntity ",myEntity.class)
                .getResultList();

        session.getTransaction().commit();

        session.close();
        factory.close();
        return allEntity;
    }


}
