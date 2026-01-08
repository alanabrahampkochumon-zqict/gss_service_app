package org.grandstrandsystems;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaskTest {

    private static final String ID = "001";
    private static final String NAME = "Task Name";
    private static final String DESCRIPTION = "Task Description";
    
    @Nested
    class TaskIDTests {
        @Test
        @Tag("TaskID")
        void taskID_oneLongerThanLimit_throwsException() {
            String longTaskId = "0".repeat(Task.MAX_ID_LENGTH + 1);
            assertThrows(IllegalArgumentException.class, () -> new Task(longTaskId, NAME, DESCRIPTION));
        }

        @Test
        @Tag("TaskID")
        void taskID_muchLongerThanLimit_throwsException() {
            Random random = new Random();
            String longTaskId = "0".repeat(Task.MAX_ID_LENGTH + random.nextInt(100) + 10);
            assertThrows(IllegalArgumentException.class, () -> new Task(longTaskId, NAME, DESCRIPTION));
        }

        @Test
        @Tag("TaskID")
        void taskID_validLength_createsTask() {
            String exactId = "0".repeat(Task.MAX_ID_LENGTH);
            String[] validIDs = {exactId, exactId.substring(0, exactId.length() - 1), exactId.substring(0, exactId.length()/2)};
            for (String id: validIDs){
                Task task = new Task(id, NAME, DESCRIPTION);
                assertEquals(id, task.getId());
            }
        }

        @Test
        @Tag("TaskID")
        void taskID_updateWithValidID_throwsException() {
            Task task = new Task(ID, NAME, DESCRIPTION);
            assertThrows(IllegalArgumentException.class, () -> task.setId("0001"));
        }

        @Test
        @Tag("TaskID")
        void taskID_null_throwsException() {
            assertThrows(IllegalArgumentException.class, () -> new Task(null, NAME, DESCRIPTION));
        }
    }

    @Nested
    class TaskNameTests {

        @Test
        @Tag("TaskName")
        void taskName_oneLongerThanLimit_throwsException() {
            String longTaskName = "0".repeat(Task.MAX_NAME_LENGTH + 1);
            assertThrows(IllegalArgumentException.class, () -> new Task(ID, longTaskName, DESCRIPTION));
        }

        @Test
        @Tag("TaskName")
        void taskName_muchLongerThanLimit_throwsException() {
            Random random = new Random();
            String longTaskName = "0".repeat(Task.MAX_NAME_LENGTH + random.nextInt(100) + 10);
            assertThrows(IllegalArgumentException.class, () -> new Task(ID, longTaskName, DESCRIPTION));
        }

        @Test
        @Tag("TaskName")
        void taskName_validLength_createsTask() {
            String taskName = "A".repeat(Task.MAX_NAME_LENGTH);
            String[] validNames = {taskName, taskName.substring(0, taskName.length() - 1), taskName.substring(0, taskName.length()/2)};
            for (String name: validNames){
                Task task = new Task(ID, name, DESCRIPTION);
                assertEquals(name, task.getName());
            }
        }

        @Test
        @Tag("TaskName")
        void taskName_null_throwsException() {
            assertThrows(IllegalArgumentException.class, () -> new Task(ID, null, DESCRIPTION));
        }
    }

    @Nested
    class TaskDescriptionTests {

        @Test
        @Tag("TaskDescription")
        void taskDescription_oneLongerThanLimit_throwsException() {
            String longTaskDescription = "0".repeat(Task.MAX_DESCRIPTION_LENGTH + 1);
            assertThrows(IllegalArgumentException.class, () -> new Task(ID, NAME, longTaskDescription));
        }

        @Test
        @Tag("TaskDescription")
        void taskDescription_muchLongerThanLimit_throwsException() {
            Random random = new Random();
            String longTaskDescription = "0".repeat(Task.MAX_DESCRIPTION_LENGTH + random.nextInt(100) + 10);
            assertThrows(IllegalArgumentException.class, () -> new Task(ID, NAME, longTaskDescription));
        }

        @Test
        @Tag("TaskDescription")
        void taskDescription_validLength_createsTask() {
            String taskDescription = "A".repeat(Task.MAX_DESCRIPTION_LENGTH);
            String[] validDescriptions = {taskDescription, taskDescription.substring(0, taskDescription.length() - 1), taskDescription.substring(0, taskDescription.length()/2)};
            for (String description: validDescriptions){
                Task task = new Task(ID, NAME, description);
                assertEquals(description, task.getDescription());
            }
        }

        @Test
        @Tag("TaskDescription")
        void taskDescription_null_throwsException() {
            assertThrows(IllegalArgumentException.class, () -> new Task(ID, NAME, null));
        }
    }
}