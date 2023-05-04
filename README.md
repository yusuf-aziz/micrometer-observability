# Observability with Micrometer and Zipkin
This project demonstrates how to use Micrometer and Zipkin to achieve observability in a Spring Boot application.

In order to achieve observability, there are two important aspects: tracing and metrics.

 - **Tracing** helps you understand **what** happened in your application. This includes things like remote calls made, web requests processed, and database accesses.


 - **Metrics** help you understand how long it took for things to happen. Metrics provide information about things like the number of requests, response times, and error rates.

Micrometer is a tool that provides a unified way to collect and report application metrics. It has a concept called an "Observation" which lets you see what has happened during a key operation, such as a web request or a database access.

Zipkin is an open source distributed tracing system that allows you to trace requests as they flow through a distributed system.

This project shows how to configure a Spring Boot application to use Micrometer and Zipkin for tracing and metrics.

## Running Zipkin
In order to make tracing work, you need to run your own copy of Zipkin. You can do this easily with Docker by executing the following command:

```
docker run -d -p 9411 openzipkin/zipkin:latest
```

## Configuring Spring Boot
To configure your Spring Boot application for tracing, add the following attribute to your application.properties file:

```
#Trace every action
management.tracing.sampling.probability=1.0
```

By default, Micrometer only traces 10% of the time, so we set the sampling probability to 1.0 to trace every action.

## Tracing a database application
To trace a database application, we need to add a few additional dependencies to our project. We need to include Spring Boot Actuator, Micrometer, and its bridge for Zipkin.

We also need to add a special module called **datasource-micrometer-spring-boot** which will wrap any DataSource bean with a proxy that uses Micrometer APIs to log actions.

Once we have these dependencies, we can use Micrometer to trace any relational database application.

## Conclusion
Observability is an important aspect of modern application development. By using Micrometer and Zipkin, we can achieve observability in our applications by collecting and reporting metrics and tracing requests as they flow through a distributed system. This project demonstrates how to configure a Spring Boot application to use Micrometer and Zipkin for tracing and metrics.
