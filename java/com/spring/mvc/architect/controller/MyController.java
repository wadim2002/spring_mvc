package com.spring.mvc.architect.controller;

import com.spring.mvc.architect.dao.myEntityDAO;
import com.spring.mvc.architect.entity.myEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.parser.Entity;
import java.util.List;
@Controller
public class MyController {
    @Autowired
    private myEntityDAO myEntityDAO;

    @RequestMapping(path = "/ent")
    public String showEntity(Model model){

//        myEntity myentity = new myEntity();
//
//        System.out.println("Создали сущность");
//
//        System.out.println("Попытка создать сессию сессиию");
//        // Создаем сессию для Hibernate
//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(myEntity.class)
//                .buildSessionFactory();
//
//        Session session = (Session) factory.getCurrentSession();
//
//        System.out.println("Создали сессиию");
//
//        session.beginTransaction();
//
//        myentity = session.get(myEntity.class,1);
//
//        System.out.println("Полцчили 1-й объект" + myentity.getNameEntity());
//
//        session.getTransaction().commit();
//
//        session.close();
//        factory.close();
        //@Autowired
        List<myEntity> allEntity = myEntityDAO.getAllEntity();
        // Добавили результаты во вью
        model.addAttribute("ents", allEntity);
        System.out.println("Передали объект в модель");
        System.out.println("Запустили вью");
        return "first";

    }
}
