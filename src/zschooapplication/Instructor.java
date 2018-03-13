/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zschooapplication;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 * This is an Instructor class extending from the abstract class Person. Each
 * Instructor has instance variables to store the first name, last name, date
 * they were hired, their birthday, street address, city, postal code, employee
 * number and a list of course codes that they can teach.
 *
 * @author CAIRD
 */
public class Instructor extends Person {

    private LocalDate hireDate;
    private int employeeNum;
    private ArrayList<String> certList;

    /**
     *
     * @param firstName
     * @param lastName
     * @param streetAddress
     * @param city
     * @param postalCode
     * @param hireDate
     * @param birthday
     * @param employeeNum * This is a constructor that accepts all of the
     * instance variables for a Instructor. The constructor accepts arguments in
     * the following order: first name, last name, street address, city, postal
     * code, the teachers birth date (using LocalDate), the date they Where
     * hired at the school and the Employee number.
     */
    public Instructor(String firstName, String lastName, String streetAddress, String city, String postalCode, LocalDate hireDate, LocalDate birthday, int employeeNum) {
        super(firstName, lastName, streetAddress, city, postalCode, birthday);
        setHireDate(hireDate);
        setEmployeeNum(employeeNum);
        setCertList(certList);
        certList = new ArrayList<>();
    }

    /**
     * This is a get method that returns the date the teacher was hired at the
     * college
     *
     * @return
     */
    public LocalDate getHireDate() {
        return hireDate;
    }

    /**
     * This method validates that the teacher was not hired more a month into
     * the future. If it is not a valid employment date an
     * IllegalArgumentException is thrown.
     *
     * @param hireDate
     */
    public void setHireDate(LocalDate hireDate) {
        if (hireDate.isAfter(LocalDate.now().plusMonths(1))) {
            throw new IllegalArgumentException("Hiring date cannot be set more than a month in advance.");
        } else {
            this.hireDate = hireDate;
        }
    }

    /**
     * This is a get method that returns the teachers employee number. college
     *
     * @return
     */
    public int getEmployeeNum() {
        return employeeNum;
    }

    /**
     * This method validates that the employee number is valid. If it is not a
     * valid number an IllegalArgumentException is thrown.
     *
     * @param employeeNum
     */
    public void setEmployeeNum(int employeeNum) {
        if (employeeNum < 0) {
            throw new IllegalArgumentException("Please insure you have entered a valid employee number ");
        } else {
            this.employeeNum = employeeNum;
        }
    }

    /**
     * this is a method that returns an Array list of strings containing all the
     * course codes a teacher can teach.
     *
     * @return
     */
    public ArrayList<String> getCourseCert() {
        return certList;
    }

    /**
     * This is a set method to set the Array list.
     *
     * @param courseCert
     */
    public void setCertList(ArrayList<String> courseCert) {
        this.certList = courseCert;
    }

    /**
     * This method will return the number of years the instructor has worked at
     * the college.
     *
     * @return
     */
    public int getYearsAtCollege() {
        return Period.between(hireDate, LocalDate.now()).getYears();
    }

    /**
     * This method accepts a course code as a String and adds it to the list of
     * teachable subjects in UPPERCASE. If the course code is empty, it throws
     * an IllegalArgumentException
     *
     * @param courseCode
     */
    public void addCourseToAbilities(String courseCode) {
        if (courseCode.equals("")) {
            throw new IllegalArgumentException("The course code entered is invaild");
        } else {
            certList.add(courseCode.toUpperCase());
        }
    }

    /**
     * This method accepts a String with a course code in it. If the course code
     * is in the list of courses an Instructor can teach, it returns true, false
     * otherwise.
     *
     * @param courseCode
     * @return
     */
    public boolean canTeach(String courseCode) {
        return certList.contains(courseCode.toUpperCase());
    }

    /**
     * This returns a String with all the course codes an Instructor is
     * certified to teach. The course codes are separated by a comma
     *
     * @return
     */
    public String listOfSubjectsCertifiedToTeach() {
        String certListString = String.join(", ", certList);
        return certListString;
    }

    /**
     * This method is a toString method returns the first name and last name
     * separated by a space.
     *
     * @return
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
