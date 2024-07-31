## Microservices Monitoring

Monitoring is the control system of the microservice. As the microservices are more, it becomes harder to understand its performance and troubleshoot the problems. Given the vivid changes to software delivery, it is required to monitor the service. There are **five** principles of monitoring microservices, as seen below:

1. Monitory container and what's inside them
2. Alert on service performance
3. Monitor services that are elastic and multi location
4. Monitor APIs
5. Monitor the organizational structure

These principles allow us to address technological changes associated with the microservices and organizational changes related to them.

### Microservice Monitoring Tool
There are three monitoring tools as follows

1. Hystrix dashboard
2. Eureka admin dashboard
3. Spring boot admin dashboard


#### Microservice Virtualization
Microservices virtualization is the method to simulate the behavior of specific components in various component-based application like cloud-based application, SOA, and API driven architecture. Service virtualization also reduces cost and save time. By combining service virtualization, an organization can develop the application which can be delivered from various locations and dissimilar environments.


#### Spring Software Enablers of Microservices
1. **Spring Cloud Config Server**: This provides the HTTP resource-based API for external configuration in the distributed system. We can enable the Spring Cloud config server by using the annotation `@EnableConfigServer`

2. **Netflix Eureka Naming Server**: This is a service discovery server. It provides the REST interface to the outside for communication. A microservice after coming up, registers itself as a discovery client. The Eureka server also has another software module called Eureka Client - which interacts with the Eureka server for service discovery. The Eureka Client also balances the client requests

3. **Hystrix Server**: This acts as a fault tolerant robust system. It is used to avoid complete failure of an application. It does this by using the **Circuit Breaker Mechanism**. if the application is running without any issue, the circuit remains closed. If there is an error encountered in the application, the Hystrix Server opens the circuit. The Hystrix server stops the further requests from calling the service. 

4. **Netflix Zuul API Gateway Server**: This is a gateway server from where all the client requests pass through. It acts as a unified interface to a client. It also has an inbuilt load balancer to balance the load of all incoming client requests.

5. **Netflix Ribbon**: This is the client side Inter-Process Communication(IPC) library. It provides the client-side balancing algorithm. It uses a Round Robin Load Balancing Algorithm. It provides fault tolerance, load balancing, multiple protocols, caching and batching etc.