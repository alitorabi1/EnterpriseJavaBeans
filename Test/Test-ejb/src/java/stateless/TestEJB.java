/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import javax.ejb.Stateless;

/**
 *
 * @author ipd
 */
@Stateless
public class TestEJB implements TestEJBLocal {

    @Override
    public String getMessage() {
        return "Hi this is the jsp";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
