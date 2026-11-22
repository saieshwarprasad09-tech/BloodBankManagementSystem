# Blood Bank Management System
Java 21 + Maven WAR + JSP/Servlet + MySQL + Tomcat 10.1+.

Features: donor registration/login, blood-group records, demo blood availability, blood requests, donor request history, admin dashboard, admin stock updates, approve/reject requests.

## Setup
1. Extract ZIP and open this folder in IntelliJ (the folder containing `pom.xml`).
2. Let Maven import. Use Maven Reload if necessary.
3. In MySQL Workbench: File > Open SQL Script > `database/bloodbank.sql` > lightning-bolt Execute.
4. Edit `src/main/java/com/bloodbank/util/DBConnection.java` and set your MySQL password.
5. Run `DBTest.java`; expect `Database Connected Successfully!`.
6. Configure Tomcat 10.1+ in IntelliJ: Run > Edit Configurations > + > Tomcat Server > Local. Choose Tomcat folder. Deployment > + > Artifact > `blood-bank-management:war exploded`. Context `/bloodbank`.
7. Run Tomcat and open http://localhost:8080/bloodbank/
8. Register a donor, log in, view availability, submit a blood request, then check My Requests.
9. Admin: http://localhost:8080/bloodbank/admin/login.jsp ; username `admin`, password `admin123`.

Academic demo only. Inventory figures are sample values, not real-time medical information. Passwords are stored in plain text for simplicity; never use this approach in production.
