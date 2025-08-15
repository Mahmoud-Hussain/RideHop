# RideHop — JavaFX Carpool (Rider-side)

RideHop is a desktop car‑pool application built with **JavaFX**. This snapshot implements the **Rider (customer) experience** (login, account, dashboard and basic ride interaction UIs). The **Driver side (publish/manage rides)** was planned but not completed in this version.



## ✨ Features (current)
- JavaFX UI with FXML views (`login`, `Dashboard`, `Account`, `About_us`).
- Module‑based project (`module application`) with Maven build.
- MySQL connector configured (basic `Database` helper for JDBC).
- Client/Server scaffolding present (`Server`, `Client`, `NetworkUtil`, `ReadThread`, `WriteThreadClient`) for future real‑time features.

## 🚧 Not implemented / Known gaps
- Driver flow (create ride, seat management, trip lifecycle).
- Proper domain model & persistence layer (tables and DAOs).
- Input validation and error handling across screens.
- Test coverage (JUnit is on the classpath but no tests provided).
- Mixed source packages (`app` and `application`) and legacy artifacts under `target/`.

---

## 🧱 Tech Stack
- **Language:** Java (module: `application`)
- **UI:** JavaFX (controls, FXML, web)
- **Build:** Maven (`javafx-maven-plugin`)
- **DB:** MySQL (JDBC)
- **JUnit 5** and **Apache Commons IO** (declared in `pom.xml`)

> `pom.xml` currently targets **Java 20** and sets `mainClass` to `com.example.project/com.example.project.HelloApplication`, which does not exist in this codebase. See the **Fix the run target** step below.

---

## 📁 Project Structure (trimmed)
```
src/main/
+ java/
  + java/app/
    - java/app/Dashboard.java
    - java/app/DataBase.java
    - java/app/Failed.java
    - java/app/login.java
    - java/app/loginController.java
    - java/app/loginController2.java
  + java/application/
    - java/application/About_us.java
    - java/application/Account.java
    - java/application/Client.java
    - java/application/Dashboard.java
    - java/application/Database.java
    - java/application/Driver_account.java
    - java/application/NetworkUtil.java
    - java/application/ReadThread.java
    - java/application/Server.java
    - java/application/WriteThreadClient.java
    - java/application/login.java
    - java/application/loginController1.java
    - java/application/loginController2.java
  - java/module-info.java
+ resources/
  + resources/Files/
  + resources/app/
    - resources/app/Dashboard.fxml
    - resources/app/Design.css
    - resources/app/Failed.fxml
    - resources/app/LoginController2.fxml
    - resources/app/loginController.fxml
  + resources/application/
    - resources/application/About_us.fxml
    - resources/application/Account.fxml
    - resources/application/Dashboard.fxml
    - resources/application/Design.css
    - resources/application/Style.css
    - resources/application/loginController1.fxml
    - resources/application/loginController2.fxml
    - resources/application/main.css
  + resources/image/
```
Key files:
- `src/main/java/application/login.java` → intended JavaFX `Application` entry point
- `src/main/java/application/Database.java` → MySQL connection helper (hard‑coded creds)
- `src/main/java/application/Server.java` and networking utilities → planned real‑time features
- `src/main/resources/application/*.fxml` → main FXML views
- `module-info.java` → `module application` (opens/exports `application` package)

---

## 🚀 Getting Started

### 1) Prerequisites
- **JDK 17+** (LTS recommended; code compiles on 20 as configured, but 17 is more stable)
- **Maven 3.8+**
- **MySQL 8+** (optional until persistence is added back)
  - If you use MySQL, create a database named `car` or update the JDBC URL.

### 2) Clone
```bash
git clone https://github.com/Mahmoud-Hussain/RideHop.git
cd RideHop
```

### 3) Configure Database (optional for UI-only exploration)
Update `src/main/java/application/Database.java` or, better, refactor to read from env vars:
```java
String url = System.getenv().getOrDefault("RIDEHOP_DB_URL", "jdbc:mysql://localhost:3306/car");
String databaseuser = System.getenv().getOrDefault("RIDEHOP_DB_USER", "root");
String databasepassword = System.getenv().getOrDefault("RIDEHOP_DB_PASS", "root123");
```
> **Security note:** The current code has hard‑coded credentials. Move them to environment variables or a config file before committing.

### 4) Fix the run target (important)
The Maven `mainClass` points to a non‑existing class. Replace it with the actual entry:
```xml
<mainClass>application/application.login</mainClass>
```
in `pom.xml` under the `javafx-maven-plugin` → `<configuration>` block.

### 5) Run
```bash
mvn clean javafx:run
```
If you use an IDE, set the run configuration to main module `application` and main class `application.login`.

---

## 🧪 Testing
JUnit 5 is declared in `pom.xml`, but there are no tests yet. Suggested next steps:
- Unit tests for `Database` and future DAO classes.
- Controller tests with TestFX for FXML flows.

---

## 🧹 Clean-up Checklist (highly recommended)
- [ ] Remove compiled outputs committed under `target/` from VCS and add `/target/` to `.gitignore`.
- [ ] Consolidate packages: keep only `application/*` (or rename to a meaningful base package like `com.ridehop.app`) and delete the duplicate `app/*` sources.
- [ ] Update `pom.xml`:
  - Set `groupId/artifactId` to `com.ridehop` / `ridehop`.
  - Align Java version to **17 LTS** (or stay on 21 LTS) in the compiler plugin.
  - Fix `mainClass` as shown above.
- [ ] Externalize DB credentials (env vars or properties).
- [ ] Add a license and a proper project description in this README.
- [ ] Add `.editorconfig` and basic style rules.

---

## 🗺️ Roadmap (suggested)
1. **Persistence layer**: introduce a simple schema (users, rides, ride_requests, vehicles).
2. **Driver flow**: create/edit rides, seat management, trip status (Scheduled → Active → Completed).
3. **Rider flow polish**: search by time window and origin/destination, booking states.
4. **Notifications**: wire up the existing client/server stubs for in‑app updates.
5. **Packaging**: use `jpackage` to create distributables.

---

## 🤝 Contributing
Pull requests are welcome. Please open an issue to discuss changes to structure, dependencies, or UI flows.

---
