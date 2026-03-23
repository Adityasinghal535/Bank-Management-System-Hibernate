package hiber_nate_test;

import java.util.*;
import jakarta.persistence.*;

public class Driver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();

        while (true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Bank Management");
            System.out.println("2. Branch Management");
            System.out.println("3. Customer Management");
            System.out.println("4. Account Management");
            System.out.println("5. Loan Management");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: bankMenu(sc, em); break;
                case 2: branchMenu(sc, em); break;
                case 3: customerMenu(sc, em); break;
                case 4: accountMenu(sc, em); break;
                case 5: loanMenu(sc, em); break;
                case 6:
                    sc.close();
                    em.close();
                    emf.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void bankMenu(Scanner sc, EntityManager em) {

        while (true) {

            System.out.println("\n--- BANK ---");
            System.out.println("1.Create 2.View 3.Update 4.Delete 5.Back 6.Show Details");
            int ch = sc.nextInt();

            EntityTransaction et = em.getTransaction();

            if (ch == 1) {
                sc.nextLine();
                Bank b = new Bank();
                System.out.print("Enter Name: ");
                b.setName(sc.nextLine());
                System.out.print("Enter Address: ");
                b.setAddress(sc.nextLine());
                et.begin();
                em.persist(b);
                et.commit();
                System.out.println("Created");
            }

            else if (ch == 2) {
                List<Bank> list = em.createQuery("from Bank", Bank.class).getResultList();
                for (Bank b : list)
                    System.out.println(b.getId() + " " + b.getName());
            }

            else if (ch == 3) {
                System.out.print("Enter Bank ID: ");
                int id = sc.nextInt();
                Bank b = em.find(Bank.class, id);
                if (b != null) {
                    sc.nextLine();
                    System.out.print("New Name: ");
                    b.setName(sc.nextLine());
                    et.begin();
                    et.commit();
                    System.out.println("Updated");
                } else System.out.println("Not Found");
            }

            else if (ch == 4) {
                System.out.print("Enter Bank ID: ");
                int id = sc.nextInt();
                Bank b = em.find(Bank.class, id);
                if (b != null) {
                    et.begin();
                    em.remove(b);
                    et.commit();
                    System.out.println("Deleted");
                } else System.out.println("Not Found");
            }

            else if (ch == 6) {
                System.out.print("Enter Bank ID: ");
                int id = sc.nextInt();
                Bank b = em.find(Bank.class, id);
                if (b != null) {
                    System.out.println("Bank: " + b.getName());
                    System.out.println("Address: " + b.getAddress());
                    if (b.getBranches() != null) {
                        for (Branch br : b.getBranches()) {
                            System.out.println("Branch: " + br.getBranchId() + " " + br.getName());
                        }
                    }
                } else System.out.println("Not Found");
            }

            else if (ch == 5) return;
        }
    }

    private static void branchMenu(Scanner sc, EntityManager em) {

        while (true) {

            System.out.println("\n--- BRANCH ---");
            System.out.println("1.Create 2.View 3.Update 4.Delete 5.Back 6.Show Details");
            int ch = sc.nextInt();

            EntityTransaction et = em.getTransaction();

            if (ch == 1) {
                System.out.print("Enter Bank ID: ");
                int id = sc.nextInt();
                Bank b = em.find(Bank.class, id);

                if (b != null) {
                    sc.nextLine();
                    Branch br = new Branch();
                    System.out.print("Name: ");
                    br.setName(sc.nextLine());
                    System.out.print("Address: ");
                    br.setAddress(sc.nextLine());
                    br.setBank(b);

                    et.begin();
                    em.persist(br);
                    et.commit();
                    System.out.println("Created");
                } else System.out.println("Bank Not Found");
            }

            else if (ch == 2) {
                List<Branch> list = em.createQuery("from Branch", Branch.class).getResultList();
                for (Branch b : list)
                    System.out.println(b.getBranchId() + " " + b.getName());
            }

            else if (ch == 3) {
                System.out.print("Enter Branch ID: ");
                int id = sc.nextInt();
                Branch b = em.find(Branch.class, id);
                if (b != null) {
                    sc.nextLine();
                    System.out.print("New Name: ");
                    b.setName(sc.nextLine());
                    et.begin();
                    et.commit();
                    System.out.println("Updated");
                } else System.out.println("Not Found");
            }

            else if (ch == 4) {
                System.out.print("Enter Branch ID: ");
                int id = sc.nextInt();
                Branch b = em.find(Branch.class, id);
                if (b != null) {
                    et.begin();
                    em.remove(b);
                    et.commit();
                    System.out.println("Deleted");
                } else System.out.println("Not Found");
            }

            else if (ch == 6) {
                System.out.print("Enter Branch ID: ");
                int id = sc.nextInt();
                Branch br = em.find(Branch.class, id);
                if (br != null) {
                    System.out.println("Branch: " + br.getName());
                    System.out.println("Bank: " + br.getBank().getName());
                    for (Account a : br.getAccounts())
                        System.out.println("Account: " + a.getAccountNo());
                    for (Loan l : br.getLoans())
                        System.out.println("Loan: " + l.getLoanId());
                } else System.out.println("Not Found");
            }

            else if (ch == 5) return;
        }
    }

    private static void customerMenu(Scanner sc, EntityManager em) {

        while (true) {

            System.out.println("\n--- CUSTOMER ---");
            System.out.println("1.Create 2.View 3.Update 4.Delete 5.Back 6.Show Details");
            int ch = sc.nextInt();

            EntityTransaction et = em.getTransaction();

            if (ch == 1) {
                sc.nextLine();
                Customer c = new Customer();
                System.out.print("Name: ");
                c.setName(sc.nextLine());
                System.out.print("Phone: ");
                c.setPhone(sc.nextLine());
                System.out.print("Address: ");
                c.setAddress(sc.nextLine());

                et.begin();
                em.persist(c);
                et.commit();
                System.out.println("Created");
            }

            else if (ch == 2) {
                List<Customer> list = em.createQuery("from Customer", Customer.class).getResultList();
                for (Customer c : list)
                    System.out.println(c.getCustId() + " " + c.getName());
            }

            else if (ch == 3) {
                System.out.print("Enter Customer ID: ");
                int id = sc.nextInt();
                Customer c = em.find(Customer.class, id);
                if (c != null) {
                    sc.nextLine();
                    System.out.print("New Name: ");
                    c.setName(sc.nextLine());
                    et.begin();
                    et.commit();
                    System.out.println("Updated");
                } else System.out.println("Not Found");
            }

            else if (ch == 4) {
                System.out.print("Enter Customer ID: ");
                int id = sc.nextInt();
                Customer c = em.find(Customer.class, id);
                if (c != null) {
                    et.begin();
                    em.remove(c);
                    et.commit();
                    System.out.println("Deleted");
                } else System.out.println("Not Found");
            }

            else if (ch == 6) {
                System.out.print("Enter Customer ID: ");
                int id = sc.nextInt();
                Customer c = em.find(Customer.class, id);
                if (c != null) {
                    System.out.println("Name: " + c.getName());
                    System.out.println("Phone: " + c.getPhone());
                    for (Account a : c.getAccounts())
                        System.out.println("Account: " + a.getAccountNo());
                    for (Loan l : c.getLoans())
                        System.out.println("Loan: " + l.getLoanId());
                } else System.out.println("Not Found");
            }

            else if (ch == 5) return;
        }
    }

    private static void accountMenu(Scanner sc, EntityManager em) {

        while (true) {

            System.out.println("\n--- ACCOUNT ---");
            System.out.println("1.Create 2.View 3.Update 4.Delete 5.Back 6.Show Details");
            int ch = sc.nextInt();

            EntityTransaction et = em.getTransaction();

            if (ch == 1) {
                System.out.print("Enter Branch ID: ");
                int id = sc.nextInt();
                Branch b = em.find(Branch.class, id);

                if (b != null) {
                    sc.nextLine();
                    Account a = new Account();
                    System.out.print("Type: ");
                    a.setAccType(sc.nextLine());
                    System.out.print("Balance: ");
                    a.setBalance(sc.nextDouble());
                    a.setBranch(b);

                    et.begin();
                    em.persist(a);
                    et.commit();
                    System.out.println("Created");
                } else System.out.println("Branch Not Found");
            }

            else if (ch == 2) {
                List<Account> list = em.createQuery("from Account", Account.class).getResultList();
                for (Account a : list)
                    System.out.println(a.getAccountNo() + " " + a.getAccType());
            }

            else if (ch == 3) {
                System.out.print("Enter Account ID: ");
                int id = sc.nextInt();
                Account a = em.find(Account.class, id);
                if (a != null) {
                    System.out.print("New Balance: ");
                    a.setBalance(sc.nextDouble());
                    et.begin();
                    et.commit();
                    System.out.println("Updated");
                } else System.out.println("Not Found");
            }

            else if (ch == 4) {
                System.out.print("Enter Account ID: ");
                int id = sc.nextInt();
                Account a = em.find(Account.class, id);
                if (a != null) {
                    et.begin();
                    em.remove(a);
                    et.commit();
                    System.out.println("Deleted");
                } else System.out.println("Not Found");
            }

            else if (ch == 6) {
                System.out.print("Enter Account ID: ");
                int id = sc.nextInt();
                Account a = em.find(Account.class, id);
                if (a != null) {
                    System.out.println("Type: " + a.getAccType());
                    System.out.println("Balance: " + a.getBalance());
                    System.out.println("Branch: " + a.getBranch().getName());
                    for (Customer c : a.getCustomers())
                        System.out.println("Customer: " + c.getName());
                } else System.out.println("Not Found");
            }

            else if (ch == 5) return;
        }
    }

    private static void loanMenu(Scanner sc, EntityManager em) {

        while (true) {

            System.out.println("\n--- LOAN ---");
            System.out.println("1.Create 2.View 3.Update 4.Delete 5.Back 6.Show Details");
            int ch = sc.nextInt();

            EntityTransaction et = em.getTransaction();

            if (ch == 1) {
                System.out.print("Enter Branch ID: ");
                int bid = sc.nextInt();
                System.out.print("Enter Customer ID: ");
                int cid = sc.nextInt();

                Branch b = em.find(Branch.class, bid);
                Customer c = em.find(Customer.class, cid);

                if (b != null && c != null) {
                    sc.nextLine();
                    Loan l = new Loan();
                    System.out.print("Type: ");
                    l.setLoanType(sc.nextLine());
                    System.out.print("Amount: ");
                    l.setAmount(sc.nextDouble());
                    l.setBranch(b);
                    l.setCustomer(c);

                    et.begin();
                    em.persist(l);
                    et.commit();
                    System.out.println("Created");
                } else System.out.println("Invalid IDs");
            }

            else if (ch == 2) {
                List<Loan> list = em.createQuery("from Loan", Loan.class).getResultList();
                for (Loan l : list)
                    System.out.println(l.getLoanId() + " " + l.getLoanType());
            }

            else if (ch == 3) {
                System.out.print("Enter Loan ID: ");
                int id = sc.nextInt();
                Loan l = em.find(Loan.class, id);
                if (l != null) {
                    System.out.print("New Amount: ");
                    l.setAmount(sc.nextDouble());
                    et.begin();
                    et.commit();
                    System.out.println("Updated");
                } else System.out.println("Not Found");
            }

            else if (ch == 4) {
                System.out.print("Enter Loan ID: ");
                int id = sc.nextInt();
                Loan l = em.find(Loan.class, id);
                if (l != null) {
                    et.begin();
                    em.remove(l);
                    et.commit();
                    System.out.println("Deleted");
                } else System.out.println("Not Found");
            }

            else if (ch == 6) {
                System.out.print("Enter Loan ID: ");
                int id = sc.nextInt();
                Loan l = em.find(Loan.class, id);
                if (l != null) {
                    System.out.println("Type: " + l.getLoanType());
                    System.out.println("Amount: " + l.getAmount());
                    System.out.println("Branch: " + l.getBranch().getName());
                    System.out.println("Customer: " + l.getCustomer().getName());
                } else System.out.println("Not Found");
            }

            else if (ch == 5) return;
        }
    }
}