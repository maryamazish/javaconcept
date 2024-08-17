package com.azish.java15to17.sealedclass;

public sealed interface Service permits Employee, Student {

    int getMaxServiceIntervalInMonths();

    default int getMaxDistanceBetweenServicesInKilometers() {
        return 100000;
    }

}