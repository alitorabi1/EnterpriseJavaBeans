
package ejb;

import javax.ejb.Stateless;

@Stateless
public class HelloService implements HelloServiceRemote {

    @Override
    public String sayHello(String name) {
        {
            return String.format("Hello %s, nice to meet you!", name);
        }
    }
}
