# Circuit_Breaker_Pattern

## Project Overview
An implementation of the **Circuit Breaker Design Pattern**. It prevents cascading failures in microservices by monitoring error rates. If a service fails too often, the "circuit opens" to stop requests immediately.

## States
* **CLOSED:** Normal operation
* **OPEN:** Fails immediately (Safety mode)
* **HALF-OPEN:** Testing if service recovered