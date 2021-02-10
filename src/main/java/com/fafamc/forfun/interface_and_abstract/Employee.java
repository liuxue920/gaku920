package com.fafamc.forfun.interface_and_abstract;

import lombok.Data;

@Data
public abstract class Employee {
    private String name;
    private String address;
    private int number;
    public Employee(String name, String address, int number) {
        System.out.println("Constructing an Employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }
    public Employee(){

    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Employee){
            return this.name.equals(((Employee) obj).getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    public double computePay() {
        System.out.println("Inside Employee computePay");
        return 0.0;
    }
    public abstract void mailCheck();

    public String toString() {
        return name + " " + address + " " + number;
    }
}