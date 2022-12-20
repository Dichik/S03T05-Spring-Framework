# Assignment 5. JdbcTemplate

## curl scripts

#### Get users

```curl http://localhost:8080/users```

#### Create user

```curl -X POST -H "Content-Type: application/json" -d '{"email": "test@email.com", "firstName": "test", "secondName": "test"}' http://localhost:8080/users```

#### Delete user

```curl -X DELETE http://localhost:8080/users/1```

#### Update user

```curl -X PUT -H "Content-Type: application/json" -d '{"firstName": "test2", "secondName": "test2"}' http://localhost:8080/users/2```

## Questions:

### 1. Поясніть різницю між JDBC та JdbcTemplate.

JDBC (Java Database Connectivity) is the Java API that manages connecting to a database, issuing queries and commands,
and handling result sets obtained from the database.

JdbcTemplate is a central class in the JDBC core package that simplifies the use of JDBC and helps to avoid common
errors.
It internally uses JDBC API and eliminates a lot of problems with JDBC API.
The JdbcTemplate class executes SQL queries, iterates over the ResultSet , and retrieves the called values,
updates the instructions and procedure calls, “catches” the exceptions, and translates them into the exceptions.

### 2. Які переваги надає PreparedStatement у порівнянні зі звичайним Statement?

- PreparedStatement helps us in **preventing SQL injection attacks** because it automatically escapes the special
  characters.
- PreparedStatement allows us to **execute dynamic queries** with parameter inputs.
- PreparedStatement provides **different types of setter methods** to set the input parameters for the query.
- PreparedStatement is **faster** than Statement. It becomes more visible when we reuse the PreparedStatement or use
  it’s batch processing methods for executing multiple queries.
- PreparedStatement helps us in writing **object oriented code with setter methods** whereas with Statement we have to
  use String Concatenation to create the query. If there are multiple parameters to set, writing Query using String
  concatenation looks very ugly and error prone.

### 3. Поясніть різницю між методами execute(), executeQuery() та executeUpdate() класу PreparedStatement.

| executeQuery()                                                                                   | executeUpdate()                                                                                                 | execute()                                                                           |
|--------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------|
| executeQuery() method used to retrieve some data from database.                                  | executeUpdate() method used for update or modify database.                                                      | execute() use for any SQL statements.                                               |
| It returns an object of the class. ```ResultSet executeQuery (String sql) throws SQLException``` | It returns an integer value. ```int executeUpdate(String sql) throws SQLException```                            | It returns a boolean value. ```int executeUpdate(String sql) throws SQLException``` |
| This method is normally used to execute SELECT queries.                                          | This method Is used to execute non SELECT queries. **
DML** as INSERT, DELETE, UPDATE or **
DDL** as CREATE. DROP | This method can be used to execute any type of SQL statement.                       |

### 4. Чим відрізняються інтерфейси RowMapper<T> та ResultSetExtractor<T>?

### 5. Для чого потрібен інтерфейс KeyHolder?

Interface for retrieving keys, typically used for auto-generated keys as potentially returned by JDBC insert statements.
Implementations of this interface can hold any number of keys.
In the general case, the keys are returned as a List containing one Map for each row of keys.

### 6. Як працює декларативне керування транзакціями у Spring Framework?

### 7. Що таке «transaction propagation»? Як обрати потрібний механізм поширення транзакцій? Який механізм поширення транзакцій використовується за замовченням? 





