## Тимофеев Вадим

### Группа: Веб-разработка на Java | Тех. специализация | 2

> `Java Junior. Урок 3. Сериализация`

- Для того, чтобы исключить средний балл студента из конвертации - пометил аннотацией `@JsonIgnore`

- В домашней работе использовал тот же способ, что и на семинаре, разве что изменил логику для десериализации 
объекта, вместо коллекции объектов. Саму логику вынес в отдельный не статический класс [Converter](src/main/java/org/example/converter/Converter.java), сделав
методы обобщенными

- Обычно пользуюсь библиотеками Gson (для JSON) и JAXB (для XML), поэтому Jackson - что-то новенькое)
