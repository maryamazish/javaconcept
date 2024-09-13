package com.azish.java8to11.stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StreamWorkerTest {

    private StreamWorker streamWorker;
    private List<Employee> employees;

    @BeforeEach
    void beforeEach() {
        employees = new ArrayList<>();
        this.employees.addAll(
                List.of(new Employee(1, "Maryam", "001", true, 25)
                        , new Employee(2, "Elahe", "002", true, 30)
                        , new Employee(3, "Fatemeh", "003", false, 36)
                        , new Employee(4, "Neda", "004", true, 18)
                        , new Employee(4, "mostafa", "005", true, 25)
                )
        );
        this.streamWorker = new StreamWorker(employees);
    }

    @Test
    void save_Success(@Mock Employee employee) {
        String code = "006";
        when(employee.code()).thenReturn(code);
        when(employee.isActive()).thenReturn(true);
        assertEquals(employee, this.streamWorker.save(employee));
        var result = this.streamWorker.findByCode(code);
        assertTrue(result.isPresent());
        assertEquals(employee, result.get());
    }

    @Test
    void findByAge_Success() {
        Integer age = 25;
        List<Employee> result = this.streamWorker.findByAge(age, 10);
        for (Employee e : result)
            assertTrue(e.age() <= age);
    }


    @Test
    void csvExport_Success() {
        Integer age = 25;
        var result = this.streamWorker.csvExport();
        assertTrue(!result.isBlank());
        String expected = "Employee[id=2, name=Elahe, code=002, isActive=true, age=30],Employee[id=1, name=Maryam, code=001, isActive=true, age=25],Employee[id=4, name=mostafa, code=005, isActive=true, age=25],Employee[id=4, name=Neda, code=004, isActive=true, age=18]";
        assertEquals(expected,result);
    }

    @Test
    void findByCode_Success(@Mock Employee employee) {
        //String code = "006";
        //when(employee.code()).thenReturn(code);
        //when(employee.isActive()).thenReturn(true);
        String code = "005";
        var result = this.streamWorker.findByCode(code);
        assertTrue(result.isPresent());
        assertEquals(employees.get(4), result.get());
        //assertEquals(employee, result.get());
    }

    @Test
    void containsYoung_Success() {
        var result = this.streamWorker.containsYoung();
        assertTrue(result);
    }

    //

    @Test
    void searchOnItems_Success() {
        Set<String> items = Set.of("Friday","Saturday");
        Set<String> result = StreamWorker.searchOnItems(
                Set.of("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"),items);
        assertEquals(items.size(),result.size());

        result.forEach(System.out::println);
    }
}
