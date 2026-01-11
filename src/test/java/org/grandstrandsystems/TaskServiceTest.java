package org.grandstrandsystems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private static final String ID = "001";
    private static final String NAME = "Task Name";
    private static final String DESCRIPTION = "Task Description";
    TaskService service;

    @BeforeEach
    void setUp() {
        service = new TaskService();
    }

    private void assertTaskEquals(Task expected, Task actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getDescription(), actual.getDescription());
    }

    @Nested
    class AddTaskTests {
        @Test
        @Tag("AddTask")
        void addTask_null_throwsException() {
            assertThrows(IllegalArgumentException.class, () -> service.addTask(null));
        }

        @Test
        @Tag("AddTask")
        void addTask_uniqueTask_addsTask() {
            Task task = new Task(ID, NAME, DESCRIPTION);
            service.addTask(task);

            Task retrieved = service.getTask(task.getId());
            assertTaskEquals(task, retrieved);
        }

        @Test
        @Tag("AddTask")
        void addTask_duplicateTaskId_throwsException() {
            Task task = new Task(ID, NAME, DESCRIPTION);
            service.addTask(task);
            assertThrows(IllegalArgumentException.class, () -> service.addTask(task));
        }
    }

    @Nested
    class DeleteTasksTest {
        @Test
        @Tag("DeleteTask")
        void deleteTask_null_returnsFalse() {
            assertFalse(service.deleteTask(null));
        }

        @Test
        @Tag("DeleteTask")
        void deleteTask_invalidId_returnsFalse() {
            Task task = new Task(ID, NAME, DESCRIPTION);
            service.addTask(task);
            assertFalse(service.deleteTask("Invalid"));
        }

        @Test
        @Tag("DeleteTask")
        void deleteTask_validId_deletesTask() {
            Task task = new Task(ID, NAME, DESCRIPTION);
            service.addTask(task);
            assertTrue(service.deleteTask(task.getId()));
            assertFalse(service.deleteTask(task.getId()));
        }
    }

    @Nested
    class UpdateTaskTests {
        @Nested
        class NameUpdateTests {
            @Test
            @Tag("UpdateTask")
            void updateTaskName_validIdValidName_updatesName() {
                Task task = new Task(ID, NAME, DESCRIPTION);
                String updatedName = "Updated Name";
                service.addTask(task);
                service.updateName(task.getId(), updatedName);

                Task updatedTask = service.getTask(task.getId());
                assertEquals(updatedName, updatedTask.getName());
            }

            @Test
            @Tag("UpdateTask")
            void updateTaskName_nullId_throwsException() {
                assertThrows(IllegalArgumentException.class, () -> service.updateName(null, "Updated Name"));
            }

            @Test
            @Tag("UpdateTask")
            void updateTaskName_nullName_throwsException() {
                Task task = new Task(ID, NAME, DESCRIPTION);
                service.addTask(task);
                assertThrows(IllegalArgumentException.class, () -> service.updateName(task.getId(), null));
            }

            @Test
            @Tag("UpdateTask")
            void updateTaskName_invalidName_throwsException() {
                Task task = new Task(ID, NAME, DESCRIPTION);
                String invalidName = "A".repeat(Task.MAX_NAME_LENGTH + 5);
                service.addTask(task);
                assertThrows(IllegalArgumentException.class, () -> service.updateName(task.getId(), invalidName));
            }

            @Test
            @Tag("UpdateTask")
            void updateTaskName_nonExistentId_throwsException() {
                // We don't add any task to the service, so "001" won't exist
                assertThrows(IllegalArgumentException.class, () -> service.updateName("001", "New Name"));
            }
        }

        @Nested
        class DescriptionUpdateTests {

            @Test
            @Tag("UpdateTask")
            void updateTaskDescription_validIdValidDescription_updatesDescription() {
                Task task = new Task(ID, NAME, DESCRIPTION);
                String updatedDescription = "Updated Description";
                service.addTask(task);
                service.updateDescription(task.getId(), updatedDescription);

                Task updatedTask = service.getTask(task.getId());
                assertEquals(updatedDescription, updatedTask.getDescription());
            }

            @Test
            @Tag("UpdateTask")
            void updateTaskDescription_nullId_throwsException() {
                assertThrows(IllegalArgumentException.class, () -> service.updateDescription(null, "Updated Description"));
            }

            @Test
            @Tag("UpdateTask")
            void updateTaskDescription_nullDescription_throwsException() {
                Task task = new Task(ID, NAME, DESCRIPTION);
                service.addTask(task);
                assertThrows(IllegalArgumentException.class, () -> service.updateDescription(task.getId(), null));
            }

            @Test
            @Tag("UpdateTask")
            void updateTaskDescription_invalidDescription_throwsException() {
                Task task = new Task(ID, NAME, DESCRIPTION);
                String invalidDescription = "A".repeat(Task.MAX_DESCRIPTION_LENGTH + 5);
                service.addTask(task);
                assertThrows(IllegalArgumentException.class, () -> service.updateDescription(task.getId(), invalidDescription));
            }

            @Test
            @Tag("UpdateTask")
            void updateTaskDescription_nonExistentId_throwsException() {
                // We don't add any task to the service, so "001" won't exist
                assertThrows(IllegalArgumentException.class, () -> service.updateDescription("001", "New Description"));
            }
        }
    }
}