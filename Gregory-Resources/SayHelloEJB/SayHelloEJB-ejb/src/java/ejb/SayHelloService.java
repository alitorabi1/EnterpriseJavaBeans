package ejb;

import javax.ejb.Stateless;

@Stateless
public class SayHelloService implements SayHelloServiceRemote {

    @Override
    public String sayHello(String name) {
        return String.format("Hi %s, nice to meet you!", name);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
