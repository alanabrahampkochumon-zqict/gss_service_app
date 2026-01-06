package org.grandstrandsystems;

/**
 * Represents a specific task within the project management system.
 * <p>
 * This class stores task details including a unique ID, a name, and a description.
 * It enforces strict validation rules ensuring that no fields are null and that all
 * fields adhere to specific character length constraints.
 * </p>
 *
 * @author Alan Abraham
 * @version 1.0
 * @since 1/6/2026
 */
public class Task {

    // Validation Constants
    static final byte MAX_ID_LENGTH = 10;
    static final byte MAX_NAME_LENGTH = 20;
    static final byte MAX_DESCRIPTION_LENGTH = 50;

    private String id;
    private String name;
    private String description;

    /**
     * Constructs a new Task object.
     * <p>
     * All parameters are validated upon instantiation. The unique Task ID is immutable
     * once set during this constructor call.
     * </p>
     *
     * @param id          The unique task ID (max 10 characters, not null, not updatable).
     * @param name        The task name (max 20 characters, not null).
     * @param description The task description (max 50 characters, not null).
     * @throws IllegalArgumentException if any parameter is null or violates length constraints.
     */
    public Task(String id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    /**
     * Retrieves the unique Task ID.
     *
     * @return The task ID string.
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieves the task name.
     *
     * @return The task name string.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the task description.
     *
     * @return The task description string.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the unique Task ID.
     * <p>
     * <b>Note:</b> The ID can only be set once (during instantiation). Attempting
     * to call this method on an object that already has an ID will throw an exception.
     * </p>
     *
     * @param id The unique ID string.
     * @throws IllegalArgumentException if ID is null, exceeds 10 characters, or is already set.
     */
    public void setId(String id) {
        if (id == null || id.length() > MAX_ID_LENGTH) {
            throw new IllegalArgumentException("Id cannot be null or longer than " + MAX_ID_LENGTH + " characters.");
        }
        // Enforce immutability
        if (this.id != null) {
            throw new IllegalArgumentException("Cannot change ID once it is set.");
        }
        this.id = id;
    }

    /**
     * Sets the task name.
     *
     * @param name The name string.
     * @throws IllegalArgumentException if name is null or exceeds 20 characters.
     */
    public void setName(String name) {
        if (name == null || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Name cannot be null or longer than " + MAX_NAME_LENGTH + " characters.");
        }
        this.name = name;
    }

    /**
     * Sets the task description.
     *
     * @param description The description string.
     * @throws IllegalArgumentException if description is null or exceeds 50 characters.
     */
    public void setDescription(String description) {
        if (description == null || description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("Description cannot be null or longer than " + MAX_DESCRIPTION_LENGTH + " characters.");
        }
        this.description = description;
    }
}