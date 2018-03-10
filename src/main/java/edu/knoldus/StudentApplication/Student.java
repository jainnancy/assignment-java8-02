package edu.knoldus.StudentApplication;

import java.util.List;
import java.util.Optional;

/**
 * Student class contains student details.
 */
public class Student {

    private String name;
    private int rollNumber;
    private Optional<List<String>> subjectList;

    /**
     *
     * @param name name
     * @param rollNumber roll number
     * @param subjectList subject list
     */
    Student(final String name, final int rollNumber,
            final Optional<List<String>> subjectList) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjectList = subjectList;
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
