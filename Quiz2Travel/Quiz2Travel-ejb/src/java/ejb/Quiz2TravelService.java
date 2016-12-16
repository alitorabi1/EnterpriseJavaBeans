package ejb;

import entities.Traveller;
import entities.Trip;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

@Stateless
public class Quiz2TravelService implements Quiz2TravelServiceRemote {

    @PersistenceContext(unitName = "Quiz2Travel-PU")
    private EntityManager em; 

    @Override
    public void addTraveller(Traveller traveller) {
        em.persist(traveller);
    }

    @Override
    public List<Traveller> getAllTravellers() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Traveller.class));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public void addTrip(Trip trip) {
        em.persist(trip);
    }

    @Override
    public List<Trip> getTripsByTraveller(Traveller traveller) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Trip> q = cb.createQuery(Trip.class);
        Root<Trip> c = q.from(Trip.class);
        q.select(c);
        ParameterExpression<Traveller> p = cb.parameter(Traveller.class);
        q.where(cb.equal(c.get("traveller"), traveller));
        // equivalent of SELECT * FROM cars WHERE owner = $owner
        return em.createQuery(q).getResultList();        
    }

    @Override
    public List<Trip> getTripsByFilter(Traveller traveller, String trip) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Trip> q = cb.createQuery(Trip.class);
        Root<Trip> c = q.from(Trip.class);
        q.select(c);
        ParameterExpression<Traveller> p = cb.parameter(Traveller.class);
        q.where(cb.equal(c.get("traveller"), traveller));
        q.where(cb.like(c.get("destination"), "%"+trip+"%"));
        // equivalent of SELECT * FROM cars WHERE owner = $owner
        return em.createQuery(q).getResultList();        
    }
    
    
}
