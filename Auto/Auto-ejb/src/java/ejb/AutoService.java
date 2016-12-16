package ejb;

import auto.entity.Lord;
import auto.entity.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AutoService implements AutoServiceRemote {

    @PersistenceContext(unitName = "AutoPU")
    private EntityManager em;

    @Override
    public void addLord(Lord lord) {
        em.persist(lord);
    }

    @Override
    public List<Lord> getLordList() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Lord.class));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        em.persist(vehicle);
    }

    @Override
    public List<Vehicle> getVehicleList() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Vehicle.class));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<Vehicle> getVehiclesOfLord(Lord lord) {
        Vehicle v = new Vehicle();
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//        cq.select(cq.from(Vehicle.class));
//        cq.where("=:l", l);
        em.createQuery("SELECT FROM v WHERE lord.id=:vId");
        em.setProperty("vId", lord.getId());
        return em.createQuery(cq).getResultList();
    }

}
