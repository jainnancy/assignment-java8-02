package edu.knoldus.StudentApplication;

import java.util.List;
import java.util.Optional;

/**
 * Classromm class.
 */
public class Classroom {

    private String roomId;
    private Optional<List<Student>> studentList;

    Classroom(final String roomId, final Optional<List<Student>> studentList) {
        this.roomId = roomId;
        this.studentList = studentList;
    }

    /**
     *
     * @return room id
     */
    public final String getRoomId() {
        return roomId;
    }

    /**
     *
     * @return student list
     */
    public final Optional<List<Student>> getStudentList() {
        return studentList;
    }
}
