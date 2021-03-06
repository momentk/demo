package com.test;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CriteriaQuery {
    public static void main(String[] args){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        Criteria c = s.createCriteria(UserEntity.class);
        c.add(Restrictions.like("username", "%a%"));
        c.setFirstResult(0);//从第1条记录开始
        c.setMaxResults(1);//查询1个结果

        List<UserEntity> ps = c.list();
        for(UserEntity u : ps){
            System.out.println(u.getUsername());
        }
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
}
