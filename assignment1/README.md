# Лабораторна робота №1
## Тема: Перше знайомство з Spring Framework


### Interface CommandLineRunner
Functional Interface:
This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.

Interface used to indicate that a bean should run when it is contained within a SpringApplication. Multiple CommandLineRunner beans can be defined within the same application context and can be ordered using the Ordered interface or @Order annotation.

Note: A functional interface is an interface that contains only **one abstract method**. They can have only one functionality to exhibit. 
From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface. A functional interface can have any number of default methods.