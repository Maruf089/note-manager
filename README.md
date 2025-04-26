# 📝 Note Manager (Java 11–17)

A simple Java console application to manage personal notes. This project is designed to showcase modern features introduced in **Java 11–17**.

---
📁 Project Structure
-----
![Image](https://github.com/user-attachments/assets/3b9f5596-da0c-40bd-b275-fbcbcfa18e75)




## 🚀 Features

- Create, save, and view notes
- Auto-save notes to text files
- Display note statistics (count & average length)
- Built using features from Java 11 to 17

## ✨ Modified Features

- ✅ Create and manage different types of notes:
  - **TextNote** – simple text-based notes
  - **ChecklistNote** – list of items to tick off
  - **ReminderNote** – notes with a datetime reminder
- ✅ Use of **sealed interfaces** to define note types (Java 17)
- ✅ Modernized menu and note output using **text blocks** (Java 15)
- ✅ Smart type handling via **pattern matching for instanceof** (Java 16)
- ✅ Enhanced **switch expressions** for clean logic (Java 17)
- ✅ Immutable list views using `List.copyOf()`

---

## 🛠 Java Features Used

| Java Version | Feature                              | Usage                        |
|--------------|--------------------------------------|------------------------------|
| **Java 11**  | `Files.writeString/readString`       | Read/write note files        |
|              | New String methods (`strip`, etc.)   | Trim user input              |
|              | `var`                                | Local variable inference     |
| **Java 12**  | `Collectors.teeing`                  | Note statistics              |
| **Java 14**  | Nicer `switch` syntax (non-preview)  | Menu input handling          |
| 16           | Pattern Matching for `instanceof`    | Type-safe note handling                 |
| 17           | Sealed Classes                       | Base note type with controlled subtypes |
| 17           | Enhanced Switch Expressions          | Simplified control flows                |

---

## 📦 Setup

### Prerequisites
- Java **17+**
- Maven **3.6+**

### Clone and Run

```bash
git clone https://github.com/your-username/note-manager.git
cd note-manager
mvn compile exec:java

## 🏗️ Updated Project Structure


note-manager/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/
                └── example/
                    └── notemanager/
                        ├── Note.java
                        ├── TextNote.java
                        ├── ChecklistNote.java
                        ├── ReminderNote.java
                        ├── NoteManager.java
                        └── NoteApp.java


