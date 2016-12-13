package ejb;


import java.util.ArrayList;
import javax.ejb.Remote;

@Remote
public interface AccountServiceRemote {
    // throw exception if deposit is negative
    void makeDeposit(double amount) throws AccountAccessException; 
    // throw exception if deposit is negative or
    // there is not enough money in the account to withdraw without going below 0
    void makeWithdrawal(double amount) throws AccountAccessException;
    double getBalance();
    ArrayList<Operation> getOperationList();
}
