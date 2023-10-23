# Дипломный проект по профессии «Тестировщик ПО»
______

### Описание приложения
Приложение — это веб-сервис, который предлагает купить тур по определённой цене двумя способами:

![](pic/service.png)

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

1) [Google Chrome](https://www.google.ru/chrome/);
2) [IntelliJ IDEA](https://www.jetbrains.com/ru-ru/idea/download/?section=windows#section=windows);
3) [Github](https://desktop.github.com/);
4) [Docker Desktop](https://www.docker.com/).

______

## Запуск тестов:

* #### Работа с базой данных MySQl:

1. `git clone https://github.com/MrLaikaBoss/QA-diploma` - Клонировать репозиторий
2. `docker-compose up -d` - Запуск контейнеров
3. `java -jar ./artifacts/aqa-shop.jar` - Запустить jar-файл с базой данных MySQL
4. `http://localhost:8080/` - Проверить доступность приложения в браузере
5. `./gradlew clean test` - Открыть второй терминал, запустить автотесты
6. `./gradlew allureReport','./gradlew allureServe` - Создание отчета Allure

* #### Работа с базой данных PostgreSQl:

1. `docker-compose up -d` - Запуск контейнеров
2. `java -jar ./artifacts/aqa-shop.jar` - Запустить jar-файл с базой данных PostgreSQl
3. `http://localhost:8080/` - Проверить доступность приложения в браузере
4. `./gradlew clean test `- В новой вкладке терминала запустить автотесты
5. `./gradlew allureReport', './gradlew allureServe` - Создание отчета Allure