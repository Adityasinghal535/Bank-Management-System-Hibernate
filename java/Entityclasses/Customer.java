package hiber_nate_test;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int custId;

    private String name;
    private String phone;
    private String address;

    @ManyToMany(mappedBy = "customers")
    private List<Account> accounts;

    @OneToMany(mappedBy = "customer")
    private List<Loan> loans;

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}