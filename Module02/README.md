# Discussion and Live Session Relating to Module 02 and the Start of Module 03


## Q - Review UML
> Can you review UML diagrams in a more systematic way? Shall we include constructors there too?

Starting HW03 - 2 UML diagrams - always
* First: Is your plan
* Second: Is what you actually

* NOUNS - what are they - help define classes
* VERBS - for each now - these are my methods in the classes

```mermaid
classDiagram
    class Shape {
        + final static MAX_SIDES : int
        - final static SCANNER : Scanner
        - num_sides : int

        + Shape(int) 
        + Shape(int, Color)

        + getArea()    : double
        + printShape() : void

        # protectedMethod() : Integer

        defaultMethod(): Boolean
    }

    class Circle {


    }
    Shape <-- Circle
    
```


## Q - Review Method Overloading
> Review method overloading. 


## Q - Make sure to define over writing 
> Why overwrite, when, etc.
