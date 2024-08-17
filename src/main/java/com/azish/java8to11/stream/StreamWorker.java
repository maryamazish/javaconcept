package com.azish.java8to11.stream;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


public class StreamWorker {
    private final List<Employee> db;

    public StreamWorker(List<Employee> db) {
        this.db = db;
    }

    public List<Employee> findByAge(Integer age, Integer limitation) {
        return this.db.stream()
                .filter(e -> e.age() <= age && e.isActive())
                .sorted((a, b) -> b.age() - a.age())
                .limit(limitation)
                .toList();
    }

    public String csvExport() {
        return this.db.stream()
                .filter(s -> s.isActive())
                .sorted((a, b) -> b.age() - a.age())
                .map(s -> s.toString())
                .collect(Collectors.joining(","));
    }

    public Optional<Employee> findByCode(String code) {
        return this.db.stream()
                //ترتیب کاندیشن ها در سرعت نرم افزار مهم هست
                .filter(e -> e.code().equals(code) && e.isActive())
                .findFirst();
    }

    public boolean containsYoung() {
        return this.db.stream()
                .anyMatch(e->e.age()<=18 && e.isActive());
    }

    public Employee save(Employee employee) {
        this.db.add(employee);
        return employee;
    }



    public static Set<String> searchOnItems(Set<String> mySet , Set<String> items){
        return mySet.parallelStream()
                .filter(items::contains)
                //.filter(s -> items.contains(s))
                .collect(Collectors.toSet());
    }
}
