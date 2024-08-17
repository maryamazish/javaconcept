package com.azish.designpatterns.factory;

public class ComputerFactory {
    public static Computer create(String type, String ram, String hdd, String cpu, Os os){
        if("PC".equalsIgnoreCase(type)) return new Pc(ram, hdd, cpu, os);
        else if("Server".equalsIgnoreCase(type)) return new Server(ram, hdd, cpu, os);

        throw new UnsupportedOperationException("Wrong computer type ...");
    }
}
