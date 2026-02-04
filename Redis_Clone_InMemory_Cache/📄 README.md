# 🚀 010_Redis_Clone_InMemory_Cache

## 📌 Project Overview
A lightweight Key-Value store that keeps data in **RAM (Heap)** for microsecond access times, simulating Redis. Includes basic `SET`, `GET` commands and hypothetical disk snapshots.

## 🛠️ Architecture
* **Storage:** ConcurrentHashMap
* **Speed:** O(1) Access Time