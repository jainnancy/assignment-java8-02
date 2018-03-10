package edu.knoldus.StudentApplication;

import java.util.List;
import java.util.Optional;

/**
 * Classrooms class contains list of classroom.
 */
public class Classrooms {
    /**
     * classroom list.
     */
    private Optional<List<Classroom>> classroomList;

    /**
     * Classrooms constructor.
     * @param classroomsList classroom list
     */
    Classrooms(final Optional<List<Classroom>> classroomsList) {

        this.classroomList = classroomsList;
    }

    /**
     *
     * @return classroom list
     */
    public final Optional<List<Classroom>> getClassroomList() {
        return classroomList;
    }
}
