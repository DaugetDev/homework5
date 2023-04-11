package ru.croc.java.homework5;

import org.junit.jupiter.api.*;

public class TaskManagerTest {


    /**
     * Попытка добавить null
     */

    @Test
    public void testAddingNulLElement(){
        TaskManager testTaskManager = new TaskManager();
        testTaskManager.addTask(null);
        Assertions.assertEquals("", testTaskManager.allTasks());
        testTaskManager.deleteAllTasks();
    }

    /**
     * Попытка удалить несуществующий
     */

    @Test
    public void testDeletingNonExistentElement(){
        TaskManager testTaskManager = new TaskManager();
        testTaskManager.addTask(new Task("1", "task1", "first task", "123", "in process"));
        testTaskManager.deleteTask("2");
        Assertions.assertEquals("code - 1; name - task1; description - first task; executor - 123; status - in process;", testTaskManager.allTasks());
        testTaskManager.deleteAllTasks();
    }

    /**
     * Запрос списка задач, когда он пустой
     */

    @Test
    public void testEmptyListRequest(){
        TaskManager testTaskManager = new TaskManager();
        Assertions.assertEquals("", testTaskManager.allTasks());
        testTaskManager.deleteAllTasks();
    }

    /**
     * Иммитация нормальной работы
     */

    @Test
    public void testNormalWork(){
        TaskManager testTaskManager = new TaskManager();
        testTaskManager.addTask(new Task(
                "1", "task 1", "task", "Alesha", "in progress"));
        testTaskManager.addTask(new Task(
                "2", "task 2", "task", "Pasha", "in progress"));
        testTaskManager.addTask(new Task(
                "3", "task 3", "task", "Alesha", "complete"));
        testTaskManager.addTask(new Task(
                "4", "task 4", "task", "Pasha", "in progress"));
        testTaskManager.addTask(new Task(
                "5", "task 5", "task", "Alesha", "complete"));
        testTaskManager.addTask(new Task(
                "6", "task 6", "task", "Pasha", "complete"));
        testTaskManager.addTask(new Task(
                "7", "task 7", "task", "Alesha", "in progress"));
        Assertions.assertEquals(
                "code - 1; name - task 1; description - task; executor - Alesha; status - in progress;\n" +
                "code - 2; name - task 2; description - task; executor - Pasha; status - in progress;\n" +
                "code - 3; name - task 3; description - task; executor - Alesha; status - complete;\n" +
                "code - 4; name - task 4; description - task; executor - Pasha; status - in progress;\n" +
                "code - 5; name - task 5; description - task; executor - Alesha; status - complete;\n" +
                "code - 6; name - task 6; description - task; executor - Pasha; status - complete;\n" +
                "code - 7; name - task 7; description - task; executor - Alesha; status - in progress;",
                testTaskManager.allTasks());
        testTaskManager.deleteTask("2");
        testTaskManager.editTask(
                "3", new Task("8", "task 8", "task", "Alesha", "complete"));
        Assertions.assertEquals(
                "code - 1; name - task 1; description - task; executor - Alesha; status - in progress;\n" +
                "code - 8; name - task 8; description - task; executor - Alesha; status - complete;\n" +
                "code - 4; name - task 4; description - task; executor - Pasha; status - in progress;\n" +
                "code - 5; name - task 5; description - task; executor - Alesha; status - complete;\n" +
                "code - 6; name - task 6; description - task; executor - Pasha; status - complete;\n" +
                "code - 7; name - task 7; description - task; executor - Alesha; status - in progress;",
                testTaskManager.allTasks());
        testTaskManager.deleteAllTasks();
    }
}
