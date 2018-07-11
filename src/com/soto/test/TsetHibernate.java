package com.soto.test;


import com.soto.pojo.Category;
import com.soto.pojo.Product;
import com.soto.pojo.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TsetHibernate {
    public static void main(String[] args) {
//        1. 获取SessionFactory
        SessionFactory sf =  new Configuration().configure().buildSessionFactory();
//        2. 通过SessionFactory 获取一个Session
        Session s = sf.openSession();
//        3. 在Session基础上开启一个事务
        s.beginTransaction();

//        4. 通过调用Session的save方法把对象保存到数据库
//
//        for (int i = 0; i < 10; i++) {
//            Product p = new Product();
//            p.setName("iphone" + i);
//            p.setPrice(i);
//            s.save(p);
//
//        }

//        Product p = (Product)s.get(Product.class, 3);
//        System.out.println("id=6的产品名称是: " + p.getName());
//
//        p.setName("iphonr-modified");
//        s.update(p);
        /**
         * 测试many-to-one关系
         */
//        Category c = new Category();
//        c.setName("c1");
//        s.save(c);
//
//        Product p = (Product) s.get(Product.class, 8);
//        p.setCategory(c);
//        s.update(p);

        /**
         * 测试one-to-many关系
         */
//        Category c = (Category) s.get(Category.class, 1);
//        Set<Product> ps = c.getProducts();
//        for (Product p : ps) {
//            System.out.println(p.getName());
//        }
        /**
         * 测试may-to-many
         */
        //增加3个用户
//        Set<User> users = new HashSet();
//        for (int i = 0; i < 3; i++) {
//            User u =new User();
//            u.setName("user"+i);
//            users.add(u);
//            s.save(u);
//        }
//        Product p1 = (Product) s.get(Product.class, 5);
//
//        p1.setUsers(users);
//        s.save(p1);
        /**
         *分页 测试
         */
        String name = "iphone";

        Criteria c = s.createCriteria(Product.class);
        c.add(Restrictions.like("name", "%" + name + "%"));
//        表示从第2条数据开始
        c.setFirstResult(2);
//        一共查询5条数据
        c.setMaxResults(5);

        List<Product> ps = c.list();
        for (Product p : ps) {
            System.out.println(p.getName());

        }


//        s.delete(p);

//        5. 提交事务
        s.getTransaction().commit();

//        6. 关闭Session
//        7. 关闭SessionFactory
        s.clear();
        sf.close();

    }
}
