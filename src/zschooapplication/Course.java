/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zschooapplication;
import java.util.ArrayList;

/**
 *This is a Course class
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
 * 
 * @return 
 */
    public ArrayList<Student> getStudents() {
        return classList;
    }
/**
 * 
 * @param classList 
 */
    public void setClassList(ArrayList<Student> classList) {
        this.classList = classList;
    }
/**
 * 
 * @return 
 */
    public Instructor getInstructor() {
        return instructor;
    }
/**
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
 * 
 * @return 
 */
    public String getCourseCode() {
        return courseCode;
    }
/**
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
 * 
 * @return 
 */
    public String getCourseName() {
        return courseName;
    }
/**
 * 
 * @param courseName 
 */
    public void setCourseName(String courseName) {
        if (courseName == null || courseName.equals("")) {
            throw new IllegalArgumentException("Please insure you have entered a valid course name. ");
        }
        else{
            this.courseName = courseName;
        }
    }
/**
 * 
 * @return 
 */
    public String getRoom() {
        return room;
    }
/**
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
 * 
 * @return 
 */
    public int getMaxStudents() {
        return maxStudents;
    }
/**
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
 * 
 * @param student 
 */
    public void addStudent(Student student) {
        if (student.isInGoodStanding() == true) {
            if(classList.size() < maxStudents){
                classList.add(student);
            }else{
                throw new IllegalArgumentException("Student could not be added, the course is full.");
            }
        }
        else{
            throw new IllegalArgumentException("Student could not be added, they are not in good standing.");
        }
    }
/**
 * 
 */
    public void showClassList() {
      //classList.forEach(System.out::println);
      for(Student student:classList) {
        System.out.println(student.toString());
      }
      
    }
/**
 * 
 * @return 
 */
    @Override
    public String toString() {
        return courseName + " " + courseCode;
    }

}