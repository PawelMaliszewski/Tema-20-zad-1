package com.temat20zad1;

public class User {
    private String firstName;
    private String lastName;
    private int age;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String ageInfo() {
        if (age <1) {
            return "nie wpisano danych";
        }
        return Integer.toString(age);
    }

    @Override
    public String toString() {
        return "Imię: " + firstName + ", Nazwisko: " + lastName + ", Wiek: " + ageInfo();
    }
}
