In essence, a design pattern is about describing a reusable
solution to a problem when given a specific context. Using a tried and tested
solution from a design pattern can save a lot of time and increase the quality of the
implementation compared to spending time on inventing the solution ourselves.

### Some Examples of Design Pattern in Microservices

1. Service Discovery
2. Edge Server
3. Reactive Microservices
4. Central Configuration
5. Centralized Log Analysis
6. Distributed tracing
7. Circuit breaker
8. Control loop
9. Centralized monitoring and alarms

We will use a lightweight approach to describing design patterns, and focus on the
following:
* The problem
* A solution
* Requirements for the solution

# Service Discovery
### Problem
How can clients find microservices and their instances?

Microservices instances are typically assigned dynamically allocated IP addresses
when they start up, for example, when running in containers. This makes it difficult
for a client to make a request to a microservice that, for example, exposes a REST API
over HTTP.

### Solution

Add a new component - a **service discovery** service - to the system landscape, which keeps track of currently available microservices and the IP addresses of its instances.

### Solution Requirements

* Automatically register/unregister microservices and their instances as they come and go.
* The client must be able to make a request to a logical endpoint for the microservice. The request will be routed to one of the available microservice
* Requests to a microservice must be load-balanced over the available instances
* We must be able to detect instances that are currently unhealthy, so that requests will not be routed to them.

Later in this book this design pattern is implemented using two different strategies:

* Client Side routing: The client uses a library that communicates with the
  service discovery service to find out the proper instances to send the requests
  to
* Server-side routing: The infrastructure of the service discovery service
  also exposes a reverse proxy that all requests are sent to. The reverse proxy
  forwards the requests to a proper microservice instance on behalf of the
  client.


# Edge Server
### Problem
In a system landscape of microservices, it is in many cases desirable to expose some
of the microservices to the outside of the system landscape and hide the remaining
microservices from external access. The exposed microservices must be protected
against requests from malicious clients.

### Solution
Add a new component, an edge server, to the system landscape that all incoming
requests will go through

Implementation notes: An edge server typically behaves like a reverse proxy and
can be integrated with a discovery service to provide dynamic load-balancing
capabilities.

### Solution Requirements
* Hide internal services that should not be exposed outside their context; that
is, only route requests to microservices that are configured to allow external
requests
* Expose external services and protect them from malicious requests; that is,
use standard protocols and best practices such as OAuth, OIDC, JWT tokens,
and API keys to ensure that the clients are trustworthy


# Reactive microservices
### Problem 
Traditionally, as Java developers, we are used to implementing synchronous
communication using blocking I/O, for example, a RESTFUL JSON API over HTTP.
Using a blocking I/O means that a thread is allocated from the operating system
for the length of the request. If the number of concurrent requests goes up, a server
might run out of available threads in the operating system, causing problems ranging
from longer response times to crashing servers. Using a microservice architecture
typically makes this problem even worse, where typically a chain of cooperating
microservices is used to serve a request. The more microservices involved in serving
a request, the faster the available threads will be drained.

### Solution
Use non-blocking I/O to ensure that no threads are allocated while waiting for
processing to occur in another service, that is, a database or another microservice.

### Solution Requirements
* Whenever feasible, use an asynchronous programming model, sending
  messages without waiting for the receiver to process them.
* If a synchronous programming model is preferred, use reactive frameworks
  that can execute synchronous requests using non-blocking I/O, without
  allocating a thread while waiting for a response. This will make the
  microservices easier to scale in order to handle an increased workload
* Microservices must also be designed to be resilient and self-healing. Resilient
  meaning being capable of producing a response even if one of the services
  it depends on fails; self-healing meaning that once the failing service is
  operational again, the microservice must be able to resume using it.

# Central Configuration
### Problem
An application is, traditionally, deployed together with its configuration, for example, a set of environment variables and/or files containing configuration information. Given a system landscape based on a microservice architecture, that is, with a large number of deployed microservice instances, some queries arise:

* How do I get a complete picture of the configuration that is in place for all the running microservice instances?
* How do I update the configuration and make sure that all the affected microservice instances are updated correctly?

### Solution
Add a new component, a central configuration service, to the system landscape that will store the configuration of all the microservices. The microservices will then query the central configuration service for their configuration when they start up.

### Solution Requirements
Make it possible to store configuration information for a group of microservices in one place, with different settings for different environments, for example, development, test, and production.

# Centralized Log Analysis
### Problem
Traditionally, an application rites log events to log files that are stored in the local filesystem of the server that the application runs on. Given a system landscape based on a microservice architecture, with a large number of deployed microservice instances on a large number of smaller servers, we can ask the following questions:

* How do I get an overview of what is going on in the system landscape when each microservice instance writes to its own local log file
* How do I find out if any of the microservice instances get into trouble and start writing error messages to their log files?
* If end users start to report problems, how can I find related log messages; that is, how can I identify which microservice instance is the oot cause of the problem

