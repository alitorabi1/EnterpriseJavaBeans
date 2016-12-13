package ejb;

import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

@Singleton
public class Quiz1AccountEJB implements AccountServiceRemote {

    private ArrayList<Operation> opList;
    private double balance;

    @PostConstruct
    void init() {
        opList = new ArrayList<>();
    }

    @Override
    @Lock(LockType.WRITE)
    public void makeDeposit(double amount) throws AccountAccessException {
        if (amount <= 0) {
            throw new AccountAccessException("Please enter a positive amount.");
        }
        balance = balance + amount;
        opList.add(new Operation(amount, balance, new Date()));
    }

    @Override
    @Lock(LockType.WRITE)
    public void makeWithdrawal(double amount) throws AccountAccessException {
        if ((balance < 0) || (balance - amount < 0)) {
            throw new AccountAccessException("You can not withdraw more than your balance amount.");
        }
        balance = balance - amount;
        opList.add(new Operation(amount, balance, new Date()));
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    @Lock(LockType.READ)
    public ArrayList<Operation> getOperationList() {
        return opList;
    }

}
