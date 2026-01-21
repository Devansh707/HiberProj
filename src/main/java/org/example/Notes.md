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

ManyToMany Relationships
----------------
ManyToMany relationships in ORM represent a relationship where multiple instances of one entity are associated with multiple instances of another entity.
For example, multiple aliens can have multiple laptops and multiple laptops can be associated with multiple aliens.

Both Alien and Laptop classes should be aware of each other to maintain the relationship properly. If we don't use mappedBy attribute in either side, Hibernate will create a separate join table to manage the relationship.
To prevent separate join table creation, use the mappedBy attribute in one of the entity classes to indicate that the relationship is managed by the other entity.
In the laptop class we will use @ManyToMany(mappedBy="laptops") annotation to indicate that the relationship is managed by the laptops field in the Alien class. the @Embeddable annotation.


Hibernate Eager and Lazy Fetching
----------------
Eager and Lazy fetching are strategies used by Hibernate to load related entities from the database.
In Hibernate we need caching to improve performance by reducing database access. Hibernate provides two types of caching: first-level cache and second-level cache.
When we fetch an entity in same session, Hibernate first checks the first-level cache (session cache) to see if the entity is already loaded. If it is, Hibernate returns the entity from the cache instead of querying the database again.
If the entity is not found in the first-level cache, Hibernate queries the database to load the entity and stores it in the first-level cache for future use.
First-level cache is enabled by default and is specific to a Hibernate session. Each session has its own first-level cache, and entities loaded in one session are not visible in another session.
Second-level cache is an optional cache that can be configured to store entities across multiple sessions. It is shared among all sessions and can improve performance by reducing database access for frequently accessed entities.

To make multiple sessions  should share the same data, then we need to enable second-level cache in Hibernate configuration and annotate the entity classes with @Cache annotation to specify the caching strategy.

By Default, Hibernate uses Lazy fetching for OneToMany and ManyToMany relationships. This means that related entities are not loaded from the database until they are accessed in the code.
For example, when we load an Alien entity that has a OneToMany relationship with Laptop entities, the Laptop entities are not loaded from the database until we access the laptops field in the Alien entity.
Eager fetching, on the other hand, loads related entities from the database immediately when the main entity is loaded.
To change the fetching strategy from Lazy to Eager, we can use the fetch attribute in the relationship annotation.
For example, to change the fetching strategy of the laptops field in the Alien class to Eager, we can use the following annotation:
```java
@OneToMany(fetch = FetchType.EAGER, mappedBy = "alien")