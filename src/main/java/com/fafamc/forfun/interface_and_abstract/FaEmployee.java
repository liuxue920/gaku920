package com.fafamc.forfun.interface_and_abstract;

public class FaEmployee extends Employee {


    @Override
    public double computePay() {
        System.out.println("#######");
        return 0.0;
    }

    @Override
    public void mailCheck() {
        System.out.println("Mailing a check to " + super.getName()
                + " " + super.getAddress());
    }
}
