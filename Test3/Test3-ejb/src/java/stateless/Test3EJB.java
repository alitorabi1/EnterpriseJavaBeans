/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import javax.ejb.Stateless;

/**
 *
 * @author lenovo
 */
@Stateless
public class Test3EJB implements Test3EJBLocal {

    @Override
    public String getMessage() {
        return "Hello EJB World";
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
