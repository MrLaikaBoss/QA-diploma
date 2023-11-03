# Дипломный проект по профессии «Тестировщик ПО»

### Описание приложения
Приложение — это веб-сервис, который предлагает купить тур по определённой цене двумя способами:

<img width="705" alt="service" src="https://github.com/MrLaikaBoss/QA-diploma/assets/131680949/adf5696a-1d7e-474f-aadf-a4eba555e6d6">

Приложение предлагает купить тур по определённой цене с помощью двух способов:
1. Обычная оплата по дебетовой карте
2. Уникальная технология: выдача кредита по данным банковской карты

Само приложение не обрабатывает данные по картам, а пересылает их банковским сервисам:
* сервису платежей (далее - Payment Gate)
* кредитному сервису (далее - Credit Gate)

Приложение должно в собственной СУБД сохранять информацию о том, каким способом был совершён платёж и успешно ли он был совершён (при этом данные карт сохранять не допускается).

______

### Документация:

1. [План автоматизации](https://github.com/MrLaikaBoss/QA-diploma/blob/main/docs/Plan.md)
2. [Отчет от тестировании](https://github.com/MrLaikaBoss/QA-diploma/blob/main/docs/Report.md)
3. [Отчет по итогам автоматизации](https://github.com/MrLaikaBoss/QA-diploma/blob/main/docs/Summary.md)

### Для выполнения работы необходимо:

* [Google Chrome](https://www.google.ru/chrome/);
* [IntelliJ IDEA](https://www.jetbrains.com/ru-ru/idea/download/?section=windows#section=windows);
* [Github](https://desktop.github.com/);
* [Docker Desktop](https://www.docker.com/).

______

## Запуск тестов:

* #### Работа с базой данных MySQl:

1. `git clone https://github.com/MrLaikaBoss/QA-diploma` - Клонировать репозиторий
2. `docker-compose up -d` - Запустить контейнер
3. `java -jar ./artifacts/aqa-shop.jar -Dspring.datasource.url=jdbc:mysql://localhost:3306/app` - Запустить jar-файл с базой данных MySQL
4. http://localhost:8080/ - Проверить доступность приложения в браузере
5. `./gradlew clean test '-Ddb.url=jdbc:mysql://localhost:3306/app` - Открыть второй терминал, запустить автотесты
6. `./gradlew allureReport','./gradlew allureServe` - Создание отчета Allure
7. `CTRL + C` - Закрыть приложение в терминале
8. `docker compose down` - Остановить контейнер 

* #### Работа с базой данных PostgreSQl:

1. `docker-compose up -d` - Запустить контейнер
2. `java -jar ./artifacts/aqa-shop.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/app` - Запустить jar-файл с базой данных PostgreSQl
3. http://localhost:8080/ - Проверить доступность приложения в браузере
4. `./gradlew clean test '-Ddb.url=jdbc:postgresql://localhost:5432/app`- В новой вкладке терминала запустить автотесты
5. `./gradlew allureReport', './gradlew allureServe` - Создание отчета Allure
6. `CTRL + C` - Закрыть приложение в терминале
7. `docker compose down` - Остановить контейнер  
