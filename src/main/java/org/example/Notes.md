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

```

Hibernate Caching - Level 1 Cache
----------------   

Level 1 caching in Hibernate, also known as the session-level cache, is a mechanism that stores entities loaded during a particular session. Here are some key points to understand about it:
Automatic Activation: Level 1 cache is always enabled by default in Hibernate, meaning that once an entity is loaded within a session, it is stored in the cache and will not repeatedly hit the database for the same entity until the session is closed.
Limited Scope: The cache is limited to the current session. If you create a new session, it will not have access to the entities stored in Level 1 cache from the previous session. This means that two different sessions cannot share data.
Data Freshness: If you need to ensure that your application is working with fresh data from the database, you can use the session.refresh(entity) method to reload the entity from the database, bypassing the cached version.
Resource Considerations: While caching improves performance by reducing database access, it also consumes memory. Therefore, it's important to consider when to use caching based on the dynamics of your data.
In contrast, Level 2 caching is optional and requires additional configuration. It allows sharing cached data across different sessions and involves external caching libraries like Ehcache or Caffeine.

Hibernate Caching - Level 2 Cache
----------------
Level 2 caching in Hibernate, also known as the session factory-level cache, is an optional caching mechanism that allows entities to be cached across multiple sessions. Here are some key points to understand about it:
Optional Configuration: Unlike Level 1 cache, Level 2 cache is not enabled by default. You need to explicitly configure it in your Hibernate settings and choose a caching provider (like Ehcache, Infinispan, etc.) to manage the cache.
Shared Across Sessions: Level 2 cache is shared among all sessions created by the same session factory. This means that entities cached in Level 2 cache can be accessed by different sessions, improving performance for frequently accessed data.


HQL - Hibernate Query Language
----------------
HQL (Hibernate Query Language) is an object-oriented query language used in Hibernate to perform database operations. It is similar to SQL but operates on the entity objects rather than database tables.
Key Features of HQL
1. **Object-Oriented**: HQL allows developers to write queries using object-oriented syntax, making it easier to work with entities and their relationships.
2. **Database Independence**: HQL is database-independent, meaning that the same HQL query can be used with different database systems without modification.
3. **Supports Joins**: HQL supports various types of joins (inner join, left join, right join) to retrieve related entities.
4. **Supports Aggregate Functions**: HQL supports aggregate functions like COUNT, SUM, AVG, MAX, and MIN to perform calculations on entity attributes.
5. **Supports Subqueries**: HQL allows the use of subqueries to perform complex queries.
6. **Parameter Binding**: HQL supports parameter binding to prevent SQL injection attacks and improve query performance.
7. **Pagination**: HQL supports pagination to retrieve a subset of results from a large dataset.
Example HQL Query
```java
String hql = "FROM Alien WHERE alienName = :name";
Query query = session.createQuery(hql);
query.setParameter("name", "Zorg");
List<Alien> aliens = query.list();
``` 
In this example, we are retrieving all Alien entities where the alienName attribute matches the specified name parameter.

Conclusion
----------------
HQL, or Hibernate Query Language, is a powerful query language provided by Hibernate that allows you to interact with the database in an object-oriented manner. 
Here’s a brief introduction to HQL:Derived from SQL: HQL is somewhat similar to SQL (Structured Query Language), but instead of dealing with database tables and columns, it operates on the entities and their properties in your Java application. 
If you already understand basic SQL, you’ll find transitioning to HQL quite manageable.
Object-Oriented: In HQL, you perform queries using the names of entity classes instead of actual database tables. 
For example, if you have an entity called Student, your queries will reference Student rather than a students table. Similarly, you refer to object properties rather than database columns.
CRUD Operations: It allows for typical CRUD (Create, Read, Update, Delete) operations. 
You can use HQL to insert new records, select records from the database, update existing records, and delete records.
Flexibility: HQL supports complex queries that can include joins, filtering, and sorting. This makes it a versatile choice for querying your database through Hibernate.
Integration with ORM: HQL helps bridge the gap between the object-oriented programming paradigm of Java and the relational database world. 
This way, developers can work with Java objects, while Hibernate manages the underlying database interactions seamlessly.

In summary, HQL simplifies database operations by allowing developers to think in terms of Java objects and entities, leveraging Hibernate's ORM capabilities