package com.yash.dev.dao;

import com.yash.dev.entity.Instructor;

/**
 * @author yashwanthanands
 */
public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}
