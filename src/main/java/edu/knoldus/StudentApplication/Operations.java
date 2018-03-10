package edu.knoldus.StudentApplication;

import java.util.Collections;

/**
 * Operation class.
 */
public class Operations {

    /**
     *
     * @param classroom classroom object
     */
    public final void displayStudentsWithNoSubjects(final Classroom classroom) {
        classroom.getStudentList().ifPresent(x -> x
                .stream()
                .filter(student -> !student.getSubjectList().isPresent())
                .forEach(student -> System.out.println("\nStudents with No "
                        + "subjects associated are\n" + student.getName()))
        );
    }

    /**
     *
     * @param classrooms classroom object list
     * @param roomId roomid
     */
    public final void displayStudentsWithRoomId(
            final Classrooms classrooms, final String roomId) {

        System.out.println("\nStudents with room id = " + roomId + " are");
        Classroom classroom = classrooms.getClassroomList()
                .orElse(Collections.emptyList()).stream()
                .filter(x -> x
                        .getRoomId()
                        .equalsIgnoreCase(roomId))
                .findFirst()
                .orElse(null);

        classroom.getStudentList().ifPresent(x -> x.stream()
                .forEach(student -> System.out.println(student.getName())));
    }

    /**
     *
     * @param classroom classroom object
     */
    public final void printHelloStudent(final Classroom classroom) {
        classroom.getStudentList()
                .ifPresent(x -> System.out.println("\n" + "Hello Student!"));
    }
}
