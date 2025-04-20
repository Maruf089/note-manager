# note-manager
# 🗒️ Note Manager

A simple Java console application to manage personal notes. This project is designed to showcase modern features introduced in **Java 11–14**.

---

## 🚀 Features

- Create, save, and view notes
- Auto-save notes to text files
- Display note statistics (count & average length)
- Built using features from Java 11 to 14

---

## 🛠 Java Features Used

| Java Version | Feature                              | Usage                        |
|--------------|--------------------------------------|------------------------------|
| **Java 11**  | `Files.writeString/readString`       | Read/write note files        |
|              | New String methods (`strip`, etc.)   | Trim user input              |
|              | `var`                                | Local variable inference     |
| **Java 12**  | `Collectors.teeing`                  | Note statistics              |
| **Java 14**  | Nicer `switch` syntax (non-preview)  | Menu input handling          |

---

## 📦 Setup

### Prerequisites
- Java **14**
- Maven **3.6+**

### Clone and Run

```bash
git clone https://github.com/your-username/note-manager.git
cd note-manager
mvn compile exec:java
