package edu.knoldus.StudentApplication;

import java.util.Arrays;
import java.util.Optional;

/**
 * main class.
 */
public class Driver {

    /**
     * Driver class constructor.
     */
    protected Driver() {

    }
    /**
     *
     * @param args stringargs
     */
    public static void main(final String[] args) {

        Student student1 = new Student("Ashima", 1, Optional
                .ofNullable(Arrays.asList("Java", "Math", "DS")));
        Student student2 = new Student("Radha", 1, Optional
                .ofNullable(Arrays.asList("c++", "Math", "OS")));
        Student student3 = new Student("Nikhil", 1, Optional
                .ofNullable(Arrays.asList("Java", "Math", "ST")));
        Student student4 = new Student("Naman", 1, Optional
                .ofNullable(null));

        Classroom classroom1 = new Classroom("xyz", Optional
                .ofNullable(Arrays.asList(student1, student2)));
        Classroom classroom2 = new Classroom("abc", Optional
                .ofNullable(Arrays.asList(student2, student3, student4)));
        Classroom classroom3 = new Classroom("abc", Optional
                .ofNullable(null));

        Classrooms classrooms = new Classrooms(Optional
                .ofNullable(Arrays.asList(classroom1, classroom2, classroom3)));
// 1.Find students associated with a room that have no subjects associated.
        new Operations().displayStudentsWithNoSubjects(classroom1);
        new Operations().displayStudentsWithNoSubjects(classroom2);

// 2. Find subjects of students associated with the roomID "xyz".
        new Operations().displayStudentsWithRoomId(classrooms, "xyz");

// 3. print "hello Student" if a room has students associated.
        new Operations().printHelloStudent(classroom1);
        new Operations().printHelloStudent(classroom2);
        new Operations().printHelloStudent(classroom3);

    }
}
