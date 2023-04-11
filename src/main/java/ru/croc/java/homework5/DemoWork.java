package ru.croc.java.homework5;

import java.util.Scanner;

public class DemoWork {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("1. Add task");
            System.out.println("2. Edit task");
            System.out.println("3. Delete task");
            System.out.println("4. View tasks");
            System.out.println("5. Exit");

            int choice = Integer.parseInt(input.nextLine());
            switch (choice){
                case 1:{
                    System.out.print("Enter code: ");
                    String code = input.nextLine();

                    System.out.print("Enter name: ");
                    String name = input.nextLine();

                    System.out.print("Enter description: ");
                    String description = input.nextLine();

                    System.out.print("Enter executor: ");
                    String executor = input.nextLine();

                    System.out.print("Enter status: ");
                    String status = input.nextLine();

                    Task task = new Task(code, name, description, executor, status);
                    if(taskManager.addTask(task)){
                        System.out.println("Task successfully added");
                    }
                    else {
                        System.out.println("Error when adding a task, check the correctness of the entered values");
                    }
                    break;
                }
                case 2:{
                    System.out.print("Enter code of task to edit: ");
                    String code = input.nextLine();
                    if (!taskManager.containsTask(code)){
                        System.out.println("There is no task under this number");
                        break;
                    }

                    System.out.print("Enter new code: ");
                    String newCode = input.nextLine();

                    System.out.print("Enter name: ");
                    String newName = input.nextLine();

                    System.out.print("Enter description: ");
                    String newDescription = input.nextLine();

                    System.out.print("Enter executor: ");
                    String newExecutor = input.nextLine();

                    System.out.print("Enter status: ");
                    String newStatus = input.nextLine();

                    Task task = new Task(newCode, newName, newDescription, newExecutor, newStatus);

                    if(taskManager.editTask(code, task)){
                        System.out.println("Task successfully edit");
                    }
                    else {
                        System.out.println("Error when editing the task, check the correctness of the entered values");
                    }
                    break;
                }
                case 3:{
                    System.out.print("Enter code of task to delete: ");
                    String code = input.nextLine();

                    if(taskManager.deleteTask(code)){
                        System.out.println("Task successfully delete");
                    }
                    else {
                        System.out.println("Error when deleting the task, check the correctness of the entered values");
                    }
                    break;
                }
                case 4:{
                    System.out.println("All tasks");
                    System.out.println(taskManager.allTasks());
                    break;
                }
                case 5:{
                    return;
                }
                default:{
                    System.out.println("Incorrect choice");
                    break;
                }
            }
        }
    }
}