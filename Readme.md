## Поиск по БД библиотеке
Design and implement a REST API using Spring-Boot.


* Поиск всех книг
* Статистика по алфавиту авторов от A до Z
* Возврат всех книги автора по первой букве в его имени

### Server
#### Build requirements
- Java 11
- Mysql
  
#### Run an application
A built executable war is working application and does not need any specific configuration.

SpringbootApplication deploy to localserver

resources/db for initialization and populate DB

### book-rest-controller
get /api/books getAll

get /api/books/statistic getSortedStatistic

get /api/book/{latter} getBooksAuthorsContainLatter

