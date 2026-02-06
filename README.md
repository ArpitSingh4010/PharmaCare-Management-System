# PharmaCare Management System

> **A comprehensive enterprise-level pharmacy management system built with JSP, Servlets, and MySQL for managing drug inventory, customer orders, and vendor operations.**

[![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=java&logoColor=white)](https://www.java.com/)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![JSP](https://img.shields.io/badge/JSP-007396?style=flat&logo=java&logoColor=white)](https://www.oracle.com/java/technologies/jspt.html)
[![Apache Tomcat](https://img.shields.io/badge/Apache%20Tomcat-F8DC75?style=flat&logo=apache-tomcat&logoColor=black)](http://tomcat.apache.org/)

---

## 📋 Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [System Requirements](#system-requirements)
- [Database Setup](#database-setup)
- [Installation & Configuration](#installation--configuration)
- [Project Structure](#project-structure)
- [Usage](#usage)
- [User Roles](#user-roles)
- [Security Notes](#security-notes)
- [Troubleshooting](#troubleshooting)

---

## 🎯 Project Overview

**PharmaCare Management System** is a full-stack web application designed to streamline pharmacy operations through automated inventory management, secure order processing, and role-based access control.

### 💼 Resume-Ready Description
```
PharmaCare Management System | Full-Stack Web Application
Technologies: JSP, Java Servlets, MySQL 8.0, Apache Tomcat, JDBC, HTML5/CSS3

• Developed enterprise-level pharmacy management system with dual portals for 
  customers and vendors
• Implemented automated inventory tracking using MySQL triggers, eliminating 
  manual stock updates
• Built secure authentication with role-based access control, session management, 
  and input validation
• Designed normalized database schema with 5 tables, foreign key constraints, 
  and automated business logic
• Applied MVC architecture with PreparedStatements for SQL injection prevention
```

**📄 Full resume descriptions available in:** [RESUME_DESCRIPTION.md](RESUME_DESCRIPTION.md)

### 🎓 Perfect for Portfolio & Resume
This project demonstrates:
- ✅ Full-stack development (Frontend + Backend + Database)
- ✅ Enterprise application architecture
- ✅ Security best practices
- ✅ Database design & automation
- ✅ Professional code organization

---

## ✨ Features

### Customer Features
- User registration and login
- Browse available medicines with details (manufacturer, price, stock, expiry date)
- Place orders for medicines
- View order history
- User profile management

### Vendor/Seller Features
- Vendor registration and login
- Add new products to the catalog
- Manage inventory (add stock, update quantities)
- View seller-specific orders
- Track product sales

### System Features
- Automatic inventory management using database triggers
- Real-time stock updates upon order placement
- Session management for user authentication
- Responsive UI with custom CSS styling
- Input validation and error handling

## 🛠️ Technologies Used

- **Frontend**: HTML5, CSS3, JSP
- **Backend**: Java Servlets, JSP
- **Database**: MySQL 8.0+
- **Server**: Apache Tomcat 9.0+
- **Build Tool**: Apache Ant (build.xml)
- **JDBC Driver**: MySQL Connector/J 8.0+

## 💻 System Requirements

- **Java Development Kit (JDK)**: 8 or higher
- **Apache Tomcat**: 9.0 or higher
- **MySQL Server**: 8.0 or higher
- **Web Browser**: Chrome, Firefox, Edge, or Safari (latest versions)
- **Memory**: Minimum 2GB RAM
- **Disk Space**: At least 500MB free space

## 🗄️ Database Setup

### Step 1: Create Database
1. Open MySQL command line or MySQL Workbench
2. Run the SQL script provided in `drugdatabase.sql`:

```bash
mysql -u root -p < drugdatabase.sql
```

Or manually execute the script in MySQL Workbench.

### Step 2: Database Configuration
The database includes:
- **5 Tables**: customer, seller, product, inventory, orders
- **2 Triggers**: 
  - `updatetime` - Automatically sets order timestamp
  - `inventorytrigger` - Automatically updates inventory on order placement
- **Foreign Key Constraints**: Ensures data integrity

### Step 3: Update Database Credentials
If your MySQL credentials differ, update the connection strings in all JSP files:

**Current credentials:**
- Host: `localhost:3306`
- Database: `drugdatabase`
- Username: `root`
- Password: `1234`

**Update in:** All `.jsp` files in the `WebContent` directory.

## 🚀 Installation & Configuration

### 1. Clone or Download the Project
```bash
cd "c:\Users\Ayush Singh\Downloads\Pharmacy-Drug-Management-System"
```

### 2. Import MySQL Connector JAR
Download MySQL Connector/J 8.0+ and place it in:
```
WebContent/WEB-INF/lib/
```

Download link: https://dev.mysql.com/downloads/connector/j/

### 3. Configure Apache Tomcat
1. Install Apache Tomcat 9.0+
2. Copy the project folder to Tomcat's `webapps` directory or configure as a web application
3. Update `context.xml` if needed (located in `WebContent/META-INF/`)

### 4. Build the Project (Optional)
If using Apache Ant:
```bash
ant build
```

### 5. Deploy to Tomcat
1. Start Tomcat server
2. Access the application at: `http://localhost:8080/Pharmacy-Drug-Management-System/Index.html`

## 📁 Project Structure

```
PharmaCare-Management-System/
├── WebContent/                  # Main web application directory
│   ├── *.jsp                   # JavaServer Pages
│   ├── *.html                  # Static HTML pages
│   ├── SessionCheck.jsp        # Session validation include
│   ├── css/                    # Stylesheets
│   │   ├── Index.css
│   │   ├── Login.css
│   │   ├── Register.css
│   │   ├── Homepage.css
│   │   ├── Buy.css
│   │   ├── Orders.css
│   │   └── AddProduct.css
│   ├── images/                 # Image assets
│   ├── META-INF/
│   │   └── context.xml         # Context configuration
│   └── WEB-INF/
│       ├── classes/
│       │   └── SecurityUtil.java  # Security utility class
│       └── lib/                # JAR dependencies
├── build/                      # Compiled output
├── Screenshots/                # Application screenshots
├── drugdatabase.sql           # Database creation script
├── SQL.txt                    # SQL reference
├── build.xml                  # Ant build configuration
├── README.md                  # This file
├── SECURITY_TESTING.md        # Security testing guide
└── SECURITY_QUICK_REFERENCE.md # Security implementation guide
```

## 📖 Usage

### First Time Setup
1. Start MySQL server
2. Import `drugdatabase.sql` to create the database
3. Compile SecurityUtil.java:
   ```bash
   cd WebContent/WEB-INF/classes
   javac SecurityUtil.java
   ```
4. Start Tomcat server
5. Navigate to `http://localhost:8080/PharmaCare-Management-System/Index.html`

### Customer Workflow
1. **Register**: Click "Register As Customer" and fill in details
2. **Login**: Use your credentials to log in
3. **Browse**: Navigate to "BUY" to see available medicines
4. **Order**: Enter quantity and click "Buy"
5. **Track**: View your orders in the "ORDERS" section

### Vendor Workflow
1. **Register**: Click "Register As Vendor" and fill in details
2. **Login**: Use your credentials to log in
3. **Add Products**: Add new medicines to the catalog
4. **Manage Inventory**: Update stock quantities
5. **View Orders**: Track orders for your products

## 👥 User Roles

### Customer
- **Registration Page**: `Register.html`
- **Login**: `Login.html` (User Type: Customer)
- **Homepage**: `Homepage.jsp`
- **Key Pages**: Buy.jsp, Orders.jsp

### Vendor/Seller
- **Registration Page**: `SellerRegister.html`
- **Login**: `Login.html` (User Type: Vendor)
- **Homepage**: `SellerHomepage.jsp`
- **Key Pages**: AddProduct.jsp, AddInventory.jsp, SellerOrders.jsp

## 🔒 Security Features

### ✅ Implemented Security Measures (v1.2)

#### Session Management
- **Session validation** on all protected pages
- **Automatic session timeout** (30 minutes)
- **Redirect to login** for unauthorized access
- Protected pages: Homepage, Buy, Orders, SellerHomepage, and seller functions

#### Input Validation & Sanitization
Created **SecurityUtil.java** utility class with comprehensive security functions:
- ✅ Email format validation
- ✅ Password strength checking (minimum 8 chars, letters + numbers)
- ✅ Alphanumeric validation for user IDs
- ✅ Phone number validation
- ✅ XSS prevention (HTML sanitization)
- ✅ SQL injection prevention helpers
- ✅ String length validation

#### Database Security
- ✅ All queries use **PreparedStatements** (SQL injection protected)
- ✅ Updated to modern MySQL JDBC driver (8.0+)
- ✅ Foreign key constraints for data integrity
- ✅ Database triggers for automatic inventory management

### 📋 Security Implementation Guide
See [SECURITY_QUICK_REFERENCE.md](SECURITY_QUICK_REFERENCE.md) for:
- Ready-to-use security methods
- Implementation examples
- Security checklist
- Best practices

### ⚠️ Recommended Improvements for Production

**High Priority:**
1. **Password Hashing**: Implement password hashing in registration/login
   - SecurityUtil.hashPassword() ready to use
   - Replace plain text password storage
2. **Environment Variables**: Move database credentials to config files
3. **HTTPS**: Enable SSL/TLS for encrypted communication
4. **Error Handling**: Remove stack traces from user-facing pages

**Medium Priority:**
5. **Connection Pooling**: Use JNDI DataSource instead of direct connections
6. **CSRF Protection**: Implement CSRF tokens for state-changing operations
7. **Rate Limiting**: Add brute force protection on login
8. **Security Headers**: Configure X-Frame-Options, CSP, etc.

**Low Priority:**
9. **Input Sanitization**: Apply SecurityUtil validation to all forms
10. **Audit Logging**: Track security-relevant events
11. **Role-Based Access Control**: Enhance authorization mechanisms

## 🐛 Troubleshooting

### Database Connection Error
**Error**: `Communications link failure`
**Solution**: 
- Verify MySQL is running
- Check database credentials in JSP files
- Ensure MySQL Connector JAR is in `WEB-INF/lib/`
- Update connection string to include timezone parameter (already added):
  ```java
  jdbc:mysql://localhost:3306/drugdatabase?useSSL=false&serverTimezone=UTC
  ```

### Class Not Found Exception
**Error**: `java.lang.ClassNotFoundException: com.mysql.cj.jdbc.Driver`
**Solution**: 
- Download MySQL Connector/J 8.0+
- Place `mysql-connector-java-8.x.x.jar` in `WebContent/WEB-INF/lib/`

### Login Failed
**Error**: Redirected to `LoginError1.html` or `LoginError2.html`
**Solution**:
- **LoginError1.html**: Incorrect password
- **LoginError2.html**: User ID not found - Register first

### Registration Error
**Error**: Redirected to `RegisterError1.html` or `RegisterError2.html`
**Solution**:
- **RegisterError1.html**: User ID already exists
- **RegisterError2.html**: Passwords don't match

### Inventory Not Updating
**Solution**:
- Check that the `inventorytrigger` exists in MySQL
- Verify trigger is active: `SHOW TRIGGERS;`
- Ensure orders table is inserting records correctly

### Build Errors
**Solution**:
- Ensure JDK is properly installed
- Verify `JAVA_HOME` environment variable is set
- Check Tomcat configuration

## 📝 Database Schema

### Tables

#### customer
- `uid` (PK): User ID
- `pass`: Password (⚠️ Plain text - consider hashing)
- `fname`, `lname`: Name
- `email`: Email address
- `address`: Address
- `phno`: Phone number

#### seller
- `sid` (PK): Seller ID
- `sname`: Seller name
- `pass`: Password (⚠️ Plain text - consider hashing)
- `address`: Address
- `phno`: Phone number

#### product
- `pid` (PK): Product ID
- `pname` (UNIQUE): Product name
- `manufacturer`: Manufacturer name
- `mfg`: Manufacturing date
- `exp`: Expiry date
- `price`: Price

#### inventory
- `pid, sid` (Composite PK): Product and Seller IDs
- `pname`: Product name
- `quantity`: Available quantity

#### orders
- `oid` (PK, AUTO_INCREMENT): Order ID
- `pid`: Product ID (FK)
- `sid`: Seller ID (FK)
- `uid`: Customer ID (FK)
- `orderdatetime`: Timestamp
- `quantity`: Ordered quantity
- `price`: Total price

## 🔄 Recent Updates

### Version 1.2 - Security Enhancements (Feb 2026)
1. **Added Session Security**: Protected pages now validate user sessions with 30-min timeout
2. **Created Security Utilities**: New SecurityUtil.java class for input validation & sanitization
3. **Security Documentation**: Comprehensive guides for implementation and testing

### Version 1.1 - Critical Bug Fixes
1. **Fixed Critical Trigger Bug**: Updated `inventorytrigger` to use `NEW.pid` and `NEW.quantity` instead of querying the orders table, eliminating race conditions
2. **Updated JDBC Driver**: Migrated from deprecated `com.mysql.jdbc.Driver` to `com.mysql.cj.jdbc.Driver`
3. **Added Connection Parameters**: Included `useSSL=false&serverTimezone=UTC` to prevent timezone warnings
4. **Improved Inventory Management**: Trigger now properly matches both `pid` and `sid` for accurate inventory updates

## 📧 Support

For issues or questions:
1. Check the troubleshooting section
2. Review MySQL and Tomcat logs
3. Verify all prerequisites are installed correctly

## �‍💻 Project Information

**Project Name:** PharmaCare Management System  
**Type:** Full-Stack Web Application  
**Technologies:** JSP, Servlets, MySQL, Java, HTML5, CSS3  
**Architecture:** MVC Pattern with Three-Tier Architecture  

### Key Features for Resume:
- Secure user authentication with role-based access (Customer/Vendor)
- Automated inventory management using database triggers
- Real-time order processing and tracking
- Input validation and XSS protection
- Session management with timeout
- Responsive UI design

## 📄 License

This project is for educational and portfolio purposes. 

## 🙏 Acknowledgments

- Database design follows industry-standard pharmacy management practices
- UI styling uses modern CSS3 features
- Built with Java EE technologies and best practices

---

**PharmaCare Management System** - A professional pharmacy management solution

