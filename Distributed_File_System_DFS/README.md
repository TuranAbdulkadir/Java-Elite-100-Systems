# 📂 004_Distributed_File_System (DFS)

## 📌 Project Overview
A distributed file storage system inspired by **Hadoop HDFS**. Files are split into chunks and replicated across multiple "DataNodes" to prevent data loss upon server failure.

## 🛠️ Architecture
* **Nodes:** NameNode (Metadata) + DataNodes (Storage)
* **Logic:** Chunking & Replication
* **Fault Tolerance:** High