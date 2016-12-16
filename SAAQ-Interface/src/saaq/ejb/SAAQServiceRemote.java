/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saaq.ejb;

import java.util.List;
import javax.ejb.Remote;
import saaq.entity.Car;
import saaq.entity.Owner;

/**
 *
 * @author ipd
 */
@Remote
public interface SAAQServiceRemote {

    void addOwner(Owner owner);

    void addCar(Car car);

    List<Owner> getOwnerList();

    List<Car> getCarList();

    List<Car> getCarListForOwner(Owner owner);
    
}
