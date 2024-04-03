package edu.wctc.part2;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * In this lab focus on METHOD encapsulation and fix/add code as necessary.
 * Pay special attention to the following issues:
 *
 * 1. Not all methods need to be public
 *
 * 2. When methods need to be called in a certain order you can do this
 * by creating a parent method that calls the other, helper methods.
 *
 * 3. There is some duplicate code used that violates the D.R.Y. principle.
 * Eliminate that by encapsulating the duplicate code in a new method
 * and then call that method in place of the duplicate code.
 *
 * 4. All method parameters should be validated (except booleans).
 *
 * Review the tips in the document Encapsulation Checklist if needed.
 */
public class Employee {
    public final int MIN_NAME_LENGTH = 2;

    private String firstName;
    private String lastName;
    private String ssn;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;
    private LocalDate orientationDate;

    public Employee(String firstName, String lastName, String ssn, String cubeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;

        this.meetWithHrForBenefitAndSalaryInfo();
        this.meetDepartmentStaff();
        this.reviewDeptPolicies();
        this.moveIntoCubicle(cubeId);
    }

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired.
    private void meetWithHrForBenefitAndSalaryInfo() {
        setMetWithHr(true);
        String fmtDate = formatDateString(orientationDate);
        System.out.println(firstName + " " + lastName + " met with HR on "
                + fmtDate);
    }

    // Assume this must be performed second, and assume that an employee
    // would only do this once, upon being hired.
    private void meetDepartmentStaff() {
        setMetDeptStaff(true);
        String fmtDate = formatDateString(orientationDate);
        System.out.println(firstName + " " + lastName + " met with dept staff on "
                + fmtDate);
    }

    // Assume this must be performed third. And assume that because department
    // policies may change that this method may need to be called 
    // independently from other classes.
    public void reviewDeptPolicies() {
        setReviewedDeptPolicies(true);
        String fmtDate = formatDateString(orientationDate);
        System.out.println(firstName + " " + lastName + " reviewed dept policies on "
                + fmtDate);
    }

    // Assume this must be performed fourth. And assume that because employees
    // sometimes change office locations that this method may need to be called 
    // independently from other classes.
    public void moveIntoCubicle(String cubeId) {
        setCubeId(cubeId);
        setMovedIn(true);
        String fmtDate = formatDateString(orientationDate);
        System.out.println(firstName + " " + lastName + " moved into cubicle "
                + cubeId + " on " + fmtDate);
    }

    // helper method

    private String formatDateString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");
        return formatter.format(date);
    }

    public String getFirstName() {
        return firstName;
    }

    // setter methods give the developer the power to control what data is
    // allowed through validation.

    public void setFirstName(String firstName) {
        if(firstName.isBlank() || firstName.length() < MIN_NAME_LENGTH) throw new IllegalArgumentException("First name not updated, name must be at least 2 characters long!");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(firstName.isBlank() || firstName.length() < MIN_NAME_LENGTH) throw new IllegalArgumentException("First name not updated, name must be at least 2 characters long!");
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    private void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public boolean hasMetWithHr() {
        return metWithHr;
    }

    private void setMetWithHr(boolean bool) {
        metWithHr = bool;
    }

    public boolean hasMetDeptStaff() {
        return metDeptStaff;
    }

    private void setMetDeptStaff(boolean bool) {
        metDeptStaff = bool;
    }

    public boolean hasReviewedDeptPolicies() {
        return reviewedDeptPolicies;
    }

    private void setReviewedDeptPolicies(boolean bool) {
        reviewedDeptPolicies = bool;
    }

    public boolean hasMovedIn() {
        return movedIn;
    }

    private void setMovedIn(boolean bool) {
        movedIn = bool;
    }

    public String getCubeId() {
        return cubeId;
    }

    private void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }

    public LocalDate getOrientationDate() {
        return orientationDate;
    }

    private void setOrientationDate(LocalDate orientationDate) {
        this.orientationDate = orientationDate;
    }
}
