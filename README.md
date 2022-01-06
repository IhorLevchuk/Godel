# Godel

Используемая Java: 1.8

БД: PostgreSQL

Сборщик: maven

## Развёртывание:
- Cкачать содержимое репозитория:

 https://github.com/IhorLevchuk/GodelDocker.git
- Запустить Docker;
- С помощью командной строки перейти в директорию, извлеченную из архив;
- Выполнить комманду "docker-compose up".

## Использование:

Поиск:

Диапазон id расходов: 1-11

http://localhost:8081/Godel/expenses/searchParameters

Cоздание расхода:

http://localhost:8081/Godel/expenses/new

Редактирование расхода:

http://localhost:8081/Godel/expenses/{id}/edit

Все расходы:

http://localhost:8081/Godel/expenses

Расход по id (тут же и кнопка для удаления текущего расхода):

http://localhost:8081/Godel/expenses/{id}


