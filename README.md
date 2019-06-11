# weather-service
A simple weather service app

## Prerequisites
* [Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 8 or higher
* Maven 3.5+
* [NodeJS](https://nodejs.org/en/) 10 or higher
* NPM or Yarn

## API run
Running the application locally.
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the au.origin.weather.WeatherServiceApplication class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

mvn spring-boot:run

## API access
http://localhost:8080/temperature/city

JSON Response:
[{"name":"Melbourne","temperature":15.0},{"name":"Sydney","temperature":24.0},{"name":"Brisbane","temperature":32.0},{"name":"Hobart","temperature":5.0},{"name":"Perth","temperature":40.0},{"name":"Adelaide","temperature":30.0},{"name":"Darwin","temperature":28.0}]

## Asumptions
Data is read from static json file named weather-results.json.

Temperature is taken as double data type.

## Client
React frontend client bootstrapped by [create-react-app](https://facebook.github.io/create-react-app)

Inside the client directory, you can run some built-in commands:
Use`npm install` and then

`npm start or yarn start`
Runs the app in development mode. Open http://localhost:3000 to view it in the browser.

The page will automatically reload if you make changes to the code. You will see the build errors and lint warnings in the console.