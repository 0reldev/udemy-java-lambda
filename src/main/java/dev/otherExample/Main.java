package dev.otherExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

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

        var coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{29.1566, -89.2495},
                new double[]{35.1556, -90.0659});
        coords.forEach(s -> System.out.println(Arrays.toString(s)));
//          [47.216, -95.2348]
//          [29.1566, -89.2495]
//          [35.1556, -90.0659]

        BiConsumer<Double, Double> p1 = (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng);
        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);
//        [lat:47,216 lon:-95,235]

        System.out.println("------");
        coords.forEach(s -> processPoint(s[0], s[1], p1));
//          [lat:47,216 lon:-95,235]
//          [lat:29,157 lon:-89,250]
//          [lat:35,156 lon:-90,066]

        coords.forEach(s -> processPoint(s[0], s[1], (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng)));
//          [lat:47,216 lon:-95,235]
//          [lat:29,157 lon:-89,250]
//          [lat:35,156 lon:-90,066]

        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(s -> System.out.println(s));
//        alpha
//        charlie
//        delta

        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(s -> System.out.println(s));
//        alpha
//        charlie
//        delta
//        echo
//        easy
//        earnest

        System.out.println("---------");
        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(s -> System.out.println(s));
//        alpha
//        charlie
//        delta
//        echo

        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        System.out.println("--------------");
        list.forEach(s -> System.out.println(s));
//        a - ALPHA
//        c - CHARLIE
//        d - DELTA
//        e - ECHO

        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));
//        [null, null, null, null, null, null, null, null, null, null]

        Arrays.fill(emptyStrings, "");
        System.out.println(Arrays.toString(emptyStrings));
//          [, , , , , , , , , ]

        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". ");
        System.out.println(Arrays.toString(emptyStrings));
//          [1. , 2. , 3. , 4. , 5. , 6. , 7. , 8. , 9. , 10. ]

        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". "
            + switch (i) {
                case 0 -> "one";
                case 1 -> "two";
                case 2 -> "three";
                default -> "";
            }
        );
        System.out.println(Arrays.toString(emptyStrings));
//        [1. one, 2. two, 3. three, 4. , 5. , 6. , 7. , 8. , 9. , 10. ]

        String[] names =  {"Ann", "Bob", "Carol", "David", "Ed", "Fred"};
        String[] randomList = randomlySelectedValues(15, names, () -> new Random().nextInt(0, names.length));
        System.out.println(Arrays.toString(randomList));
//        [Bob, Fred, Ed, Fred, Fred, Fred, Ed, David, Carol, Ann, Ed, Carol, Bob, Ed, Bob]
    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }

    public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s) {
        String[] selectedValues = new String[count];
        for (int i = 0 ; i < count ; i++) {
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }
}