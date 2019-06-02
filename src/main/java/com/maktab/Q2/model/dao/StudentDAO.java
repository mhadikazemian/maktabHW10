package com.maktab.Q2.model.dao;

import com.maktab.Q2.core.dao.BaseDAO;
import com.maktab.Q2.model.Student;


public interface StudentDAO extends BaseDAO<Student> {
    void search(String name);

    void notInTehran();
}//end of StudentDAO interface
