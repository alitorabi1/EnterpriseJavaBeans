/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author lenovo
 */
@Remote
public interface ChatEJBRemote {

    ArrayList<Chat> getChat();

    void addChat(String name, String chat, String date) throws InvalidChatException;
    
}
