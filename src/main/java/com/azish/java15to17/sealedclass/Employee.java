package com.azish.java15to17.sealedclass;

non-sealed public class Employee extends Human implements Service
{
    public Employee() {
    }

    public String printName()
    {
        return "Employee name";
    }

    @Override
    public int getMaxServiceIntervalInMonths() {
        return 0;
    }
}