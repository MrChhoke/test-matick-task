# Test task of 'TestMatick' (Eng)

## Condition of the test task:

Shaped objects of the following types are provided: square, triangle, circle and trapezium. Each shape can be drawn, its
area and color parameters can be obtained. Also, shapes have unique methods, for example, rotate radius, hypotenuse
length, side length, etc.

We need to generate a random set of shapes, the number of objects in the set is also unknown in advance.

After generating the array, you need to display the entire list of objects that we have, for example:

> Figure: square, area: 25 square meters. units, side length: 5 units, color: blue.

> Shape: triangle, area: 12.5 sq. units, hypotenuse: 7.1 units, color: yellow.

## Getting Started

Clone the repo

```sh
git clone https://github.com/MrChhoke/test-matick-task.git
```

Rum the program (Windows)

```sh
./gradlew.bat -q --console plain run
```

Rum the program (Linux)

```sh
./gradlew -q --console plain run
```

## Additional

You also have the option to add your language. You have already had two implemented languages: Ukrainian (default) and
English

### For this you need:

1. Extend `Language` class
2. Override all methods of `Language` (Translate all sentence in a language which you need)
3. Change a field in `ConsoleMenu` class. The name of field is `language`. Assign this field the value of an object of
   the class that you have implemented or that has already existed.

### Some classes have been covered with autotests, if you change something, you can always check that those changes are correct

# Завдання 'TestMatick' (Укр)

## Умова тестового завдання:

Подано об'єкти-фігури таких видів: квадрат, трикутник, коло та трапеція. Кожну фігуру можна намалювати, отримати
параметри її площі і колір. Також фігури мають унікальні методи, наприклад, повернути радіус, довжину гіпотенузи,
довжину сторони і т. д.

Нам необхідно згенерувати випадковий набір фігур, кількість об'єктів у наборі також заздалегідь невідома.

Після генерації масиву потрібно вивести весь список об'єктів, які у нас є, наприклад:

> Фігура: квадрат, площа: 25 кв. од., довжина сторони: 5 од., колір: синій.

> Фігура: трикутник, площа: 12,5 кв.од., гіпотенуза: 7.1 од., колір: жовтий.

## Запуск

Завантажте репозиторій

```sh
git clone https://github.com/MrChhoke/test-matick-task.git
```

Запуск програми (Windows)

```sh
./gradlew.bat -q --console plain run
```

Запуск програми (Linux)

```sh
./gradlew -q --console plain run
```

## Додатково

У вас також є можливість додавати свої мови. Уже імплементовано дві мови: українська (за замовчуванням) та англійська

### Для цього вас потрібно:

1. Розширити клас `Language`
2. Перевизначити усі методи класу `Language` (Переведіть усі речення у мову яку вам потрібно)
3. Змінити поле в класі `ConsoleMenu`. Поле має ім'я `language`. Присвойте полю значення об'єкта клас якого ви
   імплементували або які уже існували

### Деякі класи були покриті автотестами, якщо ви щось зміните, ви завжди зможете перевірити правильність цих змін