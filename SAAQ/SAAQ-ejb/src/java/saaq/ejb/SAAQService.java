/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saaq.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import saaq.entity.Car;
import saaq.entity.Owner;

/**
 *
 * @author ipd
 */
@Stateless
public class SAAQService implements SAAQServiceRemote {

    @PersistenceContext(unitName = "SAAQ-ejbPU")
    private EntityManager em;    

    @Override
    public void addOwner(Owner owner) {
        em.persist(owner);
    }

    @Override
    public List<Owner> getOwnerList() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Owner.class));
        return em.createQuery(cq).getResultList();
    }
    
    @Override
    public void addCar(Car car) {
        em.persist(car);
    }

    @Override
    public List<Car> getCarListForOwner(Owner owner) {
        Car car = new Car();
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//        cq.select(cq.from(Vehicle.class));
//        cq.where("=:l", l);
        em.createQuery("SELECT FROM car WHERE owner.id=:oId");
        em.setProperty("oId", owner.getId());
        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<Car> getCarList() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Car.class));
        return em.createQuery(cq).getResultList();
    }

}
