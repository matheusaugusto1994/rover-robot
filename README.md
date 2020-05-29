# Rover-robot
This is a simple test project with the objective of move a robot on determined area.

## Business rules
 - The robot can only move through a 5x5 matrix.
 - The position of the robot must be represented by coordinates (x, y) and direction (north, south, east and west).
 - The robot starts in position x:0, y:0, direction:N.
 - The robot can execute only the commands:
    - Move: M;
    - Turn left: L
    - Turn right: R
 - A command must be executed through a POST request with a command sequence. For example http://host/rest/mars/MML
 - At each request, the robot must return to its initial position. No states should be kept between requests.

## Tech
---
### Requirements to compile the project
 - [JDK 11] or later. 

### Build
    mvn clean install
    
### Run tests
    mvn test
    
### Run project
    mvn spring-boot:run
    
## API
---
### Send Command
 Request:
 
    $ curl -X POST http://localhost:8080/rest/mars/{YOUR_COMMAND}
 Response:

    { "x":0, "y":0, "direction":"N" }


## License
---
MIT


   [JDK 11]: <https://openjdk.java.net/projects/jdk/11/>
