package edu.knoldus.StudentApplication;

import java.util.List;
import java.util.Optional;

/**
 * Student class contains student details.
 */
public class Student {

    /**
     * Student name.
     */
    private String name;
    /**
     * Student roll number.
     */
    private int rollNumber;
    /**
     * Subject list of student.
     */
    private Optional<List<String>> subjectList;

    /**
     *
     * @param stuentName name
     * @param studentRollNumber roll number
     * @param studentSubjectList subject list
     */
    Student(final String stuentName, final int studentRollNumber,
            final Optional<List<String>> studentSubjectList) {
        this.name = stuentName;
        this.rollNumber = studentRollNumber;
        this.subjectList = studentSubjectList;
    }

    /**
     *
     * @return name
     */
    public final String getName() {
        return name;
    }

    /**
     *
     * @return rollNumber
     */
    public final int getRollNumber() {
        return rollNumber;
    }

    /**
     *
     * @return subjectList
     */
    public final Optional<List<String>> getSubjectList() {

        return subjectList;
    }

}
