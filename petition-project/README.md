# Лабораторна робота №2

## Контрольні питання:

Spring Bean: is an object, which is created, managed and destroyed in Spring Container.

### 1. Поясніть значення наступних термінів:
    - Inversion of Control (IoC);
    - IoC container;
    - Dependency Injection (DI);
    - Dependency inversion principle. (+ repeat SOLID principles) 

- Inversion of Control is a principle in software engineering which transfers the control of objects or portions of a program to a container or framework.
- *Spring IoC Container* is the core of Spring Framework.
It creates the objects, configures and assembles their dependencies, manages their entire life cycle.
- Dependency Injection is a fundamental aspect of the Spring framework, through which the Spring container “injects” objects into other objects or “dependencies”.
Simply put, this allows for loose coupling of components and moves the responsibility of managing components onto the container.
- The Dependency Inversion Principle (DIP) states that high level modules should not depend on low level modules; both should depend on abstractions.
Abstractions should not depend on details.

### 2. В чому полягає різниця між анотаціями @Component та @Bean? Опишіть переваги та недоліки створення бінів за допомогою цих анотацій.

- *@Component* is a class-level annotation, but *@Bean* is at the method level, so *@Component* is only an option when a class's source code is editable. *@Bean* can always be used, but it's more verbose.
- *@Component* is compatible with Spring's auto-detection, but *@Bean* requires manual class instantiation.
- Using *@Bean* decouples the instantiation of the bean from its class definition. This is why we can use it to make even third-party classes into Spring beans. It also means we can introduce logic to decide which of several possible instance options for a bean to use.
- We **cannot create a bean** of a class using @Component, if the class is outside spring container whereas we **can create a bean** of a class using @Bean even if the class is present **outside the spring container**.
- @Component has **different specialisations** like @Controller, @Repository and @Service whereas @Bean has **no specialisations**.

*When should you use **@Bean**?*

Sometimes automatic configuration is not an option. **When?** Let's imagine that you want to wire components from 3rd-party libraries (you don't have the source code so you can't annotate its classes with @Component), so automatic configuration is not possible.

The **@Bean** annotation **returns an object** that spring should register as bean in application context. The **body of the method** bears the logic responsible for creating the instance.

### 3. Чому слід уникати ін’єкцій залежностей напряму у поле біна?

- Disallows immutable field declaration
- Eases single responsibility principle violation
- Tightly coupled with dependency injection container
- Hidden dependencies

### 4. В яких випадках краще використовувати ін’єкції залежностей за допомогою конструкторів, а в яких за допомогою сетерів?

Use Setter injection when a number of dependencies are more or you need readability. It doesn’t check the circular dependency.
Setter-based DI helps us to inject the dependency only when it is required, as opposed to requiring it at construction time.

Use Constructor Injection when Object must be created with all of its dependency. It doesn’t allow to create circular dependency.
Constructor-based DI fixes the order in which the dependencies need to be injected.

### 5. В яких випадках краще використовувати біни типу singleton, а в яких prototype?

singleton ми використовуємо, коли потрібно мати один інстанс per Spring IoC container. prototype створює новий інстанс біна кожного разу як ми звертаємося до об'єкта.

### 6. Чи можливе у Spring Framework створення циркулярних залежностей при ін’єкціях?

But with a circular dependency, Spring cannot decide which of the beans should be created first since they depend on one another.
In these cases, Spring will raise a BeanCurrentlyInCreationException while loading context.

It can happen in Spring when using constructor injection.

### 7. Чи може бути в одному проекті кілька класів з реалізацією якогось інтерфейсу, якщо цей інтерфейс використовується для ін’єкції залежностей?

Yes, we can have several implementations of the same interface, but for dependency injection we will need to specify which implementation we want to use.
In this case we should use @Qualifier to specify the corresponded implementation.

### 8. Чи може бін мати кілька методів, помічених анотацією @Autowired?

Config methods may have an arbitrary name and any number of arguments; each of those arguments will be autowired with a matching bean in the Spring container.
Bean property setter methods are effectively just a special case of such a general config method.
Such config methods do not have to be public.

### 9. Чи може бін мати кілька конструкторів, помічених анотацією @Autowired?

Only a single constructor may be annotated with @Autowired.


# Лабораторна робота №3

## Контрольні запитання

### 1. Для чого потрібен шаблон проектування MVC.



### 2. В чому полягають переваги використання шаблону проектування Front Controller?



### 3. Поясніть особливості використання шаблону проектування Front Controller при реалізації веб-застосунків та RESTful веб-сервісів.



### 4. В чому полягають відмінності методів GET та POST протоколу HTTP?



### 5. Що таке сервлет?



### 6. Якими способами передаються данні HTML-форм з клієнта на сервер? В чому полягають їх переваги і недоліки?



### 7. Чи впливає регістр символів при передачі імен параметрів у HTTP-запитах до сервлетів?



### 8. Чи впливає регістр символів при передачі значень параметрів у HTTP-запитах до сервлетів?



### 9. В чому полягає різниця між статичними HTML-сторінками та шаблонами сторінок Thymeleaf та JSP?



### 10. В чому полягає різниця між сервлетами та JSP-сторінками?



### 11. Як виглядає життєвий цикл JSP-сторінки? Що таке трансляція та компіляція JSP-сторінок?



### 12. Що таке скриптлети та директивні елементи?



### 13. В чому полягає різниця між директивою <%@ include%> та елементом <jsp:include>?



### 14. Що таке JavaBean? Як їх використовувати у JSP-сторінках?



### 15. В чому полягають переваги/недоліки використання EL та JSTL у порівнянні з такими JSP-елементами як вирази (<%=…  %>) та скриптлети (<% … %>)?



### 16. В чому полягають переваги/недоліки використання JSTL-елемента <c:out> у порівнянні зі звичайними EL-виразом ${…} або JSP-елементом <%=… %>?



### 17. Який час життя атрибутів на рівнях  requestScope, sessionScope, applicationScope? Чи можуть одночасно існувати атрибути з однаковими іменами на різних рівнях?



### 18. Що таке XSS-атака? Як зробити сайт стійким до таких атак?



### 19. Поясніть різницю між термінами forward та redirect.


