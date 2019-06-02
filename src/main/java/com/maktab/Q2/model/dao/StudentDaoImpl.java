package com.maktab.Q2.model.dao;


import com.maktab.Q2.core.dao.BaseDaoImpl;
import com.maktab.Q2.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDAO {
    private Session session;

    public StudentDaoImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    public String getEntityName() {
        return "Student";
    }

    //Searches to find a student with the desired name
    public void search(String name) {
        session = factory.openSession();
        List<Student> search = new ArrayList<>();
        search.add((Student) session.createQuery("from Student where firstName like :name or lastName like :name")
                .setParameter("name", name).uniqueResult());
        System.out.println(search);
    }

    //Searches to find students who doesn't live in Tehran
    public void notInTehran() {
        session = factory.openSession();
        List<Student> notInTehran = new ArrayList<>();
        notInTehran.add((Student) session.createQuery("from Student where address.city != 'Tehran' ").uniqueResult());
        System.out.println(notInTehran);
    }

}//end of StudentDaoImp class
