# README #
Technical task for an applicant for the Software Engineering Intern role.
Implementation of Associative array.

## Command line examples.##
#### Compilation.####

```
#!bash

javac -cp src src/associativeArray/AssociativeArray.java

```

#### Execution.####

```
#!bash

java -cp src associativeArray/AssociativeArray
```

### Usage of tests.###
#### Compilation of a test.####

```
#!bash

javac -encoding utf8 -cp 'src:test:test/junit-4.13.1.jar:test/hamcrest-core-1.3.jar' test/AssociativeArrayTest.java

```
In Windows replace colons by semicolons. 

```
#!bash

javac -encoding utf8 -cp 'src;test;test/junit-4.13.1.jar;test/hamcrest-core-1.3.jar' test/AssociativeArrayTest.java


```

#### Running a test.####

```
#!bash

java -cp 'src:test:test/junit-4.13.1.jar:test/hamcrest-core-1.3.jar' org.junit.runner.JUnitCore AssociativeArrayTest
```

The same for Windows. Sama Windows aknas (koolonite asemel semikoolonid):

```
#!bash

java -cp 'src;test;test/junit-4.13.1.jar;test/hamcrest-core-1.3.jar' org.junit.runner.JUnitCore AssociativeArrayTest
```
