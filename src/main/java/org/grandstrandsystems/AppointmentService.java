package org.grandstrandsystems;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the storage and manipulation of Appointment objects.
 * <p>
 * This service uses an in-memory data structure (HashMap) to store appointments.
 * It provides functionality to add and delete appointments while enforcing
 * uniqueness based on the Appointment ID.
 * </p>
 *
 * @author Alan Abraham
 * @version 1.0
 * @since 1/7/2026
 */
public class AppointmentService {

    // In-memory storage for appointments. Key is the Appointment ID.
    private final Map<String, Appointment> appointments = new HashMap<>();

    /**
     * Adds a new appointment to the service.
     * <p>
     * Ensures that the appointment object is not null and that the Appointment ID
     * is unique before adding it to the storage.
     * </p>
     *
     * @param appointment The Appointment object to be added.
     * @throws IllegalArgumentException if the appointment is null or if an appointment with the same ID already exists.
     */
    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }
        // FIX: Check for duplicate ID to satisfy "Unique ID" requirement
        if (appointments.containsKey(appointment.getId())) {
            throw new IllegalArgumentException("Appointment ID already exists.");
        }
        appointments.put(appointment.getId(), appointment);
    }

    /**
     * Deletes an appointment by its ID.
     *
     * @param id The unique ID of the appointment to delete.
     * @throws IllegalArgumentException if the ID is null or if the appointment is not found.
     */
    public void deleteAppointment(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null.");
        }
        if (!appointments.containsKey(id)) {
            throw new IllegalArgumentException("Appointment not found.");
        }
        appointments.remove(id);
    }

    /**
     * Retrieves an appointment by its ID.
     *
     * @param id The unique ID of the appointment.
     * @return The Appointment object if found, or null if not found.
     */
    public Appointment getAppointment(String id) {
        return appointments.getOrDefault(id, null);
    }
}