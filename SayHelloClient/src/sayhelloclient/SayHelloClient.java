/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sayhelloclient;

import java.io.FileInputStream;
import java.util.Properties;
import javax.naming.InitialContext;
import ejb.SayHelloServiceRemote;
import java.util.Scanner;
import javax.naming.NamingException;

public class SayHelloClient {

    /**
     * @param args the command line arguments
     */
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            //props.load(new FileInputStream("jndi.properties"));
            props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            InitialContext ctx = new InitialContext(props);
            SayHelloServiceRemote testEJB = (SayHelloServiceRemote) ctx.lookup("ejb.SayHelloServiceRemote");
            //
            System.out.println("What is your name?");
            String name = input.nextLine();
            System.out.println(testEJB.SayHello(name));
            
        } catch (NamingException ex) {
            ex.printStackTrace();
        }   
    }
    
}
