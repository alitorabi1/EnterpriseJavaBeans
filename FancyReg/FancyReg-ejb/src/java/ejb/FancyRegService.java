package ejb;

import entities.Course;
import entities.Registration;
import entities.Student;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FancyRegService implements FancyRegServiceRemote {

    @PersistenceContext(unitName = "FancyRegInterfacePU")
    private EntityManager em;    
    
    
    @Override
    public void addStudent(Student student){
        em.persist(student);
    }

    @Override
    public List<Student> getAllStudents() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Student.class));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public void addCourse(Course course) {
        em.persist(course);
    }

    @Override
    public List<Course> getAllCourses() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Course.class));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public void addRegistration(Registration registration) {
        em.persist(registration);
    }

    @Override
    public List<Registration> getAllRegistrations() {
         javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Registration.class));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public void removeRegistration(Registration registration) {
        em.remove(em.merge(registration));
    }
    
    
}
