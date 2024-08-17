package com.azish.java8to11.immutable;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UnmodifiableWorkerTest {
    @Test
    void toUnmodifiableList_Success(){
//        List<Dimension> mutableList = Arrays.asList(
//                new Dimension(1),
//                new Dimension(2),
//                new Dimension(3)
//        );
        List<Dimension> mutableList=new ArrayList<>();
        mutableList.add(new Dimension(1));
        mutableList.add(new Dimension(2));
        mutableList.add(new Dimension(3));

        assertDoesNotThrow(()->mutableList.add(new Dimension(10)));

        List<Dimension> immutableList = UnmodifiableWorker.toUnmodifiableList(mutableList);

        assertEquals(mutableList.get(0),immutableList.get(0));//check value
        assertSame(mutableList.get(0),immutableList.get(0)); //check address
        assertThrows(UnsupportedOperationException.class,()->immutableList.add(new Dimension(10)));


    }

}
