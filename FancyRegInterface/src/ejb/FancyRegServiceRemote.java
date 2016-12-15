/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Course;
import entities.Registration;
import entities.Student;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ipd
 */
@Remote
public interface FancyRegServiceRemote {

    void addStudent(Student parameter);

    List<Student> getAllStudents();

    void addCourse(Course parameter);

    List<Course> getAllCourses();

    void addRegistration(Registration parameter);

    List<Registration> getAllRegistrations();

    void removeRegistration(Registration parameter);
    
}
