package org.grandstrandsystems;

import java.util.Date;

/**
 * Represents an appointment within the system.
 * <p>
 * This class stores appointment details including a unique ID, a specific date, and a description.
 * It enforces strict validation rules ensuring data integrity, such as preventing appointments
 * in the past and enforcing character limits.
 * </p>
 *
 * @author Alan Abraham
 * @version 1.0
 * @since 1/7/2026
 */
public class Appointment {

    // Constants for validation limits
    static final byte ID_MAX_LENGTH = 10;
    static final byte DESCRIPTION_MAX_LENGTH = 50;

    private String id;
    private Date date;
    private String description;

    /**
     * Constructs a new Appointment object.
     * <p>
     * All parameters are validated upon instantiation. The unique Appointment ID is immutable
     * once set during this constructor call.
     * </p>
     *
     * @param id          The unique appointment ID (max 10 characters, not null, not updatable).
     * @param date        The appointment date (must not be null and must be in the future).
     * @param description The appointment description (max 50 characters, not null).
     * @throws IllegalArgumentException if any parameter violates validation rules.
     */
    public Appointment(String id, Date date, String description) {
        setId(id);
        setDate(date);
        setDescription(description);
    }

    /*
     * *******************************************
     * * GETTERS                   *
     * *******************************************
     */

    /**
     * Retrieves the unique Appointment ID.
     *
     * @return The appointment ID string.
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieves the appointment date.
     *
     * @return The Date object representing the appointment time.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Retrieves the appointment description.
     *
     * @return The description string.
     */
    public String getDescription() {
        return description;
    }

    /*
     * *******************************************
     * * SETTERS                   *
     * *******************************************
     */

    /**
     * Sets the unique Appointment ID.
     * <p>
     * <b>Note:</b> The ID can only be set once (during instantiation). Attempting
     * to call this method on an object that already has an ID will throw an exception.
     * </p>
     *
     * @param id The unique ID string.
     * @throws IllegalArgumentException if ID is null, exceeds 10 characters, or is already set.
     */
    public void setId(String id) {
        if (id == null || id.length() > ID_MAX_LENGTH) {
            throw new IllegalArgumentException("Appointment ID cannot be null or more than " + ID_MAX_LENGTH + " characters.");
        }
        if (this.id != null) {
            throw new IllegalArgumentException("Appointment ID cannot be changed after initialization.");
        }
        this.id = id;
    }

    /**
     * Sets the appointment date.
     *
     * @param date The Date object.
     * @throws IllegalArgumentException if the date is null or in the past.
     */
    public void setDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Appointment Date cannot be null.");
        }
        if (date.before(new Date())) {
            throw new IllegalArgumentException("Appointment Date cannot be in the past");
        }
        this.date = date;
    }

    /**
     * Sets the appointment description.
     *
     * @param description The description string.
     * @throws IllegalArgumentException if description is null or exceeds 50 characters.
     */
    public void setDescription(String description) {
        if (description == null || description.length() > DESCRIPTION_MAX_LENGTH) {
            throw new IllegalArgumentException("Appointment Description cannot be null or more than " + DESCRIPTION_MAX_LENGTH + " characters.");
        }
        this.description = description;
    }
}