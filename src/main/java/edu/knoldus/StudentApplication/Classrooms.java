package edu.knoldus.StudentApplication;

import java.util.List;
import java.util.Optional;

/**
 * Classrooms class contains list of classroom.
 */
public class Classrooms {
    private Optional<List<Classroom>> classroomList;

    Classrooms(final Optional<List<Classroom>> classroomList) {

        this.classroomList = classroomList;
    }

    /**
     *
     * @return classroom list
     */
    public final Optional<List<Classroom>> getClassroomList() {
        return classroomList;
    }
}
