package com.azish.classes;

import com.azish.classes.outerclass.OutreWorker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutreWorkerTest {

    @Test
    void cubeStatic_Success(){
        assertEquals(40000 ,OutreWorker.StaticInnerClass.cubeStatic(200));
    }

    @Test
    void cubeNonStatic_Success(){
        OutreWorker.StaticInnerClass innerClass = new OutreWorker.StaticInnerClass();
        assertEquals(160000 ,innerClass.cubeNonStatic(400));
    }

    @Test
    void plus_Success(){
        OutreWorker outreWorker = new OutreWorker();
        OutreWorker.innerClass innerClass = outreWorker.new innerClass();
        assertEquals(500 , innerClass.plus(200,300));
    }
}
