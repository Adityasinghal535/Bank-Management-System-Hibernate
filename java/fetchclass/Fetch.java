package hiber_nate_test;

import java.util.*;
import jakarta.persistence.*;

public class Fetch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();

        while (true) {

            System.out.println("\n===== FETCH MENU =====");
            System.out.println("1. Fetch Bank");
            System.out.println("2. Fetch Branch");
            System.out.println("3. Fetch Customer");
            System.out.println("4. Fetch Account");
            System.out.println("5. Fetch Loan");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Bank ID: ");
                    int bid = sc.nextInt();
                    Bank bank = em.find(Bank.class, bid);

                    if (bank != null) {

                        System.out.println("Bank: " + bank.getName());
                        System.out.println("Address: " + bank.getAddress());

                        System.out.println("1.Basic 2.Full");
                        int ch = sc.nextInt();

                        for (Branch b : bank.getBranches()) {

                            System.out.println("Branch: " + b.getName());

                            if (ch == 2) {

                                for (Account a : b.getAccounts()) {

                                    System.out.println("Account: " + a.getAccountNo());
                                    System.out.println("Type: " + a.getAccType());
                                    System.out.println("Balance: " + a.getBalance());

                                    for (Customer c : a.getCustomers()) {
                                        System.out.println("Customer: " + c.getName());
                                    }
                                }

                                for (Loan l : b.getLoans()) {

                                    System.out.println("Loan: " + l.getLoanType());
                                    System.out.println("Amount: " + l.getAmount());
                                    System.out.println("Customer: " + l.getCustomer().getName());
                                }
                            }
                        }
                    }
                    else System.out.println("Not Found");
                    break;

                case 2:
                    System.out.print("Enter Branch ID: ");
                    int brid = sc.nextInt();
                    Branch br = em.find(Branch.class, brid);

                    if (br != null) {

                        System.out.println("Branch: " + br.getName());
                        System.out.println("Bank: " + br.getBank().getName());

                        for (Account a : br.getAccounts()) {
                            System.out.println("Account: " + a.getAccountNo());
                        }

                        for (Loan l : br.getLoans()) {
                            System.out.println("Loan: " + l.getLoanType());
                        }
                    }
                    else System.out.println("Not Found");
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    int cid = sc.nextInt();
                    Customer c = em.find(Customer.class, cid);

                    if (c != null) {

                        System.out.println("Name: " + c.getName());
                        System.out.println("Phone: " + c.getPhone());

                        for (Account a : c.getAccounts()) {
                            System.out.println("Account: " + a.getAccountNo());
                        }

                        for (Loan l : c.getLoans()) {
                            System.out.println("Loan: " + l.getLoanType());
                        }
                    }
                    else System.out.println("Not Found");
                    break;

                case 4:
                    System.out.print("Enter Account No: ");
                    int aid = sc.nextInt();
                    Account a = em.find(Account.class, aid);

                    if (a != null) {

                        System.out.println("Type: " + a.getAccType());
                        System.out.println("Balance: " + a.getBalance());
                        System.out.println("Branch: " + a.getBranch().getName());

                        for (Customer cust : a.getCustomers()) {
                            System.out.println("Customer: " + cust.getName());
                        }
                    }
                    else System.out.println("Not Found");
                    break;

                case 5:
                    System.out.print("Enter Loan ID: ");
                    int lid = sc.nextInt();
                    Loan l = em.find(Loan.class, lid);

                    if (l != null) {

                        System.out.println("Type: " + l.getLoanType());
                        System.out.println("Amount: " + l.getAmount());
                        System.out.println("Branch: " + l.getBranch().getName());
                        System.out.println("Customer: " + l.getCustomer().getName());
                    }
                    else System.out.println("Not Found");
                    break;

                case 6:
                    sc.close();
                    em.close();
                    emf.close();
                    return;
            }
        }
    }
}