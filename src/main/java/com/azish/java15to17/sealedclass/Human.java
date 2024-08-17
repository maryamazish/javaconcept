package com.azish.java15to17.sealedclass;

public sealed class Human permits Employee, Manager, Student
{
    public String printName()
    {
        return "Default";
    }
}