package com.spring.mvc.architect.dao;

import com.spring.mvc.architect.entity.Book;
import com.spring.mvc.architect.entity.myEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookDAOimpl implements BookDAO {


    @Override
    @Transactional
    public List<Book> getAllBook() {
        // Создаем сессию для Hibernate
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        Session session = (Session) factory.getCurrentSession();
        session.beginTransaction();
        List<Book> allBooks = session.createQuery("from Book ",Book.class)
                .getResultList();

        session.getTransaction().commit();

        session.close();
        factory.close();
        return allBooks;
    }

    @Override
    @Transactional
    public Book getBook(int id) {
        // Создаем сессию для Hibernate
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        // Создаем сессию для Hibernate
        Session session = (Session) factory.getCurrentSession();
        session.beginTransaction();
        Book books = session.get(Book.class, id);

        session.getTransaction().commit();

        session.close();
        factory.close();
        return books;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        // Создаем сессию для Hibernate
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        // Создаем сессию для Hibernate
        Session session = (Session) factory.getCurrentSession();
        session.beginTransaction();

        session.save(book);

        session.getTransaction().commit();

        session.close();
        factory.close();
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        // Создаем сессию для Hibernate
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        // Создаем сессию для Hibernate
        Session session = (Session) factory.getCurrentSession();
        session.beginTransaction();
        Book book = session.get(Book.class, id);

        session.delete(book);

        session.getTransaction().commit();

        session.close();
        factory.close();
    }
    //    @Autowired
    //    private SessionFactory sessionFactory;

//    @Override
//    @Transactional
//    public List<myEntity> getAllEntity() {
//        // Создаем сессию для Hibernate
//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(myEntity.class)
//                .buildSessionFactory();
//        Session session = (Session) factory.getCurrentSession();
//        session.beginTransaction();
//
//        List<myEntity> allEntity = session.createQuery("from myEntity ",myEntity.class)
//                .getResultList();
//
//        session.getTransaction().commit();
//
//        session.close();
//        factory.close();
//        return allEntity;
//    }


}
