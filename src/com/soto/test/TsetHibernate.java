package com.soto.test;


import com.soto.pojo.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TsetHibernate {
    public static void main(String[] args) {
//        1. 获取SessionFactory
        SessionFactory sf =  new Configuration().configure().buildSessionFactory();
//        2. 通过SessionFactory 获取一个Session
        Session s = sf.openSession();
//        3. 在Session基础上开启一个事务
        s.beginTransaction();

//        4. 通过调用Session的save方法把对象保存到数据库
        Product p = new Product();
        p.setName("iphone7");
        p.setPrice(7000);
        s.save(p);

//        5. 提交事务
        s.getTransaction().commit();

//        6. 关闭Session
//        7. 关闭SessionFactory
        s.clear();
        sf.close();

    }
}
