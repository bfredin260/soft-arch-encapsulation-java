package edu.wctc.part1;

import java.time.LocalDate;

/**
 * Fix the code in this class to do PROPERTY encapsulation correctly. Also
 * consider if any of the properties should be mandatory and use a constructor
 * to enforce that. Review the tips in the document Encapsulation Checklist if
 * needed.
 */
public class Employee {
    public final int MIN_NAME_LENGTH = 2;

    private String firstName;
    private String lastName;
    private String ssn;

    private boolean metWithHr = false;
    private boolean metDeptStaff = true;
    private boolean reviewedDeptPolicies = false;
    private boolean movedIn = false;

    private String cubeId;
    private LocalDate orientationDate;

    public Employee(String firstName, String lastName, String ssn, String cubeId, LocalDate orientationDate) {
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);

        setCubeId(cubeId);
        setOrientationDate(orientationDate);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String name) {
        if(name.isBlank() || name.length() < MIN_NAME_LENGTH) throw new IllegalArgumentException("First name must be more than 1 character long, name not set.");
        this.firstName = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String name) {
        if(name.isBlank() || name.length() < MIN_NAME_LENGTH) throw new IllegalArgumentException("Last name must be more than 1 character long, name not set.");
        this.lastName = name;
    }

    public String getSsn() {
        return this.ssn;
    }

    private void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public boolean hasMetWithHr() {
        return this.metWithHr;
    }

    public void setMetWithHr(boolean hasMet) {
        this.metWithHr = hasMet;
    }

    public boolean hasMetDeptStaff() {
        return this.metDeptStaff;
    }

    public void setMetDeptStaff(boolean hasMet) {
        this.metDeptStaff = hasMet;
    }

    public boolean hasReviewedDeptPolicies() {
        return this.reviewedDeptPolicies;
    }

    public void setReviewedDeptPolicies(boolean hasReviewed) {
        this.reviewedDeptPolicies = hasReviewed;
    }

    public boolean hasMovedIn() {
        return this.movedIn;
    }

    public void setMovedIn(boolean hasMovedIn) {
        this.movedIn = hasMovedIn;
    }

    public String getCubeId() {
        return this.cubeId;
    }

    private void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }

    public LocalDate getOrientationDate() {
        return this.orientationDate;
    }

    private void setOrientationDate(LocalDate orientationDate) {
        this.orientationDate = orientationDate;
    }
}
