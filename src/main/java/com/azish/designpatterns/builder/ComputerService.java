package com.azish.designpatterns.builder;

public class ComputerService {
    public Computer create(String HDD, String RAM,Boolean isGraphicsCardEnabled ,Boolean isBluetoothEnabled){
        Computer computer = new ComputerBuilder(HDD,RAM)
                .withGraphicsCardEnabled(isGraphicsCardEnabled)
                .withBluetoothEnabled(isBluetoothEnabled)
                .build();


        System.out.println(computer.isGraphicsCardEnabled());
        return computer;
    }

}
