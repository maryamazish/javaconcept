package com.azish.designpatterns.factory;

import com.azish.exceptions.SpecException;

public record Server (String ram, String hdd, String cpu, Os os) implements Computer {

    @Override
    public String hardwareSpec() {
        return "ram = " + ram() + " hdd = " + hdd() + " cpu = " + cpu();
    }

    @Override
    public String softwareSpec() {
        return "name = " + os().name() + " version = " + os().version();
    }

    @Override
    public void turnOn() {
        if(ram().isBlank() || hdd().isBlank() || cpu().isBlank() || os().name().isBlank() || os().version().isBlank())
            throw new SpecException("Spec is missing");

    }
}