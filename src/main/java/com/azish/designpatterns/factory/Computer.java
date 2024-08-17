package com.azish.designpatterns.factory;

public interface Computer {
    String hardwareSpec();
    String softwareSpec();
    void turnOn();

    default String getSpecifications() {
        return "hardwareSpec= " + this.hardwareSpec() + " softwareSpec= " + this.softwareSpec();
    }

}
