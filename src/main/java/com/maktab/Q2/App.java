package com.maktab.Q2;

import com.maktab.Q2.model.Address;
import com.maktab.Q2.model.Student;
import com.maktab.Q2.model.Teacher;
import com.maktab.Q2.model.dao.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        TeacherDAO teacherDao = new TeacherDaoImpl(factory);
        StudentDAO studentDAO = new StudentDaoImpl(factory);
        AddressDaoImpl addressDao = new AddressDaoImpl(factory);

        Teacher teacher = null;
        Teacher teacher2 = null;
        Student student = null;
        Address address1 = null;
        Address address2 = null;
        Address address3 = null;

        address1 = new Address("111", "add1", "Tehran", "09121111111");
        address2 = new Address("222", "add2", "Semnan", "09132222222");
        address3 = new Address("333", "add3", "Tehran", "09123333333");

        teacher = new Teacher("saman", "Smith", "2222", 452, LocalDate.of(2000, 05, 4), address1);
        teacher2 = new Teacher("Ali", "Mammadi", "3222", 454, LocalDate.of(1995, 10, 5), address2);

        student = new Student("mohammad", "Ali", address3);

        addressDao.create(address1);
        addressDao.create(address2);
        addressDao.create(address3);
        teacherDao.create(teacher);
        teacherDao.create(teacher2);
        studentDAO.create(student);

//        studentDAO.search("mohammad");
//        teacherDao.livesInTehran();
//        teacherDao.beginsWith912();
//        teacherDao.extremeAge();
//        teacherDao.tehran_912();
//        studentDAO.notInTehran();
//        teacherDao.max_MinSalary();
//        teacherDao.deleteTeacher("3222");
//        studentDAO.search("mohammad");

        factory.close();

    }//end of main method

}//end of App class
