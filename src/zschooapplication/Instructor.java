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
 *
 * @author CAIRD
 */
public class Instructor extends Person {

    private LocalDate hireDate;
    private int employeeNum;
    private ArrayList<String> certList;

    public Instructor(String firstName, String lastName, String streetAddress, String city, String postalCode, LocalDate hireDate, LocalDate birthday, int employeeNum) {
        super(firstName, lastName, streetAddress, city, postalCode, birthday);
        setHireDate(hireDate);
        setEmployeeNum(employeeNum);
        setCertList(certList);
        certList = new ArrayList<>();
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        if (hireDate.isAfter(LocalDate.now().plusMonths(1))) {
            throw new IllegalArgumentException("Hiring date cannot be set more than a month in advance.");
        }
        this.hireDate = hireDate;
    }

    public int getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum) {
        if (employeeNum < 0) {
            throw new IllegalArgumentException("Please insure you have entered a valid employee number ");
        }
        this.employeeNum = employeeNum;
    }

    public ArrayList<String> getCourseCert() {
        return certList;
    }

    public void setCertList(ArrayList<String> courseCert) {
        this.certList = courseCert;
    }

    public int getYearsAtCollege() {
        return Period.between(hireDate, LocalDate.now()).getYears();
    }

    public void addCourseToAbilities(String courseCode) {
        if (courseCode.equals("")) {
            throw new IllegalArgumentException("The course code entered is invaild");
        } else {
            certList.add(courseCode.toUpperCase());
        }
    }

    public boolean canTeach(String courseCode) {
        return certList.contains(courseCode.toUpperCase());
    }

    public String listOfSubjectsCertifiedToTeach() {
        String certListString = String.join(", ", certList);
        return certListString;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
