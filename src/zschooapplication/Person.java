/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zschooapplication;

import java.time.LocalDate;
import java.time.Period;

/**
 * This is an abstract class for a person
 *
 * @author CAIRD
 */
public abstract class Person {

    String firstName;
    String lastName;
    private String streetAddress, city, postalCode;
    private LocalDate birthday;

    /**
     *
     * @param firstName
     * @param lastName
     * @param streetAddress
     * @param city
     * @param postalCode
     * @param birthday
     */
    public Person(String firstName, String lastName, String streetAddress, String city, String postalCode, LocalDate birthday) {
        setFirstName(firstName);
        setLastName(lastName);
        setStreetAddress(streetAddress);
        setCity(city);
        setPostalCode(postalCode);
        setDateOfBirth(birthday);
    }

    /**
     * This is a get method that returns the persons first name as a String
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This is a set method to set the persons first name and validates that the
     * argument is not empty.
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        if (firstName.equals("")) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        this.firstName = firstName;
    }

    /**
     * This is a get method that returns the persons last name as a String
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This is a set method to set the persons last name and validates that the
     * argument is not empty.
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.equals("")) {
            throw new IllegalArgumentException("Please insure you have entered a valid Last name. ");
        }
        this.lastName = lastName;
    }

    /**
     * This is a get method that returns the persons street address as a String
     *
     * @return
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * This is a set method to set the persons address and validates that the
     * argument is not empty.
     *
     * @param streetAddress
     */
    public void setStreetAddress(String streetAddress) {

        if (streetAddress == null || streetAddress.equals("")) {
            throw new IllegalArgumentException("Please insure you have entered a valid street address. ");
        }
        this.streetAddress = streetAddress;

    }

    /**
     * This is a get method that returns the persons city as a String
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * This is a set method to set the city and validates that the argument is
     * not empty.
     *
     * @param city
     */
    public void setCity(String city) {
        if (city == null || city.equals("")) {
            throw new IllegalArgumentException("Please insure you have entered a valid city. ");
        }
        this.city = city;
    }

    /**
     * This is a get method that returns the persons postal code as a String
     *
     * @return
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * This is a set method to set the postal code and validates that the
     * argument is not empty.
     *
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        if (postalCode == null || postalCode.equals("")) {
            throw new IllegalArgumentException("Please insure you have entered a valid postal code");
        }
        this.postalCode = postalCode;
    }

    /**
     * This is a get method that returns the persons birth year as an int
     *
     * @return
     */
    public int getYearBorn() {
        return birthday.getYear();
    }

    /**
     * This is a get method that returns the persons birth date
     *
     * @return
     */
    public LocalDate getDateOfBirth() {
        return birthday;
    }

    /**
     * This is a get method that returns the persons birthday(date of birth)
     *
     * @return
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * This is a get method that returns the persons age in years as an int
     *
     * @return
     */
    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    /**
     * This is a get method that returns the persons age in years as an int
     *
     * @return
     */
    public int getAgeInYears() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    /**
     * This method validates the person is less than 100 years old. If the
     * birthday does not appear to be valid, a IllegalArgumentException is
     * thrown
     *
     * @param birthday
     */
    public void setDateOfBirth(LocalDate birthday) {
        if (Period.between(birthday, LocalDate.now()).getYears() > 100) {
            throw new IllegalArgumentException("You have indicated this student is over 100 years of age"
                    + "please insure the information you have entered is correct");
        } else {
            this.birthday = birthday;
        }
    }

    /**
     * This method validates the person is less than 90 years old. If the
     * birthday does not appear to be valid, a IllegalArgumentException is
     * thrown
     *
     * @param birthday
     */
    public void setBirthday(LocalDate birthday) {
        if (Period.between(birthday, LocalDate.now()).getYears() > 90) {
            throw new IllegalArgumentException("You have indicated this instuctor is over 90 years of age"
                    + "please insure the information you have entered is correct");
        } else {
            this.birthday = birthday;
        }
    }
}
