# Godel

Используемая Java: 1.8

БД: PostgreSQL

Сборщик: maven

## Развёртывание:
- Разархивировать "test.rar";
- Запустить Docker;
- С помощью командной строки перейти в директорию, извлеченную из архив;
- Выполнить комманду "docker-compose up".

## Использование:

Поиск:
````
http://localhost:8081/Godel/expenses/searchParameters
````

Cоздание расхода:
````
http://localhost:8081/Godel/expenses/new
````

Редактирование расхода:
````
http://localhost:8081/Godel/expenses/{id}/edit
````

Все расходы:
````
http://localhost:8081/Godel/expenses
````

Расход по id (тут же и кнопка для удаления текущего расхода):
````
http://localhost:8081/Godel/expenses/{id}
````


