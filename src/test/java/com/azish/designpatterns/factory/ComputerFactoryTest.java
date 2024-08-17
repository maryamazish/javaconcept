package com.azish.designpatterns.factory;

import com.azish.exceptions.SpecException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ComputerFactoryTest {


    @Test
    void create_Success(@Mock Os winOs) {
        when(winOs.name()).thenReturn("Windows");
        when(winOs.version()).thenReturn("11");
        Computer pc = ComputerFactory.create("pc", "2 GB", "500 GB", "2.4 GHz", winOs);
        assertNotNull(pc);
        assertNotNull(winOs);
        assertEquals("ram = 2 GB hdd = 500 GB cpu = 2.4 GHz", pc.hardwareSpec());
        assertEquals("name = Windows version = 11", pc.softwareSpec());
        assertDoesNotThrow(pc::turnOn);

    }

    @Test
    void create_SpecException_Failed(@Mock Os linuxOs) {
        when(linuxOs.name()).thenReturn("Linux");
        when(linuxOs.version()).thenReturn("");
        Computer server = ComputerFactory.create("server", "128 GB", "500  TB", "16 GHz", linuxOs);
        assertNotNull(server);
        assertNotNull(linuxOs);
        var exception = assertThrows(SpecException.class, server::turnOn);
        assertEquals("Spec is missing", exception.getMessage());
    }






















    //mockConstruction is recommended to mock constructors within a try-with-resources statement.
    //ماک کردن سازنده کلاسی که در داخل متد هدف نیو شده است و چه حطا پرتاب کند و چه پرتاب نکند
    //mockConstruction(Test.class)
    //mockStatic
    //spy


    //By using the when(). thenReturn() method provided by Mockito, we can specify the behavior of our mock objects and ensure that the dependencies are controlled in our tests.
}
