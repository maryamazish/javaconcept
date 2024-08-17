package com.azish.java8to11.functional;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Stream;

public class FunctionalWorker {

    public static final Supplier<String> generateRandomString = () -> {
        return
                new Random().ints(97, 122 + 1)
                        .limit(10)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
    };

    public static final Function<String, String> complexPassword = (String password) -> {
        return password.concat(String.valueOf(new Random().nextInt(1000000, 100000000)));
    };

    public static final Consumer<String> printPassword = (String password) -> System.out.println("the password is : " + password);

    public static final Runnable alert = () -> System.out.println("Operations is starting ... ");

    public static final Predicate<String> isPasswordComplex = (String password) -> {
        return password.matches(".*\\d.*");
    };

    public static final Comparator<Credential> comparator = (Credential c1, Credential c2) -> {
        return c1.username().length() - c2.username().length();
    };

    public static final Comparator<String> comparator2 = Comparator.comparing(String::toString);

    public static final BiConsumer<String, String> biConsumer = (String st1, String st2) -> System.out.println(st1.compareTo(st2));

    public static final BiFunction<Integer, Integer, String> biFunction = (Integer num1, Integer num2) -> {
        return String.format("num1 + num2 = %s", num1 + num2);
    };

    public static final BiPredicate<String, String> biPredicate = (String st1, String st2) -> {return st1.length() > st2.length(); };


    public static Stream<Credential> generateCredentials(List<String> strList){
        //java9
        alert.run();
        return strList.stream()
                .filter(isPasswordComplex)
                .map(p -> new Credential(generateRandomString.get(), p))
                .limit(2)
                .sorted(comparator);

    }

    /*
        public static void main(String[] args) {
        //java8
        String password = generateRandomString.get();
        password = complexPassword.apply(password);
        printPassword.accept(password);
        System.out.println(isPasswordComplex.test(password));


        List<String> strList = List.of("one", complexPassword.apply(generateRandomString.get()), complexPassword.apply(generateRandomString.get()), "three");
        var findFirstCredential = Worker.generateCredentials(strList).findFirst();
        var anyMatchCredential = Worker.generateCredentials(strList).anyMatch(p -> p.username().length() > 10);
        var findAnyCredential = Worker.generateCredentials(strList).findAny();
    }
     */

}
