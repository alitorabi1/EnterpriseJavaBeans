package ejb;

import java.io.Serializable;
import java.util.Date;

public class Operation implements Serializable {
    
    public double despositAmount;
    public double withdrawalAmount;
    public Date date;

    public Operation(double despositAmount, double withdrawalAmount, Date date) {
        this.despositAmount = despositAmount;
        this.withdrawalAmount = withdrawalAmount;
        this.date = date;
    }
  
}
