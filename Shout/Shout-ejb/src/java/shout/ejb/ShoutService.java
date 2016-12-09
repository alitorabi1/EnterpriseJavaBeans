package shout.ejb;

import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

@Singleton
public class ShoutService implements ShoutServiceRemote {

    private ArrayList<Shout> shoutList;
    
    @PostConstruct
    void init() {
        shoutList = new ArrayList<>();
    }
    
    @Override
    @Lock(LockType.WRITE)
    public void addShout(String name, String shout) throws InvalidShoutDataException {
        if ((name == null) || (name.length() < 2)) {
            throw new InvalidShoutDataException("Name must be at least two characters long.");
        }
        if ((shout == null) || (shout.length() < 1)) {
            throw new InvalidShoutDataException("Shout must not be empty.");
        }
        shoutList.add(new Shout(name, shout, new Date()));
    }

    @Override
    @Lock(LockType.READ)
    public ArrayList<Shout> getAllShouts() {
        // FIXME: should clone list and list elements (add clonable to shout)
        return shoutList;
    }

    
}
