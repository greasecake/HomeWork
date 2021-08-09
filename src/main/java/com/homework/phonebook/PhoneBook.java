package com.homework.phonebook;

import java.io.IOException;
import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        if (args.length > 3 || !args[0].startsWith("-")) {
            throw new IllegalArgumentException("Unknown parameters");
        }
        String flag = args[0];

        Set<Person> persons = new HashSet<>();
        persons.add(new Person("Иван", "Иванович", "Иванов", 25, "71234567890"));
        persons.add(new Person("Ива", "Ива", "Ива", 25, "71234567890"));
        persons.add(new Person("Петр", "Петрович", "Петров", 44, "71234367890"));
        persons.add(new Person("Алексей", "Алексеевич", "Алексеев", 32, "71234567690"));
        persons.add(new Person("Василий", "Васильевич", "Васильев", 19, "71254567890"));

        switch (flag) {
            case ("-f"):
                for (Person person : persons) {
                    if (person.getLastName().contains(args[1])) {
                        System.out.println(person);
                    }
                }
                break;
            case ("-i"):
                for (Person person : persons) {
                    if (person.getFirstName().contains(args[1])) {
                        System.out.println(person);
                    }
                }
                break;
            case ("-o"):
                for (Person person : persons) {
                    if (person.getMiddleName().contains(args[1])) {
                        System.out.println(person);
                    }
                }
                break;
            case ("-n"):
                for (Person person : persons) {
                    if (person.getPhoneNumber().contains(args[1])) {
                        System.out.println(person);
                    }
                }
            case ("-d"):
                if (args.length != 3) {
                    throw new IllegalArgumentException("Expected 2 parameters");
                }
                for (Person person : persons) {
                    if (
                        person.getLastName().compareTo(args[1]) > 0 &&
                        person.getLastName().compareTo(args[2]) <= 0
                    ) {
                        System.out.println(person);
                    }
                }
                break;
        }
    }
}