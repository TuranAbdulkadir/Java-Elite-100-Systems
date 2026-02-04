# Search_Engine_Inverted_Index

## Project Overview
A core search engine component. It builds an **Inverted Index** mapping words to the documents they appear in. This allows for O(1) retrieval of search results, unlike O(n) linear scanning.

## Tech Stack
* **Structure:** HashMap<Word, List<DocID>>
* **Complexity:** O(1) Lookup