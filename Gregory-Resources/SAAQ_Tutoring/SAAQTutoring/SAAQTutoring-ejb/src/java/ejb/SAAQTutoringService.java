package ejb;

import entities.Car;
import entities.Owner;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

@Stateless
public class SAAQTutoringService implements SAAQTutoringServiceRemote {
   
    @PersistenceContext(unitName="SAAQTutoring-ejbPU")
    private EntityManager em;

    @Override
    public void addOwner(Owner owner) {
        em.persist(owner);
    }

    @Override
    public List<Owner> getAllOwners() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Owner.class));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public void addCar(Car car) {
        em.persist(car);
    }    

    @Override
    public List<Car> getCarsByOwner(Owner owner) {
        // DO NOT USE NATIVE QUERY UNLESS ALLOWED
        // em.createNativeQuery(sqlString);
        //
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Car> q = cb.createQuery(Car.class);
        Root<Car> c = q.from(Car.class);
        q.select(c);
        ParameterExpression<Owner> p = cb.parameter(Owner.class);
        q.where(cb.equal(c.get("owner"), owner));
        // equivalent of SELECT * FROM cars WHERE owner = $owner
        return em.createQuery(q).getResultList();        
    }
    
}
