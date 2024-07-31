### Microservice Architecture
Well, a microservice architecture enables large teams to build scalable applications that are composed of many loosely coupled services.

Each microservice has its own database. For example, product service has its own database, inventory service has its own database, and stock service has its own database. 

In the microservices project, all the microservices are loosely coupled. So loosely coupled, meaning all the services in a microservices project are independent of each other and each microservice should be developed independently and each microservice should be deployed independently and each microservice should be scaled independently. 

So basically, a microservice has the below characteristics

1. Each microservice can have its own database. 
2. Each microservice should be developed independently
3. Each microservice should be deployed independently
4. Each microservice should be scaled independently

In microservices projects, the services can communicate with each other. For example, product service can communicate with inventory service and inventory service can communicate with stock service.  Microservice can communicate with multiple services as well. 

Well, there are two types of communication styles. One is synchronous and another is asynchronous. 

In the case of **synchronous**, we can use the HTTP protocol to make an HTTP request from one microservice to the microservice. 

And in the case of **asynchronous** communication, we have to use a message broker for asynchronous communication between multiple microservices. For example, we can use a RabbitMQ or Apache Kafka as a message broker in order to make an asynchronous communication between multiple microservices and each microservice in a microservices project can expose REST API's.


#### Key Components in a Microservices Architecture

1. The key component is the **API gateway**, whenever the client sends a request to the API gateway, the API gateway will route that request to the relevant microservice.

2. Another key component is the **service registry**. All the microservices will have to register to a service registry, and the API gateway will discover the particular microservice hostname and port using the service registry so that the API gateway can allow that request to a particular microservice

3. One more key component is the **config server**. So this config server component will basically externalize the configuration of microservices. 

4. One more key component is **distributed tracing**. Well, in order to maintain the logs or complete log hierarchy for a particular HTTP call from start to end, we can use distributed tracing. 

5. One more key component is **Security**. We can implement centralized security in API-Gateway.