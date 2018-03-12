/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zschooapplication;

import java.time.LocalDate;

/**
 * This is a student class extending from the abstract class Person.
 * @author CAIRD
 */
public class Student extends Person {

    private LocalDate dateEnrolled;
    private int studentNumber;
    private boolean currentStanding;

    /**
     *This is a constructor that accepts all of the instance variables for a Student.
     * The constructor accepts arguments in the following order: first name, last name, street address, city, postal code, 
     * the student's birth date (using LocalDate), the date they enrolled at the school and the student number.
     * 
     *
     * @param firstName
     * @param lastName
     * @param streetAddress
     * @param city
     * @param postalCode
     * @param yearBorn
     * @param dateEnrolled
     * @param studentNumber
     */
    public Student(String firstName, String lastName, String streetAddress, String city, String postalCode, LocalDate yearBorn, LocalDate dateEnrolled, int studentNumber) {
        super(firstName, lastName, streetAddress, city, postalCode, yearBorn);
        setDateEnrolled(dateEnrolled);
        setStudentNumber(studentNumber);
        currentStanding = true;
    }

    /**
     * This is a get method that returns the date the student enrolled at the
     * college
     *
     * @return
     */
    public LocalDate getDateEnrolled() {
        return dateEnrolled;
    }

    /**
     * This is a get method that returns the year enrolled as an integer
     *
     * @return
     */
    public int getYearEnrolled() {
        return dateEnrolled.getYear();
    }

    /**
     * This method validates that the student was not enrolled in the future If
     * it is not a valid enrollment date an IllegalArgumentException is thrown.
     *
     * @param dateEnrolled
     */
    public void setDateEnrolled(LocalDate dateEnrolled) {
        if (dateEnrolled.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Please insure you have entered a valid enrollment date");
        }
        this.dateEnrolled = dateEnrolled;
    }

    /**
     * This method returns true if the student is in good standing or false if
     * they are in bad standing
     *
     * @return
     */
    public boolean isInGoodStanding() {
        return currentStanding;
    }

    /**
     * This is a get method that returns the date the student enrolled at the
     * college
     *
     * @return
     */
    public int getStudentNum() {
        return studentNumber;
    }

    /**
     * This method validates that the student number is valid If it is not a
     * valid number an IllegalArgumentException is thrown.
     *
     * @param studentNumber
     */
    public void setStudentNumber(int studentNumber) {
        if (studentNumber < 0) {
            throw new IllegalArgumentException("Please insure you have entered a valid student number ");
        }
        this.studentNumber = studentNumber;
    }

    /**
     * this method sets the current "good standing" to be false
     */
    public void suspendStudent() {
        currentStanding = false;
    }

    /**
     * This method reinstates the student's "good standing" to be true
     */
    public void reinstateStudent() {
        currentStanding = true;
    }

    /**
     * This method is a toString method returns the first name, last name and
     * student number
     *
     * @return
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + ", student number: " + studentNumber;
    }
}
