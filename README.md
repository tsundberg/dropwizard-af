# Dropwizard - ett enkelt alternativ för Arbetsförmedlingen

## Building

The project is built using Gradle wrapper.

    ./gradlew clean shadowJar
    
## Run

    java -jar ./build/libs/hello-world-1.0-all.jar server configuration.yaml 
    
## Accessing

The application is available at [http://localhost:8080/hello-world?name=Thomas](http://localhost:8080/hello-world?name=Thomas)


## Used by

Finacial Times, https://github.com/Financial-Times

    https://github.com/Financial-Times/wordpress-article-mapper
    
Klarna

    At least according to their recruitments of devs     