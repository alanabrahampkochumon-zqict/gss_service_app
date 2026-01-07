package org.grandstrandsystems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    private final String ID = "001";
    private final String DESCRIPTION = "Valid Description";

    private Date validDate;
    private Date invalidDate;

    @BeforeEach
    void setUp() {
        int dayOffset = 5;

        LocalDateTime _futureDateTime = LocalDateTime.now().plusDays(dayOffset);
        validDate = Date.from(_futureDateTime.atZone(ZoneId.systemDefault()).toInstant());

        LocalDateTime _pastDateTime = LocalDateTime.now().minusDays(dayOffset);
        invalidDate = Date.from(_pastDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    @Test
    @Tag("AppointmentId")
    void appointmentId_null_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, validDate, DESCRIPTION));
    }

    @Test
    @Tag("AppointmentId")
    void appointmentId_oneGreaterThanRange_throwsException() {
        String id = "0".repeat(Appointment.ID_MAX_LENGTH + 1);
        assertThrows(IllegalArgumentException.class, () -> new Appointment(id, validDate, DESCRIPTION));
    }

    @Test
    @Tag("AppointmentId")
    void appointmentId_randomOffsetOutOfRange_throwsException() {
        Random random = new Random();
        String id = "0".repeat(Appointment.ID_MAX_LENGTH + random.nextInt(100) + 10);
        assertThrows(IllegalArgumentException.class, () -> new Appointment(id, validDate, DESCRIPTION));
    }

    @Test
    @Tag("AppointmentId")
    void appointmentId_inRange_createsObjectWithCorrectId() {
        String _id = "0".repeat(Appointment.ID_MAX_LENGTH);
        String[] validIds = {_id, _id.substring(_id.length() - 1), _id.substring(_id.length() / 2)};
        for(String id: validIds) {
            Appointment appointment = new Appointment(id, validDate, DESCRIPTION);
            assertEquals(id, appointment.getId());
        }
    }

    @Test
    @Tag("AppointmentId")
    void appointmentId_changedAfterInstantiation_throwsException() {
        Appointment appointment = new Appointment(ID, validDate, DESCRIPTION);
        assertEquals(ID, appointment.getId());
        assertThrows(IllegalArgumentException.class, () -> appointment.setId("001"));
    }

    @Test
    @Tag("AppointmentDate")
    void appointmentDate_null_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(ID, null, DESCRIPTION));
    }

    @Test
    @Tag("AppointmentDate")
    void appointmentDate_inPast_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(ID, invalidDate, DESCRIPTION));
    }

    @Test
    @Tag("AppointmentDate")
    void appointmentDate_inFuture_createsObjectWithCorrectDate() {
        Appointment appointment = new Appointment(ID, validDate, DESCRIPTION);
        assertEquals(validDate, appointment.getDate());
    }


    @Test
    @Tag("AppointmentDescription")
    void appointmentDescription_null_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(ID, validDate, null));
    }

    @Test
    @Tag("AppointmentDescription")
    void appointmentDescription_oneGreaterThanRange_throwsException() {
        String description = "D".repeat(Appointment.DESCRIPTION_MAX_LENGTH + 1);
        assertThrows(IllegalArgumentException.class, () -> new Appointment(ID, validDate, description));
    }

    @Test
    @Tag("AppointmentDescription")
    void appointmentDescription_randomOffsetOutOfRange_throwsException() {
        Random random = new Random();
        String description = "D".repeat(Appointment.DESCRIPTION_MAX_LENGTH + random.nextInt(100) + 10);
        assertThrows(IllegalArgumentException.class, () -> new Appointment(ID, validDate, description));
    }

    @Test
    @Tag("AppointmentDescription")
    void appointmentDescription_inRange_createsObjectWithCorrectId() {
        String _description = "D".repeat(Appointment.DESCRIPTION_MAX_LENGTH);
        String[] validDescriptions = {_description, _description.substring(_description.length() - 1), _description.substring(_description.length() / 2)};
        for(String description: validDescriptions) {
            Appointment appointment = new Appointment(ID, validDate, description);
            assertEquals(description, appointment.getDescription());
        }
    }

}