package com.gauro.java7;

import java.util.Objects;

/**
 * @author Chandra
 */
public class RequireNonNull {

    public static void main(String[] args) {
        Person person=null;
        processPersonDetails(person);

//        Person person=new Person();
//        person.setFirstName("Ram");
//        person.setLastName("Das");
//        processPersonDetails(person);

    }

    private static void processPersonDetails(Person person) {
        Objects.requireNonNull(person,"Person Object can't be null");
        System.out.println(person.getFirstName());
        System.out.println(person.getLastName());
    }

    public static class Person{
        private String firstName;
        private String lastName;



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
    }
}
