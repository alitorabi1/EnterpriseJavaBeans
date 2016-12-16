/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import auto.entity.Lord;
import auto.entity.Vehicle;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author lenovo
 */
@Remote
public interface AutoServiceRemote {

    void addLord(Lord lord);

    void addVehicle(Vehicle vehicle);

    List<Vehicle> getVehicleList();

    List<Vehicle> getVehiclesOfLord(Lord lord);

    List<Lord> getLordList();
    
}
