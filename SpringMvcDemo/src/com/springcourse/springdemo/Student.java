package com.springcourse.springdemo;

import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String languages;
    private String[] operatingSystems;

    private LinkedHashMap<String, String> countryOptions;
    private LinkedHashMap<String, String> languagesOptions;

    public Student() {

        countryOptions = new LinkedHashMap<>();
        countryOptions.put("BR", "Brazil");
        countryOptions.put("FR", "France");
        countryOptions.put("DE", "Germany");
        countryOptions.put("IN", "India");
        countryOptions.put("USA", "United States of America");

        languagesOptions = new LinkedHashMap<>();
        languagesOptions.put("Java", "Java");
        languagesOptions.put("Python", "Python");
        languagesOptions.put("C#", "C#");
        languagesOptions.put("C++", "C++");
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public LinkedHashMap<String, String> getLanguagesOptions() {
        return languagesOptions;
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}
