# Web Technologies – Lab 1

Servlets, cookies, sessions, filters, listeners, JSP and MVC with **Apache Tomcat 11** (Jakarta EE).

The lab report is [`rapport/rapport.pdf`](rapport/rapport.pdf).

## Contents

| Part | Files | URL (`http://localhost:8080/lab1/...`) |
|---|---|---|
| 1.1 POST request | `FormServlet.java`, `web/index.html` | `index.html`, `FormServlet`, `Form_Servlet` |
| 1.2 Cookies | `FormServlet.java`, `ReadCookie.java`, `VisitCounter.java` | `ReadCookie`, `VisitCounter` |
| 1.3.1 Session (simple values) | `ShowSession.java` | `ShowSession` |
| 1.3.2 Session (complex values) | `ListItems.java`, `web/items.html` | `items.html` |
| 1.4.1 Filters | `LoggingFilter.java`, `SecurityFilter.java`, `LoginServlet.java`, `LogoutServlet.java`, `web/login.html` | `login.html`, `ListItems`, `LogoutServlet` |
| 1.4.2 Listeners | `ApplicationListener.java`, `ActiveSessionListener.java`, `RequestListener.java`, `SessionAttributeListener.java`, `ApplicationAttributeListener.java`, `RequestAttributeListener.java`, `AttributeTest.java` | `ShowSession`, `AttributeTest` |
| 1.4.3 Extra | `SessionUser.java` | `LoginServlet`, `LogoutServlet?remove=true` |
| 2.1 First JSPs | `web/expression.jsp`, `web/scriptlet.jsp`, `web/declaration.jsp` | same names |
| 2.2 JSP + JavaBean | `isep/lab1/bean/Person.java`, `web/form-jsp.html`, `web/bean.jsp` | `form-jsp.html` |
| 3 MVC | `lab/mvc/model/Person.java`, `lab/mvc/controller/Controller.java`, `web/mvc/index.html`, `web/mvc/old.jsp`, `web/mvc/young.jsp` | `mvc/index.html` |

## Deploy

1. Start Tomcat (`bin\startup.bat`).
2. Run `deploy.bat`: it compiles the `.java` files into `webapps/lab1/WEB-INF/classes` and copies `web/` into Tomcat.
3. Open http://localhost:8080/lab1/
