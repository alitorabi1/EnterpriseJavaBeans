/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 *
 * @author lenovo
 */
@Singleton
public class ChatEJB implements ChatEJBRemote {

    private ArrayList<Chat> chatList;
    
    @PostConstruct
    void init() {
        chatList = new ArrayList<>();
    }

    @Override
    @Lock(LockType.READ)
    public ArrayList<Chat> getChat() {
        return chatList;
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    @Lock(LockType.WRITE)
    public void addChat(String name, String chat, String date) throws InvalidChatException {
        if ((name == null) || (name.length() < 2)) {
            throw new InvalidChatException("Name must be at least 2 characters long");
        }
        if ((chat == null) || (chat.length() < 1)) {
            throw new InvalidChatException("Shout must not be empty");
        }
        chatList.add(new Chat(name, chat, new Date()));
    }
}
