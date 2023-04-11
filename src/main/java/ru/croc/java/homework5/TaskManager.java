package ru.croc.java.homework5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Менеджкр задач
 */
public class TaskManager {

    /**
     * Список, содержащий все задачи
     */
    private final List<Task> tasks = new ArrayList<>();

    /**
     * Файл в котором хранятся задачи
     */

    private final File saveFile;

    /**
     * Создание менеджера задач
     */
    public TaskManager() {
        String filePath = getClass().getClassLoader().getResource("").getPath() + "SaveFiles";
        new File(filePath).mkdir();
        saveFile = new File(filePath + "/saveTasks.dat");
        try {
            saveFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        loadTasks();
    }

    /**
     * Проверка наличия задачи
     *
     * @param code код задачи
     * @return Наличие задачи в списке
     */

    public boolean containsTask(String code) {
        for (var task : tasks) {
            if (task.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Добавление задачи
     *
     * @param task Задача, которая будет добавлена
     * @return успешность добавления
     */

    public boolean addTask(Task task) {
        if (Objects.isNull(task)) {
            return false;
        }
        tasks.add(task);
        saveTasks();
        return true;
    }

    /**
     * изменяет существующую задачу
     *
     * @param code                  код задачи, которая будет изменена
     * @param taskWithNewParameters Задача из которой будут взяты новые параметры
     * @return Успешность операции
     */

    public boolean editTask(String code, Task taskWithNewParameters) {
        if (Objects.isNull(taskWithNewParameters)) {
            return false;
        }
        for (var task : tasks) {
            if (task.getCode().equals(code)) {
                task.changeParameters(taskWithNewParameters);
                saveTasks();
                return true;
            }
        }
        return false;
    }

    /**
     * Удаляет задачу
     *
     * @param code код задачи которую надо удалить
     * @return успешность опериции
     */

    public boolean deleteTask(String code) {
        if (Objects.isNull(code)) {
            return false;
        }
        for (var it = tasks.iterator(); it.hasNext(); ) {
            Task task = it.next();
            if (task.getCode().equals(code)) {
                it.remove();
                saveTasks();
                return true;
            }
        }
        return false;
    }

    /**
     * Предоставляет всю информацию о задачах
     *
     * @return Строка с информацией о задачах
     */

    public String allTasks() {
        if (tasks.size() == 0) {
            return "";
        }
        StringBuilder report = new StringBuilder();
        tasks.forEach(x -> report.append(x).append('\n'));
        return report.substring(0, report.length() - 1);
    }

    /**
     * Метод, который сохраняет информацию о задачах в файл
     */

    private void saveTasks() {
        try (OutputStream outputStream = new FileOutputStream(saveFile);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(tasks);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка сохранения файла");
        }
    }

    public void deleteAllTasks() {
        tasks.clear();
        saveTasks();
    }

    /**
     * Метод который подгружает зачади из файла
     */

    private void loadTasks() {
        try (InputStream inputStream = new FileInputStream(saveFile);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            tasks.addAll((List<Task>) objectInputStream.readObject());
        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка загрузки файла");
        }
    }

}
