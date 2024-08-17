package com.azish.designpatterns.builder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ComputerServiceTest {


    @Test
    void create_Success(@Mock Computer computer) {

        String HDD = "1TB";
        String RAM = "16GB";
        Boolean isGraphicsCardEnabled = true;
        Boolean isBluetoothEnabled = false;


        try (var ignored = mockConstruction(ComputerBuilder.class,
                (builder, context) -> {
                    when(builder.withGraphicsCardEnabled(anyBoolean())).thenReturn(builder);
                    when(builder.withBluetoothEnabled(anyBoolean())).thenReturn(builder);
                    when(builder.build()).thenReturn(computer);
                }
        )) {

            ComputerService computerService = new ComputerService();
            Computer newComputer = computerService.create(HDD, RAM, isGraphicsCardEnabled, isBluetoothEnabled);

            assertEquals(computer, newComputer);
        }

    }


}
