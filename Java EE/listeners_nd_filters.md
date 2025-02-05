# **Listeners & Filters in J2EE**

---

## **1. Listeners in J2EE**

### **Definition**

A **Listener** in J2EE is a special class that listens for specific events in a web application (e.g., session creation, request initialization, context changes). It allows developers to **track, manage, and respond** to lifecycle events.

### **Types of Listeners in J2EE**

J2EE provides **three main types** of listeners based on their scope:  
1️⃣ **ServletContextListener** – Listens for application startup and shutdown.  
2️⃣ **HttpSessionListener** – Tracks session creation and destruction.  
3️⃣ **ServletRequestListener** – Monitors incoming client requests.

---

### **1.1 ServletContextListener (Application-Level Listener)**

#### **Purpose:**

- Executes tasks when the application **starts or stops**.
- Used to initialize resources like **database connections, caches, loggers**.

#### **Implementation:**

```java
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyAppContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("Application Started!");
        // Initialize resources (DB connection, logging, etc.)
    }

    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("Application Stopped!");
        // Cleanup resources
    }
}
```

#### **When to Use?**

✔️ To **initialize resources** at startup (DB connection, file logging).  
✔️ To **release resources** when the application shuts down.

---

### **1.2 HttpSessionListener (Session-Level Listener)**

#### **Purpose:**

- Tracks when a **user session is created or destroyed**.
- Useful for **tracking active users, logging user sessions, or session cleanup**.

#### **Implementation:**

```java
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MySessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("Session Created: " + event.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("Session Destroyed: " + event.getSession().getId());
    }
}
```

#### **When to Use?**

✔️ To **track active users** in an application.  
✔️ To **log session start and end** for auditing purposes.

---

### **1.3 ServletRequestListener (Request-Level Listener)**

#### **Purpose:**

- Monitors when a **client request is received** and **processed**.
- Useful for **logging request details, performance monitoring, or security auditing**.

#### **Implementation:**

```java
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyRequestListener implements ServletRequestListener {
    public void requestInitialized(ServletRequestEvent event) {
        System.out.println("Request Received: " + event.getServletRequest().getRemoteAddr());
    }

    public void requestDestroyed(ServletRequestEvent event) {
        System.out.println("Request Completed!");
    }
}
```

#### **When to Use?**

✔️ To **log incoming requests** for analytics or debugging.  
✔️ To measure **request processing time**.

---

### **Other Listeners in J2EE**

| **Listener**                      | **Purpose**                                                           |
| --------------------------------- | --------------------------------------------------------------------- |
| `HttpSessionAttributeListener`    | Tracks when attributes are added, modified, or removed from sessions. |
| `ServletContextAttributeListener` | Tracks changes to application-level attributes.                       |
| `HttpSessionBindingListener`      | Tracks object binding and unbinding from sessions.                    |

---

## **2. Filters in J2EE**

### **Definition**

A **Filter** in J2EE is a component that **intercepts requests and responses** to perform common pre-processing or post-processing tasks.

**Example Use Cases:**  
✔️ Authentication and Authorization (Blocking unauthorized users).  
✔️ Logging and Auditing requests.  
✔️ Compressing responses to improve performance.

---

### **2.1 How Filters Work?**

1️⃣ A client sends an **HTTP request**.  
2️⃣ The request first passes through the **filter(s)**.  
3️⃣ The filter **modifies or processes** the request (e.g., validation, logging).  
4️⃣ The request is **forwarded** to the servlet.  
5️⃣ The servlet **processes the request** and generates a response.  
6️⃣ The response again **passes through the filter** before reaching the client.

---

### **2.2 Implementing a Filter**

#### **Example: Logging Filter**

```java
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*") // Applies filter to all requests
public class LoggingFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        System.out.println("Request Received at " + System.currentTimeMillis());
        chain.doFilter(request, response); // Continue to servlet
        System.out.println("Response Sent!");
    }

    public void init(FilterConfig config) { System.out.println("Filter Initialized!"); }
    public void destroy() { System.out.println("Filter Destroyed!"); }
}
```

**How It Works?**  
🔹 **Before the servlet is called**, the filter logs the request.  
🔹 **After the servlet processes the request**, the filter logs the response.

---

### **2.3 Common Use Cases of Filters**

| **Filter Type**           | **Purpose**                                             |
| ------------------------- | ------------------------------------------------------- |
| **Authentication Filter** | Checks if the user is logged in before allowing access. |
| **Logging Filter**        | Logs details of incoming requests and responses.        |
| **Compression Filter**    | Compresses response data for faster transmission.       |
| **Security Filter**       | Prevents XSS (Cross-Site Scripting) and SQL Injection.  |

---

### **2.4 Authentication Filter Example**

```java
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/secure/*") // Applies to all URLs under /secure/
public class AuthenticationFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            res.sendRedirect("/login.jsp"); // Redirect to login page
        } else {
            chain.doFilter(request, response); // Proceed to servlet
        }
    }
}
```

🔹 **Ensures only authenticated users can access `/secure/*` URLs**.  
🔹 **Redirects unauthenticated users to the login page**.

---

## **3. Key Differences Between Listeners & Filters**

| Feature              | **Listeners**                                                         | **Filters**                                                           |
| -------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| **Purpose**          | Listens for **events** (e.g., session creation, request destruction). | Intercepts **requests and responses** to process them.                |
| **When it Executes** | Executes **before or after** an event occurs.                         | Executes **before** or **after** a servlet processes the request.     |
| **Use Case**         | Used for **tracking**, **logging**, and **session management**.       | Used for **security**, **logging**, **modifying requests/responses**. |
| **Examples**         | `HttpSessionListener`, `ServletContextListener`                       | Authentication Filter, Logging Filter                                 |

---

## **4. Conclusion**

🔹 **Listeners** are event-driven components that track changes in **application, session, and request lifecycles**.  
🔹 **Filters** modify **incoming requests and outgoing responses**, commonly used for **security, logging, and validation**.  
🔹 Both are **powerful** in building **secure, scalable, and efficient** J2EE applications. 🚀
