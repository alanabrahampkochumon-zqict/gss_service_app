package org.grandstrandsystems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


class AppointmentServiceTest {

    AppointmentService service;
    private final String ID = "001";
    private final String DESCRIPTION = "Valid Description";

    private Date validDate;

    @BeforeEach
    void setUp() {
        int dayOffset = 5;

        LocalDateTime _futureDateTime = LocalDateTime.now().plusDays(dayOffset);
        validDate = Date.from(_futureDateTime.atZone(ZoneId.systemDefault()).toInstant());

        service = new AppointmentService();
    }

    @Test
    @Tag("AddAppointment")
    void addAppointment_null_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(null));
    }

    @Test
    @Tag("AddAppointment")
    void addAppointment_validAppointment_addsAppointment() {
        Appointment appointment = new Appointment(ID, validDate, DESCRIPTION);
        service.addAppointment(appointment);
        Appointment retrieved = service.getAppointment(appointment.getId());
        assertAppointmentEquals(appointment, retrieved);
    }


    @Test
    @Tag("AddAppointment")
    void addAppointment_duplicateAppointment_throwsException() {
        Appointment appointment = new Appointment(ID, validDate, DESCRIPTION);
        service.addAppointment(appointment);
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appointment));
    }

    @Test
    @Tag("DeleteAppointment")
    void deleteAppointment_nullId_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment(null));
    }

    @Test
    @Tag("DeleteAppointment")
    void deleteAppointment_nonExistent_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment(ID));
    }

    @Test
    @Tag("DeleteAppointment")
    void deleteAppointment_validAppointment_deletesAppointment() {
        Appointment appointment = new Appointment(ID, validDate, DESCRIPTION);
        service.addAppointment(appointment);

        assertAppointmentEquals(appointment, service.getAppointment(appointment.getId()));

        service.deleteAppointment(appointment.getId());

        assertNull(service.getAppointment(appointment.getId()));
    }

    void assertAppointmentEquals(Appointment expected, Appointment actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getDate(), actual.getDate());
        assertEquals(expected.getDescription(), actual.getDescription());
    }

}