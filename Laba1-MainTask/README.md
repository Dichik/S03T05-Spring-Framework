### 1. В чому полягає різниця між Spring Framework та Spring Boot?

Spring Framework спроощує життя програмістів, роблячи багацько роботи замість них. Це певна філософія програмування. 
У той самий час як Spring Boot - це як певна надбудова над Spring Framework, яка допомагає нам скоротити 
час розробки та уникати складних XML кофігурацій. 

### 2. Для чого в структурі проекту потрібен файл pom.xml?

Ми зберігаємо plugin configurations, dependency and packaging management systems.

### 3. Для чого потрібна анотація @SpringBootApplication? Що буде, якщо її прибрати?

@SpringBootApplication дає нам чітко зрозуміти, що ми працюємо з Spring Boot application.

### 4. Для чого потрібен інтерфейс CommandLineRunner?

Interface використовується, щоб зрозуміти чи bean повинен запускатися, коли він міститься всередині SpringApplication. 
Декілька CommandLineRunner beans можуть бути визначені всередині the same application context і можуть мати певну довільну послідовність, 
використовуючи @Order annotation.

### 5. Чим інтерфейс CommandLineRunner відрізняється від ApplicationRunner?

Обидва інтерфейси працюють однаково і пропонують однаковий єдиниий метод run.
Різниця в тому, що CommandLineRunner interface надає доступ до application arguments як до String array, 
тим часом ApplcationRunner використовує ApplicationArguments interface, який надає доступ до the raw String[] arguments 
та parsed option and non-option arguments.

### 6. Використовуючи анотацію @Component додайте в перший проект два біна First та Second з інтерфейсом CommandLineRunner, які виводять на консоль слова "First" та "Second" відповідно. За допомогою анотації @Order зробіть так, щоб рядки на консоль виводились у наступному порядку:

Done.

### 7. Додайте у другий проект кілька статичних HTML-сторінок про вашу команду в цілому та кожного з вас.

