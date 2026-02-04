# Web_Crawler_MultiThreaded

## Project Overview
A multi-threaded **Web Crawler (Spider)**. It starts from a seed URL, downloads the page, extracts all hyperlinks, and recursively visits them using a Thread Pool, mimicking how search engines index the web.

## Tech Stack
* **Concurrency:** ExecutorService
* **Structure:** ConcurrentHashMap (Visited URLs)