package com.maktab.Q2.model.dao;

import com.maktab.Q2.core.dao.BaseDaoImpl;
import com.maktab.Q2.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDAO {

    private Session session;

    public TeacherDaoImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    public String getEntityName() {
        return "Teacher";
    }

    //Deletes a teacher with desired code
    public void deleteTeacher(String code) {
        session = factory.openSession();
        session.beginTransaction();
        Query teacher = session.createQuery("delete from Teacher where teacherCode = " + code + "");
        teacher.executeUpdate();
        session.close();
    }

    //Finds teachers with maximum and minimum salaries
    public void max_MinSalary() {
        List<Teacher> mxmn = new ArrayList<>();
        session = factory.openSession();
        mxmn.add((Teacher) session.createQuery("from Teacher e where e.salary " +
                "= (select max(b.salary) from Teacher b) ").getSingleResult());
        mxmn.add((Teacher) session.createQuery("from Teacher e where e.salary " +
                "= (select min(b.salary) from Teacher b) ").getSingleResult());
        System.out.println(mxmn);
        session.close();
    }

    //Finds the oldest and youngest teachers
    public void extremeAge() {
        session = factory.openSession();
        List<Teacher> extremeAge = new ArrayList<>();
        extremeAge.add((Teacher) session.createQuery(" from Teacher e where e.birthday " +
                "= (select min (b.birthday) from Teacher b) ").getSingleResult());
        extremeAge.add((Teacher) session.createQuery(" from Teacher e where e.birthday " +
                "= (select max (b.birthday) from Teacher b) ").getSingleResult());
        System.out.println(extremeAge);
        session.close();
    }

    //Finds teachers who lives in Tehran
    public void livesInTehran() {
        session = factory.openSession();
        List<Teacher> livesInTehran = new ArrayList<>();
        livesInTehran.add((Teacher) session.createQuery("From Teacher e where e.address.city " +
                "= 'Tehran'").uniqueResult());
        System.out.println(livesInTehran);
        session.close();
    }

    //Finds teachers who has phone numbers that starts with 0912
    public void beginsWith912() {
        session = factory.openSession();
        List<Teacher> beginsWith912 = new ArrayList<>();
        beginsWith912.add((Teacher) session.createQuery("From Teacher e where e.address.number " +
                "LIKE '0912%'").uniqueResult());
        System.out.println(beginsWith912);
        session.close();
    }

    //Finds teachers who lives in Tehran & has phone numbers that starts with 0912
    public void tehran_912() {
        session = factory.openSession();
        List<Teacher> tehran_912 = new ArrayList<>();
        tehran_912.add((Teacher) session.createQuery("From Teacher e where e.address.number " +
                "LIKE '0912%' and e.address.city = 'Tehran'").uniqueResult());
        System.out.println(tehran_912);
        session.close();
    }
}//end of TeacherDaoImpl class
