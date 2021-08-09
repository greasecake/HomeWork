package com.homework.phonebook;

public class Person {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final int age;
    private final String phoneNumber;

    public Person(String firstName, String middleName, String lastName, int age, String phoneNumber) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return firstName + " " + middleName + " " + lastName + " " + age + " " + phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
