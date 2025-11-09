# File System Simulation (Java)

This project simulates a **file system** using a **tree data structure** in Java.  
It allows you to **create folders**, **create files**, **delete items**, **search using DFS**, and **display the structure** as a hierarchical tree.

---

## 📁 Project Structure

```
File_System_Simulation/
│
├─ filesystem/
│   ├─ FileSystem.java      # Handles file system operations (create, delete, display, search)
│   └─ Node.java            # Represents a file or folder in the tree
│
├─ FileSystemApp.java       # Main program providing the user interface
└─ README.md                # Project documentation
```

---

## ✅ Features

| Feature | Description |
|--------|-------------|
| Create Folder | Create new directories under existing ones |
| Create File | Create files inside folders |
| Display Structure | Shows directory tree with indentation |
| Delete | Deletes files and empty folders safely |
| Search (DFS) | Search files/folders by name using Depth First Search |
| Path-Based Access | Operations use full paths like `/root/docs/file.txt` |

---

## ▶️ How to Compile

Open terminal inside **File_System_simulation** folder and run:

### Windows:
```
javac -d out src\filesystem\*.java src\app\FileSystemApp.java
```

### Mac/Linux:
```
javac -d out src/filesystem/*.java src/app/FileSystemApp.java
```

---

## ▶️ How to Run

```
java -cp out app.FileSystemApp
```

---

## 💻 Example Usage

```
--------File System Simulation--------
1. Create Folder
2. Create File
3. Delete
4. Display
5. Search (DFS)
6. Exit
Enter an option: 1
Enter parent folder path (e.g., /root): /root
Folder name: documents
Folder created: /root/documents
```

---

## 🧠 Concepts Used

- Tree Data Structure
- Node Representation (Parent / Children Structure)
- Depth First Search (DFS)
- String Path Parsing
- Menu-driven CLI Program

---

## 🙌 Authors

This project was developed as part of a **Data Structures / Java Programming / AI** assignment by Shravya, Kiran and Pranjal.

Feel free to modify and improve ✨
