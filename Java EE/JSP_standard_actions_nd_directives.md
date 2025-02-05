# **JSP Standard Actions & Directives**

In **JSP (JavaServer Pages)**, **standard actions** and **directives** are essential for controlling the behavior and configuration of the page. They help manage the page's content, include external resources, handle objects, and provide dynamic functionality in web applications.

---

## **1. JSP Standard Actions**

JSP **standard actions** are tags that help interact with the server and control the behavior of JSP pages. They perform specific tasks like including other resources, forwarding requests, or creating Java objects.

### **1.1 `<jsp:include>`**

- **Purpose**: Includes the content of another JSP page or static resource into the current page.
- **Usage**: It is useful for **reusing common parts of the web page**, like headers or footers, and keeping the code modular.

**Syntax**:

```jsp
<jsp:include page="otherPage.jsp" />
```

**Example**:

```jsp
<html>
<body>
    <h1>Welcome to My Web Page</h1>
    <jsp:include page="header.jsp" />
    <p>Main content goes here.</p>
    <jsp:include page="footer.jsp" />
</body>
</html>
```

- **Explanation**: The `header.jsp` and `footer.jsp` pages are included within the main page dynamically.

### **1.2 `<jsp:forward>`**

- **Purpose**: Forwards the request to another JSP page, Servlet, or resource. The original request is **passed to the target page**.
- **Usage**: Used when you want to forward the user to a different resource without sending a response to the client until the forward is complete.

**Syntax**:

```jsp
<jsp:forward page="targetPage.jsp" />
```

**Example**:

```jsp
<jsp:forward page="success.jsp" />
```

- **Explanation**: The request is forwarded to the `success.jsp` page. The user will be shown the content of `success.jsp`.

### **1.3 `<jsp:useBean>`**

- **Purpose**: Declares and initializes a JavaBean in the JSP page. It is used to **create or access a JavaBean object** and make it available in the page's scope.
- **Usage**: Commonly used to retrieve and set properties of JavaBeans.

**Syntax**:

```jsp
<jsp:useBean id="beanName" class="com.example.BeanClass" scope="page|request|session|application" />
```

**Example**:

```jsp
<jsp:useBean id="user" class="com.example.User" scope="session" />
```

- **Explanation**: The `user` JavaBean is instantiated and made available in the **session scope**. This can be used across multiple JSP pages.

### **1.4 `<jsp:setProperty>`**

- **Purpose**: Sets a property of a JavaBean object declared by `<jsp:useBean>`.
- **Usage**: To set values to the JavaBean properties from request parameters or other data.

**Syntax**:

```jsp
<jsp:setProperty name="beanName" property="propertyName" value="value" />
```

**Example**:

```jsp
<jsp:setProperty name="user" property="name" value="John Doe" />
```

- **Explanation**: The `name` property of the `user` JavaBean is set to "John Doe".

### **1.5 `<jsp:getProperty>`**

- **Purpose**: Retrieves the value of a property from a JavaBean and displays it.
- **Usage**: Commonly used to output a property of a JavaBean in the JSP page.

**Syntax**:

```jsp
<jsp:getProperty name="beanName" property="propertyName" />
```

**Example**:

```jsp
<jsp:getProperty name="user" property="name" />
```

- **Explanation**: Displays the value of the `name` property of the `user` JavaBean.

### **1.6 `<jsp:plugin>`**

- **Purpose**: Used to embed a plugin (e.g., Java Applet or ActiveX control) within a JSP page.
- **Usage**: Typically used for embedding external software components in the web page.

**Syntax**:

```jsp
<jsp:plugin type="applet" code="AppletClass" width="300" height="300" />
```

---

## **2. JSP Directives**

**Directives** provide global information about the JSP page and control the page’s behavior, such as its content type, buffer size, error page, and more.

### **2.1 `<%@ page %>`**

- **Purpose**: Provides information and configuration for the entire JSP page.
- **Usage**: Commonly used to set page properties such as **content type**, **language**, **error pages**, and more.

