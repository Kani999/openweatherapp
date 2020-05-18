# Spring MVC - Open weather application

- To get weather info use `GET /wheather/{city}`
  - displays City name, temperature and time when data was pulled from api
- No error handlers are implemented
- No exception erros are handled
- Unit test are missing
- Implements Factory for changable API classes
- ~~Includes Dockerfile for running the application~~
  - `build_and_run.sh`
  - access `localhost:8080/weather/Ostrava`
  - DOES NOT WORK `java.net.UnknownHostException: api.openweathermap.org`
- API key configurable via `resources/application.properties` file
  - `personal API key included`

### Run application

```
mvn clean install
java -jar target/openweatherapp.war
`localhost:8080/weather/Ostrava`
```

