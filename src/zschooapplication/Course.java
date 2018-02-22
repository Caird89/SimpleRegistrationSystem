/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zschooapplication;

import java.util.ArrayList;

/**
 *
 * @author CAIRD
 */
public class Course {

    private Instructor instructor;
    private String courseCode;
    private String courseName;
    private String classRoom;
    private int maxStudents;
    ArrayList<String> classList;

    public Course(Instructor instructor, String courseCode, String courseName, String classRoom, int maxStudents) {
        setInstructor(instructor);
        setCourseCode(courseCode);
        setCourseName(courseName);
        setClassRoom(classRoom);
        setMaxStudents(maxStudents);
        classList = new ArrayList<>();
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        if (instructor.canTeach(courseCode)) {
            this.instructor = instructor;
        } else {
            throw new IllegalArgumentException("The chosen instuctor is not certififed to teach this course.");
        }

    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        if (courseCode == null || courseCode.equals("")) {
            throw new IllegalArgumentException("Please insure you have entered a valid Last name. ");
        }
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.equals("")) {
            throw new IllegalArgumentException("Please insure you have entered a valid course name. ");
        }
        this.courseName = courseName;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        if (classRoom == null || classRoom.equals("")) {
            throw new IllegalArgumentException("Please insure you have entered a valid class room. ");
        }
        this.classRoom = classRoom;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        if (maxStudents > 45 || maxStudents <= 0) {
            throw new IllegalArgumentException("Please ensure class capacity is being set within the accepted range, (1-45). ");
        }
        this.maxStudents = maxStudents;
    }

    public void addStudent(Student student) {
        if (student.isInGoodStanding() == true ) {
            add()
        }
    }

    public void showClassList() {

    }

    @Override
    public String toString() {
        return courseName + " " + courseCode;
    }

}
