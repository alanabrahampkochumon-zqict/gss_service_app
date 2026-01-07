package org.grandstrandsystems;

import java.util.Date;

/**
 * @author Alan Abraham
 * @since 1/7/2026
 */

public class Appointment {

    // Constants for validation limits
    static final byte ID_MAX_LENGTH = 10;
    static final byte DESCRIPTION_MAX_LENGTH = 50;

    private String id;
    private Date date;
    private String description;


    public Appointment(String id, Date date, String description) throws IllegalArgumentException {
        setId(id);
        setDate(date);
        setDescription(description);
    }

    /*
     * *******************************************
     * *               GETTERS                   *
     * *******************************************
     */

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    /*
     * *******************************************
     * *               SETTERS                   *
     * *******************************************
     */

    public void setId(String id) throws IllegalArgumentException {
        if (id == null || id.length() > ID_MAX_LENGTH)
            throw new IllegalArgumentException("Appointment ID cannot be null or more than " + ID_MAX_LENGTH + " characters.");
        if (this.id != null)
            throw new IllegalArgumentException("Appointment ID cannot be changed after initialization.");
        this.id = id;
    }

    public void setDate(Date date) throws IllegalArgumentException {
        if (date == null)
            throw new IllegalArgumentException("Appointment Date cannot be null.");
        if (date.before(new Date()))
            throw new IllegalArgumentException("Appointment Date cannot be in the past");
        this.date = date;
    }

    public void setDescription(String description) throws IllegalArgumentException {
        if (description == null || description.length() > DESCRIPTION_MAX_LENGTH)
            throw new IllegalArgumentException("Appointment Description cannot be null or more than " + DESCRIPTION_MAX_LENGTH + " characters.");
        this.description = description;
    }
}
