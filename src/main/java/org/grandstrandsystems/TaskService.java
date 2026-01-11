package org.grandstrandsystems;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the storage and manipulation of Task objects.
 * <p>
 * This service uses an in-memory data structure (HashMap) to store tasks.
 * It provides functionality to add, delete, and update specific fields of a task,
 * while enforcing uniqueness based on the Task ID.
 * </p>
 *
 * @author Alan Abraham
 * @version 1.0
 * @since 1/6/2026
 */
public class TaskService {

    // In-memory storage for tasks. Key is the Task ID.
    private final Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task to the service.
     * <p>
     * Ensures that the task object is not null and that the task ID is unique
     * before adding it to the storage.
     * </p>
     *
     * @param task The Task object to be added.
     * @throws IllegalArgumentException if the task is null or if a task with the same ID already exists.
     */
    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null!");
        }
        if (tasks.containsKey(task.getId())) {
            throw new IllegalArgumentException("Tasks already exists!");
        }
        tasks.put(task.getId(), task);
    }

    /**
     * Deletes a task by its ID.
     *
     * @param id The unique ID of the task to delete.
     * @return {@code true} if the task was found and deleted; {@code false} otherwise.
     */
    public boolean deleteTask(String id) {
        Task task = getTask(id);
        if (task == null) {
            return false;
        }
        tasks.remove(id);
        return true;
    }

    /**
     * Updates the name of an existing task.
     *
     * @param id   The unique ID of the task to update.
     * @param name The new name (must validate against Task rules).
     * @throws IllegalArgumentException if the Task ID is null or the task is not found.
     */
    public void updateName(String id, String name) {
        if (id == null) {
            throw new IllegalArgumentException("Task Id cannot be null!");
        }
        Task task = getTask(id);
        if (task == null) {
            throw new IllegalArgumentException("Task does not exist!");
        }
        task.setName(name);
    }

    /**
     * Updates the description of an existing task.
     *
     * @param id          The unique ID of the task to update.
     * @param description The new description (must validate against Task rules).
     * @throws IllegalArgumentException if the Task ID is null or the task is not found.
     */
    public void updateDescription(String id, String description) {
        if (id == null) {
            throw new IllegalArgumentException("Task Id cannot be null!");
        }
        Task task = getTask(id);
        if (task == null) {
            throw new IllegalArgumentException("Task does not exist!");
        }
        task.setDescription(description);
    }

    /**
     * Retrieves a task by its ID.
     *
     * @param id The unique ID of the task.
     * @return The Task object if found, or null if not found.
     */
    public Task getTask(String id) {
        return tasks.getOrDefault(id, null);
    }
}