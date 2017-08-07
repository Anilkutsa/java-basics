package com.design_patterns.builder;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String nationality;
    
    private Person(PersonBuilder pb){
        this.firstName = pb.firstName;
        this.lastName = pb.lastName;
        this.age = pb.age;
        this.gender = pb.gender;
        this.nationality = pb.nationality;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public int getAge(){
        return age;
    }
    
    public String getGender(){
        return gender;
    }
    
    public String getNationality(){
        return nationality;
    }
    
    @Override
    public String toString(){
        return getFirstName() + " " + getLastName() + " " + getAge() + " " + getGender() + " " + getNationality();
    }
    

    static class PersonBuilder {

        private String firstName;
        private String lastName;
        private int age;
        private String gender;
        private String nationality;

        PersonBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        
        PersonBuilder age(int age){
            this.age = age;
            return this;
        }
        
        PersonBuilder gender(String gender){
            this.gender = gender;
            return this;
        }
        
        PersonBuilder nationality(String nationality){
            this.nationality = nationality;
            return this;
        }
        
        Person build(){
            Person person = new Person(this);
            return person;
        }
    }
}