### Solution
Add a new component that can manage centralized logging and is capable of the
following:
*  Detecting new microservice instances and collecting log events from them
*  Interpreting and storing log events in a structured and searchable way in a
central database
*  Providing APIs and graphical tools for querying and analyzing log events

### Solution Requirements
* Microservices stream log events to standard system output, stdout. This
makes it easier for a log collector to find the log events compared to when log
events are written to microservice-specific logfiles.
* Microservices tag the log events with the correlation ID described in the next
section regarding the Distributed tracing design pattern.
* A canonical log format is defined, so that log collectors can transform log
events collected from the microservices to a canonical log format before log
events are stored in the central database. Storing log events in a canonical log
format is required to be able to query and analyze the collected log events.

# Distributed tracing
### Problem
It must be possible to track requests and messages that flow between microservices while processing an external request to the system landscape.

Some examples of fault scenarios are as follows:
* If end users start to file support cases regarding a specific failure, how can we identify the microservice that caused the problem, that is, the rot cause.
* If one support case mentions problems related to a specific entity, for example, a specific order number, how can we find log messages related to processing this specific order - for instance, log messages from all microservices that have been involved in processing the order.
* If end users start to file support cases regarding an unacceptably long
  response time, how can we identify which microservice in a call chain is
  causing the delay?

### Solution
To track the processing between cooperating microservices, we need to ensure that
all related requests and messages are marked with a common correlation ID and
that the correlation ID is part of all log events. Based on a correlation ID, we can use
the centralized logging service to find all related log events. If one of the log events
also includes information about a business-related identifier, for example, the ID of
a customer, product, or order, we can find all related log events for that business
identifier using the correlation ID.
To be able to analyze delays in a call chain of cooperating microservices, we must be
able to collect timestamps for when requests, responses, and messages enter and exit
each microservice.

### Solution Requirements
* Assign unique correlation IDs to all incoming or new requests and events in
  a well-known place, such as a header with a standardized name
* When a microservice makes an outgoing request or sends a message, it must
  add the correlation ID to the request and message
* All log events must include the correlation ID in a predefined format so that
  the centralized logging service can extract the correlation ID from the log
  event and make it searchable
* Trace records must be created for when requests, responses, and messages
  both enter or exit a microservice instance


# Circuit breaker
### Problem
A system landscape of microservices that uses synchronous intercommunication can be exposed to a chain of failures. If one microservice stops responding, its clients
might get into problems as well and stop responding to requests from their clients.
The problem can propagate recursively throughout a system landscape and take out
major parts of it.
This is especially common in cases where synchronous requests are executed using
blocking I/O, that is, blocking a thread from the underlying operating system while
a request is being processed. Combined with a large number of concurrent requests
and a service that starts to respond unexpectedly slowly, thread pools can quickly
become drained, causing the caller to hang and/or crash. This failure can spread
unpleasantly quickly to the caller's caller, and so on.

### Solution
Add a circuit breaker that prevents new outgoing requests from a caller if it detects a
problem with the service it calls.

### Solution Requirements
* Open the circuit and fail fast (without waiting for a timeout) if problems with
  the service are detected.
* Probe for failure correction (also known as a half-open circuit); that is, allow
  a single request to go through on a regular basis to see whether the service is
  operating normally again.
* Close the circuit if the probe detects that the service is operating normally
  again. This capability is very important since it makes the system landscape
  resilient to these kinds of problems; in other words, it self-heals

# Control loop
### Problem
In a system landscape with a large number of microservice instances spread out over
a number of servers, it is very difficult to manually detect and correct problems such
as crashed or hung microservice instances.

### Solution
Add a new component, a control loop, to the system landscape.

### Solution Requirements
The control loop will constantly observe the actual state of the system landscape, comparing it with a desired state,
as specified by the operators. If the two states differ, it will take actions to make the actual state equal to the 
state.

In the world of containers, a container orchestrator such as Kubernetes can be used to implement a control loop.

# Centralized monitoring and alarms
### Problem
If observed response times and/or the usage of hardware resources become
unacceptably high, it can be very hard to discover the root cause of the problem.
For example, we need to be able to analyze hardware resource consumption per
microservice.

### Solution
To curb this, we add a new component, a monitor service, to the system landscape,
which is capable of collecting metrics about hardware resource usage for each
microservice instance level.

### Solution Requirements
* It must be able to collect metrics from all the servers that are used by the
system landscape, which includes autoscaling servers
* It must be able to detect new microservice instances as they are launched on
the available servers and start to collect metrics from them
* It must be able to provide APIs and graphical tools for querying and
analyzing the collected metrics
* It must be possible to define alerts that are triggered when a specified metric
exceeds a specified threshold value

page 28