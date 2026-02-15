#  Hospital Management System (Java + JDBC)

A **console-based Hospital Management System** developed using **Core Java**, **JDBC**, and **MySQL**.
This project demonstrates Object-Oriented Programming (OOP) concepts along with database connectivity to manage patients, doctors, and appointments efficiently.

---

##  Project Overview

The Hospital Management System allows users to:

* Add new patients
* Add doctors with specialization
* Schedule appointments
* View stored patients, doctors, and appointments
* Persist data using MySQL database

This project is ideal for beginners learning:

* Java OOP concepts
* JDBC connectivity
* Database CRUD operations
* Layered project structure

---

##  Features

- Add Patient details
- Add Doctor details
- Schedule Appointment
- View Patients List
- View Doctors List
- View Appointments
- MySQL Database Integration
- Auto-generated database IDs

---

##  Tech Stack

| Technology    | Usage                        |
| ------------- | ---------------------------- |
| Java          | Core Programming             |
| JDBC          | Database Connectivity        |
| MySQL         | Database Management          |
| OOP Concepts  | Class Design & Relationships |
| Java Time API | Appointment Date Handling    |

---

##  Project Structure

```
HospitalManagementSystem
│
├── db
│   └── DBConnection.java        # Database connection setup
│
├── management
│   ├── Patient.java             # Patient entity & DB operations
│   ├── Doctor.java              # Doctor entity & DB operations
│   └── Appointment.java         # Appointment handling
│
├── Execution
│   └── HospitalManagement.java  # Main application (Menu-driven system)
│
└── README.md
```

---

##  Database Setup

### 1️ Create Database

```sql
CREATE DATABASE hospitaldb;
USE hospitaldb;
```

---

### 2️ Create Tables

#### Patients Table

```sql
CREATE TABLE Patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    gender VARCHAR(10),
    age INT
);
```

#### Doctors Table

```sql
CREATE TABLE Doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    speciality VARCHAR(100)
);
```

#### Appointments Table

```sql
CREATE TABLE Appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    FOREIGN KEY (patient_id) REFERENCES Patients(id),
    FOREIGN KEY (doctor_id) REFERENCES Doctors(id)
);
```

---

##  Database Configuration

Update database credentials inside:

```
db/DBConnection.java
```

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/hospitaldb",
    "root",
    "YOUR_PASSWORD"
);
```

---

##  How to Run the Project

### Step 1: Clone Repository

```bash
git clone https://github.com/your-username/Hospital-Management-System.git
```

### Step 2: Open in IDE

Open project using:

* Eclipse
* IntelliJ IDEA
* VS Code (Java Extensions)

---

### Step 3: Add MySQL Connector

Download MySQL JDBC Driver:

👉 [https://dev.mysql.com/downloads/connector/j/](https://dev.mysql.com/downloads/connector/j/)

Add the `.jar` file to project build path.

---

### Step 4: Run Application

Run:

```
Execution → HospitalManagement.java
```

---

##  Application Menu

```
++++++++++++ HOSPITAL MANAGEMENT SYSTEM ++++++++++++

1. Add Patient
2. Add Doctor
3. Schedule Appointment
4. View Patients
5. View Doctors
6. View Appointment
0. Exit
```

---

##  Concepts Used

* Classes & Objects
* Encapsulation
* Constructor Usage
* Method Overriding (`toString()`)
* JDBC PreparedStatement
* Auto-generated Keys
* ArrayList Collection
* Exception Handling

---

##  Sample Workflow

1️⃣ Add Patient
2️⃣ Add Doctor
3️⃣ Schedule Appointment
4️⃣ View Records

All records are stored permanently in MySQL database.

---

##  Future Improvements

* GUI using Java Swing / JavaFX
* Update & Delete operations
* Search functionality
* Login Authentication System
* Appointment conflict checking
* REST API using Spring Boot

---

##  Author

**Radhika Malpani**

* Java Developer


---

##  Support

If you like this project:

 - Star the repository
 - Fork it
 - Contribute improvements
