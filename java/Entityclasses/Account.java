package hiber_nate_test;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private int accountNo;

    private String accType;
    private double balance;

    @ManyToOne
    private Branch branch;

    @ManyToMany
    private List<Customer> customers;

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}