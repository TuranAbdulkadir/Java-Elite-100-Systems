# ⚡ 006_HTTP2_Protocol_Parser

## 📌 Project Overview
A raw byte parser for the HTTP/2 binary protocol. Unlike HTTP/1.1 (text), HTTP/2 uses binary framing. This tool decodes standard **Frame Headers** for high-performance servers.

## 🛠️ Architecture
* **Format:** Binary Framing Layer
* **Components:** Length, Type, Flags, Stream ID