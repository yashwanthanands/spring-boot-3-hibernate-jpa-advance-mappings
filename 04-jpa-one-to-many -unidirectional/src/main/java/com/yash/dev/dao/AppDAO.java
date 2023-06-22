package com.yash.dev.dao;

import com.yash.dev.entity.Course;
import com.yash.dev.entity.Instructor;
import com.yash.dev.entity.InstructorDetail;
import java.util.List;

/**
 * @author yashwanthanands
 */
public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailsById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);

    void update(Course tempCourse);

    Course findCourseById(int theCourseId);

    void deleteCourseById(int theId);

    void save(Course course);
}
