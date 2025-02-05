## **Session Management in Servlets**

### **Definition of Session Management**

Session management is a technique used in web applications to maintain user-specific data **across multiple requests**. Since HTTP is a **stateless protocol**, session management helps track user interactions between different web pages or requests.

**Example Use Cases:**  
✔️ User authentication (Login/logout system)  
✔️ Shopping cart management in e-commerce applications  
✔️ Tracking user preferences and settings

---

## **Types of Session Management Techniques**

### **1. Cookies**

A **cookie** is a small piece of data stored in the user's browser by the server. It helps track user activity across multiple requests.

#### **How Cookies Work?**

1️⃣ The server sends a cookie to the client in the response header.  
2️⃣ The browser stores the cookie.  
3️⃣ The browser sends the cookie back to the server with each request.

#### **Setting a Cookie in a Servlet**

```java
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieExample extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Create a cookie
        Cookie cookie = new Cookie("username", "JohnDoe");
        cookie.setMaxAge(60 * 60 * 24); // Cookie lasts for 1 day
        response.addCookie(cookie);
        response.getWriter().println("Cookie Set Successfully!");
    }
}
```

#### **Retrieving a Cookie in a Servlet**

```java
Cookie[] cookies = request.getCookies();
if (cookies != null) {
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("username")) {
            response.getWriter().println("Welcome, " + cookie.getValue());
        }
    }
}
```

#### **Pros & Cons of Cookies**

✅ **Advantages**  
✔️ Simple to implement  
✔️ Automatically sent with each request  
✔️ Can store small amounts of data

❌ **Disadvantages**  
❌ Can be **disabled** by the user  
❌ **Security risk** (storing sensitive data in cookies is not safe)  
❌ Limited storage capacity (~4KB per cookie)

---

### **2. URL Rewriting**

URL Rewriting involves **appending session data** (Session ID) to the URL. This technique is useful when cookies are disabled.

#### **How URL Rewriting Works?**

1️⃣ The server generates a **session ID**.  
2️⃣ The session ID is appended to URLs.  
3️⃣ The client makes requests with the modified URLs, passing the session ID back to the server.

#### **Example of URL Rewriting in a Servlet**

```java
HttpSession session = request.getSession();
String url = response.encodeURL("dashboard.jsp");
response.getWriter().println("<a href='" + url + "'>Go to Dashboard</a>");
```

💡 **`encodeURL()`** automatically appends the session ID if cookies are disabled.

#### **Pros & Cons of URL Rewriting**

✅ **Advantages**  
✔️ Works even when **cookies are disabled**  
✔️ **No dependency** on client-side storage

❌ **Disadvantages**  
❌ Can lead to **long, complex URLs**  
❌ **Security risk** (Session ID is visible in the URL, making it vulnerable to session hijacking)

---

### **3. Session API (`HttpSession`)**

The **HttpSession API** provides a built-in mechanism to manage user sessions in servlets. It is the **most commonly used** session management technique in Java.

#### **How HttpSession Works?**

1️⃣ The server creates a unique session ID for each user.  
2️⃣ The session ID is stored in a **cookie (JSESSIONID)** or **URL rewriting**.  
3️⃣ The server maintains session attributes associated with the user.

#### **Creating a Session in a Servlet**

```java
HttpSession session = request.getSession();  // Create/Get a session
session.setAttribute("username", "JohnDoe"); // Store data in session
response.getWriter().println("Session Created Successfully!");
```

#### **Retrieving Data from Session**

```java
HttpSession session = request.getSession(false); // Get existing session (if any)
if (session != null) {
    String username = (String) session.getAttribute("username");
    response.getWriter().println("Welcome, " + username);
} else {
    response.getWriter().println("No active session found!");
}
```

#### **Invalidating a Session (Logout Functionality)**

```java
HttpSession session = request.getSession(false);
if (session != null) {
    session.invalidate(); // Destroys session
    response.getWriter().println("Session Terminated.");
}
```

#### **Pros & Cons of HttpSession API**

✅ **Advantages**  
✔️ **Secure** – Session ID is stored server-side  
✔️ **Automatic session tracking** with `JSESSIONID`  
✔️ **Can store large amounts of data** (unlike cookies)

❌ **Disadvantages**  
❌ Can increase **server memory usage** (Sessions are stored on the server)  
❌ **Requires proper session timeout management**

---

## **Comparison of Session Management Techniques**

| Feature                            | Cookies                  | URL Rewriting          | HttpSession                          |
| ---------------------------------- | ------------------------ | ---------------------- | ------------------------------------ |
| **Where Data is Stored?**          | Client-side (browser)    | URL parameters         | Server-side                          |
| **Works if Cookies are Disabled?** | ❌ No                    | ✅ Yes                 | ✅ Yes (if URL rewriting is enabled) |
| **Security**                       | Moderate (can be stolen) | Low (visible in URL)   | High (stored in server memory)       |
| **Data Storage Limit**             | 4KB per cookie           | No limit               | No limit (depends on server)         |
| **Best Use Case**                  | Simple user preferences  | Stateless applications | Secure session tracking              |

---

## **Real-World Example: Implementing Session-Based Login System**

### **Steps to Implement:**

1️⃣ **User logs in (store user info in HttpSession).**  
2️⃣ **User accesses multiple pages using session data.**  
3️⃣ **User logs out (session invalidated).**

### **LoginServlet.java** (Stores session data)

```java
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "1234".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("dashboard.jsp");
        } else {
            response.getWriter().println("Invalid credentials.");
        }
    }
}
```

### **DashboardServlet.java** (Retrieves session data)

```java
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            response.getWriter().println("Welcome, " + session.getAttribute("username"));
        } else {
            response.sendRedirect("login.html");
        }
    }
}
```

### **LogoutServlet.java** (Invalidates session)

```java
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("login.html");
    }
}
```

---

## **Conclusion**

🔹 **Cookies** are useful for **lightweight session tracking**, but have **security limitations**.  
🔹 **URL Rewriting** is an alternative when **cookies are disabled**, but exposes session IDs in URLs.  
🔹 **HttpSession API** is the **most secure and widely used** technique for session management.

By using **HttpSession**, you can build **secure, scalable** Java web applications efficiently! 🚀
