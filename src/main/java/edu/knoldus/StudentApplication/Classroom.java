package edu.knoldus.StudentApplication;

import java.util.List;
import java.util.Optional;

/**
 * Classromm class.
 */
public class Classroom {

    /**
     * class room id.
     */
    private String roomId;
    /**
     * Student list of room.
     */
    private Optional<List<Student>> studentList;

    /**
     * Classromm class constructor.
     * @param roomid room id
     * @param studentlist student list
     */
    Classroom(final String roomid, final Optional<List<Student>> studentlist) {
        this.roomId = roomid;
        this.studentList = studentlist;
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
