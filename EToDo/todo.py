"""
Input values:
1. Add Task
2. Edit Task
3. Delete Task
4. Exit
Select an option: 1
Enter task: Buy groceries
Output value:
Task added successfully.
Input values:
1. Add Task
2. Edit Task
3. Delete Task
4. Exit
Select an option: 2
Enter task index to edit: 1
Enter new task: Buy weekly groceries
Output value:
Task edited successfully.
Input values:
1. Add Task
2. Edit Task
3. Delete Task
4. Exit
Select an option: 3
Enter task index to delete: 1
Output value:
Task deleted successfully.
Input values:
1. Add Task
2. Edit Task
3. Delete Task
4. Exit
Select an option: 4
"""

tasks = []

def displayMenu():
    print("\nInput Values")
    print("1. Add Task")
    print("2. Edit Task")
    print("3. Delete Task")
    print("4. Exit")

while True:
    displayMenu()

    choice = int(input("Select an option: "))

    if choice == 1:
        task = input("Enter task: ")
        tasks.append(task)
        print("Task added successfully.")

    elif choice == 2:
        taskIndex = int(input("Enter task index to edit: ")) - 1
        print(str(taskIndex + 1) + ". " + tasks[taskIndex])
        tasks[taskIndex] = input("Enter new task: ")
        print("Task edited successfully.")

    elif choice == 3:
        taskIndex = int(input("Enter task index to delete: ")) - 1
        print(str(taskIndex + 1) + ". " + tasks[taskIndex])
        tasks.pop(taskIndex)
        print("Task deleted successfully.")

    elif choice == 4:
        print("Exiting...")
        break