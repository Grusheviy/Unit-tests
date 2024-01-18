## Задание 1. Ответьте письменно на вопросы:

1)  Почему использование тестовых заглушек может быть 
полезным при написании модульных тестов?

Заглушки позволяют тестировать код в изоляции без взаимодействия 
с внешними сервисами, БД, итд.Также заглушки могут быть полезны для ускорения
выполнения тестов например вместо обращения к БД возвращать заранее 
определенные значения. Так же используя заглушки можно избежать изменения
реальных данных.


2) Какой тип тестовой заглушки следует использовать,
если вам нужно проверить, что метод был вызван с определенными аргументами?

Spy или Stub с утверждениями

Spy, чтобы записывать параметры, с которыми вызывается метод,
и затем проверять эти записи в тесте.
Stub с утверждениями если нужно вернуть результат и убедится что метод вызввался
с определенными параметрами.


3) Какой тип тестовой заглушки следует использовать,
если вам просто нужно вернуть определенное значение или исключение
в ответ на вызов метода?

Mock или Fake например используя библиотеку Mockito

4) Какой тип тестовой заглушки вы бы использовали для имитации
взаимодействия с внешним API или базой данных?

Mock к они предоставляют возможность задавать ожидаемые вызовы методов 
и возвращаемые значения , а также проверять фактические вызовы
в процессе выполнения тестов.
Так же хорошо подойдут Fake они тоже хорошо эмулируют поведение внешних API
или БД на них можно реализовать упрощенную реализацию которая позволит тестировать
в изолированной среде
Выбор между Моками и Фейками зависит от требований и команды.