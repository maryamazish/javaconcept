package com.azish.java15to17.sealedclass;

public final class Student extends Human implements Service
{
    public String printName()
    {
        return "Student name";
    }

    @Override
    public int getMaxServiceIntervalInMonths() {
        return 0;
    }
}
