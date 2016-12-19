package helloejbclient;

import java.io.FileInputStream;
import java.util.Properties;
import javax.naming.InitialContext;
import ejb.HelloServiceRemote;
import java.io.IOException;
import java.util.Scanner;
import javax.naming.NamingException;

public class HelloEJBClient {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("jndi.properties"));
            InitialContext ctx = new InitialContext(props);
            HelloServiceRemote testEJB = (HelloServiceRemote) ctx.lookup("ejb.HelloServiceRemote");
            System.out.println("What is your name?");
            String name = input.nextLine();
            System.out.println(testEJB.sayHello(name));
        } catch (NamingException | IOException ex) {
            ex.printStackTrace();
        }
    }

}
