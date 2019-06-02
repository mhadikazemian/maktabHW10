package com.maktab.Q2.model.dao;

import com.maktab.Q2.core.dao.BaseDAO;
import com.maktab.Q2.model.Teacher;

public interface TeacherDAO extends BaseDAO<Teacher> {
    void deleteTeacher(String teacherCod);

    void max_MinSalary();

    void extremeAge();

    void livesInTehran();

    void beginsWith912();

    void tehran_912();
}//end of TeacherDAO interface
