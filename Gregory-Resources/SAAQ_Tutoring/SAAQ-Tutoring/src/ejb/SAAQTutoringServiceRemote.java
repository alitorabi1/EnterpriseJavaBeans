/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Car;
import entities.Owner;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ipd
 */
@Remote
public interface SAAQTutoringServiceRemote {

    void addOwner(Owner owner);

    List<Owner> getAllOwners();

    void addCar(Car car);

    List<Car> getCarsByOwner(Owner owner);
    
}
