/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zschooapplication;

import java.util.ArrayList;

/**
 * This is a course class containing instance variables to store an Instructor,
 * course code, a course name, room, a list of Student objects and the maximum
 * number of students allowed in the course.
 *
 * @author CAIRD
 */
public class Course {

    private Instructor instructor;
    private String courseCode;
    private String courseName;
    private String room;
    private int maxStudents;
    private ArrayList<Student> classList;

    /**
     *
     * @param instructor
     * @param courseCode
     * @param courseName
     * @param room
     * @param maxStudents
     */
    public Course(Instructor instructor, String courseCode, String courseName, String room, int maxStudents) {
        setCourseCode(courseCode);
        setInstructor(instructor);
        setCourseName(courseName);
        setRoom(room);
        setMaxStudents(maxStudents);
        setClassList(classList);
        classList = new ArrayList<>();
    }

    /**
     * Returns an ArrayList of Student objects enrolled in the course
     *
     * @return
     */
    public ArrayList<Student> getStudents() {
        return classList;
    }

    /**
     * This method Accepts the class list of Students as an argument and sets
     * the instance variable.
     *
     * @param classList
     */
    public void setClassList(ArrayList<Student> classList) {
        this.classList = classList;
    }

    /**
     * This is a get method that returns the Instructor
     *
     * @return
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * this method accepts an Instructor as an argument. If the course code is
     * within the Instructors teachable subjects, it sets the Instructor,
     * otherwise an IllegalArgumentException is thrown.
     *
     * @param instructor
     */
    public void setInstructor(Instructor instructor) {
        if (instructor.canTeach(courseCode.toUpperCase())) {
            this.instructor = instructor;
        } else {
            throw new IllegalArgumentException("The chosen instuctor is not certififed to teach this course.");
        }

    }

    /**
     * This method will return the course code when called.
     *
     * @return
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * This method accepts the Course code as a String and validates to ensure
     * it's not empty. If empty, an IllegalArgumentException is throw otherwise
     * it sets the instance variable.
     *
     * @param courseCode
     */
    public void setCourseCode(String courseCode) {
        if (courseCode == null || courseCode.equals("")) {
            throw new IllegalArgumentException("Please insure you have entered a valid Last name. ");
        }
        this.courseCode = courseCode;
    }

    /**
     * This method will return the course name when called.
     *
     * @return
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * This method Accept the course name as a String validates to ensure it's
     * not empty. If empty, an IllegalArgumentException is throw otherwise it
     * sets the instance variable.
     *
     * @param courseName
     */
    public void setCourseName(String courseName) {
        if (courseName == null || courseName.equals("")) {
            throw new IllegalArgumentException("Please insure you have entered a valid course name. ");
        } else {
            this.courseName = courseName;
        }
    }

    /**
     * This method returns the Room Where the course will take place.
     *
     * @return
     */
    public String getRoom() {
        return room;
    }

    /**
     * This method accepts the room as a String and validates to ensure it's not
     * empty. If empty, an IllegalArgumentException is throw otherwise it sets
     * the instance variable.
     *
     * @param room
     */
    public void setRoom(String room) {
        if (room == null || room.equals("")) {
            throw new IllegalArgumentException("Please insure you have entered a valid class room. ");
        }
        this.room = room;
    }

    /**
     * This method returns the maximum number of students being accepted for the
     * course
     *
     * @return
     */
    public int getMaxStudents() {
        return maxStudents;
    }

    /**
     * this method accepts an integer as an argument. The argument is validated
     * to be less than or equal to 45, and above 0. If the number is outside
     * that range, an IllegalArgumentException is thrown otherwise the instance
     * variable is set.
     *
     * @param maxStudents
     */
    public void setMaxStudents(int maxStudents) {
        if (maxStudents > 45 || maxStudents <= 0) {
            throw new IllegalArgumentException("Please ensure class capacity is being set within the accepted range, (1-45). ");
        }
        this.maxStudents = maxStudents;
    }

    /**
     * this accepts a Student as an argument. It checks if the student is
     * currently in good standing AND if there is space in the class. If a
     * student cannot be added, it throws an exception.
     *
     * @param student
     */
    public void addStudent(Student student) {
        if (student.isInGoodStanding() == true) {
            if (classList.size() < maxStudents) {
                classList.add(student);
            } else {
                throw new IllegalArgumentException("Student could not be added, the course is full.");
            }
        } else {
            throw new IllegalArgumentException("Student could not be added, they are not in good standing.");
        }
    }

    /**
     * this method will print the names of each student registered in the class
     * to the screen. There is 1 student per line.
     */
    public void showClassList() {
        //classList.forEach(System.out::println);
        for (Student student : classList) {
            System.out.println(student.toString());
        }

    }

    /**
     * This is a method that returns the course name and course code as a String
     * This method over rides the default toSting() method.
     *
     * @return
     */
    @Override
    public String toString() {
        return courseName + " " + courseCode;
    }

}
