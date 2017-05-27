## Most Frequent Word ##

### Programming Language ###

This assignemnt is attempted with Programming Language Java using JDK 1.8

### Build Tool ###

This application can be built with Maven


### How to run the program ###

#### Pre-requisties Software for Build ####

 1. Maven
 2. JDK 1.8

 #### Running the Program ####

1. Build it using command "mvn clean install"  This will create target folder

2. Run with command below from folder analytics-app after building

java -jar target/analytics-app-1.0-SNAPSHOT.jar "A blue shirt cost is twenty-four dollars but a white shirt is only twenty so I bought the white shirt" "new a new "

### Unit Test ###

Junit is used and 6 test cases have been added




### Complexity ###

Time Complexity of solution is :- O(n)
Space Complexity :- O(n) where n is number of words in input text


### Assumption ###

1. Words in quotation are same as words without quotation. i.e ignore "".
2. Words are case sensitive Words are case
