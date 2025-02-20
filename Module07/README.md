# Module 06 / 07 



* Java Bean - class you write, that has an empty constructor, a get/set equally for every field variable you want to expose, equals and hashcode == this is mutable
* Java Record - immutable, constructor - has to have all values - it generates .equals, .hashcode, .toString
* Java POJO - Plain Old Java Object. nothing special

```java

List<Book> books;

return books.stream().map(book->book.toRecord()).toList();
```