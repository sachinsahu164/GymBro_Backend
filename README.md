# 🏋️ GymBro Fitness App Backend API
A powerful backend service for the **Fitness App**, built using **Java and Spring Boot**.
This backend provides secure and scalable **REST APIs** for managing users, workouts, and fitness tracking data.
---

# 🚀 Features

* 🔐 User authentication & management
* 🏋️ Workout tracking APIs
* 📊 Fitness progress management
* ⚡ Fast REST API responses
* 🗄 Database integration
* 📡 Android app backend support

---

# 🛠 Tech Stack

| Technology         | Purpose                   |
| ------------------ | ------------------------- |
| Java               | Core programming language |
| Spring Boot        | Backend framework         |
| Spring Web         | REST API development      |
| Spring Data JPA    | Database operations       |
| Hibernate          | ORM framework             |
| MySQL / PostgreSQL | Database                  |
| Maven / Gradle     | Build tool                |

---

# 📂 Project Structure

```
src/main/java/com/fitnessapp

├── controller      # REST API controllers
├── service         # Business logic layer
├── repository      # Database repositories
├── model           # Entity classes
├── dto             # Data Transfer Objects
├── config          # Application configuration
└── exception       # Error handling
```

---

# ⚙️ Installation & Setup

### 1️⃣ Clone the repository

```
git clone https://github.com/yourusername/fitness-app-backend.git
```

### 2️⃣ Open project

Open the project in **IntelliJ IDEA / VS Code / Eclipse**

### 3️⃣ Configure database

Edit the `application.properties` file:

```
spring.datasource.url=jdbc:mysql://localhost:3306/fitnessdb
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
```

### 4️⃣ Run the project

Using Maven:

```
./mvnw spring-boot:run
# 📡 API Base URL

```
http://localhost:8080/api
```

---

# 📊 Example API Endpoints

| Method | Endpoint      | Description          |
| ------ | ------------- | -------------------- |
| GET    | /api/workouts | Get workout list     |
| POST   | /api/workouts | Add workout          |
| GET    | /api/users    | Get users            |
| POST   | /api/users    | Create user          |
| GET    | /api/progress | Get fitness progress |

-
# 🔗 Related Project
Android App (Frontend):
Add your Android repo link here
--
# 🤝 Contributing
Contributions are welcome!
Feel free to **fork this repository** and submit a **pull request**.
--
# 👨‍💻 Developer
Developed with ❤️ by **Sachin**
