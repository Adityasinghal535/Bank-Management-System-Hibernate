package hiber_nate_test;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Branch {

    @Id
    @GeneratedValue
    private int branchId;

    private String name;
    private String address;

    @ManyToOne
    private Bank bank;

    @OneToMany(mappedBy = "branch")
    private List<Account> accounts;

    @OneToMany(mappedBy = "branch")
    private List<Loan> loans;

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
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