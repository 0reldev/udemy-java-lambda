package dev.otherExample;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"));
        for (String s : list) {
            System.out.println(s);
        }
//        alpha
//        bravo
//        charlie
//        delta

        System.out.println("---------");
        list.forEach((var myString) -> System.out.println(myString));
//        alpha
//        bravo
//        charlie
//        delta

        System.out.println("----------");
        String prefix = "nato";
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + first);
        });
//        nato alpha means a
//        nato bravo means b
//        nato charlie means c
//        nato delta means d

        int result = calculator((var a, var b) -> a + b, 5, 2);
//        Result of operation: 7

        var result2 = calculator((a, b) -> a / b, 10.0, 2.5);
//        Result of operation: 4.0

        var result3 = calculator((a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "Ralph", "Kramden");
//        Result of operation: RALPH KRAMDEN
    }

    public static <T> T calculator(Operation<T> function, T value1, T value2) {
        T result = function.operate(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }
}