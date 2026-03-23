# 💼 Bank Management System 🚀

### Built with Java + Hibernate (JPA)

<p align="center">
  <b>A complete console-based backend system demonstrating real-world banking operations with ORM mapping and relational data handling.</b>
</p>

---

## 🌟 Project Overview

This project is a **menu-driven Bank Management System** that performs full CRUD operations and demonstrates **real-world entity relationships** using Hibernate.

It simulates how banking systems manage:

* Banks
* Branches
* Customers
* Accounts
* Loans

---

## ⚡ Features

✨ Full CRUD operations for all modules
✨ Advanced relationship mapping using JPA
✨ Smart "Show Details" feature (hierarchical data view)
✨ Menu-driven UI for better interaction
✨ Clean and modular structure

---

## 🧠 Tech Stack

| Technology         | Purpose          |
| ------------------ | ---------------- |
| Java               | Core Programming |
| Hibernate (JPA)    | ORM Mapping      |
| PostgreSQL / MySQL | Database         |
| JDBC               | DB Connectivity  |

---

## 🔗 Entity Relationship Diagram

```
Bank
  ↓ OneToMany
Branch
  ↓ OneToMany          ↓ OneToMany
Account               Loan
  ↕ ManyToMany        ↓ ManyToOne
Customer  ←────────────
```

---

---<img width="1200" height="800" alt="architecture_dark" src="https://github.com/user-attachments/assets/b4b623f8-3723-489c-a2a8-031d85c6cf71" />


## 🔄 Workflow

```
Start
  ↓
Select Module
  ↓
Choose Operation (CRUD / Show Details)
  ↓
Process via Hibernate
  ↓
Store / Fetch Data
  ↓
Display Output
  ↓
Repeat / Exit
```

---
<img width="1400" height="1000" alt="flowchart_dark" src="https://github.com/user-attachments/assets/e3332a8e-aa17-4675-9ad1-f0e17aff8f9b" />


---

## 📊 Show Details Feature

This feature dynamically fetches **dependent data**:

* Bank → Branches
* Branch → Accounts + Loans
* Account → Customers
* Customer → Accounts + Loans
* Loan → Branch + Customer

---

## 🧪 Example Output

```
Bank: SBI
Branch: Bangalore
Account: 101
Customer: Aditya
Loan: Home Loan
```

---

## 🚀 How to Run

1. Configure `persistence.xml`
2. Create database
3. Run `Driver.java`
4. Use menu to interact

---

## 💡 Key Concepts Demonstrated

✔ ORM (Object Relational Mapping)
✔ Entity Relationships (1:N, M:N)
✔ Hibernate Session Management
✔ CRUD Operations
✔ Console-based system design

---

## 🎯 Why This Project Stands Out

✔ Real-world database design
✔ Strong backend fundamentals
✔ Clean modular code
✔ Relationship-based data handling
✔ Scalable architecture


## 👨‍💻 Author

**Aditya Singhal**
Aspiring Java Backend Developer 🚀

---
