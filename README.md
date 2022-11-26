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
git clone https://github.com/binoy14/static-website-webpack-boilerplate.git
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
2. Override all methods of Language (Translate all sentence in a language which you need)
3. Change a field in `ConsoleMenu` class. The name of field is `language`. Assign this field the value of an object of
   the class that you have implemented or that has already existed.#   t e s t - m a t i c k - t a s k  
 