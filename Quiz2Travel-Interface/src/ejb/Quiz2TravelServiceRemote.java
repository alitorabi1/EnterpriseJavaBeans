/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Traveller;
import entities.Trip;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ipd
 */
@Remote
public interface Quiz2TravelServiceRemote {

    void addTraveller(Traveller traveller);

    List<Traveller> getAllTravellers();

    void addTrip(Trip trip);

    List<Trip> getTripsByTraveller(Traveller traveller);

    List<Trip> getTripsByFilter(Traveller traveller, String trip);
    
}
