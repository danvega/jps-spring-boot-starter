# JsonPlaceholder Service Spring Boot Starter

This is a Spring Boot Starter for the [JsonPlaceholder](https://jsonplaceholder.typicode.com/) service. I use this service all the time and decided to create a Spring Boot Starter for it. Now instead of having to create an instance of the `RestClient`, configure it and then talk to each of the endpoints you can just use this starter and start making requests.


## Getting Started

To use this starter you will need to add the following dependency to your project.

```xml
<dependency>
    <groupId>dev.danvega</groupId>
    <artifactId>jps-spring-boot-starter</artifactId>
    <version>0.0.3-SNAPSHOT</version>
</dependency>
```

And configure the following properties in your `application.properties` file. The reason I made this a setting is because you might
want to run JsonPlaceHolder Service locally or in a different environment. If you don't configure one the default will be used.

```properties
json-placeholder-service.base-url=https://jsonplaceholder.typicode.com
```

## What's next 

I plan on adding more features to this starter in the future to support all of the JsonPlaceholder endpoints. In the meantime if you
have any questions or requests please feel free to open an issue or a pull request.

## References

- [JsonPlaceholder](https://jsonplaceholder.typicode.com/)
- [Spring Boot Starters](https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-starter)