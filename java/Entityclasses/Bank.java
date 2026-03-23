package hiber_nate_test;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Bank {

    @Id
    @GeneratedValue
    private int id;

    private int code;
    private String name;
    private String address;

    @OneToMany(mappedBy = "bank")
    private List<Branch> branches;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}