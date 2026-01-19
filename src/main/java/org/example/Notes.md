ORM - Object Relational Mapping
===============================
ORM (Object Relational Mapping) is a programming technique used to convert data between incompatible type systems in object-oriented programming languages. It allows developers to work with databases using high-level object-oriented concepts instead of writing raw SQL queries.
Key Concepts
----------------
1. **Entities**: In ORM, entities are classes that represent tables in a database.
2. **Attributes**: Attributes are the properties of an entity that correspond to the columns in a database table.
3. **Relationships**: ORM frameworks allow defining relationships between entities, such as one-to-one


Hibernate
----------------
Hibernate is a popular ORM framework for Java. It provides a powerful and flexible way to map Java objects to database tables.
Key Features of Hibernate
1. **Automatic Table Creation**: Hibernate can automatically create database tables based on entity definitions. 
2. **Lazy Loading**: Hibernate supports lazy loading, which means that related entities are loaded only when they are accessed.
3. **Caching**: Hibernate provides a caching mechanism to improve performance by reducing database access.
4. **Query Language**: Hibernate has its own query language called HQL (Hibernate Query Language) that allows developers to write database queries using object-oriented syntax.
5. **Transaction Management**: Hibernate provides built-in support for managing database transactions.
6. **Database Independence**: Hibernate supports multiple database systems, allowing developers to switch databases with minimal changes to the code.
7. **Annotations and XML Configuration**: Hibernate allows configuration through both annotations in the Java code and XML files, providing flexibility in how mappings are defined.
8. **Integration with Spring**: Hibernate can be easily integrated with the Spring Framework, allowing developers to leverage Spring's features alongside Hibernate's ORM capabilities.
9. **Support for Inheritance**: Hibernate supports various inheritance mapping strategies, allowing developers to model complex class hierarchies in the database.
10. **Criteria API**: Hibernate provides a Criteria API for building type-safe queries programmatically, which can be more flexible than HQL for dynamic query construction


Embedded Databases
----------------
Embedded databases are lightweight database systems that run within the application process. They are often used for development, testing, or small-scale applications.

Making Hibernate Work with Embedded Databases
Using Laptop class embedding with Alien class as an embedded object.
1. **Define the Embedded Class**: Create a class that represents the embedded object and annotate
using this we can embed the object in another entity. and use it as a field in the main entity class.