**Syntax**:

```jsp
<%@ page attribute="value" %>
```

#### **Common Attributes of `<%@ page %>`**

- **language**: Specifies the programming language used (typically "java").
- **contentType**: Defines the content type for the response, e.g., `text/html; charset=UTF-8`.
- **errorPage**: Specifies an error page to display when an exception occurs.
- **isThreadSafe**: Indicates whether the JSP page should be thread-safe.

**Example**:

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" isThreadSafe="false" %>
```

- **Explanation**: The page will use Java as the language, return HTML content with UTF-8 encoding, and it is **not thread-safe**.

### **2.2 `<%@ include %>`**

- **Purpose**: Includes an external file (e.g., another JSP file or static resource) at page translation time. The included content is **merged at compile time**, not runtime.
- **Usage**: Used to include static resources (like headers, footers) or dynamic content before the page is served to the client.

**Syntax**:

```jsp
<%@ include file="header.jsp" %>
```

**Example**:

```jsp
<%@ include file="header.jsp" %>
<html>
<body>
    <h1>Welcome to My Web Page</h1>
</body>
</html>
```

- **Explanation**: The content of `header.jsp` is included at translation time, resulting in a single merged page.

### **2.3 `<%@ taglib %>`**

- **Purpose**: Declares a tag library in the JSP page. This directive is used to include **custom tags** or **standard tag libraries** (e.g., JSTL).
- **Usage**: It allows you to use tags from external libraries, such as JSTL tags, in the JSP page.

**Syntax**:

```jsp
<%@ taglib uri="uri" prefix="prefix" %>
```

**Example**:

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```

- **Explanation**: The JSTL core library is included in the page, allowing the use of tags with the prefix `c`.

### **2.4 `<%@ directive %>` for other directives**

- The **`<%@ directive %>`** can also be used to control attributes like:
  - **session**: Specifies whether the page participates in session management.
  - **buffer**: Defines the size of the output buffer.

---

## **3. Key Differences: Standard Actions vs. Directives**

| **Feature**        | **Standard Actions**                                                       | **Directives**                                                             |
| ------------------ | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- |
| **Purpose**        | Used for **dynamic behavior** like including, forwarding, and using beans. | Used for **page configuration** (language, error pages, etc.).             |
| **Execution Time** | Executed at **runtime** when the page is requested.                        | Processed at **translation/compilation time** (before the page is served). |
| **Scope**          | Affects the **dynamic content** of the page.                               | Affects the **entire page** (configuration, static settings).              |
| **Examples**       | `<jsp:include>`, `<jsp:useBean>`, `<jsp:forward>`                          | `<%@ page %>`, `<%@ include %>`, `<%@ taglib %>`                           |

---

## **4. Real-World Example: Using JSP Actions and Directives**

### **header.jsp**

```jsp
<html>
<head>
    <title>Welcome to My Website</title>
</head>
<body>
    <h1>Welcome to My Website</h1>
</body>
</html>
```

### **profile.jsp**

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" isThreadSafe="false" %>
<%@ include file="header.jsp" %>
<jsp:useBean id="user" class="com.example.User" scope="session" />
<jsp:setProperty name="user" property="name" value="John Doe" />
<h2>User Profile</h2>
<p>Name: <jsp:getProperty name="user" property="name" /></p>
</body>
</html>
```

- **Explanation**:
  - The `header.jsp` file is included via `<%@ include %>`.
  - A `User` bean is used to store user information, and its `name` property is set with `<jsp:setProperty>`. The property value is then displayed using `<jsp:getProperty>`.

---

## **Conclusion**

🔹 **Standard Actions** like `<jsp:include>`, `<jsp:forward>`, and `<jsp:useBean>` control the behavior and functionality of a JSP page.  
🔹 **Directives** such as `<%@ page %>`, `<%@ include %>`, and `<%@ taglib %>` configure the page and its environment during the translation and compilation phases.  
🔹 These tools enable the creation of dynamic, reusable, and maintainable web applications in J2EE.
