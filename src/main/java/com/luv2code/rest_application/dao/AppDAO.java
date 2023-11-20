package com.luv2code.rest_application.dao;

import com.luv2code.rest_application.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
