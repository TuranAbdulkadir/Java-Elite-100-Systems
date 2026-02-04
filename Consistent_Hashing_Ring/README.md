# Consistent_Hashing_Ring

## Project Overview
A load balancing algorithm used in distributed caches (like DynamoDB, Cassandra). It maps both data and servers onto a circular ring, minimizing data movement when servers are added or removed.

## Tech Stack
* **Structure:** SortedMap (Ring)
* **Logic:** Hash Space Partitioning