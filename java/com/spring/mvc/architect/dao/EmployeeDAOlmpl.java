package com.spring.mvc.architect.dao;


import com.spring.mvc.architect.entity.Book;
import com.spring.mvc.architect.entity.Employee;
import com.spring.mvc.architect.entity.myEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@Repository
public class EmployeeDAOlmpl implements EmployeeDAO {
//    @Autowired
//    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Employee> getAllEmployees(){

        System.out.println("Попытка создать сессию для Хайбер");

        // Создаем сессию для Hibernate
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = factory.openSession();
        session = factory.getCurrentSession();
        System.out.println("Попытка пооучить текущуюю сессию для Хайбер");





        session.beginTransaction();

        System.out.println("Попытка сделать запрос");
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> allEmployee = query.getResultList();
        System.out.println("Результат запроса" + allEmployee.get(0).getName());
        //session.getTransaction().commit();

        session.close();
        factory.close();
        return allEmployee;

    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee){
        // Создаем сессию для Hibernate
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.saveOrUpdate(employee);
        session.getTransaction().commit();

        session.close();
        factory.close();
    }
    @Override
    @Transactional
    public Employee getEmployee(int id){

        // Создаем сессию для Hibernate
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);

        session.getTransaction().commit();

        session.close();
        factory.close();

        return employee;
    }

    @Override
    @Transactional
    public void deleteEmployee(int id){

        // Создаем сессию для Hibernate
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
        query.setParameter("employeeId",id);

        query.executeUpdate();


        //session.getTransaction().commit();

        session.close();
        factory.close();
    }
}
