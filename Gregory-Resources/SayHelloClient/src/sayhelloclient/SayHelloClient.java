package sayhelloclient;

import ejb.SayHelloServiceRemote;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class SayHelloClient {

    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            // props.load(new FileInputStream("jndi.properties"));
            props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            InitialContext ctx = new InitialContext(props);
            SayHelloServiceRemote testEJB = (SayHelloServiceRemote) ctx.lookup("ejb.SayHelloServiceRemote");
            //
            System.out.println("What is your name?");
            String name = input.nextLine();
            System.out.println(testEJB.sayHello(name));
            //
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }
    
}
