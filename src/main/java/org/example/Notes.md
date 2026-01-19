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

OneToMany Relationships
----------------
OneToMany relationships in ORM represent a relationship where one entity is associated with multiple instances of another
As an Alien can have multiple Laptops. 
1. **Define the Relationship**: In the main entity class, use the @OneToMany annotation to define the relationship with the related entity class.
2. Create a Alien reference in Laptop class using @ManyToOne annotation to establish the bidirectional relationship.
3. This will create a foreign key in the Laptop table referencing the Alien table. relationship. For example, one alien can have multiple laptops.
from Laptop perspective 1 alien can have multiple laptops and from Alien perspective one alien can have multiple laptops.
Both the sides(Alien and Laptop) should be aware of each other to maintain the relationship properly. Both are creating tables in the database with foreign key constraints.
4. To prevent separate tables for the relationship, use the mappedBy attribute in the @OneToMany annotation to indicate that the relationship is managed by the other entity.
Laptop class will have the foreign key column referencing the Alien table. So no separate table will be created for the relationship. So in the Alien class we will use @OneToMany(mappedBy="alien") annotation to indicate that the relationship is managed by the alien field in the Laptop class.
