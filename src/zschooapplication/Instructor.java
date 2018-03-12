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
 * This is an Instructor class extending from the abstract class Person.
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
 * @param employeeNum 
 */
    public Instructor(String firstName, String lastName, String streetAddress, String city, String postalCode, LocalDate hireDate, LocalDate birthday, int employeeNum) {
        super(firstName, lastName, streetAddress, city, postalCode, birthday);
        setHireDate(hireDate);
        setEmployeeNum(employeeNum);
        setCertList(certList);
        certList = new ArrayList<>();
    }
/**
 * 
 * @return 
 */
    public LocalDate getHireDate() {
        return hireDate;
    }
/**
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
 * 
 * @return 
 */
    public int getEmployeeNum() {
        return employeeNum;
    }
/**
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
 * 
 * @return 
 */
    public ArrayList<String> getCourseCert() {
        return certList;
    }
/**
 * 
 * @param courseCert 
 */
    public void setCertList(ArrayList<String> courseCert) {
        this.certList = courseCert;
    }
/**
 * 
 * @return 
 */
    public int getYearsAtCollege() {
        return Period.between(hireDate, LocalDate.now()).getYears();
    }
/**
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
 * 
 * @param courseCode
 * @return 
 */
    public boolean canTeach(String courseCode) {
        return certList.contains(courseCode.toUpperCase());
    }
/**
 * 
 * @return 
 */
    public String listOfSubjectsCertifiedToTeach() {
        String certListString = String.join(", ", certList);
        return certListString;
    }
/**
 * 
 * @return 
 */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
