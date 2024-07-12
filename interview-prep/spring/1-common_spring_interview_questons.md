1. What is Spring Framework?
Spring Framework is an open source application framework. We can also say that it is a lightweight inversion of control(IoC) container and aspect-oriented container framework for the Java platform. Spring handles the infrastructure so that we can focus on our application development. It was created by Rod Johnson. In 2003 Spring came into existence.

2. What is an application framework?
An application framework is a software library that provides a fundamental structure to support the development of applications for a specific environment. An application framework acts as the skeletal support to build an application. The intention of designing application frameworks is to lessen the general issues faced during the development of applications.

3. How is Spring lightweight?
Spring is considered lightweight compared to traditional Java EE applications. If we want to run a Java EE application, we can't just create a small application that will run on its own. We shall need a Java EE application server to run our application such as Glassfish, Wildfly, WebLogic, Websphere etc. Most application servers are big and complex pieces of software, that are not trivial to install or configure. Hence If we use Spring then we won't need such things.

Secondly, Spring provides various modules for different purposes. These modules are grouped into Core Container, Data Access/Integration, Web, AOP (Aspect Oriented Programming), Instrumentation, Messaging, and Test. To use one or part of the module we don't need to inject all the modules. For example, we can use Spring JDBC without Spring Web.

4. What is Inversion of Control (IoC)?
Inversion of Control is a principle in Software Engineering by which the control of objects or portions of a program is transferred to a container or framework.

For example, say our application has a text editor component and we want to provide spell checking. Our standard code would look something like this:
```java
public class TextEditor {
    private SpellChecker checker = new SpellChecker();
}
```
Here TextEditor needs a SpellChecker object. Means TextEditor is dependent on SpellChecker and we are manually instantiating the TextEditor object. Means we are managing the dependency. Means we have the control. Now look at the below code:
```java
public class TextEditor {
   private SpellChecker checker;

   public TextEditor(SpellChecker checker) {
       this.checker = checker;
   }
}
```
Here we are asking the Spring to instantiate the SpellChecker object and pass in the constructor of TextEditor i.e. Constructor Injection. Means Spring is managing the dependency. Now the control is transferred from Programmer to Spring. This is nothing but Inversion of Control.

5. What is an aspect-oriented container framework?
In computing, aspect-oriented programming (AOP) is a programming paradigm that aims to increase modularity by allowing the separation of cross-cutting concerns. In simple words we can say that it is a methodology which will separate cross-cutting concerns from core concerns. For example, if writing an application for handling medical records, the indexing of such records is a core concern, while logging a history of changes to the record database or user database, or an authentication system, would be cross-cutting concerns.

**Core concern:** The logic that seems to be mandatory and without having that logic the existence of our application will not be there, such kind of logic is considered as core concern. Ex: writing business logic, fetching data from database/external API etc.

**Cross-Cutting concern:** The program logic which is common across the application and the presence/absence of that logic does not impact core business functionality but if we apply the cross-cutting logic then it affects multiple points of an application is nothing but cross-cutting logic. Ex: Logging, Caching, Transaction processing, Security etc.

7. What are the features of Spring Framework?
**Versatile**: Spring can be called as a framework of frameworks because it provides support to various other frameworks such as Struts, Hibernate, Tapestry, EJB, JSF etc. If we want to use Spring in the existing application we can use it without removing the existing technology and don't need to rewrite the code for existing functionality that is nothing but Versatile application development.

Prior to Spring, Struts was so popular in the market. Almost every company was using the Struts. Now Spring says let the existing investments(code/technology) be in the same way. We don't demand you to modify any of your existing investments. In addition to the existing investments you have, start adding the Spring framework into your project. Spring is versatile & flexible in such a way, it can dissolve into your existing project and can make your project more richer, much better & much stronger than earlier one.

**Non-Invasive:** We don't need to extend/implement any Spring provided class/interface to our classes. So whenever we want we can change Spring framework to any other framework. In this case no need to change the logic of our classes.

**Lightweight**: Actually Spring is a vast framework but Spring people divided the whole framework into different modules. They are designed in such a way that no module is dependent on other modules except the Spring Core module. Hence according to our requirement we can learn/use a particular module. We don't need to learn the whole framework to use the part of it. Example: We can use Spring ORM module without Spring Web module.

**Dependency Injection**: The process of injecting the target object into the dependent object is nothing but dependency injection. Let's take an example: There is an Employee class. It requires an Address object. Means Employee class is dependent on Address class. Hence Employee class becomes the dependent object and the Address class becomes the target object.

```java
@Component
class Employee {
  private int id;
  private String name;
  private Address address;

  Employee() {
    id = 10;
    name="David";
    address = new Address();
  }
}
```
```java
@Component
class Address {
  private String street;
  private String city;

  Address() {
    street="Wall Street";
    city="New York";
  }
}
```
In the above code, Spring is creating both the objects(Employee & Address) and injecting the address object into Employee class constructor.

There are 3 types of Dependency Injection:

**Constructor Injection**: Dependencies are provided as constructor parameters. Ex: Spring, Pico container etc
**Setter Injection**: Dependencies are assigned through setter methods. Ex: Spring
**Field Injection**: Dependencies are assigned directly through the variables. Ex: Spring
**Interface Injection**: Injection is done through an interface. Ex: Avalon, but Avalon has been closed now
Note: Spring supports only Constructor and Setter Injection.

**IoC Container**: Spring has provided a container which is responsible for collaborating objects & managing the lifecycle of objects. There are two ways for collaborating objects.

a. Dependency Pulling

- Dependency Lookup
- Contextual Dependency Lookup

b. Dependency Injection
- Setter Injection
- Constructor Injection


**AOP: Aspect-Oriented Programming(AOP)** is used for separating cross-cutting concerns (logging, caching, security, etc) from the business logic of the application. For more info Read this...

**MVC Framework**: Used to create web applications or RESTful web services, capable of returning responses in different formats like json,xml etc.

**Transaction Management**: Spring framework provides a generic Transaction Management layer which can be used with or without J2EE(JEE) environment. It provides an interface that can scale down to a local transaction and scale up to global transactions (using JTA).

**Secure**: Spring has provided a separate module for securing the application. Spring Security is a Java SE/Java EE security framework to provide Authentication, Authorization, SSO and other Security features for Web Applications or Enterprise Applications. Spring Security supports the various types of security such as :

- Authentication and Authorization.
- BASIC,Digest and Form-Based Authentication.
- LDAP Authentication.
- OpenID Authentication.
- SSO (Single Sign-On) Implementation.
- Cross-Site Request Forgery (CSRF) Implementation.
- "Remember-Me" Feature through HTTP Cookies.
- Implementation of ACLs.
- "Channel Security" that means automatically switching between - HTTP and HTTPS.
- JAAS (Java Authentication and Authorization Service).
- Flow Authorization using Spring WebFlow Framework.
- WS-Security using Spring Web Services.

**Layered Architecture**: Spring framework is a layered architecture which consists of several modules. All modules are built on the top of its core module. These modules provide everything that a developer may need for use in enterprise application development. A developer is always free to choose what features he/she needs and eliminate the modules which are of no use. It's modular architecture enables integration with other frameworks without much hassle.

**Exception Handling**: Spring provides a convenient API for translating technology-specific exceptions into unchecked exceptions.

**Easy Integration**: Spring is designed to be used with other frameworks as well. We can use ORM, Struts, Hibernate and other frameworks together with Spring. Spring framework does not impose any restriction on the frameworks to be used together.

**End to end development**: Spring can be used for development of different kinds of applications like standalone applications, Web applications and applets as well.

8. Can we say Spring is the replacement of Java EE?
No, Spring is not the replacement of Java EE. Spring is built on the top of Java EE. Spring internally uses Java EE. Our application will talk to the Spring provided classes and Spring provided classes talk to Java EE internally. Without Java EE, the existence of the Spring will not be there. Just like Hibernate is nothing without JDBC or Omelette (Spring) is not possible without Egg (Java EE). Rather we can say Spring is the complement to Java EE.

9. What is POJO?
POJO: POJO stands for Plain Old Java Object. If a public class does not implement/extend an prespecified interface/class and does not have any prespecified annotation and can be directly compiled & executable under the JDK without having any classpath reference to a library & framework is called a POJO class. 

10. What is a Java Bean?
A JavaBean is nothing but a POJO class but have a strict set of rules:

- Access levels: Properties should be private and expose getters and setters.
Method names: Getters & Setters follow the getX() & setX() convention (in the case of a boolean, isX() can be used for a getter).
- Default Constructor: A no-argument constructor must be present so that an instance can be created without providing arguments for example during deserialization.
- Serializable: Implementing the Serializable interface allows us to store the state.

11. Similarities and Differences between POJO & Java Bean?
**Similarities:**
- Both classes must be public i.e accessible to all.
- Properties or variables defined in both classes must be private i.e. can't be accessed directly.
- Both classes must have a default constructor i.e no argument constructor.
**Differences:**
- Java Bean must implement java.io.Serializable but it is not mandatory in case of POJO.
- There must be getters & setters in Java Bean but it is optional in case of POJO.
**Note**: Due to this we can say, All Java Beans are POJOs but not all POJOs are Java Beans.

12. What is a Spring Bean?
A class which contains attributes and methods with business logic to perform some processing and its object is instantiated, assembled and otherwise managed by a Spring IoC container is called a Spring Bean. There is no restriction for creating spring beans. It can refer to any third party interface/class/annotation.

13. What is IoC Container?
IoC Container is a container of Spring Beans. The main objective of this container is to create the objects, wire them together, configure and manage their complete life cycle from creation till destruction. We provide Spring Beans(POJO) and some configuration metadata to the IoC container. IoC container reads the configuration metadata, wire the beans each other and manage beans lifecycle accordingly and provide us fully configured system(Ready for use).