package ejb;

import java.io.Serializable;
import java.util.Date;

public class Chat implements Serializable{
    
    public String name;
    public String chat;
    public Date date;

    public Chat(String name, String chat, Date date) {
        this.name = name;
        this.chat = chat;
        this.date = date;
    }
    
}
