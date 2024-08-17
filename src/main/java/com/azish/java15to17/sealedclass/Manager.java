package com.azish.java15to17.sealedclass;

public sealed class Manager extends Human permits ManagerSubClass
{
    public String printName()
    {
        return "Manager Name";
    }
}
