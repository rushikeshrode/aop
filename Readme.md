# Spring Boot Aspect-Oriented Programming (AOP) 📦
This project demonstrates how to use **Aspect-Oriented Programming (AOP)** in a Spring Boot application to log method execution using aspects.

---

## 🔧 Technologies Used

- Java 21
- Spring Boot
- Spring AOP
- Lombok

---

## ✅ Prerequisites

### 🔌 Maven Dependency (in `pom.xml`)

Make sure you have the following dependencies:

```xml
<!-- Spring AOP -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

---

### ⚙️ Enable AOP

In your main Spring Boot application class:

```java
@SpringBootApplication
@EnableAspectJAutoProxy
public class RushikeshApplication {
    public static void main(String[] args) {
        SpringApplication.run(RushikeshApplication.class, args);
    }
}
```

---

## 📁 Project Structure
```
in.rush.aop
│── configAOP
│   └── StudentAOP.java
│   └── TeacherAOP.java
├── controller
│   └── Home.java
│   └── StudentController.java
│   └── TeacherController.java
├── pojo
│   ├── Student.java
│   └── Teacher.java
├── service
│   ├── StudentService.java
│   └── TeacherService.java│
└── RushikeshApplication.java
````
---

## 💡 What This Project Shows
- How to use `@Aspect` and `@Before` in Spring AOP
- How to intercept controller method execution
- Logging method names before execution

---

## 🚀 Example AOP Code

```java
@Aspect
@Component
public class StudentAOP {

    @Before("execution(* in.rush.aop.controller.StudentController.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("StudentAOP.class :: Method called " + methodName);
    }
}
````

---

## 🧪 Sample Endpoint

```java
@GetMapping("student/all")
public ResponseEntity<?> retrieveAllStudents() {
    return ResponseEntity.ok(studentService.getStudentList());
}
```

On calling this endpoint, you'll see console output like:

```
StudentAOP.class :: Method called retrieveAllStudents
```
---
 📝 Notes (aop/AOP_Concepts.pdf)
---

## 🧠 AOP Terminology in this Project

### 1. **Aspect**

> A module/class that encapsulates cross-cutting concerns (e.g., logging, security).

📍 **In this project**:
`StudentAOP` and `TeacherAOP` are **Aspect classes** (annotated with `@Aspect`) where you write logic like logging.

---

### 2. **Advice**

> The action to take at a specific join point (e.g., log, validate, modify).

📍 **In this project**:

```java
@Before("execution(...)")
public void logBefore(JoinPoint joinPoint) { ... }
```

* This is a **`@Before` advice** — it runs *before* the method executes.
* You can also use `@After`, `@AfterReturning`, `@AfterThrowing`, `@Around`.

---

### 3. **Join Point**

> A point during execution of a program — usually a method call — where advice can be applied.

📍 **In this project**:
Every controller method (like `retrieveAllStudents()`) is a **join point**.

---

### 4. **Pointcut**

> A predicate that matches **join points** and tells Spring *where* to apply advice.

📍 **In this project**:

```java
@Before("execution(* in.rush.aop.controller.StudentController.*(..))")
```
| Part                     | Meaning                  | Explanation                                                      |
| ------------------------ | ------------------------ | ---------------------------------------------------------------- |
| `execution(...)`         | **Pointcut Designator**  | Tells AOP you're targeting method execution.                     |
| `*`                      | **Return Type Wildcard** | Match any return type (`void`, `String`, `ResponseEntity`, etc). |
| `in.rush.aop.controller` | **Package Path**         | Target package where your controller class is.                   |
| `StudentController`      | **Class Name**           | Target only the `StudentController` class.                       |
| `.*`                     | **Method Name Wildcard** | Match any method name in that class.                             |
| `(..)`                   | **Parameter Wildcard**   | Match any number of parameters of any type (0 or more).          |


* This pointcut expression matches **all methods in `StudentController`**.
* It defines the **scope of join points**.

---

### 5. **Target Object**

> The actual object (usually a Spring bean) whose method is being advised.

📍 **In this project**:

* `StudentController` is the **target** of `StudentAOP`.
* `TeacherController` would be the **target** of `TeacherAOP`.

---

### 6. **AOP Proxy**

> Spring creates a **proxy object** (dynamic subclass or interface-based proxy) to wrap the target and apply aspects.

📍 **In this project**:

* Spring wraps `StudentController` and `TeacherController` with proxy classes that execute AOP logic before calling original methods.

---

### 7. **Weaving**

> The process of applying aspects to the target class to create an advised object.

📍 **In this project**:

* At runtime, **Spring does weaving** using **proxy-based weaving** to attach your aspects to the controller methods.

---

### ✅ Summary Table:

| Term           | Code Example                                | Description                            |
| -------------- |---------------------------------------------| -------------------------------------- |
| **Aspect**     | `StudentAOP`, `TeacherAOP`                  | A class containing AOP logic           |
| **Advice**     | `@Before`, `@After` methods                 | What action to perform (e.g., logging) |
| **Join Point** | `retrieveAllStudents()`                     | Method being intercepted               |
| **Pointcut**   | `"execution(* in.rush.aop.controller...))"` | Expression matching method calls       |
| **Target**     | `StudentController`, `TeacherController`    | The bean being advised                 |
| **AOP Proxy**  | Auto-generated by Spring                    | Wraps the controller to apply advice   |
| **Weaving**    | Done by Spring at runtime                   | Linking advice with method execution   |

---
### Make sure
* `@EnableAspectJAutoProxy` is enabled in the main class.
* All dependencies managed via Spring Boot starter.
* Lombok used to reduce boilerplate code in POJOs.
---

## 📦 Run the Application

```bash
./mvnw spring-boot:run
# or
gradle bootRun
```

---

## 📄 License
This project is open-source and free to use for learning purposes.

## 👤 Author

**RUSHIKESH RODE**  
📧 Email: rushikeshrode@example.com  
💼 LinkedIn: [Rushikesh Rode](https://www.linkedin.com/in/rushikesh-rode-097572312)  
💻 GitHub: [Rushikesh Rode](https://github.com/rushikeshrode)  
🌐 Portfolio: [Rushikesh Rode](https://rushikeshrode.github.io/Rushikesh-s-Portfolio/)   
📍 Location: Pune, India
