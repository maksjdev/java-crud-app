Проект - небольшое веб-приложение "Записная книжка"
Функционал:
 - Добавление пользователей в базу данных
 - Редактирование 
 - Удаление
 - Отображение в виде HTML-таблицы
 - Проверка вводимых данных
 - Номер телефона вводится по маске "+(xxx)-xxx-xx-xx"
 - Поле "Пол" - выпадающий список из двух пунктов (М/Ж)

Запуск проекта происходит с помощью Jetty Webapp:
Run Configuration -> Jetty Webapp -> Project "NoteBook", WebApp Directory "WebContent, Context Path "/NoteBook" -> Run
В браузере вводим адрес "http://localhost:8080/NoteBook"
Скриншот в папке "ScreenShots"

Консольные команды: 
mvn compile - компилирует проект(успешно)
mvn packege - создает war файл (успешно)
mvn jetty:run - запускает сервер, но приложение не работает( 


БД - MySQL
IDE - Eclipse Kepler
Контейнер сервлетов - Jetty
Система сборки - Maven