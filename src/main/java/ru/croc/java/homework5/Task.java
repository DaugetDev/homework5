package ru.croc.java.homework5;

import java.io.Serializable;

public class Task implements Serializable {
    /**
     * Код задачи
     */
    private String code;
    /**
     * Наименование задачи
     */
    private String name;
    /**
     * Описание задачи
     */
    private String description;
    /**
     * Исполнитель задачи
     */
    private String executor;
    /**
     * Статус задачи
     */
    private String status;

    /**
     * Создание задачи
     * @param code Код задачи
     * @param name Наименование задачи
     * @param description Описание задачи
     * @param executor Исполнитель задачи
     * @param status Статус задачи
     */

    public Task(String code, String name, String description, String executor, String status) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.executor = executor;
        this.status = status;
    }

    /**
     * Изменение параметров задачи
     * @param taskWithNewParameters Задача с новыми параметрами
     */

    public void changeParameters(Task taskWithNewParameters) {
        if(taskWithNewParameters == null){
            throw new NullPointerException();
        }
        this.code = taskWithNewParameters.code;
        this.name = taskWithNewParameters.name;
        this.description = taskWithNewParameters.description;
        this.executor = taskWithNewParameters.executor;
        this.status = taskWithNewParameters.status;
    }

    /**
     * Получение кода
     * @return Код задачи
     */

    public String getCode() {
        return code;
    }

    /**
     * Получение имени задачи
     * @return Имя задачи
     */

    public String getName() {
        return name;
    }

    /**
     * Получение описания
     * @return Описание задачи
     */

    public String getDescription() {
        return description;
    }

    /**
     * Получение исполнителя
     * @return Исполнитель задачи
     */

    public String getExecutor() {
        return executor;
    }

    /**
     * Получение статуса
     * @return Статус задачи
     */

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "code - " + code +
                "; name - " + name +
                "; description - " + description +
                "; executor - " + executor +
                "; status - " + status + ";";
    }
}
