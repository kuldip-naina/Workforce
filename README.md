# Workforce
A simple in-memory Workforce Management API built for the Railse Backend Engineer Challenge. Includes task creation, assignment, smart daily view, priority filtering, and activity tracking features.

The system allows managers to create and assign tasks to staff, track progress, filter by priority, view smart daily task lists, and maintain activity and comment history — all using plain Java, without any database.

---

## 🚀 Features

- Create and assign tasks to staff
- Reassign tasks (automatically cancels old task)
- Hide cancelled tasks in fetch responses
- Smart daily view: includes open and ongoing tasks
- Set and update task priority (HIGH, MEDIUM, LOW)
- Add and view task comments
- View full activity history for each task

---

## 🛠 Tech Stack

- Java 17
- No frameworks (pure Java)
- Data stored in memory using `Map` and `List`
- JSON input/output via manual parsing

---

## 🔧 How to Run the Project (Locally)

1. Open the project in **Visual Studio Code** (or any Java-supported IDE)
2. Make sure Java 17+ is installed and configured
3. Navigate to `src/` folder
4. Run `Main.java`
5. Use any API tool like **Postman** to interact with the endpoints

---

## 📁 Folder Structure

workforce-management-api/
├── src/
│ ├── controller/
│ ├── model/
│ ├── service/
│ ├── dto/
│ └── Main.java
├── README.md
└── SUBMISSION.txt
