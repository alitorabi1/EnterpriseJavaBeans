/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shout.ejb;

import java.util.ArrayList;
import javax.ejb.Remote;

@Remote
public interface ShoutServiceRemote {

    void addShout(String name, String shout) throws InvalidShoutDataException;

    ArrayList<Shout> getAllShouts();
    
}
